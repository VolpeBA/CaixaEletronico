package caixaeletronico;
/**
 *
 * @author bruno
 */
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Scanner;

public class OptionMenu extends Account {
    
    Scanner menuInput = new Scanner(System.in);
    DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");

    HashMap<Integer, Integer> data = new HashMap<>();

    public void getLogin() {
        int x = 1;
        do{
            try{
                data.put(952141, 191904);
                data.put(989947, 717976);
                
                System.out.println("Exemplo: CONTA, SENHA");
                System.out.println("Conta 01: 989947, 717976");
                System.out.println("Conta 02: 952141, 191904\n\n");
                
                System.out.println("Bem vindo ao caixa eletrônico");
                System.out.println("Digite o numero da sua conta: ");
                setCustomerNumber(menuInput.nextInt());

                System.out.println("Digite a sua senha: ");
                setPinNumber(menuInput.nextInt());
            }
            catch(Exception e){
                System.out.println("\nSomente numeros são permitidos.\n" + e);
                x = 2;
            }

            int cn = getCustomerNumber();
            int pn = getPinNumber();
            if(data.containsKey(cn) && data.get(cn) == pn){
                getAccountType();
            }
            else{
                System.out.println("\nNúmero da conta ou senha inválido.\n\n");
            }
        }while(x == 1);
    }

    public void getAccountType() {
        System.out.println("\nSelecione o tipo de conta que deseja acessar");
        System.out.println("1. Conta corrente");
        System.out.println("2. Conta poupanca");
        System.out.println("3. Sair");
        System.out.print("Escolha: ");

        int selection = menuInput.nextInt();

        switch (selection) {
            case 1 -> getChecking();
            case 2 -> getSaving();
            case 3 -> System.out.println("Obrigado por usar o Caixa eletrônico.\n");
            default -> System.out.println("\nEscolha inválida.\n");
        }
    }

    public void getChecking() {
        System.out.println("Conta corrente");
        System.out.println("1. Ver Saldo");
        System.out.println("2. Sacar");
        System.out.println("3. Depositar");
        System.out.println("4. Sair");
        System.out.print("Escolha: ");

        int selection = menuInput.nextInt();

        switch (selection) {
            case 1 -> {
                System.out.println("Verificando o saldo da conta: " + moneyFormat.format(getCheckingBalance()));
                getAccountType();
            }
            case 2 -> {
                getCheckingWithdrawInput();
                getAccountType();
            }
            case 3 -> {
                getCheckingDepositInput();
                getAccountType();
            }
            case 4 -> System.out.println("Obrigado por usar o Caixa eletrônico.");
            default -> {
                System.out.println("\nEscolha inválida\n");
                getChecking();
            }
        }
    }

    public void getSaving() {
        System.out.println("Conta Poupanca");
        System.out.println("1. Ver Saldo");
        System.out.println("2. Sacar");
        System.out.println("3. Depositar");
        System.out.println("4. Sair");
        System.out.print("Escolha: ");

        int selection = menuInput.nextInt();

        switch (selection) {
            case 1 -> {
                System.out.println("Saldo atualizado: " + moneyFormat.format(getSavingBalance()));
                getAccountType();
            }
            case 2 -> {
                getSavingWithdrawInput();
                getAccountType();
            }
            case 3 -> {
                getSavingDepositInput();
                getAccountType();
            }
            case 4 -> System.out.println("Obrigado.\n");
            default -> {
                System.out.println("\nEscolha inválida\n");
                getChecking();
            }
        }
    }
}