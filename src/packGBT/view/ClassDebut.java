package packGBT.view;


import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.*;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class ClassDebut extends JFrame { // * * * * * * * * 

    private JPanel jp;
    private JButton jb1,jb2,jb3,jb4,jb5,jb6,jb7,jb8,jb9;
    private JButton jbShoot;
    //    public ArrayList<JButton> jbArray;
    private JTextField textFieldUserName;
    private JTextArea jt;
    private String laVarJb;
    private JLabel informations;
    private String informationsTxt = "";
    protected String monFichierImage;
    public BufferedImage peppa;
    
    //constructeur						* * * * * * * * * 
    public ClassDebut(ViewMain vm) {
		super("GrosTitre");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//this.pack();
		this.setSize (800,700); // size pour la Frame ?
		jp = new JPanel();
		jp.setSize(500,500); // size pour JPanel
		GridBagLayout gbl = new GridBagLayout();
		jp.setLayout(gbl);
		
		// image image
		try {
			monFichierImage = "src/packGBT/Images/peppa2.png";
			peppa = ImageIO.read(new File(monFichierImage));
		}
		catch(IOException ioe){
			System.out.println("monFichierImage : "+ monFichierImage);
			//System.out.println("peppa to string : "+ peppa.toString());
			System.out.println(ioe.toString());
		    System.out.println("Tout est pourri dans ce bas-monde.");
		}
		try {
		    
		    ImageIcon imagePeppa = new ImageIcon(peppa);
		    JLabel labelShoot = new JLabel(imagePeppa);
		    labelShoot.setOpaque(true);
		    labelShoot.setBackground(new Color(120,90,90));
		    jp.add(labelShoot);
		}
		catch (Exception e) {
			System.out.println("Erreur Exception : " + e.toString()); 
		}
		
		
		GridBagConstraints constraint = new GridBagConstraints();
		constraint.gridx = 1;
		constraint.gridy = 0;
		//constraint.gridheight = 1;
		GridBagConstraints constraint2 = new GridBagConstraints();
		constraint2.gridx = 2;
		constraint2.gridy = 1;
		GridBagConstraints constraint3 = new GridBagConstraints();
		constraint3.gridx=3;
		constraint3.gridy=1;
	
		GridBagConstraints constraint4 = new GridBagConstraints();
		constraint4.gridx=1;
		constraint4.gridy=2;
		//constraint4.ipadx = 50;
		//constraint4.ipady = 50;
	
		GridBagConstraints constraintMessage = new GridBagConstraints();
		constraintMessage.gridx=0;
		constraintMessage.gridy=4;
		//	constraint4.ipadx = 50;
		//constraint4.ipady = 50;
		GridBagConstraints constraintMessage2 = new GridBagConstraints();
		constraintMessage2.gridx=0; constraintMessage2.gridy=5;
		//constraint4.ipadx = 50;
		//constraint4.ipady = 50;
		GridBagConstraints constraintMessage3 = new GridBagConstraints();
		constraintMessage3.gridx=0; constraintMessage3.gridy=6;
		//constraint4.ipadx = 50;
		//constraint4.ipady = 50;
		
		GridBagConstraints constraintInfos = new GridBagConstraints();
		constraintInfos.gridx=0; constraintInfos.gridy=7;
		constraintInfos.ipady=3;
		
		
		textFieldUserName = new JTextField(20);
		
		jb1 = new JButton("1");
		jb2 = new JButton("2");
		jb3 = new JButton("3");
		jb4 = new JButton("4");
		jb5 = new JButton("5");
		jb6 = new JButton("6");
		jb7 = new JButton("7");
		jb8 = new JButton("8");
		jb9 = new JButton("9");
	
	
		Font font1 = new Font(Font.SERIF, Font.PLAIN, 24);
		Font font1b = new Font("Arial", Font.BOLD, 18);
	
		// SHOOT !
		jbShoot = new JButton("Shoot !");
		jbShoot.setFont(font1b);
		GridBagConstraints constraintShoot = new GridBagConstraints();
		constraintShoot.gridx = -1;
		constraintShoot.gridy = 0;
		constraintShoot.ipadx = 40;
		constraintShoot.ipady = 40;
		jp.add(jbShoot, constraintShoot );
		//jbArray = new ArrayList<JButton>();
	
		JTextField message1 = new JTextField("L'appli ULTIME que les chinois nous envient.");
		JTextField message2 = new JTextField("On ne rigole pas, Jordan...");
		JTextField message3 = new JTextField("Bientôt milliardaire...");
		informations = new JLabel(informationsTxt);
		Color lightRed = new Color(255,100,100);
		message1.setFont(font1);
		message2.setFont(font1);
		message3.setFont(font1);
	
		jp.setLayout(gbl);
		jp.setBackground(lightRed);
		
		jt = new JTextArea();
	
		//jp.add(textFieldUserName, constraint);
		//    jp.add(jt, constraint4);
	    jp.add(message1, constraintMessage);
	    jp.add(message2, constraintMessage2);
	    jp.add(message3, constraintMessage3);
	    //	jp.add(jb1);jp.add(jb2);jp.add(jb3);jp.add(jb4);
	    //jp.add(jb5, constraint4);jp.add(jb6);jp.add(jb7);
	    //	jp.add(jb8);jp.add(jb9);
		jp.add(informations, constraintInfos);
		
		//add(jb1, constraint2);
		getContentPane().add(jp);
	    }

    /*
    public static void main (String[] args){
	    ClassDebut cd = new ClassDebut();
	    cd.setVisible(true);
	    System.out.println("Nous sommes dans le main");
	    
	    
	}
*/
    
    // getters / setters

    public void setInfo(String message) {
	this.informationsTxt = message;
    }
    public String getInfo() {
	return informationsTxt;
    }
}

