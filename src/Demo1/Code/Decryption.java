package Demo1.Code;

import java.io.FileInputStream;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Base64;
import java.util.Scanner;

import javax.crypto.Cipher;

public class Decryption {

    public static String Input() {
        try (Scanner myObj = new Scanner(System.in)) {
            System.out.println("Input: ");
            return myObj.nextLine();
        }
    }

    public static String Decryption(String input) {
        byte[] decryptOut = null;
        try {
            // Đọc file chứa private key
            FileInputStream fis = new FileInputStream("D:/CNTT/eclipse-workspace/Project-RSA/src/RSA/privateKey.txt");
            byte[] b = new byte[fis.available()];
            fis.read(b);
            fis.close();

            // Tạo private key
            PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(b);
            KeyFactory factory = KeyFactory.getInstance("RSA");
            PrivateKey priKey = factory.generatePrivate(spec);

            // Giải mã dữ liệu
            Cipher c = Cipher.getInstance("RSA");
            c.init(Cipher.DECRYPT_MODE, priKey);
            //byte decryptOut[] = c.doFinal(Base64.getDecoder().decode(input));
            decryptOut = c.doFinal(Base64.getDecoder().decode(input));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return new String(decryptOut);
    }

    public static void main(String[] args) {
        String inp = Input();
        Decryption(inp);
        System.out.println("Dữ liệu sau khi giải mã: " + Decryption(inp));
    }
}
