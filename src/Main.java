import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to Bank Application");
        System.out.println("Do you want to create an account?");
        System.out.println("1. Yes");
        System.out.println("2. No");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        if(choice == 1){
            System.out.println("Enter your name");
            String name = sc.next();
            System.out.println("Enter your account number");
            int accountNumber = sc.nextInt();
            System.out.println("Enter your initial balance");
            double balance = sc.nextDouble();
            BankAccount account = new BankAccount(accountNumber, name, balance);
            System.out.println("Account created successfully");
        }
    }
}
