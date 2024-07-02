import java.security.*;
import java.util.Base64;
import javax.crypto.Cipher;
import java.util.Scanner;

public class RSAExample {

    // Method to generate a new RSA key pair
    public static KeyPair generateKeyPair() throws Exception {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(2048); // 2048-bit key size
        return keyPairGenerator.generateKeyPair();
    }

    // Method to encrypt a string using a public key
    public static String encrypt(String strToEncrypt, PublicKey publicKey) {
        try {
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(Cipher.ENCRYPT_MODE, publicKey);
            return Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes("UTF-8")));
        } catch (Exception e) {
            System.out.println("Error while encrypting: " + e.toString());
        }
        return null;
    }

    // Method to decrypt a string using a private key
    public static String decrypt(String strToDecrypt, PrivateKey privateKey) {
        try {
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(Cipher.DECRYPT_MODE, privateKey);
            return new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));
        } catch (Exception e) {
            System.out.println("Error while decrypting: " + e.toString());
        }
        return null;
    }

    // Method to demonstrate encryption and decryption
    public static void run() {
        try {
            // Generate a new RSA key pair
            KeyPair keyPair = generateKeyPair();
            PublicKey publicKey = keyPair.getPublic();
            PrivateKey privateKey = keyPair.getPrivate();

            // Print the public and private keys in Base64 format
            System.out.println("Public Key: " + Base64.getEncoder().encodeToString(publicKey.getEncoded()));
            System.out.println("Private Key: " + Base64.getEncoder().encodeToString(privateKey.getEncoded()));

            // The original message to be encrypted
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter String for Encryption : ");
            String originalString = sc.nextLine();

            System.out.println("Original String: " + originalString);

            // Encrypt the message
            String encryptedString = encrypt(originalString, publicKey);
            System.out.println("Encrypted String: " + encryptedString);

            // Decrypt the message
            String decryptedString = decrypt(encryptedString, privateKey);
            System.out.println("Decrypted String: " + decryptedString);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
