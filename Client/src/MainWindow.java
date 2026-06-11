import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    private JTextArea chatArea;
    private JPanel rootPanel;
    private JList<String> userList;
    private JButton send;
    private JTextField inputField;

    public MainWindow(){
        this.setTitle("Chat client");
        this.setMinimumSize(new Dimension(800, 800));
        this.setContentPane(rootPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        send.addActionListener(e -> send());
        inputField.addActionListener(e -> send());
    }

    private void send(){
        String message = inputField.getText();
        if(message.isEmpty()){
            return;
        }
        chatArea.append(message+"\n");
        inputField.setText("");
    }
}
