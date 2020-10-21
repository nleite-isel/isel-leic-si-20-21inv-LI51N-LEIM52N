import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class SymCipher {
  public static void main(String[] args) throws NoSuchPaddingException, NoSuchAlgorithmException, BadPaddingException, IllegalBlockSizeException, InvalidKeyException, InvalidAlgorithmParameterException {
    byte[] plaintext = "The quick brown fox jumps over the lazy dog".getBytes();
    byte[] ciphertext;

    // Generate key
    KeyGenerator generator = KeyGenerator.getInstance("AES");
    SecretKey key = generator.generateKey();

    // create cipher object with AES in CBC mode
    Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");

    // encrypt in symmetric encript mode
    cipher.init(Cipher.ENCRYPT_MODE, key);
    ciphertext = cipher.doFinal(plaintext);

    // change criptogram
    ciphertext[10] = 20;

    // decrypt
    cipher.init(Cipher.DECRYPT_MODE, key, new IvParameterSpec(cipher.getIV()));
    byte[] new_plaintext = cipher.doFinal(ciphertext);

    System.out.println(new String(new_plaintext));
  }
}
