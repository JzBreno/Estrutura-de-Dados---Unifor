package util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHA1Util {

    /**
     * Gera o hash SHA-1 de uma String de entrada.
     * Conforme requisito do projeto, os hashes devem ser gerados pela função
     * de dispersão criptográfica SHA-1[cite: 147].
     * * @param input A String (palavra ou concatenação de hashes) a ser processada.
     * @return O hash em formato hexadecimal de 40 caracteres.
     */

    public static String gerarHash(String input) {
        if (input == null || input.isEmpty()) {
            return "";
        }

        try {

            MessageDigest md = MessageDigest.getInstance("SHA-1");

            byte[] messageDigest = md.digest(input.getBytes());

            StringBuilder hexString = new StringBuilder();
            for (byte b : messageDigest) {

                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }

            return hexString.toString();

        } catch (NoSuchAlgorithmException e) {

            throw new RuntimeException("Erro ao processar o algoritmo SHA-1", e);
        }
    }
}
