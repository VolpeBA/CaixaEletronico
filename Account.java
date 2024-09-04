package caixaeletronico;


import java.text.DecimalFormat;
import java.util.Scanner;

/**
 *
 * @author bruno
 */
public class Account {
    
    private int customerNumber;
    private int pinNumber;
    private double checkingBalance = 0;
    private double savingBalance = 0;
    
    Scanner input = new Scanner(System.in);
    DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");
    
    public void setCustomerNumber(int customerNumber){
        this.customerNumber = customerNumber;
    }

    public int getCustomerNumber(){
        return customerNumber;
    }

    public void setPinNumber(int pinNumber){
        this.pinNumber = pinNumber;
    }

    public int getPinNumber(){
        return pinNumber;
    }

    public double getCheckingBalance() {
        return checkingBalance;
    }

    public double getSavingBalance(){
        return savingBalance;
    }

    public void calcCheckingWithdraw(double amount){
        checkingBalance = (checkingBalance - amount);
    }

    public void calcSavingWithdraw(double amount){
        savingBalance = (savingBalance - amount);
    }

    public void calcCheckingDeposit(double amount){
        checkingBalance = (checkingBalance + amount);
    }

    public void calcSavingDeposit(double amount){
        savingBalance = (savingBalance + amount);
    }

    public void getCheckingWithdrawInput() {
        System.out.println("Verificando o saldo da conta: " + moneyFormat.format(checkingBalance));
        System.out.print("Valor a ser sacado da conta corrente: ");
        double amount = input.nextDouble();

        if(checkingBalance - amount >= 0){
            calcCheckingWithdraw(amount);
            System.out.println("Novo saldo da conta corrente: " + moneyFormat.format(checkingBalance));
        }
        else{
            System.out.println("Não há dinheiro suficiente para sacar");
        }
    }

    public void getSavingWithdrawInput() {
        System.out.println("Saldo da conta poupança: " + moneyFormat.format(savingBalance));
        System.out.print("Valor a ser sacado da conta poupanca: ");
        double amount = input.nextDouble();

        if(savingBalance - amount >= 0){
            calcSavingWithdraw(amount);
            System.out.println("Novo saldo da conta poupanca: " + moneyFormat.format(savingBalance));
        }
        else{
            System.out.println("Não há dinheiro suficiente para sacar");
        }
    }

    public void getCheckingDepositInput(){
        System.out.println("Verificando o saldo da conta: " + moneyFormat.format(checkingBalance));
        System.out.print("Valor a ser depositado da conta corrente: ");
        double amount = input.nextDouble();

        if(checkingBalance + amount >= 0){
            calcCheckingDeposit(amount);
            System.out.println("Novo Saldo da Conta Corrente: " + moneyFormat.format(checkingBalance));
        }
        else{
            System.out.println("Sem dinheiro para depositar");
        }
    }

    public void getSavingDepositInput(){
        System.out.println("Saldo da conta poupanca: " + moneyFormat.format(savingBalance));
        System.out.print("Valor que você deseja depositar na conta poupanca: ");
        double amount = input.nextDouble();

        if(checkingBalance + amount >= 0){
            calcSavingDeposit(amount);
            System.out.println("Novo Saldo da Conta Poupanca: " + moneyFormat.format(savingBalance));
        }
        else{
            System.out.println("Sem dinheiro para depositar");
        }
    }
}
