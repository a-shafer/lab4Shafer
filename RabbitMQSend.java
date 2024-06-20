import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.ConnectionFactory;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class RabbitMQSend {

    private final static String QUEUE_NAME = "hello";

    public static void main(String[] argv) throws Exception {
        // Read the contents of the flat file
        StringBuilder fileContent = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader("encryptedspacegame.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                fileContent.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Set up RabbitMQ connection and channel
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            String message = fileContent.toString();
            channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
            System.out.println(" [x] Sent:\n" + message);
        }
    }
}
