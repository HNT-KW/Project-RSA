package Demo1.Code;

import java.io.FileInputStream;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import java.util.Scanner;

import javax.crypto.Cipher;

public class Encrpytion {

    public static String Input() {
        try (Scanner myObj = new Scanner(System.in)) {
            System.out.println("Input: ");
            return myObj.nextLine();
        }
    }

    public static String Encrpytion(String input) {
        String strEncrypt = null;
        try {
            // Đọc file chứa public key
            FileInputStream fis = new FileInputStream("D:/CNTT/eclipse-workspace/Project-RSA/src/RSA/publicKey.txt");
            byte[] b = new byte[fis.available()];
            fis.read(b);
            fis.close();

            // Tạo public key
            X509EncodedKeySpec spec = new X509EncodedKeySpec(b);
            KeyFactory factory = KeyFactory.getInstance("RSA");
            PublicKey pubKey = factory.generatePublic(spec);

            System.out.println(pubKey);
            // Mã hoá dữ liệu
            Cipher c = Cipher.getInstance("RSA");
            c.init(Cipher.ENCRYPT_MODE, pubKey);
            byte encryptOut[] = c.doFinal(input.getBytes());
            strEncrypt = Base64.getEncoder().encodeToString(encryptOut);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return strEncrypt;
    }

    public static void main(String[] args) {
        try {
            String inp = Input();
            String strEncrypt = Encrpytion(inp);
            System.out.println("Chuỗi sau khi mã hoá: " + strEncrypt);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
