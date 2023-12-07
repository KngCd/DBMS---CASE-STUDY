package Finals_prof;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

class Jeep {
		private String name;
	    private String spoint;
	    private String dest;
	    private String discount;
	    protected int tot;

	    public Jeep(String name, String spoint, String dest, String discount) {
	    	this.name = name;
	        this.spoint = spoint;
	        this.dest = dest;
	        this.discount = discount;
	        calculateFare();
	    }
	    public void calculateFare() {
	        int km1 = 0;
	        int km2 = 0;
	        
	        if(spoint.equals("San Vicente")){km1 = 6;}
	        else if(spoint.equals("Banay - Banay")){km1 = 6;}
	        else if(spoint.equals("Pinagtung-ulan")){km1 = 10;}
	        else if(spoint.equals("Dita")){km1 = 11;}
	        else if(spoint.equals("Ibabao")){km1 = 12;}
	        else if(spoint.equals("Labac")){km1 = 14;}
	        else if(spoint.equals("Cuenca")){km1 = 15;}
	        else if(spoint.equals("Dominador")){km1 = 17;}
	        else if(spoint.equals("Pinagkrusan")){km1 = 18;}
	        else if(spoint.equals("Alitagtag")){km1 = 20;}
	        else if(spoint.equals("San Jose")){km1 = 21;}
	        else if(spoint.equals("Muzon")){km1 = 23;}
	        else if(spoint.equals("Sta.Teresita")){km1 = 25;}
	        else if(spoint.equals("Tawilisan")){km1 = 27;}
	        else if(spoint.equals("Buli")){km1 = 28;}
	        else if(spoint.equals("Mahabang Ludlod")){km1 = 29;}
	        else if(spoint.equals("Balisong")){km1 = 30;}
	        else if(spoint.equals("Tierra")){km1 = 31;}
	        else if(spoint.equals("Taal")){km1 = 32;}   
	        else if(spoint.equals("Lemery")){km1 = 33;}
	        else if(spoint.equals("Sm Lipa")){km1 = 0;}
	        
	        if(dest.equals("San Vicente")){km2 = 6;}
	        else if(dest.equals("Banay - Banay")){km2 = 6;}
	        else if(dest.equals("Pinagtung-ulan")){km2 = 10;}
	        else if(dest.equals("Dita")){km2 = 11;}
	        else if(dest.equals("Ibabao")){km2 = 12;}
	        else if(dest.equals("Labac")){km2 = 14;}
	        else if(dest.equals("Cuenca")){km2 = 15;}
	        else if(dest.equals("Dominador")){km2 = 17;}
	        else if(dest.equals("Pinagkrusan")){km2 = 18;}
	        else if(dest.equals("Alitagtag")){km2 = 20;}
	        else if(dest.equals("San Jose")){km2 = 21;}
	        else if(dest.equals("Muzon")){km2 = 23;}
	        else if(dest.equals("Sta.Teresita")){km2 = 25;}
	        else if(dest.equals("Tawilisan")){km2 = 27;}
	        else if(dest.equals("Buli")){km2 = 28;}
	        else if(dest.equals("Mahabang Ludlod")){km2 = 29;}
	        else if(dest.equals("Balisong")){km2 = 30;}
	        else if(dest.equals("Tierra")){km2 = 31;}
	        else if(dest.equals("Taal")){km2 = 32;}
	        else if(dest.equals("Lemery")){km2 = 33;}
	        
	        if (km1 > km2){tot = km1 - km2;}
	        else if (km2 > km1){tot = km2 - km1;}
	        
	    }
	    public int getTot() {
	        return tot;
	    }
}
class fareRate extends Jeep {
    public fareRate(String name, String spoint, String dest, String discount) {
        super(name, spoint, dest, discount);
    }
    
    public BigDecimal pricing(String discount) {
    	float fare = 0;
        if (discount.equals("Regular")) {
            int total = getTot();
            if  (total <= 4){
                fare = 15.00f;
            }
            else{
                fare = 15.00f + 2.25f * (total - 4);
            }
        } else {
            int total = getTot();
            if  (total <= 4){
                fare = 15.00f - (15.00f * 0.2f); 
            }
            else{
                fare = (15.00f - (15.00f * 0.2f)) + 1.76f * (total - 4);
            }
        }
        BigDecimal bd = new BigDecimal(Float.toString(fare));
    	bd = bd.setScale(2, RoundingMode.HALF_UP);
    	return bd;
    }
}

public class Last extends Third implements ActionListener{
	
	JButton exitbtn;
	JFrame frame;

	Last(String name, String spoint, String dest, String promo) {
		//set the date and time
		Date dNow = new Date();
		SimpleDateFormat ft = new SimpleDateFormat("E yyyy.MM.dd");
		SimpleDateFormat ft2 = new SimpleDateFormat("hh:mm:ss a");
		SimpleDateFormat ft3 = new SimpleDateFormat("yyyyMM");
		SimpleDateFormat ft4 = new SimpleDateFormat("yyyy-MM-dd");
		
		//generate a random number for the passengers based on the day they, filled up
		// Create a new instance of the Random class
        Random random = new Random();
        // Generate a random number from 1 to 12 and print it
        int randomNumber = random.nextInt(8) + 1;
        
		Random random2 = new Random();
        long number = Math.abs(random2.nextLong() % 999L) + 1;
        
        fareRate f = new fareRate(name, spoint, dest, promo);
		BigDecimal fare = f.pricing(promo);
          
		
		//head label settings
        JLabel headerLabel = new JLabel();
        headerLabel.setText("JeepTicket: Ticketing System");
        headerLabel.setFont(new Font("Serif", Font.BOLD, 25));
        headerLabel.setForeground(Color.white);
        headerLabel.setBounds(50,0,350,100);

        JLabel headerLabel2 = new JLabel();
        headerLabel2.setText("Driving Innovation, Paving the Future");
        headerLabel2.setFont(new Font("Sans Serif", Font.ITALIC, 16));
        headerLabel2.setForeground(Color.white);
        headerLabel2.setBounds(650,0,350,100);

        //head panel settings
        JPanel headPanel = new JPanel();
        headPanel.setBackground(new Color(0x24293b));
        headPanel.setOpaque(true);
        headPanel.setBounds(0,0,1000, 100);
        headPanel.setLayout(null);
        
        //body label settings
        JLabel bodyLabel = new JLabel();
        bodyLabel.setText("JR Transport Corporation");
        bodyLabel.setForeground(Color.BLACK);
        bodyLabel.setFont(new Font("Serif", Font.BOLD, 25));
        bodyLabel.setBounds(340,10,670,100);
        
        
        JLabel bodyLabel2 = new JLabel();
        bodyLabel2.setText(ft.format(dNow) + " / " + ft2.format(dNow));
        bodyLabel2.setForeground(Color.BLACK);
        bodyLabel2.setFont(new Font("Monospaced", Font.BOLD, 15));
        bodyLabel2.setBounds(230,-20,670,100);
        
        JLabel bodyLabel3 = new JLabel();
        bodyLabel3.setText("Passenger ID: " + ft3.format(dNow) + number);
        bodyLabel3.setForeground(Color.BLACK);
        bodyLabel3.setFont(new Font("Monospaced", Font.BOLD, 15));
        bodyLabel3.setBounds(13,5,670,100);
        
        JLabel bodyLabel4 = new JLabel();
        bodyLabel4.setText("LIPA CITY - LEMERY BATANGAS");
        bodyLabel4.setForeground(Color.BLACK);
        bodyLabel4.setFont(new Font("Century Gothic", Font.BOLD, 17));
        bodyLabel4.setBounds(120,45,670,100);
        
        JLabel bodyLabel5 = new JLabel();
        bodyLabel5.setText(spoint + " - " + dest);
        bodyLabel5.setForeground(Color.BLACK);
        bodyLabel5.setFont(new Font("Century Gothic", Font.BOLD, 16));
        bodyLabel5.setBounds(205,90,670,100);
        
        JLabel bodyLabel6 = new JLabel();
        bodyLabel6.setText(name);
        bodyLabel6.setForeground(Color.BLACK);
        bodyLabel6.setFont(new Font("Century Gothic", Font.ROMAN_BASELINE, 16));
        bodyLabel6.setBounds(35,90,670,100);
        
		
		JLabel bodyLabel7 = new JLabel();
        bodyLabel7.setText(promo + " : " + fare);
        bodyLabel7.setForeground(Color.BLACK);
        bodyLabel7.setFont(new Font("Monospaced", Font.BOLD, 19));
        bodyLabel7.setBounds(150,150,670,100);
        
        JLabel bodyLabel8 = new JLabel();
        bodyLabel8.setText("Payment Code: Cash");
        bodyLabel8.setForeground(Color.BLACK);
        bodyLabel8.setFont(new Font("Century Gothic", Font.ROMAN_BASELINE, 16));
        bodyLabel8.setBounds(152,195,670,100);
        
        JLabel bodyLabel9 = new JLabel();
        bodyLabel9.setText("Thank you!");
        bodyLabel9.setForeground(Color.BLACK);
        bodyLabel9.setFont(new Font("Bahnschrift", Font.ROMAN_BASELINE, 16));
        bodyLabel9.setBounds(189,240,670,100);
        
        JLabel bodyLabel10 = new JLabel();
        bodyLabel10.setText("Modern Jeepney No. " + randomNumber);
        bodyLabel10.setForeground(Color.BLACK);
        bodyLabel10.setFont(new Font("Monospaced", Font.ROMAN_BASELINE, 11));
        bodyLabel10.setBounds(5,280,670,100);
        
        //button settings
        ImageIcon image2 = new ImageIcon(getClass().getResource("exit.png"));
        Image originalImage = image2.getImage();
        int width = 22;
        int height = 22;
        Image resizedImage = originalImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(resizedImage);

        exitbtn = new JButton();
        exitbtn.setText("Exit");
        exitbtn.setFont(new Font("Serif", Font.BOLD, 15));
        exitbtn.setBackground(Color.WHITE);
        exitbtn.addActionListener(this);
        exitbtn.setFocusable(false);
        exitbtn.setIcon(resizedIcon);
        exitbtn.setHorizontalTextPosition(JButton.LEFT);
        exitbtn.setVerticalAlignment(JButton.CENTER);
        exitbtn.setBorder(BorderFactory.createEmptyBorder());
        exitbtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        exitbtn.setContentAreaFilled(false);
        exitbtn.setBounds(410,500, 125,35);
        
        //set Border for the bodyPanel
        Border border = BorderFactory.createLineBorder(Color.BLACK ,2);
        
        //body panel settings
        JPanel bodyPanel = new JPanel();
        bodyPanel.setBackground(Color.WHITE);
        bodyPanel.setBounds(235,120,500,350);
        bodyPanel.setBorder(border);
        bodyPanel.setLayout(null);
        
        JPanel bodyPanel1 = new JPanel();
        bodyPanel1.setBackground(Color.WHITE);
        bodyPanel1.setBounds(0,100,1000,560);
        bodyPanel1.setLayout(null);
        
        //footer panel settings
        JPanel footerPanel = new JPanel();
        footerPanel.setBackground(new Color(0x4c5e96));
        footerPanel.setOpaque(true);
        footerPanel.setBounds(0,658,1000,55);
		
		frame = new JFrame();
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
        bodyPanel1.add(bodyLabel);
        bodyPanel.add(bodyLabel2);
        bodyPanel.add(bodyLabel3);
        bodyPanel.add(bodyLabel4);
        bodyPanel.add(bodyLabel5);
        bodyPanel.add(bodyLabel6);
        bodyPanel.add(bodyLabel7);
        bodyPanel.add(bodyLabel8);
        bodyPanel.add(bodyLabel9);
        bodyPanel.add(bodyLabel10);
        bodyPanel1.add(exitbtn);
        bodyPanel1.add(bodyPanel);
        frame.add(headPanel);
        frame.add(bodyPanel1);
        frame.add(footerPanel);
        
        try {
			//open connection
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ticketing_system", "root", "");
			
			//for inserting data into the table
			Statement stm = con.createStatement();
			
			String sql = "INSERT INTO passenger_table VALUES("+ft3.format(dNow) + number+", '"+name+"', '"+spoint+"', '"+dest+"', '"+promo+"', "+fare+", '"+ft4.format(dNow)+"', "+randomNumber+")";
			 
			//execute update
			stm.executeUpdate(sql);
			
			
			//close connection
			con.close();
		}
		catch (Exception e1){
			e1.printStackTrace();
		}
		
	}
	
	
	
	@Override
    public void actionPerformed(ActionEvent e) {
      if (e.getSource() == exitbtn){
        Intro i = new Intro();
        i.firstFrame();
        frame.dispose();
      }
    }
}



