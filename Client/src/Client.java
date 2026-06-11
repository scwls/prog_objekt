import java.io.*;
import java.net.Socket;

public class Client {
    private final Socket socket;
    private final BufferedReader reader;
    private final PrintWriter writer;

    public Client(String address, int port) throws IOException {
        socket = new Socket(address, port);
        InputStream input = socket.getInputStream();
        OutputStream output = socket.getOutputStream();
        reader = new BufferedReader(new InputStreamReader(input));
        writer = new PrintWriter(output, true);
    }

    public void send(String message) {
        writer.println(message);
    }

}