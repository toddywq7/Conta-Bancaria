
void main() {
    String nomeTitular = IO.readln("=== BEM-VINDO AO BANCO ===\nDigite o nome do titular da conta: ");

    var conta = new ContaBancaria(nomeTitular, 100.0);

    int opcao = 0;

    while (opcao != 4) {
        IO.println("\n----------------------------------");
        IO.println("Olá " + conta.getTitular() + " Seja Bem vindo! | Saldo: R$ " + conta.getSaldo());
        IO.println("----------------------------------");
        IO.println("1 - Depositar");
        IO.println("2 - Sacar");
        IO.println("3 - Consultar Saldo e Limite");
        IO.println("4 - Sair");

        try {
            opcao = Integer.parseInt(IO.readln("Escolha uma opção: "));
        } catch (NumberFormatException e) {
            IO.println("Opção inválida. Digite um número.");
            continue;
        }

        switch (opcao) {
            case 1 -> {
                double valor = Double.parseDouble(IO.readln("Informe o valor do depósito: R$ "));
                if (conta.depositar(valor)) {
                    IO.println("Depósito de R$ " + valor + " realizado com sucesso!");
                } else {
                    IO.println("Valor inválido para depósito.");
                }
            }
            case 2 -> {

                        //trava
                if (conta.getSaldo() < 0) {
                    IO.println(" TRAVA DE SEGURANÇA ACIONADA!");
                    IO.println("Sua conta está com saldo negativo R$: " + conta.getSaldo() + ").");
                    IO.println("Faça um depósito para regularizar a conta antes de efetuar novos saques.");
                } else {
                    double valor = Double.parseDouble(IO.readln("Informe o valor do saque: R$ "));
                    if (conta.sacar(valor)) {
                        IO.println("Saque de R$ " + valor + " realizado com sucesso!");
                    } else {
                        IO.println("Saque recusado! Valor acima do limite permitido.");
                    }
                }
            }
            case 3 -> {
                IO.println("\n--- EXTRATO RÁPIDO ---");
                IO.println("Saldo Atual: R$ " + conta.getSaldo());
                IO.println("Limite Total Disponível: R$ " + conta.getLimite());
                IO.println("Disponível para Saque: R$ " + (conta.getSaldo() + conta.getLimite()));
            }
            case 4 -> IO.println("Obrigado por utilizar nossos serviços!");
            default -> IO.println("Opção inválida. Tente novamente.");
        }
    }
}