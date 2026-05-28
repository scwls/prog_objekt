import java.io.*;
import java.net.Socket;

public class ClientHandler implements Runnable {
    private final Socket socket;
    private final BufferedReader reader;
    private final PrintWriter writer;
    private final Server server;
    public ClientHandler(Socket socket, Server server) throws IOException {
        this.socket = socket;
        this.server = server;
        InputStream input = socket.getInputStream();
        OutputStream output = socket.getOutputStream();
        reader = new BufferedReader(new InputStreamReader(input));
        writer = new PrintWriter(output, true);
    }

    public void send(String message) {
        writer.println(message);
    }

    @Override
    public void run() {
        String message;
        try {
            while ((message = reader.readLine()) != null)
                server.broadcast(message, this);
            socket.close();
        } catch (IOException e) { throw new RuntimeException(e); }
    }
}