package service;

import model.Conta;

public class ContaService {

    private final Conta conta;

    public ContaService(Conta conta) {
        this.conta = conta;
    }

    public void adicionaSaldo(double saldo) {
        conta.setSaldo(conta.getSaldo()+ saldo + conta.rendimento());
    }

    public void retirarDoSaldo(double valor) throws Exception {
        double saldoAtualizado = conta.getSaldo() - valor;
        if(saldoAtualizado<0){
            throw new Exception("Valor impossivel de ser retirado: " + saldoAtualizado);
        }
        conta.setSaldo(saldoAtualizado);
    }

    public void infoConta() {
        System.out.println("Conta: " + conta.getIdConta());
        System.out.println("Agencia: "+conta.getAgencia());
        System.out.println("Saldo: " + conta.getSaldo());
    }

}
