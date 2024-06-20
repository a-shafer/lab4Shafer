public class FlatFile {



    public static String toDelimitedString(String name, String health, String speed) {
            return String.format("%s,%s,%s", name, health, speed);
        }



        public static SpaceGame fromDelimitedString(String line) {
            String[] parts = line.split(",");
            if (parts.length == 3) {
                String shipname = parts[0];
                String health = parts[1];
                String speed = parts[2];

                SpaceGame enemies = new SpaceGame(shipname,health,speed);
                System.out.println("this is FDS RESULTS "+enemies);
                return enemies;
            } else {
                throw new IllegalArgumentException("Invalid delimited data: " + line);
            }
        }
}
