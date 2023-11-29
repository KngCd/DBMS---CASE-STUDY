package Finals_prof;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Intro implements ActionListener{ 
	    JFrame frame;
	    JLabel headerLabel;
	    JLabel headerLabel2;
	    JLabel bodyLabel;
	    JLabel bodyLabel2;
	    JLabel bodyLabel3;
	    JLabel bodyLabel4;
	    JPanel footerPanel;
	    JPanel bodyPanel;
	    JPanel headPanel;
	    JButton button;
	    JButton button2;
	    
	    public void firstFrame(){
	        //head label settings
	        headerLabel = new JLabel();
	        headerLabel.setText("JeepTicket: Ticketing System");
	        headerLabel.setFont(new Font("Serif", Font.BOLD, 25));
	        headerLabel.setForeground(Color.white);
	        headerLabel.setBounds(50,0,350,100);

	        headerLabel2 = new JLabel();
	        headerLabel2.setText("Driving Innovation, Paving the Future");
	        headerLabel2.setFont(new Font("Sans Serif", Font.ITALIC, 16));
	        headerLabel2.setForeground(Color.white);
	        headerLabel2.setBounds(650,0,350,100);

	        //head panel settings
	        headPanel = new JPanel();
	        headPanel.setBackground(new Color(0x24293b));
	        headPanel.setOpaque(true);
	        headPanel.setBounds(0,0,1000, 100);
	        headPanel.setLayout(null);

	        //body label settings
	        bodyLabel = new JLabel();
	        bodyLabel.setText("JR Corporation : Revolutionizing transportation with modern,eco-friendly jeepneys.");
	        bodyLabel.setForeground(Color.BLACK);
	        bodyLabel.setFont(new Font("Century Gothic", Font.BOLD, 17));
	        bodyLabel.setBounds(160,150,670,100);

	        bodyLabel2 = new JLabel();
	        bodyLabel2.setText("Innovation, safety, and sustainability drive our commitment to shaping a better future for public transportation.");
	        bodyLabel2.setForeground(Color.BLACK);
	        bodyLabel2.setFont(new Font("Century Gothic", Font.BOLD, 17));
	        bodyLabel2.setBounds(45,200,900,100);

	        bodyLabel3 = new JLabel();
	        bodyLabel3.setText("Join us on the journey towards smarter cities and greener world!");
	        bodyLabel3.setForeground(Color.BLACK);
	        bodyLabel3.setFont(new Font("Calibri", Font.BOLD, 19));
	        bodyLabel3.setBounds(230,300,550,100);

	        bodyLabel4 = new JLabel();
	        ImageIcon logo = new ImageIcon(getClass().getResource("logo.png"));
	        Image origImage = logo.getImage();
	        int width1 = 100;
	        int height1 = 100;
	        Image resImage = origImage.getScaledInstance(width1, height1, Image.SCALE_SMOOTH);
	        ImageIcon resIcon = new ImageIcon(resImage);
	        bodyLabel4.setIcon(resIcon);
	        bodyLabel4.setText("JR Transport Corporation");
	        bodyLabel4.setBackground(new Color(0xfafafa));
	        bodyLabel4.setOpaque(true);
	        bodyLabel4.setForeground(Color.BLACK);
	        bodyLabel4.setFont(new Font("Serif", Font.BOLD, 24));
	        bodyLabel4.setHorizontalTextPosition(JLabel.LEFT);
	        bodyLabel4.setHorizontalAlignment(JLabel.CENTER);
	        bodyLabel4.setBounds(0,0,1000,100);
	        bodyLabel4.setIconTextGap(470);


	        //button settings
	        ImageIcon image2 = new ImageIcon(getClass().getResource("pass.png"));
	        Image originalImage = image2.getImage();
	        int width = 25;
	        int height = 25;
	        Image resizedImage = originalImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);
	        ImageIcon resizedIcon = new ImageIcon(resizedImage);

	        button = new JButton();
	        button.setText("Passenger");
	        button.setFont(new Font("Serif", Font.BOLD, 15));
	        button.setBackground(Color.WHITE);
	        button.addActionListener(this);
	        button.setFocusable(false);
	        button.setIcon(resizedIcon);
	        button.setHorizontalTextPosition(JButton.RIGHT);
	        button.setVerticalAlignment(JButton.CENTER);
	        button.setBorder(BorderFactory.createEmptyBorder());
	        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
	        button.setContentAreaFilled(false);
	        button.setBounds(490,500, 125,35);
	        
	        ImageIcon image3 = new ImageIcon(getClass().getResource("admin.png"));
	        Image img = image3.getImage();
	        int width2 = 22;
	        int height2 = 22;
	        Image resimg = img.getScaledInstance(width2, height2, Image.SCALE_SMOOTH);
	        ImageIcon resico = new ImageIcon(resimg);

	        button2 = new JButton();
	        button2.setText("Admin");
	        button2.setFont(new Font("Serif", Font.BOLD, 15));
	        button2.setBackground(Color.WHITE);
	        button2.addActionListener(this);
	        button2.setFocusable(false);
	        button2.setIcon(resico);
	        button2.setHorizontalTextPosition(JButton.RIGHT);
	        button2.setVerticalAlignment(JButton.CENTER);
	        button2.setBorder(BorderFactory.createEmptyBorder());
	        button2.setCursor(new Cursor(Cursor.HAND_CURSOR));
	        button2.setContentAreaFilled(false);
	        button2.setBounds(330,500, 125,35);

	        //body panel settings
	        bodyPanel = new JPanel();
	        bodyPanel.setBackground(Color.WHITE);
	        bodyPanel.setBounds(0,100,1000,560);
	        bodyPanel.setLayout(null);

	        //footer panel settings
	        footerPanel = new JPanel();
	        footerPanel.setBackground(new Color(0x4c5e96));
	        footerPanel.setOpaque(true);
	        footerPanel.setBounds(0,658,1000,55);

	        //frame settings
	        frame = new JFrame("JR Corp. Ticketing System");
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setSize(1000, 750);
	        frame.setLayout(null);
	        frame.setVisible(true);
	        frame.setResizable(false);
	        ImageIcon image = new ImageIcon(getClass().getResource("logo.png"));
	        frame.setIconImage(image.getImage());
	        headPanel.add(headerLabel);
	        headPanel.add(headerLabel2);
	        bodyPanel.add(bodyLabel);
	        bodyPanel.add(bodyLabel2);
	        bodyPanel.add(bodyLabel3);
	        bodyPanel.add(bodyLabel4);
	        bodyPanel.add(button);
	        bodyPanel.add(button2);
	        frame.add(bodyPanel);
	        frame.add(headPanel);
	        frame.add(footerPanel);

	    }

	    public static void main(String[] args) {
	       Intro intro = new Intro();
	       intro.firstFrame();
	        
	    }

	    @Override
	    public void actionPerformed(ActionEvent e) {
	      if (e.getSource() == button){
	    	frame.dispose();
	        new Second();
	      }
	      else if (e.getSource() == button2){
		    	frame.dispose();
		    	Admin a = new Admin();
				a.admin();
		      }
	    }
	}

