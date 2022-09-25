package model;

public class ContaPoupanca extends Conta{


    public ContaPoupanca(long idConta, String agencia, double saldo) {
        super(idConta, agencia, saldo);
    }
    public double rendimento() {
        return this.getSaldo() * 0.01;
    }

}
