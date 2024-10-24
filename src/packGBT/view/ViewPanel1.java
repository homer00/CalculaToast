package packGBT.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ViewPanel1 extends JPanel {

	private Dimension panDim,panDim2;
	//private JPanel jp1;
	public JLabel jl1;

	public ViewPanel1(ViewMain vm) {
		panDim = new Dimension (vm.getWidth(),vm.getHeight());
		panDim2 = new Dimension((int)(panDim.width-0.2*panDim.width),(int)(panDim.height-0.2*panDim.height));
		//jp1 = new JPanel();
		System.out.println("panDim : "+panDim);
		System.out.println("panDim2 : "+panDim2);
		this.setLayout(new GridBagLayout());
		this.setPreferredSize(panDim2);
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 0; c.gridy=0;
		c.gridheight = 120; c.gridwidth = 220;
		jl1 = new JLabel("le Label de la mort qui tue");
		this.setBackground(Color.ORANGE);
		this.setOpaque(true);
		this.add(jl1,c);

	}


}
