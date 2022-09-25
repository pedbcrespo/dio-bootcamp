package service;

import controller.EventosBancarios;
import model.Cliente;
import model.Conta;

public class ClienteService implements EventosBancarios {

    private final Cliente cliente;
    private final ContaService contaService;

    public ClienteService(Cliente cliente, String senha) throws Exception {
        this.cliente = cliente;
        boolean acesso = validaSenha(senha);
        if (!acesso) {
            throw new Exception("Senha incorreta");
        }
        this.contaService = new ContaService(cliente.getContaCliente());
    }

    @Override
    public void sacar(double valor) {
        try {
            contaService.retirarDoSaldo(valor);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void depositar(double valor) {
        contaService.adicionaSaldo(valor);
    }

    @Override
    public void transferir(double valor, Conta contaDestino) {
        ContaService contaDestinoService = new ContaService(contaDestino);
        try {
            contaService.retirarDoSaldo(valor);
            contaDestinoService.adicionaSaldo(valor);
        } catch (Exception e) {
            throw new RuntimeException("Nao foi possivel transferir o valor indicado.",e);
        }
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("Cliente: " + cliente.getNome());
        System.out.println("Cpf: " + cliente.getCpf());
        contaService.infoConta();
    }

    private boolean validaSenha(String senha) {
        return senha.equals(cliente.getSenha());
    }
}
