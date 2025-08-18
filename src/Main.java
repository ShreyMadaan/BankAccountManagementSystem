import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to Bank Application");
        System.out.println("Do you want to create an account?");
        System.out.println("0. Exit");
        System.out.println("1. Yes");
        System.out.println("2. No");
        System.out.println("Please Enter your choice");
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
        }else if(choice == 2){
            System.out.println("Currently we don't provide any other features. Stay tuned for future updates");
        }else if(choice == 0){
            System.out.println("Thank you for Banking with us");
        }else{
            System.out.println("Invalid choice");
        }
    }
}
