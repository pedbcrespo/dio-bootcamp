package model;

public abstract class Conta {
    private final long idConta;
    private final String agencia;
    private double saldo;

    public Conta(long idConta, String agencia, double saldo) {
        this.idConta = idConta;
        this.agencia = agencia;
        this.saldo = saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getSaldo() {
        return this.saldo;
    }

    public String getAgencia() {
        return this.agencia;
    }
    public long getIdConta() {
        return this.idConta;
    }
    public double rendimento() {
        return 1;
    }

}
