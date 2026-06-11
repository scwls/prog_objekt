import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends JFrame {
    private JTextArea chatArea;
    private JPanel rootPanel;
    private JList<String> userList;
    private JTextField inputField;
    private JButton sendButton;
    private final Client client;

    public MainWindow(String login, Client client) {
        this.setTitle(login);
        this.setMinimumSize(new Dimension(800, 600));
        this.setContentPane(rootPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.client=client;
        sendButton.addActionListener(actionEvent -> send());
        inputField.addActionListener(actionEvent -> send());
    }
    private void send(){
        String message = inputField.getText();
        if(message.isEmpty())
            return;
        //chatArea.append(message + '\n');
        //inputField.setText("");
        client.send(message);
    }

}
