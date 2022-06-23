
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Scanner;
import javax.swing.*;
public class Start extends JFrame  {	

	public static void main(String[] args) {
		JFrame frame1 = new JFrame("Menu");
		JFrame frame2 = new JFrame("Arkanoid");
		JFrame frame3 = new JFrame("Help");
		JFrame frame4 = new JFrame("About");
		JFrame frame5 = new JFrame("Scores");
		JFrame frame6 = new JFrame("Options");
		JTextArea jt= new JTextArea("CONTROLS:Use LEFT (<==) and RIGHT (==>) arrows to move the paddle",5,20);
		JTextArea jt1= new JTextArea("Name:Mert Yigit\n Email: mert.yigit@std.yeditepe.edu.tr",5,20);
	
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ActionListener start = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				
				Ekran ekran = new Ekran("Arkanoid");				
				ekran.setResizable(false);
				ekran.setFocusable(false);					
				ekran.setSize(800 , 600);				
				ekran.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);				
				Oyun game1 = new Oyun();			
				game1.requestFocus();				
				game1.addKeyListener(game1);	
				game1.setFocusable(true);	
				game1.setFocusTraversalKeysEnabled(false);
			
				ekran.add(game1);
				 ekran.setLocationRelativeTo(null);
				ekran.setVisible(true);
				frame1.setVisible(false);		
				
				
		      }
		    };
	         ActionListener exit = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				
				System.exit(0);
		      }
		    };
		 ActionListener help = new ActionListener() {
			 public void actionPerformed(ActionEvent actionEvent) {
				 jt.setEditable(false);
				 frame3.add(jt);
				 frame3.setLocationRelativeTo(null);
				 frame3.setResizable(false);
				 frame3.pack();
				 frame3.setVisible(true);
			 }
		 };
		 ActionListener about = new ActionListener() {
			 public void actionPerformed(ActionEvent actionEvent) {
				 jt1.setEditable(false);
				 frame4.add(jt1);
				 frame4.setLocationRelativeTo(null);
				 frame4.setResizable(false);
				 frame4.pack();
				 frame4.setVisible(true);
			 }
		 };
		 
		 ActionListener level1 = new ActionListener() {
				public void actionPerformed(ActionEvent actionEvent) {
					Oyun.topdirY =3;
					Oyun.topdirX =3;
					Oyun.lvl =1;  
				}
			    };
		ActionListener level2 = new ActionListener() {
					public void actionPerformed(ActionEvent actionEvent) {
						Oyun.topdirY =9/2;
						Oyun.topdirX =9/2;
						Oyun.lvl =2;
				      }
				    };
	        ActionListener level3 = new ActionListener() {
						public void actionPerformed(ActionEvent actionEvent) {
							Oyun.topdirY =13/2;
							Oyun.topdirX =13/2;
							Oyun.lvl =3;
					      }
					    };
		 ActionListener options = new ActionListener() {
			 public void actionPerformed(ActionEvent actionEvent) {
				 Scores op = new Scores();		
					JFrame	f = new JFrame("Options");      
					JLabel  k = new JLabel("Best Scores:");
					op.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					
					
					JPanel p = new JPanel();
				        p.add(k);
					
				        f.setSize(250, 300);
				        f.setVisible(true);    
				        f.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 15));
				        f.setLocationRelativeTo(null);
				 
			
					JRadioButton lvl1 = new JRadioButton("Level 1 (Normal) ");  
					f.add(lvl1);
					JRadioButton lvl2 = new JRadioButton("Level 2 (Hard) ");  
					f.add(lvl2);
					JRadioButton lvl3 = new JRadioButton("Level 3 (Impossible)");  
					f.add(lvl3);
					
					
					lvl1.addActionListener(level1);
					lvl2.addActionListener(level2);
					lvl3.addActionListener(level3);
					
					ButtonGroup group = new ButtonGroup();  
					group.add(lvl1);
					group.add(lvl2);
					group.add(lvl3);
			 }
		 };
		 
	 
		 ActionListener scores = new ActionListener() {
			 public void actionPerformed(ActionEvent actionEvent) {
				 Scores te = new Scores();		
					JFrame	f = new JFrame("Score List");      
					JLabel  k = new JLabel("Best Scores:");
					JTextField     x = new JTextField(25);
					JTextField     x1 = new JTextField(25);
					JTextField     x2= new JTextField(25);
					JTextField     x3 = new JTextField(25);
					JTextField     x4 = new JTextField(25);
					JTextField     x5 = new JTextField(25);
					JTextField     x6= new JTextField(25);
					JTextField     x7 = new JTextField(25);
					JTextField     x8 = new JTextField(25);
					JTextField     x9 = new JTextField(25);
					te.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					
					JPanel p = new JPanel();			             
			                 p.add(k);
			                 p.add(x ); p.add(x1);p.add(x2 );p.add(x3 ); p.add(x4 );p.add(x5 );p.add(x6 ); p.add(x7 ); p.add(x8 );p.add(x9 );  		       
			                 f.add(p);    
			                 f.setSize(300, 400);
			                 f.setVisible(true);      
			                try {
			                    FileInputStream fstream = new FileInputStream("High Scores.txt");
			                  BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
			                    String strLine;                  
			                 strLine = br.readLine();			                    	
			                    	Scanner sc = new Scanner(strLine);
			                    	//while((  sc.hasNext()) ) {		                    	
			                    	x.setText(sc.next());	
			                    	x1.setText(sc.next());	
			                        x2.setText(sc.next());	
			                        x3.setText(sc.next());	
			                    	x4.setText(sc.next());	
			                        x5.setText(sc.next());	
			                        x6.setText(sc.next());	
			                    	x7.setText(sc.next());	
			                        x8.setText(sc.next());	
			                        x9.setText(sc.next());	
			                        //br.close();
			               // }
			                
			                }     
			                catch (Exception a) {
			                System.out.println("ERROR " + a.getMessage());
			                }
			            }
		 };
	 
		frame1.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 15));
		JButton b1 = new JButton("New Game");
		JButton b2 = new JButton("  Options    ");
		JButton b3 = new JButton("    Scores   ");
		JButton b4 = new JButton("     Help       ");
		JButton b5 = new JButton("     About     ");
		JButton b6 = new JButton("      Exit        ");
		b1.addActionListener(start);
		b2.addActionListener(options);
		b3.addActionListener(scores);
		b4.addActionListener(help);
		b5.addActionListener(about);
		b6.addActionListener(exit);
		frame1.add(b1);
		frame1.add(b2);
		frame1.add(b3);
		frame1.add(b4);
		frame1.add(b5);
		frame1.add(b6);
		frame1.setLocationRelativeTo(null);
		frame1.setSize(200, 380);
		frame1.setVisible(true);
	}
}
