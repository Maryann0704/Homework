package by.pvt;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Random;

import static java.lang.String.*;

public class Client {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        String question;
        Double answer;

        try (Socket socket = new Socket("127.0.0.1", 3036);
             DataOutputStream fromClient =
                     new DataOutputStream(socket.getOutputStream());
             DataInputStream fromServer =
                     new DataInputStream(socket.getInputStream())
        ) {
            Random random = new Random();
            int size = BaseWithCommands.getBase().size();
            long timeSpent = 0;
            while (timeSpent<180000) {
                question = BaseWithCommands.getBase().get(random.nextInt(size));
                System.out.println("Client question: "+question);
                fromClient.writeUTF(question);
                fromClient.flush();
                answer = fromServer.readDouble();
                System.out.println(format("Server answer: %2.0f", answer));
                Thread.sleep(3000);
                timeSpent = System.currentTimeMillis() - startTime;
            }

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
