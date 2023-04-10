package control;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Security {
	//visibilidad dentro de solo el paquete
    protected static String encriptarPassword(String password) {
        String passwordEncriptada = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(password.getBytes());
            byte[] bytes = md.digest();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            passwordEncriptada = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return passwordEncriptada;
    }

}
