
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.*;
import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageInputStream;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;

public class Oyun extends JPanel implements KeyListener , ActionListener  {

	 Timer timer = new Timer(1, this);
	private BufferedImage paddleImage , RedBrick , Ball , Space;	
	
  

	public static int lives = 3;
	public static int score = 0;
	public static int lvl = 1;
	
	public  JTextField  x = new JTextField(15);		
	
	public int en = 70;
	public int boy = 32;
	
	
	
	
	private int topY = 200;
	private int topX = 10;
	public static int topdirY =9/2 ;
	public static int topdirX =9/2;
		
	private int paddleX = 200;
	private int dirPaddleX = 25;
	
	boolean a = true ;  boolean aa = true ; boolean aaa = true ;
	boolean b = true ;  boolean bb = true ; boolean bbb = true ;
	boolean c = true ;  boolean cc = true ; boolean ccc = true ;
	boolean d = true ;  boolean dd = true ; boolean ddd = true ;
	boolean ee = true ;  boolean eee = true ;boolean eeee = true ;
	boolean f = true ;  boolean ff = true ;  boolean fff = true ;
	boolean h = true ;  boolean hh = true ;  boolean hhh = true ;
	boolean j = true ;  boolean jj = true ;boolean jjj = true ;
	
	ActionListener savename = new ActionListener() {
		public void actionPerformed(ActionEvent actionEvent) {
			 FileOutputStream fos = null;     
		        try {
		            fos = new FileOutputStream("High Scores.txt",true);
		 		            String name = "-"+Method(x)+" ";
		           byte[] scc_array = name.getBytes();        
		            fos.write(scc_array);
         
		        } catch (FileNotFoundException ex) {
		            System.out.println("");
		        } catch (IOException ex) {
		            System.out.println("");}
		        finally{        
		            try {
		                fos.close();
		            } catch (IOException ex) {
		                System.out.println("");}}	} };
	
	public Oyun() {
	
		try {
		paddleImage = ImageIO.read(new FileImageInputStream(new File("Paddle.png")));
		}catch(IOException ex){
			Logger.getLogger(Oyun.class.getName()).log(Level.SEVERE , null , ex);
		}	
		try {
			RedBrick = ImageIO.read(new FileImageInputStream(new File("Red.png")));
			}catch(IOException ex){
				Logger.getLogger(Oyun.class.getName()).log(Level.SEVERE , null , ex);
			}	
		try {
			Space = ImageIO.read(new FileImageInputStream(new File("space.png")));
			}catch(IOException ex){
				Logger.getLogger(Oyun.class.getName()).log(Level.SEVERE , null , ex);
			}	
		
		try {
			Ball = ImageIO.read(new FileImageInputStream(new File("Ball.png")));
			}catch(IOException ex){
				Logger.getLogger(Oyun.class.getName()).log(Level.SEVERE , null , ex);
			}			
		 setBackground(Color.DARK_GRAY) ;
		 
		 timer.start();	
	}	
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);		
		
		g.drawImage(Space  ,0 , 0 ,800 , 600, this );
		
		if(aaa == true) g.drawImage(RedBrick  ,40 , 20 ,en , boy, this );
		if(aa == true) g.drawImage(RedBrick  ,40 , 70 ,en , boy, this );
        if(a == true) g.drawImage(RedBrick  ,40 , 120 ,en , boy, this );          
        if(bbb == true)  g.drawImage(RedBrick  ,130 , 20 ,en , boy, this );
        if(bb == true) g.drawImage(RedBrick  ,130 , 70 ,en , boy, this );
        if(b == true) g.drawImage(RedBrick  ,130 , 120 ,en , boy, this );             
        if(ccc == true) g.drawImage(RedBrick  ,220 , 20 ,en , boy, this );
        if(cc == true)  g.drawImage(RedBrick  ,220 , 70 ,en , boy, this );
        if(c == true) g.drawImage(RedBrick  ,220 , 120 ,en , boy, this );        
        if(ddd == true)  g.drawImage(RedBrick  ,310 , 20 ,en , boy, this );
        if(dd == true) g.drawImage(RedBrick  ,310 , 70 ,en , boy, this );
        if(d == true) g.drawImage(RedBrick  ,310 , 120 ,en , boy, this );       
        if(eeee == true) g.drawImage(RedBrick  ,400 , 20 ,en , boy, this );
        if(eee == true) g.drawImage(RedBrick  ,400 , 70 ,en , boy, this );
        if(ee == true) g.drawImage(RedBrick  ,400 , 120 ,en , boy, this );       
        if(fff == true) g.drawImage(RedBrick  ,490 , 20 ,en , boy, this );
        if(ff == true) g.drawImage(RedBrick  ,490 , 70 ,en , boy, this );
        if(f == true) g.drawImage(RedBrick  ,490 , 120 ,en , boy, this );  
        if(hhh == true) g.drawImage(RedBrick  ,580 , 20 ,en , boy, this );
        if(hh == true) g.drawImage(RedBrick  ,580, 70 ,en , boy, this );
        if(h == true) g.drawImage(RedBrick  ,580 , 120 ,en , boy, this );
        if(jjj == true) g.drawImage(RedBrick  ,670 , 20 ,en , boy, this );
        if(jj == true)g.drawImage(RedBrick  ,670, 70 ,en , boy, this );
        if(j == true) g.drawImage(RedBrick  ,670 , 120 ,en , boy, this );

		g.drawImage(Ball  ,topX , topY  ,20 , 20, this );
		
		
		g.drawImage(paddleImage ,paddleX , 490 ,200 , 30, this );
		
		g.setColor(Color.WHITE);
		g.drawString("LEVEL "+lvl , 350, 12);
		
		g.setColor(Color.WHITE);
		g.drawString("SCORE "+score , 20, 12);
		
		g.setColor(Color.WHITE);
		g.drawString("LIVES "+lives , 690, 12);	
		if(score == 240) {
			g.setColor(Color.GREEN);
			g.setFont(new Font("TimesRoman", 1, 50));  
			g.drawString("YOU WON ! ", 240, 250);
		}
		
		
		if(lives == 0) {
			g.setColor(Color.RED);
			g.setFont(new Font("TimesRoman", 1, 50));  
			g.drawString("GAME OVER ", 240, 250);
		}
	
	}
	@Override
	public void repaint() {
		super.repaint();
	}
	
	@Override
	public void keyTyped(KeyEvent e) {			
	}

	@Override
	public void keyPressed(KeyEvent e) {	
		int c = e.getKeyCode();	
		if(c == KeyEvent.VK_LEFT) {
			
			if(paddleX <= -20) {
				paddleX =-20 ;
			}
			else {
				paddleX  =paddleX -dirPaddleX;
			}}
		
		else if(c== KeyEvent.VK_RIGHT) {
			if(paddleX >= 600) {
				paddleX =600 ;
			}
			else {
				paddleX  = paddleX +dirPaddleX;}}
		//paint(getGraphics());
		repaint();
	}

	@Override
	public void keyReleased(KeyEvent e) {	
	}
	@Override
	public void actionPerformed(ActionEvent e) {	
		topY += topdirY;
		topX += topdirX;
		
		if(topY >=530 ) {	 			
	         lives =lives -1;	//die
	         topY = 190;
	         topX = 50;	
		}
		
		if(topY <= 0  ) {
			topdirY =-topdirY; //kenar
		}
	
		if(topX >= 750 ) {   //kenar 
		 topdirX =-topdirX;
			}
		if(topX <= 0  ) {  //kenar 
		 topdirX =-topdirX;
		}
		
		if(topY >= 475  ) {               //paddle 
			if(paddleX+142  >=topX) {
				if(paddleX-10  <=topX) {			
					 topdirY =-topdirY;		
						 
				}
			}		
		}		
		
	//---------------------------------------------		
		if(aaa==true) {if((topY  <=53  ) & (topY  >=20  ) &(topX >=40 )&(topX <= 110)) {	 			 
					 aaa= false; score = score + 10; topdirY =-topdirY;}      }
		if(bbb==true) {if((topY  <=53  ) & (topY  >=20  ) & (topX >=130)&(topX <= 200) ) {	 	
					 bbb= false;  score = score + 10;  topdirY =-topdirY;}      }
		if(ccc==true) {if((topY  <=53  ) & (topY  >=20  )& (topX >=220)&(topX <= 290)) {	 		
				 ccc= false;	  score = score + 10;	  topdirY =-topdirY;}      }
		if(ddd==true) {if((topY  <=53  ) & (topY  >=20  )& (topX >=310)&(topX <= 380)) {	 		
            	 ddd= false;	  score = score + 10;		  topdirY =-topdirY;}      }
		if(eeee==true) {if((topY  <=53  ) & (topY  >=20  )&(topX >=400)&(topX <= 470) ) {	 		
					 eeee= false; score = score + 10;topdirY =-topdirY;}      }
		if(fff==true) {if((topY  <=53  ) & (topY  >=20 )&(topX >=490)&(topX <= 560) ) {	 			
					fff= false;score = score + 10;topdirY =-topdirY;}      }
		if(hhh==true) {if((topY  <=53  ) & (topY  >=20  )&(topX >=580)&(topX <= 650) ) {	 		
					 hhh= false; score = score + 10;	  topdirY =-topdirY;}      }		
		if(jjj==true) {if((topY  <=53  ) & (topY  >=20  )& (topX >=670)&(topX <= 740)) {	 			
					jjj= false; score = score + 10;	  topdirY =-topdirY;}      }
		if(aa==true) {if((topY  <=103  ) & (topY  >=70  )&(topX >=40)&(topX <= 110) ) {	 			
					 aa= false;  score = score + 10;  topdirY =-topdirY;}      }
		if(bb==true) {if((topY  <=103  ) & (topY  >=70  )&(topX >=130)&(topX <= 200) ) {	 		
					 bb= false;	 score = score + 10;  topdirY =-topdirY;}      }
		if(cc==true) {if((topY  <=103  ) & (topY  >=70  )&(topX >=220)&(topX <= 290) ) {	 			
					 cc= false; score = score + 10;topdirY =-topdirY;}      }
		if(dd==true) {if((topY  <=103  ) & (topY  >=70  )& (topX >=310)&(topX <= 380)) {	 		
					 dd= false;score = score + 10; topdirY =-topdirY;}      }
		if(eee==true) {if((topY  <=103  ) & (topY  >=70  )&(topX >=400)&(topX <= 470) ) {	 		
					 eee= false;  score = score + 10; topdirY =-topdirY;}      }
		if(ff==true) {if((topY  <=103  ) & (topY  >=70  )&(topX >=490)&(topX <= 560 )) {	 			
					ff= false;  score = score + 10;	  topdirY =-topdirY;}      }
		if(hh==true) {if((topY  <=103  ) & (topY  >=70  )& (topX >=580)&(topX <= 650)) {	 		
					 hh= false; score = score + 10; topdirY =-topdirY;}      }
		if(jj==true) {if((topY  <=103  ) & (topY  >=70  )& (topX >=670)&(topX <= 740)) {	 		
					jj= false;score = score + 10; topdirY =-topdirY;}      }
		if(a==true) {if((topY  <=153  ) & (topY  >=120  )&(topX >=40)&(topX <= 110) ) {	 		
				 a= false; score = score + 10; topdirY =-topdirY;}      }
		if(b==true) {if((topY  <=153  ) & (topY  >=120   )& (topX >=130)&(topX <= 200)) {	 		
			b= false;  score = score + 10;	  topdirY =-topdirY;}      }
		if(c==true) {if((topY  <=153  ) & (topY  >=120   )&(topX >=220)&(topX <= 290) ) {	 		
			c= false; score = score + 10; topdirY =-topdirY;}      }
		if(d==true) {if((topY  <=153  ) & (topY  >=120   )&(topX >=310)&(topX <= 380) ) {	 			
			d= false; score = score + 10; topdirY =-topdirY;}      }
		if(ee==true) {if((topY  <=153  ) & (topY  >=120   )& (topX >=400)&(topX <= 470)) {	 		
			ee= false; score = score + 10; topdirY =-topdirY;}      }
		if(f==true) {if((topY  <=153  ) & (topY  >=120   )&(topX >=490)&(topX <= 560) ) {	 		
			f= false; score = score + 10; topdirY =-topdirY;}      }
		if(h==true) {if((topY  <=153  ) & (topY  >=120   )&(topX >=580)&(topX <= 650) ) {	 	
			h= false; score = score + 10;topdirY =-topdirY;}      }	
		if(j==true) {if((topY  <=153  ) & (topY  >=120   )&(topX >=670)&(topX <= 740) ) {	 
			j= false;score = score + 10;topdirY =-topdirY;}      }			

		
		//---------------------------------			
			repaint();
			if(lives == 0 || score == 240) {
				timer.stop();			
				
				
				
				 Scores op = new Scores();		
					JFrame	f = new JFrame("Register");      			
					op.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);			
					JLabel  q = new JLabel("Your name :");
				    f.add(q);	
					 f.setSize(250, 300);
				     f.setVisible(true);    
				    f.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 15));     
				   f.setLocationRelativeTo(null);
				    f.add(x); 
					JButton saveb = new JButton("Save");
					f.add(saveb);
					
				  saveb.addActionListener(savename);
        
				 
				 FileOutputStream fos = null;     
			        try {
			            fos = new FileOutputStream("High Scores.txt",true);
           
			            String sc = "Score=|";
			            byte[] sc_array = sc.getBytes();        
			            fos.write(sc_array);
			            
			            fos.write(Integer.toString(score).getBytes());
			           
			            String timeStamp = new SimpleDateFormat("|yyyy/MM/dd-HH.mm.ss").format(Calendar.getInstance().getTime());
			            byte[] s_arrayy = timeStamp.getBytes();        
			            fos.write(s_arrayy);
			           
			            
			        } catch (FileNotFoundException ex) {
			            System.out.println("");
			        } catch (IOException ex) {
			            System.out.println("");
			        }
			        finally{
			            
			            try {
			                fos.close();
			            } catch (IOException ex) {
			                System.out.println("");
			            }
			           
			        }
			        
			      
			     
			}
			
			
			
	}

	private static String Method( JTextField  a) {
	return a.getText();
		
	}
	
}