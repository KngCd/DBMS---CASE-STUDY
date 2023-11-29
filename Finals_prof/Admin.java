package Finals_prof;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.AbstractBorder;

public class Admin {
	JLabel userLabel;
	JTextField userTextField;
	JLabel passwordLabel;
	JPasswordField passwordField;
	JButton loginButton;
	JFrame frame = new JFrame();

	public void admin() {
		
		 //head label settings
        JLabel headerLabel = new JLabel();
        headerLabel.setText("Login");
        headerLabel.setFont(new Font("Serif", Font.BOLD, 25));
        headerLabel.setForeground(Color.white);
        headerLabel.setBounds(220,-20,350,100);
        
        //head panel settings
        JPanel headPanel = new JPanel();
        headPanel.setBackground(new Color(0x24293b));
        headPanel.setOpaque(true);
        headPanel.setBounds(0,0,500, 70);
        headPanel.setLayout(null);
        
        
        userLabel = new JLabel("Username");
        userLabel.setFont(new Font("Century Gothic", Font.BOLD	, 16));
        userLabel.setForeground(Color.BLACK);
        userLabel.setBounds(85,37,100,100);
        
        userTextField = new JTextField(20);
        userTextField.setBounds(200,70,200,35);
        // Setting the border of the JTextField
        userTextField.setFont(new Font("Arial", Font.PLAIN, 15));
        
        // Setting the border of the JTextField
        userTextField.setBorder(new AbstractBorder() {
            @Override
            public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
                g.setColor(Color.BLACK);
                g.drawRoundRect(x, y, width - 1, height - 1, 20, 20);
            }

            @Override
            public Insets getBorderInsets(Component c) {
                return new Insets(5, 10, 5, 10);
            }

            @Override
            public boolean isBorderOpaque() {
                return false;
            }
        });

        userTextField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                passwordField.requestFocusInWindow();
            }
        });
        
        
        passwordLabel = new JLabel("Password");
        passwordLabel.setFont(new Font("Century Gothic", Font.BOLD	, 16));
        passwordLabel.setForeground(Color.BLACK);
        passwordLabel.setBounds(85,105,100,100);
        
        passwordField = new JPasswordField(20);
        passwordField.setBounds(200,138,200,35);
        // Setting the border of the JPasswordField
        passwordField.setFont(new Font("Arial", Font.PLAIN, 15));
        
        // Setting the border of the JPasswordField
        passwordField.setBorder(new AbstractBorder() {
            @Override
            public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
                g.setColor(Color.BLACK);
                g.drawRoundRect(x, y, width - 1, height - 1, 20, 20);
            }

            @Override
            public Insets getBorderInsets(Component c) {
	                return new Insets(5, 10, 5, 10);
            }

            @Override
            public boolean isBorderOpaque() {
                return false;
            }
        });
        
        loginButton = new JButton("Login");
        loginButton.setFont(new Font("Serif", Font.BOLD, 15));
        loginButton.setBackground(Color.WHITE);
        loginButton.setFocusable(false);
        loginButton.setHorizontalTextPosition(JButton.LEFT);
        loginButton.setVerticalAlignment(JButton.CENTER);
        loginButton.setBorder(BorderFactory.createEmptyBorder());
        loginButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        loginButton.setContentAreaFilled(false);
        loginButton.setBounds(180,200, 125,35);
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onLoginButtonClick();
            }
        });
     // Add a MouseListener to handle the button animations
        loginButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                loginButton.setContentAreaFilled(true);
                loginButton.setBackground(new Color(0x24293b));
                loginButton.setForeground(Color.WHITE);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                loginButton.setContentAreaFilled(false);
                loginButton.setBackground(Color.WHITE);
                loginButton.setForeground(Color.BLACK);
            }
        });
        
        
        ImageIcon image2 = new ImageIcon(getClass().getResource("exit.png"));
        Image originalImage = image2.getImage();
        int width = 17;
        int height = 17;
        Image resizedImage = originalImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(resizedImage);
        
        JButton exitbtn = new JButton();
        exitbtn.setText("Exit");
        exitbtn.setFont(new Font("Serif", Font.BOLD, 15));
        exitbtn.setBackground(Color.WHITE);
        exitbtn.setFocusable(false);
        exitbtn.setIcon(resizedIcon);
        exitbtn.setHorizontalTextPosition(JButton.LEFT);
        exitbtn.setVerticalAlignment(JButton.CENTER);
        exitbtn.setBorder(BorderFactory.createEmptyBorder());
        exitbtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        exitbtn.setContentAreaFilled(false);
        exitbtn.setBounds(183,300, 125,35);
        exitbtn.addActionListener(new ActionListener() {
        	@Override
            public void actionPerformed(ActionEvent e) {
                Intro i = new Intro();
                i.firstFrame();
                frame.dispose();
            }
        });
        
        JPanel bodyPanel = new JPanel();
        bodyPanel.setLayout(null);
        bodyPanel.setBounds(0, 70, 500, 350);
        bodyPanel.setBackground(Color.WHITE);
        
	
        //footer panel settings
        JPanel footerPanel = new JPanel();
        footerPanel.setBackground(new Color(0x4c5e96));
        footerPanel.setOpaque(true);
        footerPanel.setBounds(0,420,500,50);
        
        
        //frame settings
        frame = new JFrame("JR Corp. Ticketing System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setResizable(false);
        ImageIcon image = new ImageIcon(getClass().getResource("logo.png"));
        frame.setIconImage(image.getImage());
        
        headPanel.add(headerLabel);
        bodyPanel.add(userLabel);
        bodyPanel.add(userTextField);
        bodyPanel.add(passwordLabel);
        bodyPanel.add(passwordField);
        bodyPanel.add(loginButton);
        bodyPanel.add(exitbtn);
        frame.add(headPanel);
        frame.add(bodyPanel);
        frame.add(footerPanel);
    
	}
	
	public void onLoginButtonClick() {
		String username = userTextField.getText();
        String password = new String(passwordField.getPassword());

        if (username.equals("admin") && password.equals("admin")) {
            JOptionPane.showMessageDialog(null, "Login successful!", "Admin Login", JOptionPane.PLAIN_MESSAGE);
            frame.dispose();
            adminInterface a = new adminInterface();
            a.btns();

        } else {
            JOptionPane.showMessageDialog(null, "Invalid username or password. Please try again.", "Admin Login", JOptionPane.ERROR_MESSAGE);
        }
	}

	public static void main(String []args) {
		
		Admin a = new Admin();
		a.admin();
	}
}
