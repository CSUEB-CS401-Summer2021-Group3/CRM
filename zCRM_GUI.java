
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

import java.awt.event.*;

public class zCRM_GUI {
		
	private static JFrame frame;
		
	private static void adminGUI() {
		frame = new JFrame("CRM GUI");
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		        
		frame.setLayout(new FlowLayout());
		frame.setSize(300, 300);

		JPanel p = new JPanel(new BorderLayout()); 	
		JPanel t = new JPanel();
		
		t.setLayout(new BoxLayout(t, BoxLayout.Y_AXIS));  
		
		frame.add(p);
		p.setBorder(BorderFactory.createCompoundBorder(
	            BorderFactory.createTitledBorder("Welcome Admin"),
	            BorderFactory.createEmptyBorder(15, 15, 15, 15))
	        );
		
		    
		Box infoBox = Box.createVerticalBox();
    
		Box buttonBox = Box.createVerticalBox();

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
		p.add(infoBox);
			
		JButton editButton = new JButton("Edit a User     ");
		editButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
						 editUser();
				} catch (Exception error) {
				}
			}
		});
		infoBox.add(editButton);
		p.add(infoBox);
			
		JButton deleteButton = new JButton("Delete a User ");
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
						 deleteUser();
				} catch (Exception error) {
				}
			}
		});
		infoBox.add(deleteButton);
		
		JButton logout = new JButton("Logout             ");
		logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
						 frame.dispose();
				} catch (Exception error) {
				}
			}
		});
		infoBox.add(logout);

		p.add(infoBox);
		frame.setVisible(true);	
	}	
	
	private static void createUser() {
		
		String userName = "", password = "";
		
		userName = JOptionPane.showInputDialog(frame, "Enter Username");
		password = JOptionPane.showInputDialog(frame, "Enter Password");
		
	}
	
	private static void editUser() {
		String userName = "";
		
		userName = JOptionPane.showInputDialog(frame, "Enter Username to edit");
	}
	
	private static void deleteUser() {
		String userName = "";
		
		userName = JOptionPane.showInputDialog(frame, "Enter Username to delete");
	}
	
	public static void main(String[] args)
	{
		adminGUI();
	}
}
	
