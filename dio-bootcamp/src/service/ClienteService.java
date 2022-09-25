package service;

import controller.EventosBancarios;
import model.Cliente;
import model.Conta;

public class ClienteService implements EventosBancarios {

    private final Cliente cliente;
    private ContaService contaService = null;

    private final boolean acesso;
    public ClienteService(Cliente cliente, String senha){
        this.cliente = cliente;
        this.acesso = validaSenha(senha);
        if (acesso) {
            this.contaService = new ContaService(cliente.getContaCliente());
        } else {System.out.println("Senha incorreta");}
    }

    @Override
    public void sacar(double valor) {
        if(!acesso){return;}
        try {
            contaService.retirarDoSaldo(valor);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void depositar(double valor) {
        if(!acesso){return;}
        contaService.adicionaSaldo(valor);
    }

    @Override
    public void transferir(double valor, Conta contaDestino) {
        if(!acesso){return;}
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
        if(!acesso){return;}
        System.out.println("Cliente: " + cliente.getNome());
        System.out.println("Cpf: " + cliente.getCpf());
        contaService.infoConta();
    }

    private boolean validaSenha(String senha) {
        return senha.equals(cliente.getSenha());
    }
}
