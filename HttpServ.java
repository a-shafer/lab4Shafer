

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;



public class HttpServ {


    public static void main(String[] args) throws Exception {
        HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
        server.createContext("/hello", new MyHandler());
        server.setExecutor(null); // creates a default executor
        server.start();
    }

    static class MyHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            try (BufferedReader reader = new BufferedReader(new FileReader("encryptedspacegame.txt"))) {
            String line;
            line = reader.readLine();
                String response = String.valueOf(line);


            exchange.sendResponseHeaders(200, response.getBytes().length);

            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
       }}
    }
}
