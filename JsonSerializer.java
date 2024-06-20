import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;




public class JsonSerializer {

 // Creating an instance of the Student class
        SpaceGame ship = new SpaceGame("red 5", "500", "750");

        // Serialization: Converting the student object to JSON string
    public static String jsonSerializer(String ship) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String shipJson = objectMapper.writeValueAsString(ship);
            System.out.println("ship object serialized to JSON string:");
            System.out.println(shipJson);
            return  shipJson;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return "idk why this is happening";
    }
            // Deserialization: Converting the JSON string back to a student object
     public static SpaceGame jsonDeserializer(String shipJson){
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            SpaceGame deserializedShip = objectMapper.readValue(shipJson, SpaceGame.class);
            System.out.println("\nStudent object deserialized from JSON string:");
            System.out.println("Name: " + deserializedShip.getshipname());
            System.out.println("health: " + deserializedShip.getshiphealth());
            System.out.println("speed: " + deserializedShip.getshipspeed());
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

         return null;
     }
}






