package controller;

import model.Cliente;
import service.ClienteService;

import java.util.ArrayList;

public class Banco {
    private final ArrayList<Cliente> listaClientes;
    private ClienteService clienteAcessadoService;
    ClienteService clienteService;

    public Banco() {
        this.clienteService = null;
        this.listaClientes = new ArrayList<>();
    }

    public void adicionaNovoCliente(Cliente novoCliente) {
        this.listaClientes.add(novoCliente);
    }

    public void acessarInfoCliente(String cpf, String senha) {
        if(clienteAcessadoService!=null){
            finalizarAcessoCliente();
        }
        Cliente cliente = buscaCliente(cpf);
        if (cliente == null) {
            System.out.println("Cliente nao encontrado");
            return;
        }
        try {
            clienteAcessadoService = new ClienteService(cliente, senha);
            clienteAcessadoService.imprimirExtrato();
        } catch (Exception e) {
            clienteAcessadoService = null;
            throw new RuntimeException(e);
        }
    }

    public void finalizarAcessoCliente() {
        clienteAcessadoService = null;
    }

    public void realizarTransferencia(double valor, String cpfContaDestino){
        if (clienteAcessadoService == null) {
            return;
        }
        Cliente clienteDestino = buscaCliente(cpfContaDestino);
        if(clienteDestino == null){
            try {
                throw new Exception("Cliente inexistente");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        clienteAcessadoService.transferir(valor, clienteDestino.getContaCliente());
        System.out.println("Transferencia realizada: "+valor+ " para "+cpfContaDestino);
    }

    public void realizarSaque(double valor) {
        if (clienteAcessadoService == null) {
            return;
        }
        clienteAcessadoService.sacar(valor);
        System.out.println("Saque realizado: "+ valor);
    }

    public void realizarDeposito(double valor) {
        if (clienteAcessadoService == null) {
            return;
        }
        clienteAcessadoService.depositar(valor);
        System.out.println("Deposito realizado: "+ valor);
    }

    private Cliente buscaCliente(String cpf) {
        for(Cliente cliente: listaClientes) {
            if(cliente.getCpf().equals(cpf)){
                return cliente;
            }
        }
        return null;
    }
}
