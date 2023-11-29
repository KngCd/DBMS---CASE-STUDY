package Finals_prof;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.AbstractBorder;

public class Third extends JFrame implements ActionListener{
	
	JLabel headerLabel;
	JPanel headPanel;
	JLabel userLabel;
	JLabel startingpointLabel;
	JLabel destinationLabel;
	JLabel promoLabel;
	JTextField userField;
	JButton button1;
	JButton button2;
	JPanel bodyPanel;
	JPanel footerPanel1;
	JComboBox<String> comboBox;
	JComboBox<String> comboBox2;
	JComboBox<String> comboBox3;
	
	public void thirdFrame(){
		
		 //head label settings
        headerLabel = new JLabel();
        headerLabel.setText("Information");
        headerLabel.setFont(new Font("Serif", Font.BOLD, 25));
        headerLabel.setForeground(Color.white);
        headerLabel.setBounds(435,0,350,100);
		
		//head panel settings
        headPanel = new JPanel();
        headPanel.setBackground(new Color(0x24293b));
        headPanel.setOpaque(true);
        headPanel.setBounds(0,0,1000, 100);
        headPanel.setLayout(null);
        
        userLabel = new JLabel();
        userLabel.setText("Name");
        userLabel.setFont(new Font("Century Gothic", Font.BOLD	, 17));
        userLabel.setForeground(Color.BLACK);
        userLabel.setBounds(370,40,100,100);
        userField = new JTextField(20);
        // Setting the size of the JTextField
        userField.setPreferredSize(new Dimension(200, 35));
        userField.setBounds(470,75,200,35);
        // Setting the border of the JTextField
        userField.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        // Setting the font of the JTextField
        userField.setFont(new Font("Arial", Font.PLAIN, 15));
        
        // Setting the border of the JTextField
        userField.setBorder(new AbstractBorder() {
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
        
        
        // JLabel on places
        startingpointLabel = new JLabel();
        startingpointLabel.setText("Select Starting Point");
        startingpointLabel.setFont(new Font("Century Gothic", Font.BOLD	, 17));
        startingpointLabel.setForeground(Color.BLACK);
        startingpointLabel.setBounds(260,115,200,100);
        destinationLabel = new JLabel();
        destinationLabel.setText("Select Destination");
        destinationLabel.setFont(new Font("Century Gothic", Font.BOLD	, 17));
        destinationLabel.setForeground(Color.BLACK);
        destinationLabel.setBounds(275,190,200,100);
        
        //JLabel on discount promo
        promoLabel = new JLabel();
        promoLabel.setText("Regular/Discounted");
        promoLabel.setFont(new Font("Century Gothic", Font.BOLD	, 17));
        promoLabel.setForeground(Color.BLACK);
        promoLabel.setBounds(258,268,200,100);
        
        //adding places on the list
        comboBox = new JComboBox<>(new String[] {
        		"SM Lipa", "San Vicente", "Banay - Banay", "Pinagtung-ulan", "Dita",
        		"Ibabao", "Labac", "Cuenca", "Dominador", "Pinagkrusan", "Alitagtag",
        		"San Jose", "Muzon", "Sta.Teresita", "Tawilisan", "Buli",
        		"Mahabang Ludlod", "Balisong", "Tierra", "Taal", "Lemery"});
        comboBox.setBorder(BorderFactory.createBevelBorder(0));
        comboBox.setFont(new Font("Verdana", Font.PLAIN, 15));
        comboBox.setBackground(Color.WHITE);
        comboBox.setCursor(new Cursor(Cursor.HAND_CURSOR));
        comboBox.setBounds(470,150,200,35);
        
        comboBox2 = new JComboBox<>(new String[] {
        		"SM Lipa", "San Vicente", "Banay - Banay", "Pinagtung-ulan", "Dita",
        		"Ibabao", "Labac", "Cuenca", "Dominador", "Pinagkrusan", "Alitagtag",
        		"San Jose", "Muzon", "Sta.Teresita", "Tawilisan", "Buli",
        		"Mahabang Ludlod", "Balisong", "Tierra", "Taal", "Lemery"});
        comboBox2.setBorder(BorderFactory.createBevelBorder(0));
        comboBox2.setFont(new Font("Verdana", Font.PLAIN, 15));
        comboBox2.setBackground(Color.WHITE);
        comboBox2.setCursor(new Cursor(Cursor.HAND_CURSOR));
        comboBox2.setBounds(470,226,200,35);
        
        comboBox3 = new JComboBox<>(new String[] {
        		"Regular", "Discounted"});
        comboBox3.setBorder(BorderFactory.createBevelBorder(0));
        comboBox3.setFont(new Font("Verdana", Font.PLAIN, 15));
        comboBox3.setBackground(Color.WHITE);
        comboBox3.setCursor(new Cursor(Cursor.HAND_CURSOR));
        comboBox3.setBounds(470,300,200,35);
        
        //button settings
        ImageIcon image2 = new ImageIcon(getClass().getResource("next.png"));
        Image originalImage = image2.getImage();
        int width = 26;
        int height = 26;
        Image resizedImage = originalImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(resizedImage);

        button1 = new JButton();
        button1.setText("Next");
        button1.setFont(new Font("Serif", Font.BOLD, 15));
        button1.setBackground(Color.WHITE);
        button1.addActionListener(this);
        button1.setFocusable(false);
        button1.setIcon(resizedIcon);
        button1.setHorizontalTextPosition(JButton.LEFT);
        button1.setVerticalAlignment(JButton.CENTER);
        button1.setBorder(BorderFactory.createEmptyBorder());
        button1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button1.setContentAreaFilled(false);
        button1.setBounds(490,500, 125,35);

        ImageIcon image3 = new ImageIcon(getClass().getResource("back.png"));
        Image img = image3.getImage();
        int width2 = 24;
        int height2 = 24;
        Image resizedimg = img.getScaledInstance(width2, height2, Image.SCALE_SMOOTH);
        ImageIcon resizedico = new ImageIcon(resizedimg);

        button2 = new JButton();
        button2.setText("Back");
        button2.setFont(new Font("Serif", Font.BOLD, 15));
        button2.setBackground(Color.WHITE);
        button2.addActionListener(this);
        button2.setFocusable(false);
        button2.setIcon(resizedico);
        button2.setHorizontalTextPosition(JButton.RIGHT);
        button2.setVerticalAlignment(JButton.CENTER);
        button2.setBorder(BorderFactory.createEmptyBorder());
        button2.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button2.setContentAreaFilled(false);
        button2.setBounds(370,500, 125,35);
        
        
        //body panel settings
        bodyPanel = new JPanel (); //(new FlowLayout(FlowLayout.CENTER, 200,50));
        bodyPanel.setLayout(null);
        bodyPanel.setBackground(Color.WHITE);
        bodyPanel.setBounds(0,100,1000,560);
        
        //footer panel settings
        footerPanel1 = new JPanel();
        footerPanel1.setBackground(new Color(0x4c5e96));
        footerPanel1.setOpaque(true);
        footerPanel1.setBounds(0,658,1000,55);
        
		//frame settings
        this.setTitle("JR Corp. Ticketing System");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000, 750);
        this.setLayout(null);
        this.setVisible(true);
        this.setResizable(false);
        ImageIcon image = new ImageIcon(getClass().getResource("logo.png"));
        this.setIconImage(image.getImage());
        this.add(headPanel);
        headPanel.add(headerLabel);
        this.add(bodyPanel);
        bodyPanel.add(userLabel);
        bodyPanel.add(userField);
        bodyPanel.add(startingpointLabel);
        bodyPanel.add(destinationLabel);
        bodyPanel.add(promoLabel);
        bodyPanel.add(comboBox);
        bodyPanel.add(comboBox2);
        bodyPanel.add(comboBox3);
        bodyPanel.add(button1);
        bodyPanel.add(button2);
        this.add(footerPanel1);
        
	}
        
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == button2){
            this.dispose();
            new Second();
          }
        else if (e.getSource() == button1){
        	int result = JOptionPane.showOptionDialog(null, "Are you sure you want to proceed", "Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null,null, 0);
        	
        	if (result == JOptionPane.YES_OPTION) {
        		this.dispose();
        		// Get the selected item from the JComboBox and JTextField
        		String name = userField.getText();
                String text = (String) comboBox.getSelectedItem();
                String text2 = (String) comboBox2.getSelectedItem();
                String text3 = (String) comboBox3.getSelectedItem();

                // Call the text method from the Last class
                new Jeep(name,text,text2,text3);
                new Last(name, text, text2, text3);
                
            } 
          }
		
	}
}

