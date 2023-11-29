package Finals_prof;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class adminInterface {
	
	JFrame frame;
	JPanel leftPanel;
	JPanel bodyPanel;
	JButton btn1;
	JButton btn2;
	JButton btn3;
	JButton btn4;
	
	
	public void btns() {
		
		//head label settings
        JLabel headerLabel = new JLabel();
        headerLabel.setText("Admin");
        headerLabel.setFont(new Font("Serif", Font.BOLD, 25));
        headerLabel.setForeground(Color.white);
        headerLabel.setBounds(450,-10,350,100);
        
        //head panel settings
        JPanel headPanel = new JPanel();
        headPanel.setBackground(new Color(0x24293b));
        headPanel.setOpaque(true);
        headPanel.setBounds(0,0,1000, 100);
        headPanel.setLayout(null);
        
        Border border = BorderFactory.createLineBorder(Color.BLACK , 1);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(270,60,650,350);
        scrollPane.setBackground(Color.WHITE);
        scrollPane.setFont(new Font("Arial", Font.ROMAN_BASELINE, 10));
        scrollPane.setBorder(border);
        
        JTable table = new JTable();
        scrollPane.setViewportView(table);
        
        //body panel settings
        leftPanel = new JPanel();
        leftPanel.setBackground(Color.WHITE);
        leftPanel.setBounds(0,100,1000,560);
        leftPanel.setBorder(new EmptyBorder(5,5,5,5));
        leftPanel.setLayout(null);
        leftPanel.add(scrollPane);   
        
        
        bodyPanel = new JPanel();
        bodyPanel.setBackground(Color.WHITE);
        bodyPanel.setBounds(0,0,200,560);
        bodyPanel.setBorder(border);
		
		btn1 = new JButton("View All");
		btn1.setFont(new Font("Serif", Font.BOLD, 15));
        btn1.setBackground(Color.WHITE);
        btn1.setFocusable(false);
        btn1.setHorizontalTextPosition(JButton.LEFT);
        btn1.setBorder(BorderFactory.createEmptyBorder());
        btn1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn1.setContentAreaFilled(false);
        btn1.setBounds(37,50, 125,35);
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                	Class.forName("com.mysql.cj.jdbc.Driver");
        			
        			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ticketing_system", "root", "");
        			
        			//for inserting data into the table
        			Statement stm = con.createStatement();
        			String query = "SELECT *FROM passenger_table";
        			
        			ResultSet rs = stm.executeQuery(query);
        			ResultSetMetaData rsmd = rs.getMetaData();
        			DefaultTableModel model = (DefaultTableModel) table.getModel();
        			
        			int cols = rsmd.getColumnCount();
        			String[] colName = new String[cols];
        			for (int i = 0; i<cols; i++)
        				colName[i] = rsmd.getColumnName(i+1);
        			model.setColumnIdentifiers(colName);
        			
        			String pass_id, name, spoint, dest, promo, fare, date, bus_no;
        			while (rs.next())
        			{
        				pass_id = rs.getString(1);
        				name = rs.getString(2);
        				spoint = rs.getString(3);
        				dest = rs.getString(4);
        				promo = rs.getString(5);
        				fare = rs.getString(6);
        				date = rs.getString(7);
        				bus_no = rs.getString(8);
        				String[] row = {pass_id, name, spoint, dest, promo, fare, date, bus_no};
        				model.addRow(row);
        			}
        			stm.close();
        			con.close();
        			
                }
                catch(ClassNotFoundException | SQLException e1) {
                	e1.printStackTrace();
                }
            }
        });

        // Add a MouseListener to handle the button animations
        btn1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                btn1.setContentAreaFilled(true);
                btn1.setBackground(new Color(0x24293b));
                btn1.setForeground(Color.WHITE);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                btn1.setContentAreaFilled(false);
                btn1.setBackground(Color.WHITE);
                btn1.setForeground(Color.BLACK);
            }
        });
        
        btn2 = new JButton("Clear");
		btn2.setFont(new Font("Serif", Font.BOLD, 15));
        btn2.setBackground(Color.WHITE);
        btn2.setFocusable(false);
        btn2.setHorizontalTextPosition(JButton.LEFT);
        btn2.setBorder(BorderFactory.createEmptyBorder());
        btn2.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn2.setContentAreaFilled(false);
        btn2.setBounds(37,150, 125,35);
        btn2.addActionListener(new ActionListener() {
        	 public void actionPerformed(ActionEvent e) {
        		 table.setModel(new DefaultTableModel());
        	 }
        });
        
        // Add a MouseListener to handle the button animations
        btn2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                btn2.setContentAreaFilled(true);
                btn2.setBackground(new Color(0x24293b));
                btn2.setForeground(Color.WHITE);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                btn2.setContentAreaFilled(false);
                btn2.setBackground(Color.WHITE);
                btn2.setForeground(Color.BLACK);
            }
        });
        
        
        btn3 = new JButton("Delete");
		btn3.setFont(new Font("Serif", Font.BOLD, 15));
        btn3.setBackground(Color.WHITE);
        btn3.setFocusable(false);
        btn3.setHorizontalTextPosition(JButton.LEFT);
        btn3.setBorder(BorderFactory.createEmptyBorder());
        btn3.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn3.setContentAreaFilled(false);
        btn3.setBounds(37,250, 125,35);
        btn3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int inputValue = JOptionPane.showOptionDialog(null, "Do you want to Delete All?", "DELETE", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null,null, 0);
				
				if (inputValue == JOptionPane.NO_OPTION) {
				
				String inputValue2 = JOptionPane.showInputDialog(null, "Please enter the Passenger ID:", "DELETE", JOptionPane.QUESTION_MESSAGE);
				
				if (inputValue2 == null || inputValue2.trim().isEmpty()) {
					
					JOptionPane.showMessageDialog(null, "Please enter a value!", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else {
                try {
        			//open connection
        			Class.forName("com.mysql.cj.jdbc.Driver");
        			
        			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ticketing_system", "root", "");
        			
        			//for inserting data into the table
        			Statement stm = con.createStatement();
        			
        			String query = "DELETE FROM passenger_table WHERE pass_id =" + inputValue2;
        			 
        			//execute update
        			stm.executeUpdate(query);
        			JOptionPane.showMessageDialog(null, "Passenger Succesfully Deleted!", "Succesful!", JOptionPane.INFORMATION_MESSAGE);
        			
        			//close connection
        			con.close();
        		}
                catch(ClassNotFoundException | SQLException e1) {
                	e1.printStackTrace();
                }
				}
			}
			else if (inputValue == JOptionPane.YES_OPTION) {
				try {
        			//open connection
        			Class.forName("com.mysql.cj.jdbc.Driver");
        			
        			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ticketing_system", "root", "");
        			
        			//for deleting data into the table
        			Statement stm = con.createStatement();
        			
        			String query = "DELETE FROM passenger_table WHERE pass_id IS NOT NULL AND name IS NOT NULL AND spoint IS NOT NULL AND destination IS NOT NULL AND promo IS NOT NULL AND fare IS NOT NULL AND date IS NOT NULL AND mjeep_no IS NOT NULL;";
        			 
        			//execute update
        			stm.executeUpdate(query);
        			JOptionPane.showMessageDialog(null, "Succesfully Deleted!", "Succesful!", JOptionPane.INFORMATION_MESSAGE);
        			
        			
        			//close connection
        			con.close();
        		}
                catch(ClassNotFoundException | SQLException e1) {
                	e1.printStackTrace();
                }
			}
			
		}
        	
            });
       
        
        // Add a MouseListener to handle the button animations
        btn3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                btn3.setContentAreaFilled(true);
                btn3.setBackground(new Color(0x24293b));
                btn3.setForeground(Color.WHITE);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                btn3.setContentAreaFilled(false);
                btn3.setBackground(Color.WHITE);
                btn3.setForeground(Color.BLACK);
            }
        });
        
        btn4 = new JButton("Search");
		btn4.setFont(new Font("Serif", Font.BOLD, 15));
        btn4.setBackground(Color.WHITE);
        btn4.setFocusable(false);
        btn4.setHorizontalTextPosition(JButton.LEFT);
        btn4.setBorder(BorderFactory.createEmptyBorder());
        btn4.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn4.setContentAreaFilled(false);
        btn4.setBounds(37,350, 125,35);
        btn4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String inputValue = JOptionPane.showInputDialog(null, "Please enter the Passenger ID:", "SEARCH", JOptionPane.QUESTION_MESSAGE);
				
				if (inputValue == null || inputValue.trim().isEmpty()) {
					
					JOptionPane.showMessageDialog(null, "Please enter a value!", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else {
                try {
        			//open connection
        			Class.forName("com.mysql.cj.jdbc.Driver");
        			
        			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ticketing_system", "root", "");
        			
        			//for inserting data into the table
        			Statement stm = con.createStatement();
        			
        			String query = "SELECT *FROM passenger_table WHERE pass_id = " + inputValue;
        			 
        			JOptionPane.showMessageDialog(null, "Passenger Found!", "Succesful!", JOptionPane.INFORMATION_MESSAGE);
        			
        			//execute query
        			ResultSet rs = stm.executeQuery(query);
        			ResultSetMetaData rsmd = rs.getMetaData();
        			DefaultTableModel model = (DefaultTableModel) table.getModel();
        			
        			int cols = rsmd.getColumnCount();
        			String[] colName = new String[cols];
        			for (int i = 0; i<cols; i++)
        				colName[i] = rsmd.getColumnName(i+1);
        			model.setColumnIdentifiers(colName);
        			
        			String pass_id, name, spoint, dest, promo, fare, date, bus_no;
        			while (rs.next())
        			{
        				pass_id = rs.getString(1);
        				name = rs.getString(2);
        				spoint = rs.getString(3);
        				dest = rs.getString(4);
        				promo = rs.getString(5);
        				fare = rs.getString(6);
        				date = rs.getString(7);
        				bus_no = rs.getString(8);
        				String[] row = {pass_id, name, spoint, dest, promo, fare, date, bus_no};
        				model.addRow(row);
        			}
        			stm.close();
        			con.close();
        		}
                catch(ClassNotFoundException | SQLException e1) {
                	e1.printStackTrace();
                }
				}
				
			}
        	
        });
        
        
        // Add a MouseListener to handle the button animations
        btn4.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                btn4.setContentAreaFilled(true);
                btn4.setBackground(new Color(0x24293b));
                btn4.setForeground(Color.WHITE);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                btn4.setContentAreaFilled(false);
                btn4.setBackground(Color.WHITE);
                btn4.setForeground(Color.BLACK);
            }
        });
        
        ImageIcon image2 = new ImageIcon(getClass().getResource("exit.png"));
        Image originalImage = image2.getImage();
        int width = 17;
        int height = 17;
        Image resizedImage = originalImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(resizedImage);
        
        JButton exitbtn = new JButton();
        exitbtn.setText("Logout");
        exitbtn.setFont(new Font("Serif", Font.BOLD, 15));
        exitbtn.setBackground(Color.WHITE);
        exitbtn.setFocusable(false);
        exitbtn.setIcon(resizedIcon);
        exitbtn.setHorizontalTextPosition(JButton.LEFT);
        exitbtn.setVerticalAlignment(JButton.CENTER);
        exitbtn.setBorder(BorderFactory.createEmptyBorder());
        exitbtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        exitbtn.setContentAreaFilled(false);
        exitbtn.setBounds(37,500, 125,35);
        exitbtn.addActionListener(new ActionListener() {
        	@Override
            public void actionPerformed(ActionEvent e) {
        		Admin a = new Admin();
        		a.admin();
                frame.dispose();
            }
        });
        
        // Add a MouseListener to handle the button animations
        exitbtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                exitbtn.setContentAreaFilled(true);
                exitbtn.setBackground(new Color(0x24293b));
                exitbtn.setForeground(Color.WHITE);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                exitbtn.setContentAreaFilled(false);
                exitbtn.setBackground(Color.WHITE);
                exitbtn.setForeground(Color.BLACK);
            }
        });
        
        //footer panel settings
        JPanel footerPanel = new JPanel();
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
		leftPanel.add(btn1);
		leftPanel.add(btn2);
		leftPanel.add(btn3);
		leftPanel.add(btn4);
		leftPanel.add(exitbtn);
		leftPanel.add(bodyPanel);
        frame.add(headPanel);
        frame.add(leftPanel);
        frame.add(footerPanel);
        
	}
	

}
