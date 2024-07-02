import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;
import java.util.Base64;

public class SHA512HashExample {

    // Method to hash a string using SHA-512
    public static String hashWithSHA512(String textToHash) {
        try {
            // Get an instance of SHA-512 MessageDigest
            MessageDigest digest = MessageDigest.getInstance("SHA-512");
            
            // Perform the hashing
            byte[] hashBytes = digest.digest(textToHash.getBytes("UTF-8"));
            
            // Convert bytes to a Base64 encoded string
            return Base64.getEncoder().encodeToString(hashBytes);
        } catch (Exception e) {
            System.out.println("Error while hashing: " + e.toString());
        }
        return null;
    }

    public static void main(String[] args) {
        try {
            // Get user input
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter String to Hash : ");
            String originalString = sc.nextLine();
            sc.close();
            // Print the original string
            System.out.println("Original String: " + originalString);

            // Hash the string using SHA-512
            String hashedString = hashWithSHA512(originalString);
            System.out.println("SHA-512 Hash (Base64 encoded): " + hashedString);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
