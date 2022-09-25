package model;

public class ContaCorrente extends Conta {


    public ContaCorrente(long idConta, String agencia, double saldo) {
        super(idConta, agencia, saldo);
    }

    public double rendimento() {
        return this.getSaldo() * 0.05;
    }

}
