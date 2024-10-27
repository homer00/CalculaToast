//Classe qui permet uniquement d'afficher une image de fond à l'intérieur 
//d'un JPanel

package packGBT.view;

import java.awt.*;
import javax.swing.*;


@SuppressWarnings("serial")
public class JpanelImg extends JPanel {
	
  private Image image;
  
  // ================================ CONSTRUCTEUR
  public JpanelImg(Image img){
    this.image = img;
  }
  
  // =================================== METHODE
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.drawImage(image, 35, 2, this);
   
  }
  /*
    	Dans la page où on doit afficher le résultat :
  	Image image = new Image(..);
		JPanelImg fond = new JPanelImg (image);
		...
		fond.add(etiquette);
		...
   */

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}
  
}
