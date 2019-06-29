package by.pvt;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Server {

    private static Logger log = Logger.getLogger("by.pvt.Server");

    @SuppressWarnings("InfiniteLoopStatement")
    public static void main(String[] args) {

        try (ServerSocket serverSocket = new ServerSocket(3036)
        ) {
            ExecutorService service = Executors.newCachedThreadPool();
            while (!serverSocket.isClosed()) {
                Socket socket = serverSocket.accept();
                DataInputStream fromClient =
                        new DataInputStream(socket.getInputStream());
                DataOutputStream fromServer =
                        new DataOutputStream(socket.getOutputStream());

                service.submit(() -> {
                    try {
                        String question;
                        double answer;
                        while (true) {
                            question = fromClient.readUTF();
                            log.info("Client question: " + question);
                            answer = Math.random()*20;
                            fromServer.writeDouble(answer);
                            log.info(String.format("Server answer: %2.0f", answer));
                        }
                    } catch (IOException e) {
                        log.log(Level.SEVERE, e.getMessage(), e);
                    }
                });
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
