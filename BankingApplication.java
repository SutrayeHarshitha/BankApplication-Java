import java.util.Scanner;

public class BankingApplication {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String customerName = sc.nextLine();

        System.out.print("Enter your customer ID: ");
        String customerId = sc.nextLine();

        BankAccount account = new BankAccount(customerName, customerId);
        account.showMenu();

    }
}