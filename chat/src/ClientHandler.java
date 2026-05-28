import java.io.*;
import java.net.Socket;
import java.util.Arrays;

public class ClientHandler implements Runnable {
    private final Socket socket;
    private final BufferedReader reader;
    private final PrintWriter writer;
    private final Server server;
    private final String login;

    public String getLogin() {
        return this.login;
    }

    public ClientHandler(Socket socket, Server server) throws IOException {
        this.socket = socket;
        this.server = server;
        InputStream input = socket.getInputStream();
        OutputStream output = socket.getOutputStream();
        reader = new BufferedReader(new InputStreamReader(input));
        writer = new PrintWriter(output, true);
        this.login = reader.readLine();

    }

    public void send(String message) {
        writer.println(message);
    }

    @Override
    public void run() {
        String message;
        try {
            while ((message = reader.readLine()) != null)
                if (message.startsWith("/")) {
                    String[] tokens = message.split(" ");
                    String command = tokens[0];
                    switch (command) {
                        case "/online" -> server.online(this);
                        case "/w" -> server.whisper(
                                String.join(" ", Arrays.copyOfRange(tokens, 2, tokens.length)),
                                this,
                                tokens[1]
                        );
                    }
                }else{
                    server.broadcast(message, this);
                }

            socket.close();
        } catch (IOException e) { throw new RuntimeException(e); }
    }
}