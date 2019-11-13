import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.util.Base64;

/**
 * @author:zhaoyunxiang
 * @date:2019/9/3 2:58 下午
 */
public class Test2 {
    public static void main(String[] args) throws IOException {
        String encrypt = encrypt("gzh");
        System.out.println(encrypt);
        String decrypt = decrypt(encrypt);
        System.out.println(decrypt);
    }


    public static String encrypt(String originStr) {
        try {
            byte[] raw = "BDE7BAF3628F4242823F70F1D5C12AAE".getBytes("utf8");
            SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            IvParameterSpec iv = new IvParameterSpec("BDE7BAF3628F4242823F70F1D5C12AAE".substring(0, 16).getBytes("utf8"));
            cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);
            byte[] cipherText = originStr.getBytes("utf8");
            byte[] original = cipher.doFinal(cipherText);

            return new BASE64Encoder().encode(original);
//            byte[] bytes = new Base64().encode(original);
//            return new String(bytes);
        } catch (Exception var8) {
            return null;
        }
    }

    public static String decrypt(String strCipherText) {
        try {
            byte[] raw = "BDE7BAF3628F4242823F70F1D5C12AAE".getBytes("utf8");
            SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            IvParameterSpec iv = new IvParameterSpec("BDE7BAF3628F4242823F70F1D5C12AAE".substring(0, 16).getBytes("utf8"));
            cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);
            byte[] strBytes = Base64.getDecoder().decode(strCipherText);
            byte[] original = cipher.doFinal(strBytes);
            return new String(original);
        } catch (Exception var8) {
            return "";
        }
    }
}
