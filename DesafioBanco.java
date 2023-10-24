import java.util.InputMismatchException;
import java.util.Scanner;

public class DesafioBanco {
    public static void main(String[] args) {
        Scanner data = new Scanner(System.in);
        int escolha=0;
        String nome,tipoConta;
        double saldo=1300,valorDeposito=0,valorTransferido=0;

        System.out.print("Insira seu nome completo: ");
        nome = data.nextLine();
        System.out.print("Insira seu tipo de conta: ");
        tipoConta = data.nextLine();
        System.out.print("Insira seu saldo inicial: ");
        saldo = data.nextDouble();
        System.out.println("---------------------------");
        System.out.println("Dados iniciais do cliente: ");
        System.out.println(" ");
        System.out.println("Nome: " + nome);
        System.out.println("Tipo de conta: " + tipoConta);
        System.out.println("Saldo inicial: " + "R$ "+ saldo);
        System.out.println("---------------------------");

        while(escolha != 4){

            try{
                String menu = """
                        Operações
                        
                        1 - Consultar saldos
                        2 - Receber valor
                        3 - Transferir valor
                        4 - Sair   
                        
                        """;
                System.out.println(menu);
                System.out.print("Digite a opção desejada: ");
                escolha = data.nextInt();

                if(escolha == 1){
                    System.out.println(String.format("O saldo atual é: R$ %.2f", saldo));
                    System.out.println(" ");
                }else if(escolha == 2){

                    System.out.println("Insira o valor a ser depositado: ");
                    valorDeposito = data.nextDouble();
                    saldo += valorDeposito;
                    System.out.println(String.format("O saldo atual é: R$ %.2f", saldo));

                }else if(escolha == 3){

                    System.out.println("Insira o valor a ser transferido: ");
                    valorTransferido = data.nextDouble();

                    if(valorTransferido > saldo || valorTransferido < 1){
                        System.out.println("Operação negada, você não pode transferir esse valor.");
                        System.out.println(" ");
                    }else{
                        saldo -= valorTransferido;
                        System.out.println(String.format("O saldo atual é: R$ %.2f", saldo));
                    }


                }else{
                    System.out.println("Agradecemos sua preferência, volte sempre!");
                    break;
                }

            }catch(InputMismatchException error){
                System.out.println("Erro de digitação!");
                break;
            }
        }
    }
}
