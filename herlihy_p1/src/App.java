import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your code for encryption: ");
        String code = input.nextLine();
        String encryptedValue = Encrypter.Encrypt(code);
        System.out.println("encrypts " + code + " to " + encryptedValue);
        System.out.println("Enter your code for decryption: ");
        code = input.nextLine();
        String decryptedValue = Decrypter.Decrypt(code);
        System.out.println("decrypts " + code + " to " + decryptedValue);
    }
}