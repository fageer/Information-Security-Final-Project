import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ImageEncryptDecrypt {

    // Method to encrypt or decrypt an image using XOR
    public static BufferedImage xorImage(BufferedImage image, int key) {
        int width = image.getWidth();
        int height = image.getHeight();
        BufferedImage resultImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int rgb = image.getRGB(x, y);
                int encryptedRgb = rgb ^ key; // XOR operation for encryption/decryption
                resultImage.setRGB(x, y, encryptedRgb);
            }
        }
        return resultImage;
    }

    public static void run() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the encryption/decryption key (integer):");
        int key = scanner.nextInt();

        System.out.println("Enter the mode ('encrypt' or 'decrypt'):");
        String mode = scanner.next().trim().toLowerCase();

        if (!"encrypt".equals(mode) && !"decrypt".equals(mode)) {
            System.out.println("Invalid mode. Use 'encrypt' or 'decrypt'.");
            scanner.close();
            return;
        }

        System.out.println("Enter the input image file name (with extension):");
        String inputImagePath = scanner.next().trim();

        System.out.println("Enter the output image file name (with extension):");
        String outputImagePath = scanner.next().trim();

        try {
            // Read the image
            File inputFile = new File(inputImagePath);
            BufferedImage inputImage = ImageIO.read(inputFile);

            // Encrypt or Decrypt based on the mode
            BufferedImage outputImage;
            if ("encrypt".equals(mode)) {
                outputImage = xorImage(inputImage, key);
                System.out.println("Image encrypted successfully.");
            } else { // mode is "decrypt"
                outputImage = xorImage(inputImage, key);
                System.out.println("Image decrypted successfully.");
            }

            // Save the resulting image
            File outputFile = new File(outputImagePath);
            ImageIO.write(outputImage, "jpg", outputFile);

            System.out.println("Output saved as " + outputImagePath);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
