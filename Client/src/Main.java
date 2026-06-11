import javax.swing.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args){
        Client client = null;
        try {
            client = new Client("127.0.0.1", 8000);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(
                    null,
                    "Connection failed",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
            System.exit(1);
        }

        String login = JOptionPane.showInputDialog(null, "Zaloguj się", "Login", JOptionPane.QUESTION_MESSAGE);
        if (login == null || login.isEmpty()) {
            System.exit(2);
        }
        client.send(login);
        MainWindow mainWindow = new MainWindow(login);
        mainWindow.setVisible(true);
    }
}