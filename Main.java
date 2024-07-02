import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Choose an operation:");
            System.out.println("1. Encrypt And Decrypt Image");
            System.out.println("2. Encrypt And Decrypt Text By Public And Private keys");
            System.out.println("3. Encrypt Text By Hash Function(512)");
            System.out.println("4. Shortcut Malware");
            System.out.println("5. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline left-over

            switch (choice) {
                case 1:
                    System.out.println("Runing Encrypt And Decrypt Image Program...");
                    ImageEncryptDecrypt.run();
                    break;
                case 2:
                    System.out.println("Runing Encrypt And Decrypt Text By Public And Private keys Program...");
                    RSAExample.run();
                    break;
                case 3:
                    System.out.println("Runing Encrypt Text By Hash Function(512) Program...");
                    SHA512HashExample.run();
                    break;
                case 4:
                    System.out.println("Runing Shortcut Malware Program...");
                    Malware.run();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
