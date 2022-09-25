package model;

public class Cliente {
    private final String cpf;
    private final String nome;
    private final String senha;
    private final Conta contaCliente;


    public Cliente(String cpf, String nome, String senha, Conta contaCliente) {
        this.cpf = cpf;
        this.nome = nome;
        this.senha = senha;
        this.contaCliente = contaCliente;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public String getSenha() {
        return this.senha;
    }

    public Conta getContaCliente() {
        return this.contaCliente;
    }
}
