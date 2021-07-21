
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

public class zCRM {
		
	private static JFrame frame;
		
	public static void main(String[] args) {
		frame = new JFrame("CRM GUI");
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		        
		//frame.setLayout(new FlowLayout());
		frame.setSize(400, 400);

		JPanel p = new JPanel(new BorderLayout()); 	
		frame.add(p);
		    
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
		p.add(infoBox);
			
		JButton deleteButton = new JButton("Create a User");
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
						 editUser();
				} catch (Exception error) {
				}
			}
		});
		infoBox.add(deleteButton);
		buttonBox.add(Box.createVerticalStrut(10));
		
		p.add(infoBox);
			
		//p.add(buttonBox);
		frame.setVisible(true);
			
	}	
	
	private static void createUser() {
		
		String userName = "", password = "";
		
		userName = JOptionPane.showInputDialog(frame, "Enter Username");
		password = JOptionPane.showInputDialog(frame, "Enter Password");
		
	}
	
	private static void editUser() {
		
	}
	
	private static void deleteUser() {
		
	}
}
	
