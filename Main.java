import java.io.*;

public class Main {
    public static void main(String[] argv) {

        SpaceGame ship = new SpaceGame("red 5", "500", "750");


        String flatstring = FlatFile.toDelimitedString(SpaceGame.getshipname(), SpaceGame.getshiphealth(), SpaceGame.getshipspeed());
        System.out.println(flatstring);


        try (PrintWriter writer = new PrintWriter(new FileWriter("spacegame.txt"))) {
            writer.println(flatstring);

        } catch (IOException e) {
            e.printStackTrace();
        }


        try (BufferedReader reader = new BufferedReader(new FileReader("spacegame.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                FlatFile.fromDelimitedString(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        String serializedship = JsonSerializer.jsonSerializer(flatstring);
        System.out.println(serializedship);



    }

}