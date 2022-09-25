import controller.Banco;
import model.Cliente;
import model.ContaCorrente;
import model.ContaPoupanca;

public class Main {
    public static void main(String[] args) {
        Banco banco = new Banco();
        Cliente clienteA = new Cliente(
                "11122233345",
                "Cliente A",
                "123456",
                new ContaCorrente(1, "0001", 1000.0)
        );

        Cliente clienteB = new Cliente(
                "12312312354",
                "Cliente B",
                "654321",
                new ContaPoupanca(2, "0002", 1250.5)
        );

        Cliente clienteC = new Cliente(
                "33322211110",
                "Cliente C",
                "111222",
                new ContaCorrente(3, "0003", 2575)
        );

        banco.adicionaNovoCliente(clienteA);
        banco.adicionaNovoCliente(clienteB);
        banco.adicionaNovoCliente(clienteC);

        banco.acessarInfoCliente("11122233345", "123456");
        banco.realizarDeposito(1500);
        banco.finalizarAcessoCliente();

        banco.acessarInfoCliente("12312312354", "654321");
        banco.realizarTransferencia(50.0, "33322211110");

        banco.acessarInfoCliente("33322211110", "111222");
        banco.realizarSaque(100);
    }
}
