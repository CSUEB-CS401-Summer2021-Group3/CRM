import javax.swing.*;
import javax.swing.text.*;

import java.awt.*;              //for layout managers and more
import java.awt.event.*;        //for action events
import java.io.IOException;


public class ClientGUI extends JPanel implements ActionListener {
    private final JLabel serverAddressPortLabel;
    private final JLabel userNameLabel;
    private final JLabel userPassLabel;
    private final String serverAddrPortDefault = "localhost:7777";
    private final JTextField serverAddrPortTextField;
    private final JTextField userNameTextField;
    private final JPasswordField userPassField;
    private final JLabel failLoginField;
    private final JDialog credentialsDialog;
    private final JPanel credentialsPanelLeft;
    private final JPanel credentialsPanelRight;
    private final JPanel credentialsPanelLow;
    private final JPanel credentialsPanelTop;
    private final JPanel credentialsPanel;
    private final JButton credentialsSubmitButton;
    private final String loginFailedMsg = "Username / Password does not exists. Please try again";

    private String host;
    private int port;
    private String userName;
    private String userPass;
    private CRMClient crm;

    public ClientGUI() {
        setLayout(new BorderLayout());

        serverAddressPortLabel = new JLabel("Enter Address:Port");
        userNameLabel = new JLabel("Enter Username: ");
        userPassLabel = new JLabel("Enter Password: ");

        serverAddrPortTextField = new JTextField();
        serverAddrPortTextField.setText(serverAddrPortDefault);
        userNameTextField = new JTextField(10);
        userPassField = new JPasswordField(10);

        failLoginField = new JLabel("");
        failLoginField.setForeground(Color.red);

        credentialsDialog = new JDialog();

        credentialsSubmitButton = new JButton("Submit");
        credentialsSubmitButton.setActionCommand("login");
        credentialsSubmitButton.addActionListener(this);
        
        credentialsPanel = new JPanel();
        credentialsPanelLeft = new JPanel();
        credentialsPanelLeft.setLayout(new BoxLayout(credentialsPanelLeft, BoxLayout.Y_AXIS));
        credentialsPanelRight = new JPanel();
        credentialsPanelRight.setLayout(new BoxLayout(credentialsPanelRight, BoxLayout.Y_AXIS));
        credentialsPanelLow = new JPanel();
        credentialsPanelLow.setLayout(new BorderLayout());
        credentialsPanelTop = new JPanel();
        credentialsPanelTop.setLayout(new FlowLayout());

        credentialsPanel.setLayout(new BoxLayout(credentialsPanel, BoxLayout.Y_AXIS));        
        credentialsPanel.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createTitledBorder("CRM Login"),
            BorderFactory.createEmptyBorder(5, 5, 5, 5))
        );
       
        /**
         * -----------------------------
         *             TOP
         * 
         * LEFT                    RIGHT
         * 
         * -----------------------------
         *            BOTTOM
         */           
        
        
        
        // Setup top panel
        credentialsPanelLeft.add(serverAddressPortLabel);
        credentialsPanelRight.add(serverAddrPortTextField);
        credentialsPanelLeft.add(userNameLabel);
        credentialsPanelRight.add(userNameTextField);
        credentialsPanelLeft.add(userPassLabel);
        credentialsPanelRight.add(userPassField);

        credentialsPanelTop.add(credentialsPanelLeft);
        credentialsPanelTop.add(credentialsPanelRight);

        // Setup bottom panel
        credentialsPanelLow.add(credentialsSubmitButton, BorderLayout.CENTER);
        credentialsPanelLow.add(failLoginField, BorderLayout.PAGE_END);        

        credentialsPanel.add(credentialsPanelTop);
        credentialsPanel.add(credentialsPanelLow);

        credentialsDialog.add(credentialsPanel);
        credentialsDialog.pack();
        credentialsDialog.setSize(new Dimension(350, 175));
        credentialsDialog.setLocationRelativeTo(null);
        credentialsDialog.setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) { 
        String action = ae.getActionCommand();
        if (action.equals("login")) {
            userName = userNameTextField.getText();
            userPass = new String(userPassField.getPassword());
            
            try {
                String[] serverAddrPort = serverAddrPortTextField.getText().split(":");
                host = serverAddrPort[0];
                port = Integer.parseInt(serverAddrPort[1]);
                crm = new CRMClient(host, port, userName, userPass);
                if (! crm.login()) {
                    failLoginField.setText(loginFailedMsg);
                }
                else {
                    credentialsDialog.dispose();
                    crm.session();
                }
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            catch (ArrayIndexOutOfBoundsException e) {
                failLoginField.setText("Invalid Address Port Format");
            }
        }
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("CRM");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new ClientGUI());
        frame.pack();
        // frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        //Schedule a job for the event dispatching thread:
        //creating and showing this application's GUI.
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
		        createAndShowGUI();
            }
        });
    }
}
