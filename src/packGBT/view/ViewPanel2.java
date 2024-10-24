package packGBT.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.font.TextAttribute;
import java.util.Collections;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.DefaultHighlighter.DefaultHighlightPainter;
import javax.swing.text.Highlighter;
//import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import packGBT.control.Ccalc;

@SuppressWarnings("serial")
public class ViewPanel2 extends JPanel implements ActionListener, KeyListener {

	private Dimension panDim3,panDim4;
	//private JPanel jpChiffres;
	public JLabel jl2, jl3;
	private JTextField jt1, jt2, jt3;
	private JButton jb1,jb2,jb3,jb4,jb5,jb6,jb7,jb8,jb9,jb0,jbPoint;
	private JButton jbDiv, jbPlus, jbMoins, jbMult, jbRes;
	private JButton jbAC;
	private JPanel panContainMain, pan2;
	private JTextArea jta1,jta2,jta3,jta4, jtaRes;
	private ViewMain laVm;
	public Color mainColor;
	
	public ViewPanel2(ViewMain vm) {
		this.laVm = vm;
		panDim3 = new Dimension (laVm.getWidth(),laVm.getHeight());
		panDim4 = new Dimension((int)(panDim3.width-0.2*panDim3.width),(int)(panDim3.height-0.2*panDim3.height));
		System.out.println("panDim3 : "+ panDim3);
		System.out.println("panDim4 : "+ panDim4);
		mainColor = new Color (160,216,180);
		this.setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS)); // JPanel ==> BoxLayout
		// ajout d'un autre JPanel
		JPanel pan1 = new JPanel();
		pan1.setLayout(new FlowLayout(FlowLayout.LEADING)); // second JPanel pan1 ==> FlowLayout
		//pan1.setAlignmentX(FlowLayout.CENTER);
		//pan1.setAlignmentY(FlowLayout.CENTER);
		pan1.setBackground(mainColor);
		jl2 = new JLabel("CalculaToast: une expérience Javanesque !");
		//jl2.setFont(new Font("Arial", ));
		jl3 = new JLabel("  ");
		pan1.setSize(20,70);
		pan1.add(jl2);pan1.add(jl3);
		pan1.setOpaque(true);
		this.add(pan1);
		
		JPanel pan1b = new JPanel();
		pan1b.setLayout(new BoxLayout(pan1b,BoxLayout.LINE_AXIS)); // pan1b ==> BoxLayout Pour affichage entrée utilisateur
		//pan1b.setAlignmentX(FlowLayout.CENTER);
		//pan1b.setAlignmentY(FlowLayout.CENTER);
		pan1b.setBackground(Color.ORANGE);
		jt1 = new JTextField();
		//JTextField jt = new JTextField("fdof",2,3);
		jt1.setFont(new Font("Arial", Font.PLAIN, 16));
		jt1.setBorder(BorderFactory.createEmptyBorder(3,8,3,3));
		Dimension dimJt = new Dimension(230,50);
		jt1.setMaximumSize(dimJt);
		jt1.addKeyListener(this);
		
		int largJt2 = panDim4.width / 100;
		jt2 = new JTextField(largJt2);
		jt2.setFont(new Font("Arial", Font.PLAIN, 16));
		jt2.setForeground(Color.DARK_GRAY);
		jt2.setMaximumSize(new Dimension(dimJt.width - 30, 50));
		jt2.setBackground(new Color(240,240,240));
		jt2.setForeground(new Color(110,110,110));
		jt2.setBorder(BorderFactory.createEmptyBorder(3,8,3,3));
		jt2.setEditable(false);
		
		//jt2.setBorder(new MatteBorder(1,1,2,2,Color.GRAY));
		//pan1b.setSize(20,70);
		pan1b.add(jt1); pan1b.add(jt2);
		pan1b.setOpaque(true);
		this.add(pan1b);
		
		// va intégrer 2x JPanels au centre de la vue.
		panContainMain = new JPanel();
		FlowLayout flMain = new FlowLayout(FlowLayout.CENTER);
		panContainMain.setLayout(flMain);
		panContainMain.setBackground(mainColor);
		
		
		
		pan2 = new JPanel(); // JPanel pan2 ==> GridBagLayout pour les boutons (chiffres)
		GridBagLayout gbl2 = new GridBagLayout();
		pan2.setLayout(gbl2);
		
		

		GridBagConstraints gbcL1 = new GridBagConstraints();
		gbcL1.gridx = 0; gbcL1.gridy=0;
		gbcL1.gridheight = 1; gbcL1.gridwidth = 1;
		gbcL1.insets = new Insets(5,5,5,5);
		jb1 = new JButton("1");
		jb1.addActionListener(this);
		
		GridBagConstraints gbcL2 = new GridBagConstraints();
		gbcL2.gridx = 1; gbcL2.gridy=0;
		gbcL2.gridheight = 1; gbcL2.gridwidth = 1;
		gbcL2.insets = new Insets(5,5,5,5);
		jb2 = new JButton("2");
		jb2.addActionListener(this);
		
		GridBagConstraints gbcL3 = new GridBagConstraints();
		gbcL3.gridx = 2; gbcL3.gridy=0;
		gbcL3.gridheight = 1; gbcL3.gridwidth = 1;
		gbcL3.insets = new Insets(5,5,5,5);
		jb3 = new JButton("3");
		jb3.addActionListener(this);
		
		GridBagConstraints gbcL4 = new GridBagConstraints();
		gbcL4.gridx = 0; gbcL4.gridy=1;
		gbcL4.gridheight = 1; gbcL4.gridwidth = 1;
		gbcL4.insets = new Insets(5,5,5,5);
		jb4 = new JButton("4");
		jb4.addActionListener(this);
		
		GridBagConstraints gbcL5 = new GridBagConstraints();
		gbcL5.gridx = 1; gbcL5.gridy=1;
		gbcL5.gridheight = 1; gbcL5.gridwidth = 1;
		gbcL5.insets = new Insets(5,5,5,5);
		jb5 = new JButton("5");
		jb5.addActionListener(this);
				
		GridBagConstraints gbcL6 = new GridBagConstraints();
		gbcL6.gridx = 2; gbcL6.gridy=1;
		gbcL6.gridheight = 1; gbcL6.gridwidth = 1;
		gbcL6.insets = new Insets(5,5,5,5);
		jb6 = new JButton("6");
		jb6.addActionListener(this);
		
		GridBagConstraints gbcL7 = new GridBagConstraints();
		gbcL7.gridx = 0; gbcL7.gridy=2;
		gbcL7.gridheight = 1; gbcL7.gridwidth = 1;
		gbcL7.insets = new Insets(5,5,5,5);
		jb7 = new JButton("7");
		jb7.addActionListener(this);
		
		GridBagConstraints gbcL8 = new GridBagConstraints();
		gbcL8.gridx = 1; gbcL8.gridy=2;
		gbcL8.gridheight = 1; gbcL8.gridwidth = 1;
		gbcL8.insets = new Insets(5,5,5,5);
		jb8 = new JButton("8");
		jb8.addActionListener(this);
		
		GridBagConstraints gbcL9 = new GridBagConstraints();
		gbcL9.gridx = 2; gbcL9.gridy=2;
		gbcL9.gridheight = 1; gbcL9.gridwidth = 1;
		gbcL9.insets = new Insets(5,5,5,5);
		jb9 = new JButton("9");
		jb9.addActionListener(this);
		
		GridBagConstraints gbcL0p = new GridBagConstraints();
		gbcL0p.gridx = 0; gbcL0p.gridy=3;
		gbcL0p.gridheight = 1; gbcL0p.gridwidth = 2;
		gbcL0p.insets = new Insets(5,5,5,5);
		gbcL0p.fill = GridBagConstraints.HORIZONTAL;
		jb0 = new JButton("0");
		jb0.addActionListener(this);
		
		GridBagConstraints gbcPoint = new GridBagConstraints();
		gbcPoint.gridx = 2; gbcPoint.gridy=3;
		gbcPoint.gridheight = 1; gbcPoint.gridwidth = 1;
		gbcPoint.insets = new Insets(5,5,5,5);
		//gbcL0p.fill = GridBagConstraints.HORIZONTAL;
		jbPoint = new JButton(" . ");
		//jbPoint.setBorder(new MatteBorder(1, 1, 1, 1, Color.red));
		jbPoint.addActionListener(this);
		
		// BOUTON +
		GridBagConstraints gbcPlus = new GridBagConstraints();
		gbcPlus.gridx = 3; gbcPlus.gridy=0;
		gbcPlus.gridheight = 1; gbcPlus.gridwidth = 1;
		gbcPlus.insets = new Insets(5,5,5,5);
		//gbcL0p.fill = GridBagConstraints.HORIZONTAL;
		jbPlus = new JButton(" + ");
		//jbPoint.setBorder(new MatteBorder(1, 1, 1, 1, Color.red));
		jbPlus.addActionListener(this);
		
		// BOUTON -
		GridBagConstraints gbcMoins = new GridBagConstraints();
		gbcMoins.gridx = 3; gbcMoins.gridy=1;
		gbcMoins.gridheight = 1; gbcMoins.gridwidth = 1;
		gbcMoins.insets = new Insets(5,5,5,5);
		//gbcL0p.fill = GridBagConstraints.HORIZONTAL;
		jbMoins = new JButton(" - ");
		//jbPoint.setBorder(new MatteBorder(1, 1, 1, 1, Color.red));
		jbMoins.addActionListener(this);
		
		// BOUTON x
		GridBagConstraints gbcMult = new GridBagConstraints();
		gbcMult.gridx = 3; gbcMult.gridy=2;
		gbcMult.gridheight = 1; gbcMult.gridwidth = 1;
		gbcMult.insets = new Insets(5,5,5,5);
		//gbcL0p.fill = GridBagConstraints.HORIZONTAL;
		jbMult = new JButton(" x ");
		//jbPoint.setBorder(new MatteBorder(1, 1, 1, 1, Color.red));
		jbMult.addActionListener(this);
		
		// BOUTON /
		GridBagConstraints gbcDiv = new GridBagConstraints();
		gbcDiv.gridx = 3; gbcDiv.gridy=3;
		gbcDiv.gridheight = 1; gbcDiv.gridwidth = 1;
		gbcDiv.insets = new Insets(5,5,5,5);
		//gbcL0p.fill = GridBagConstraints.HORIZONTAL;
		jbDiv = new JButton(" / ");
		//jbPoint.setBorder(new MatteBorder(1, 1, 1, 1, Color.red));
		jbDiv.addActionListener(this);
		
		// BOUTON AC
		GridBagConstraints gbcAC = new GridBagConstraints();
		gbcAC.gridx = 4; gbcAC.gridy=0;
		gbcAC.gridheight = 1; gbcAC.gridwidth = 1;
		gbcAC.insets = new Insets(5,5,5,5);
		jbAC = new JButton("AC");
		jbAC.addActionListener(this);
		
		// BOUTON RES (=)
		GridBagConstraints gbcRes = new GridBagConstraints();
		gbcRes.gridx = 4; gbcRes.gridy=1;
		gbcRes.gridheight = 3; gbcRes.gridwidth = 1;
		gbcRes.insets = new Insets(5,5,5,5);
		gbcRes.fill = GridBagConstraints.VERTICAL;
		jbRes = new JButton(" = ");
		jbRes.addActionListener(this);
		
		// Panel à droite du pavé numérique
		JPanel panSide = new JPanel();
		panSide.setLayout(new BoxLayout(panSide,BoxLayout.PAGE_AXIS));
		jta1 = new JTextArea(" Respect de la précédence\n des opérateurs");//("Joyau de la technologie,\nprécision inégalée",2,1);
		jta1.setBackground(Color.orange);
		jta2 = new JTextArea(" Absence de parenthèses"); //("Respect de la précé-\ndence des opérateurs",2,1);
		jta3 = new JTextArea("");
		jta4 = new JTextArea("");
		
		panSide.add(jta1);panSide.add(jta2);
		panSide.add(jta3);panSide.add(jta4);
		
		pan2.setBorder(new MatteBorder(1, 1, 1, 1, Color.black));
		panSide.setBorder(new MatteBorder(1, 1, 1, 1, Color.DARK_GRAY));
		
		
		//jpChiffres.add(jb1,gbcL1);
		pan2.add(jb1,gbcL1); pan2.add(jb2,gbcL2); pan2.add(jb3,gbcL3);
		pan2.add(jb4,gbcL4); pan2.add(jb5,gbcL5); pan2.add(jb6,gbcL6);
		pan2.add(jb7,gbcL7); pan2.add(jb8,gbcL8); pan2.add(jb9,gbcL9);
		pan2.add(jb0, gbcL0p);pan2.add(jbPoint,gbcPoint);
		pan2.add(jbPlus, gbcPlus);pan2.add(jbMoins, gbcMoins);
		pan2.add(jbMult, gbcMult);pan2.add(jbDiv, gbcDiv);
		pan2.add(jbAC, gbcAC);pan2.add(jbRes,gbcRes);
		//pan2.add(jta1);

		panContainMain.add(pan2);
		
		Dimension dimPanSide = new Dimension(jta1.getPreferredSize().width+6,(int)pan2.getPreferredSize().getHeight());
		panSide.setBackground(Color.GRAY);
		System.out.println("dimPanSide : "+ dimPanSide);
		panSide.setMaximumSize(new Dimension(100,(int)pan2.getPreferredSize().getHeight())); // marche pas pour limiter la largeur
		panSide.setPreferredSize(dimPanSide);
		
		System.out.println("panSide height : "+panSide.getPreferredSize().height);
		System.out.println("pan2 height : "+pan2.getPreferredSize().height);
		
		
		panContainMain.add(panSide);
		this.add(panContainMain);
		
		//panSide.setSize(panContainMain.getSize());
		
		
		
		JPanel panRes = new JPanel();
//		JScrollPane listScroller = new JScrollPane(list);
//		listScroller.setPreferredSize(new Dimension(250, 80));
//		listScroller.setMinimumSize(new Dimension(250, 80));
//		listScroller.setAlignmentX(LEFT_ALIGNMENT);
		panRes.setLayout(new BoxLayout(panRes,BoxLayout.LINE_AXIS)); // pan1b ==> BoxLayout Pour affichage Résultat

		panRes.setBackground(Color.DARK_GRAY);
		//panRes.setAlignmentX(RIGHT_ALIGNMENT);
		
		jtaRes = new JTextArea("",1,2); // texte, lignes, colonnes,
		jtaRes.setFont(new Font("Arial", Font.PLAIN, 16));
		jtaRes.setMargin(new Insets(3,12,3,12));
		jtaRes.setPreferredSize(new Dimension(200,35));
		jtaRes.setMaximumSize(new Dimension(260,40));
		jtaRes.setAlignmentX(Component.LEFT_ALIGNMENT);
		jtaRes.setBackground(Color.DARK_GRAY);
		jtaRes.setForeground(mainColor);
		
		
		JTextArea jtaRes_bout = new JTextArea("#");
		jtaRes_bout.setEditable(false);
		jtaRes_bout.setMaximumSize(new Dimension(60,40));
		//jtaRes_bout.setAlignmentX(Component.RIGHT_ALIGNMENT);
		//panRes.add(Box.createRigidArea(getPreferredSize()));
		panRes.add(jtaRes);
		panRes.add(Box.createHorizontalGlue());
		panRes.add(jtaRes_bout);
		this.add(panRes);
		
		//this.setPreferredSize(panDim3);
		this.setSize(panDim3);
		this.revalidate();
		this.repaint();
		this.setBackground(mainColor);
		this.setOpaque(true);
		
		
	}
	
	public String jt1Bold(String s) {
		Font dfont = jt1.getFont();
		dfont = dfont.deriveFont(Collections.singletonMap(TextAttribute.WEIGHT, TextAttribute.WEIGHT_SEMIBOLD));
		jt1.setFont(dfont);
		return s;
		
	}
	public void jt1Normal() {
		Font dfont = jt1.getFont();
		dfont = dfont.deriveFont(Collections.singletonMap(TextAttribute.WEIGHT, TextAttribute.WEIGHT_REGULAR));
		jt1.setFont(dfont);
	}
	
	public void appendJt1(String str) { // fonction de concaténation pour le JTextField ("append")
		//Highlighter.HighlightPainter painter = new DefaultHighlighter.DefaultHighlightPainter(Color.BLUE);
		String jt1Temp = jt1.getText(); // récupération du contenu du JTextField
		
		switch(str){
		case "x":
			//jt1.setText(jt1Temp);
			//jt1.setHighlighter((Highlighter) painter);
			jt1.setForeground(new Color(150,20,10));
			jt1Bold("x");
			jt1.setText(jt1Temp + " "+ str + " "); // concaténation
			//System.out.println("switch..case x");
			break;
		case "/":
			jt1.setForeground(Color.blue);
			//jt1Bold("/");
			jt1.setText(jt1Temp + " "+ jt1Bold(str) + " "); // concaténation
			//System.out.println("switch..case /");
			break;
		
		case "+":
			jt1.setForeground(new Color(30,110,10)); // vert
			jt1Bold("+");
			jt1.setText(jt1Temp + " "+ str + " "); // concaténation
			//System.out.println("switch..case +");
			break;
			
		case "-":
			jt1.setForeground(Color.red);
			jt1Bold("-");
			jt1.setText(jt1Temp + " "+ str + " "); // concaténation
			//System.out.println("switch..case -");
			break;
			
		default:
			//jt1Normal();
			jt1.setForeground(Color.BLACK);
			jt1.setText(jt1Temp + str); // concaténation
			//System.out.println("switch..case default");
		}
			
			
		
	}
	
	
	public void actionPerformed(ActionEvent evt) {
		if(evt.getSource()==jb1) {
					appendJt1("1");
					System.out.println("Evenement source jb1");
				}
		if(evt.getSource()==getJb2()) {
			
			//ViewPanel1 nvp1 = new ViewPanel1(this.laVm);
			//Control1 ct1 = new Control1(laVm,nvp1);
			//Control1 ct1 = new Control1(laVm, new ViewPanel1(this.laVm));
			appendJt1("2");
			System.out.println("Evenement source jb2");
		}
		if(evt.getSource()==jb3) {
			appendJt1("3");
			System.out.println("Evenement source jb3");
		}
		if(evt.getSource()==jb4) {
			appendJt1("4");
			System.out.println("Evenement source jb4");
		}
		if(evt.getSource()==jb5) {
			appendJt1("5");
			System.out.println("Evenement source jb5");
		}
		if(evt.getSource()==jb6) {
			appendJt1("6");
			System.out.println("Evenement source jb6");
		}
		if(evt.getSource()==jb7) {
			appendJt1("7");
			System.out.println("Evenement source jb7");
		}
		if(evt.getSource()==jb8) {
			appendJt1("8");
			System.out.println("Evenement source jb8");
		}
		if(evt.getSource()==jb9) {
			appendJt1("9");
			System.out.println("Evenement source jb9");
		}
		if(evt.getSource()==jb0) {
			appendJt1("0");
			System.out.println("Evenement source jb0");
		}
		if(evt.getSource()==jbPoint) {
			appendJt1(".");
			System.out.println("Evenement source jbPoint");
		}
		if(evt.getSource()==jbPlus) {
			appendJt1("+");
			System.out.println("Evenement source jbPlus");
		}
		if(evt.getSource()==jbMoins) {
			appendJt1("-");
			System.out.println("Evenement source jbMoins");
		}
		if(evt.getSource()==jbMult) {
			appendJt1("x");
			System.out.println("Evenement source jbMult");
		}
		if(evt.getSource()==jbDiv) {
			appendJt1("/");
			System.out.println("Evenement source jbDiv");
		}
		if(evt.getSource()==jbAC) {
			//appendJt1("=");
			jt1.setText("");
			System.out.println("Evenement source jbRes : calcul résultat");
		}
		
		if(evt.getSource()==jbRes) {
			//appendJt1("=");
			Ccalc ctrl1 = new Ccalc(laVm, this);
			System.out.println("Evenement source jbRes ou [Enter] key pressed : calcul résultat");
		}
		
		
	}

	public Dimension getPanDim3() {
		return panDim3;
	}

	public void setPanDim3(Dimension panDim3) {
		this.panDim3 = panDim3;
	}

	public Dimension getPanDim4() {
		return panDim4;
	}

	public void setPanDim4(Dimension panDim4) {
		this.panDim4 = panDim4;
	}


	public JLabel getJl2() {
		return jl2;
	}

	public void setJl2(JLabel jl2) {
		this.jl2 = jl2;
	}
	
	public JButton getJb2() {
		return jb2;
	}
	
	public JTextArea getJtaRes() {
		return jtaRes;
	}
	
	public JTextField getJT1() {
		return jt1;
	}
	
	public void setJt2(String jta2Content) {
		this.jt2.setText(jta2Content);
	}
	
	public void setJta2(String jta2Content) {
		this.jta2.setText(jta2Content);
	}

	public void setJtaRes(String jtaResStr) {
		this.jtaRes.setText(jtaResStr);
	}
	public int getPan2Height() {
		return pan2.getHeight();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			Ccalc ctrl1 = new Ccalc(laVm, this);
			System.out.println("Evenement source [Enter] key pressed : calcul résultat");
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
