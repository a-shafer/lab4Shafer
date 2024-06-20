import java.io.*;
import java.util.Scanner;


public class CypherDeCypher {
     public static void main(String[] args) {
         SpaceGame ship = new SpaceGame("red 5", "500", "750");

         String plaintext = FlatFile.toDelimitedString(SpaceGame.getshipname(), SpaceGame.getshiphealth(), SpaceGame.getshipspeed());
        System.out.println(plaintext);

        int shiftValue = 7;

        String encryptedText = encrypt(plaintext, shiftValue);
        System.out.println("Encrypted text: " + encryptedText);


       try (PrintWriter writer = new PrintWriter(new FileWriter("encryptedspacegame.txt"))) {
            writer.println(encryptedText);

        } catch (IOException e) {
            e.printStackTrace();
        }



        try (BufferedReader reader = new BufferedReader(new FileReader("encryptedspacegame.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String decrypted = dencrypt(line,shiftValue);
                System.out.println("dencrypted text: " + decrypted);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


     }

    public static String encrypt(String plaintext, int shift) {
        StringBuilder encryptedText = new StringBuilder();

        for (char character : plaintext.toCharArray()) {
            if (Character.isLetter(character)) {
                char base = Character.isLowerCase(character) ? 'a' : 'A';
                int originalAlphabetPosition = character - base;
                int newAlphabetPosition = (originalAlphabetPosition + shift) % 26;
                char newCharacter = (char) (base + newAlphabetPosition);
                encryptedText.append(newCharacter);
            } else {
                encryptedText.append(character);
            }
        }

        return encryptedText.toString();
    }

    public static String dencrypt(String cyphertext, int shift) {
        StringBuilder dencryptedText = new StringBuilder();

        for (char character : cyphertext.toCharArray()) {
            if (Character.isLetter(character)) {
                char base = Character.isLowerCase(character) ? 'a' : 'A';
                int originalAlphabetPosition = character + base;
                int newAlphabetPosition = (originalAlphabetPosition + shift) % 26;
                char newCharacter = (char) (base + newAlphabetPosition);
                dencryptedText.append(newCharacter);
            } else {
                dencryptedText.append(character);
            }
        }

        return dencryptedText.toString();
    }
}
