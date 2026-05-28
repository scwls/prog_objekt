import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
    private ServerSocket serverSocket;
    private ArrayList<ClientHandler> handlers = new ArrayList<>();

    public Server(int port) throws IOException {
        this.serverSocket = new ServerSocket(port);
    }

    public void listen() throws IOException {
        System.out.println("Server started");
        while(true) {
            Socket socket = serverSocket.accept();
            ClientHandler handler = new ClientHandler(socket, this);
            Thread thread = new Thread(handler);
            thread.start();
            handlers.add(handler);
        }
    }

    public void broadcast(String message, ClientHandler sender) {
        handlers.stream()
                .filter(receiver -> receiver != sender)
                .forEach(handler -> handler.send(message));
    }
}