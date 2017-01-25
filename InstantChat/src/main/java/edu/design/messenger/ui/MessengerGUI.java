package edu.design.messenger.ui;

import edu.design.messenger.network.SocketMessageListener;
import edu.design.messenger.network.SocketMessageSender;
import lombok.extern.slf4j.Slf4j;

import javax.swing.*;
import javax.swing.text.NumberFormatter;
import java.awt.*;
import java.io.IOException;
import java.text.NumberFormat;


@Slf4j
public class MessengerGUI extends JFrame {
    private JPanel rootPanel;
    private JTextField nickTextField;
    private JTextField buddyAddressTextField;
    private JTextArea chatArea;
    private JTextField messageTextField;
    private JButton connectButton;
    private JButton sendButton;
    private JFormattedTextField listeningPortTextField;
    private JFormattedTextField sendingPortTextField;
    private JLabel sendingPortLabel;

    public MessengerGUI() throws HeadlessException {
        super("Instant chat!");

        setContentPane(rootPanel);

        pack();

        nickTextField.setText("MyName");
        buddyAddressTextField.setText("127.0.0.1");

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        connectButton.addActionListener(e -> {

            try {
                String nick = nickTextField.getText();
                String address = buddyAddressTextField.getText();
                int listeningPort = (int) listeningPortTextField.getValue();
                int sendingPort = (int) sendingPortTextField.getValue();

                SocketMessageSender sender = new SocketMessageSender(address, sendingPort);
                sendButton.addActionListener(e1 -> {
                    try {
                        String text = messageTextField.getText();
                        sender.sendMessage(nick, text);
                        chatArea.append(nick + ": " + text + "\n");
                        messageTextField.setText("");
                    } catch (IOException e2) {
                        e2.printStackTrace();
                        try {
                            sender.close();
                        } catch (IOException e3) {
                            log.error("Exception while closing sender", e3);
                        }
                    }
                });

                SocketMessageListener listener = new SocketMessageListener(textMessage -> chatArea.append(textMessage.getNick() + ": " + textMessage.getText() + "\n"));
                new Thread(() -> {
                    try {
                        listener.listen(listeningPort);
                    } catch (IOException e1) {
                        JOptionPane.showMessageDialog(this, "Exception during listening." + e1.getMessage());
                    } finally {
                        setEnabledSettings(true);
                    }
                }).start();

                setEnabledSettings(false);

            } catch (Exception e1) {
                JOptionPane.showMessageDialog(this, "Exception: " + e1.getMessage());
                setEnabledSettings(true);
            }
        });


        setEnabledSettings(true);


        setVisible(true);
    }

    private void setEnabledSettings(boolean value) {
        nickTextField.setEnabled(value);
        buddyAddressTextField.setEnabled(value);
        listeningPortTextField.setEnabled(value);
        sendingPortTextField.setEnabled(value);
        connectButton.setEnabled(value);

        sendButton.setEnabled(!value);
    }

    public static void main(String[] args) {
        MessengerGUI messengerGUI = new MessengerGUI();
    }


    private void createUIComponents() {
        NumberFormat format = NumberFormat.getInstance();
        NumberFormatter formatter = new NumberFormatter(format);
        formatter.setValueClass(Integer.class);
        formatter.setMinimum(0);
        formatter.setMaximum(Integer.MAX_VALUE);
        formatter.setAllowsInvalid(false);

        listeningPortTextField = new JFormattedTextField(formatter);
        sendingPortTextField = new JFormattedTextField(formatter);

        listeningPortTextField.setValue(10021);
        sendingPortTextField.setValue(10022);
    }
}
