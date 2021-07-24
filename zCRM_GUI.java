
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.io.File;
import java.io.IOException;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.JTextComponent;

import java.awt.event.*;

public class zCRM_GUI {
		
	private static JFrame frame;
	static JPanel userTitle;
	static JPanel actionPanel;
	static JPanel actionInputPanel;
	static Box infoBox;
	static JTextField newUserName;
	static JTextField newPassword;
	
	private static void adminGUI() {
		frame = new JFrame("CRM GUI");
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		        
		frame.setLayout(new FlowLayout());
		frame.setSize(700, 500);

		userTitle = new JPanel(new BorderLayout()); 	
		actionPanel = new JPanel();
		actionInputPanel = new JPanel(new BorderLayout());
		
		
		actionPanel.setLayout(new BoxLayout(actionPanel, BoxLayout.Y_AXIS));  
		actionInputPanel.setLayout(new BoxLayout(actionInputPanel, BoxLayout.X_AXIS));
		
		frame.add(userTitle);
		frame.add(actionInputPanel);
		
		userTitle.setBorder(BorderFactory.createCompoundBorder(
	            BorderFactory.createTitledBorder("Welcome Admin"),
	            BorderFactory.createEmptyBorder(15, 15, 15, 15)));
				
		
		JPanel panel = new JPanel();
		JPanel panel2 = new JPanel();
		panel.setSize(50, 50);
		
		GridLayout gl = new GridLayout(4,2); // 4 rows, 2 columns
		panel2.setLayout(gl);
		JButton ok = new JButton("Ok");
		JButton cancel = new JButton("Cancel");
		
		JRadioButton jRadioButtonSP, jRadioButtonM, jRadioButtonA;
		JButton jButtonSaleperson, jButtonManager, jButtonAdmin;
		ButtonGroup G1;
		JLabel labelSalePerson, labelManager, labelAdmin;
		
		jRadioButtonSP = new JRadioButton();
		jRadioButtonM = new JRadioButton();
		jRadioButtonA = new JRadioButton();
		
		labelSalePerson = new JLabel("Sale Person");
		labelManager = new JLabel("Manager");
		labelAdmin = new JLabel("Admin");
		G1 = new ButtonGroup();
	     
	    jRadioButtonSP.setBounds(120, 30, 120, 50);
	    panel.add(jRadioButtonSP);
	    panel.add(labelSalePerson);
	    G1.add(jRadioButtonSP);
	   
	    jRadioButtonM.setBounds(250, 30, 80, 50);
	    panel.add(jRadioButtonM);
	    panel.add(labelManager);
	    G1.add(jRadioButtonM);
	   
	    jRadioButtonA.setBounds(450, 30, 80, 50);
	    panel.add(jRadioButtonA);
	    panel.add(labelAdmin);
	    G1.add(jRadioButtonA);

//	    String accountType = "";
//        ok.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e){
//                if (jRadioButtonSP.isSelected())
//                	accountType = "salePerson";
//                else if (jRadioButtonM.isSelected())
//                	accountType = "Manager";
//                else if (jRadioButtonA.isSelected())
//                    accountType = "Admin";
//                else
//                	JOptionPane.showMessageDialog(frame, accountType);
//                	//accountType = "NO Button selected";
//            }
//        });
	    


		JLabel userNameLabel = new JLabel("User Name:");
		newUserName = new JTextField(15);
		
		//userNameLabel.setBounds(200, 3000, 1050, 500);
		panel2.add(userNameLabel);
		panel2.add(newUserName);

//		newUserName.addFocusListener(new FocusListener() {
//		      public void focusGained(FocusEvent e) {
//		          displayMessage("Focus gained", e);
//		        }
//
//		        public void focusLost(FocusEvent e) {
//		          displayMessage("Focus lost", e);
//		        }
//
//		        void displayMessage(String prefix, FocusEvent e) {
//		          System.out.println(prefix
//		              + (e.isTemporary() ? " (temporary):" : ":")
//		              + e.getComponent().getClass().getName()
//		              + "; Opposite component: "
//		              + (e.getOppositeComponent() != null ? e.getOppositeComponent().getClass().getName()
//		                  : "null"));
//		        }
//
//		      });
		String t = "";
		DocumentListener documentListener = new DocumentListener() {
		      public void changedUpdate(DocumentEvent documentEvent) {
		        printIt(documentEvent);
		      }

		      public void insertUpdate(DocumentEvent documentEvent) {
		        printIt(documentEvent);
		      }

		      public void removeUpdate(DocumentEvent documentEvent) {
		        printIt(documentEvent);
		      }

		      private void printIt(DocumentEvent documentEvent) {
		        DocumentEvent.EventType type = documentEvent.getType();
		        String typeString = null;
		        if (type.equals(DocumentEvent.EventType.CHANGE)) {
		          typeString = "Change";
		        } else if (type.equals(DocumentEvent.EventType.INSERT)) {
		          typeString = "Insert";
		        } else if (type.equals(DocumentEvent.EventType.REMOVE)) {
		          typeString = "Remove";
		        }
		        System.out.print("Type  :   " + typeString + " / ");
		        Document source = documentEvent.getDocument();
		        int length = source.getLength();
		        try {
		          System.out.println("Contents: " + source.getText(0, length));
		        } catch (BadLocationException badLocationException) {
		          System.out.println("Contents: Unknown");
		        }
		      }
		    };
	      newUserName.getDocument().addDocumentListener(documentListener);

		
		JLabel passwordLabel = new JLabel("Password: ");
		newPassword = new JTextField(15);
		panel2.add(passwordLabel);
		panel2.add(newPassword);

		
		panel2.add(ok);
		panel2.add(cancel);	
		frame.add(panel);
		frame.add(panel2);
		

		infoBox = Box.createVerticalBox();
		JButton createButton = new JButton("Create a User");
		createButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
						 createUser();
				} catch (Exception error) {
				}
			}
		});
		infoBox.add(createButton);

		JButton editButton = new JButton("Edit a User");
		editButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
						 editUser();
				} catch (Exception error) {
				}
			}
		});
		infoBox.add(editButton);
			
		JButton deleteButton = new JButton("Delete a User");
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
						 deleteUser();
				} catch (Exception error) {
				}
			}
		});
		infoBox.add(deleteButton);
		
		JButton logout = new JButton("Logout");
		logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
						 frame.dispose();
				} catch (Exception error) {
				}
			}
		});
		infoBox.add(logout);

		userTitle.add(infoBox);
		frame.setVisible(true);	
	}	
	  public void focusGained(FocusEvent e) {
          System.out.println("Focus gained");
      } 
	  
	private static void createUser() {
		
		String userName = "", password = "";
		
	}
	
	private static void editUser() {
		String userName = "";
	}
	
	private static void deleteUser() {
		String userName = "";
	}
	
	public static void main(String[] args)
	{
		adminGUI();
	}
}
	
