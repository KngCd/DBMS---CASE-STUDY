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

public class Second extends JFrame implements ActionListener {
    JLabel headerLabel1;
    JLabel headerLabe1;
    JLabel bodyLabel;
    JLabel bodyLabel2;
    JLabel bodyLabel3;
    JLabel bodyLabel4;
    JPanel headPanel1;
    JPanel bodyPanel1;
    JPanel footerPanel1;
    JButton button1;
    JButton button2;

    Second(){

        //head label settings
        headerLabel1 = new JLabel();
        headerLabel1.setText("ROUTE");
        headerLabel1.setFont(new Font("Serif", Font.BOLD, 25));
        headerLabel1.setForeground(Color.white);
        headerLabel1.setBounds(610,-15,100,100);

        headerLabe1 = new JLabel();
        headerLabe1.setText("Lipa City Grand Terminal - Lemery");
        headerLabe1.setFont(new Font("Sans Serif", Font.ITALIC, 16));
        headerLabe1.setForeground(Color.white);
        headerLabe1.setBounds(526,25,350,100);

        //head panel settings
        headPanel1 = new JPanel();
        headPanel1.setBackground(new Color(0x24293b));
        headPanel1.setOpaque(true);
        headPanel1.setBounds(0,0,1300, 100);
        headPanel1.setLayout(null);
        
        //body label settings
        ImageIcon image4 = new ImageIcon(getClass().getResource("route1.png"));
        Image origi = image4.getImage();
        int width1 = 450;
        int height1 = 490;
        Image imga = origi.getScaledInstance(width1, height1, Image.SCALE_SMOOTH);
        ImageIcon ico = new ImageIcon(imga);
        bodyLabel2 = new JLabel();
        bodyLabel2.setIcon(ico);
        bodyLabel2.setBounds(100,30,850,500);
        
        ImageIcon image5 = new ImageIcon(getClass().getResource("route2.png"));
        Image or = image5.getImage();
        int width3 = 450;
        int height3 = 490;
        Image imag = or.getScaledInstance(width3, height3, Image.SCALE_SMOOTH);
        ImageIcon icon = new ImageIcon(imag);
        bodyLabel3 = new JLabel();
        bodyLabel3.setIcon(icon);
        bodyLabel3.setBounds(734,27,850,500);
      
        bodyLabel = new JLabel();
        bodyLabel.setText("SM LIPA");
        bodyLabel.setFont(new Font("Serif", Font.BOLD, 23));
        bodyLabel.setForeground(Color.BLACK);
        bodyLabel.setBounds(280,-34,100,100);
        bodyLabel4 = new JLabel();
        bodyLabel4.setText("LEMERY");
        bodyLabel4.setFont(new Font("Serif", Font.BOLD, 23));
        bodyLabel4.setForeground(Color.BLACK);
        bodyLabel4.setBounds(920,-34,100,100);
        

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
        button1.setBounds(635,525, 125,35);

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
        button2.setBounds(527,525, 125,35);
        
        //body panel settings
        bodyPanel1 = new JPanel();
        bodyPanel1.setBackground(Color.WHITE);
        bodyPanel1.setBounds(0,100,1300,585);
        bodyPanel1.setLayout(null);
       
        //footer panel settings
        footerPanel1 = new JPanel();
        footerPanel1.setBackground(new Color(0x4c5e96));
        footerPanel1.setOpaque(true);
        footerPanel1.setBounds(0,683,1300,65);

        this.setTitle("JR Corp. Ticketing System");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1300, 800);
        this.setLayout(null);
        this.setVisible(true);
        this.setResizable(false);
        ImageIcon image = new ImageIcon(getClass().getResource("logo.png"));
        this.setIconImage(image.getImage());
        headPanel1.add(headerLabel1);
        headPanel1.add(headerLabe1);
        bodyPanel1.add(bodyLabel);
        bodyPanel1.add(bodyLabel2);
        bodyPanel1.add(bodyLabel3);
        bodyPanel1.add(bodyLabel4);
        bodyPanel1.add(button1);
        bodyPanel1.add(button2);
        this.add(headPanel1);
        this.add(bodyPanel1);
        this.add(footerPanel1);
    }
   
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button2){
            Intro intro = new Intro();
            this.dispose();
            intro.firstFrame();
          }
        else if (e.getSource() == button1){
            this.dispose();
            Third t = new Third();
            t.thirdFrame();
          }
    }
    
}
