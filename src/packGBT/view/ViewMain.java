package packGBT.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class ViewMain extends JFrame{

	private static final long serialVersionUID = 568;
	public static Dimension d;

	// CONSTRUCTOR
	public ViewMain(){
		super("CalculaToast - M.Daniel");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setPreferredSize(new Dimension(800,600));
		System.out.println("Salut les Kids !");
		d = new Dimension(480,300);
		this.setSize(d);
		this.setBackground(new Color(150,50,210));
	}

	// MAIN8
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ViewMain vm1 = new ViewMain();
	
		System.out.println("vm1 getWidth : "+vm1.getWidth());

		ViewPanel2 vp2 = new ViewPanel2(vm1);

		vm1.getContentPane().add(vp2);
		vm1.setVisible(true);
		vm1.centre();


		System.out.println("Nous sommes dans le main");


	}
	public void centre() {

        Dimension windowsSize = this.getSize();
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension screenSize = tk.getScreenSize();
        int x = (screenSize.width - windowsSize.width) / 2;
        int y = (screenSize.height- windowsSize.height) / 2;
        this.setLocation(x, y);
    }
}
