// revision : 27/10/24

package packGBT.control;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.ListIterator;

import packGBT.view.ViewMain;
import packGBT.view.ViewPanel2;
import packGBT.model.CalcSimplifie;

public class Ccalc {

	public int taille_x, taille_y;
	
	public Ccalc(ViewMain vm, ViewPanel2 vp2) {
		
	taille_x = vm.getWidth();
	taille_y = vm.getHeight();
	//System.out.println("[Control1.java] dimensions vm : "+taille_x+" - "+taille_y+" .");
	vp2.getJtaRes().setText("On avance bien !");

	String bloc_recup = vp2.getJT1().getText(); // récupération du JTextField jt1
	if (bloc_recup.equals("")){ // traite le cas ou aucune donnée n'a été entrée.
		bloc_recup="0";
	}
	String bloc_recup_t = bloc_recup.replaceAll(" ","");
	//System.out.println("bloc_recup size : "+bloc_recup.length());
	//System.out.println("bloc_recup_t size : "+bloc_recup_t.length());
	String[] splitted_bloc = bloc_recup_t.split("\\+|\\*|[-x/]"); // split suivant le regex (on récupère chaque nombre)
	
	System.out.println("tab splitted_bloc : "+Arrays.toString(splitted_bloc));
	System.out.println("tab splitted_bloc length -1 (index of last element): "+String.valueOf(splitted_bloc.length-1));

	
	ArrayList<Character> tab_op = new ArrayList<Character>(); // tableau des opérateurs qui seront détectés au fur et à mesure 
	//ArrayList<Float> tab_simplifie = new ArrayList<>();
	//ArrayList<CalcSimplifie> laListe = new ArrayList<>();
	int cpt_op = 0;
	int longueur_elem = 0;
	int longueur_cumulee = 0;
	int position = 0;
	
	for (String elem : splitted_bloc) { // pour chaque valeur numérique extraite (type String)
		System.out.print("elem : "+elem+"\n");
		longueur_elem = elem.length();
		//longueur_cumulee += longueur_elem; 
		longueur_cumulee += longueur_elem;
		position = longueur_cumulee + cpt_op;
		// longueur_cumulee sert à trouver l'index correspondant à l'opérateur.
		System.out.println("cpt_op : "+cpt_op);
		
		System.out.println("longueur_elem : "+String.valueOf(longueur_elem));
		System.out.println("longueur_cumulee : "+longueur_cumulee);
		System.out.println("position : "+position);
		if (cpt_op!=(splitted_bloc.length-1)) { // si ce n'est pas le dernier nombre
			
			System.out.println("bloc_recup_t.charAt(position) : "+bloc_recup_t.charAt(position));
			try {
					System.out.println("AJOUT ELEMENT TABLEAU tab_op");
					tab_op.add(bloc_recup_t.charAt(position)); // on récupère le symbole de l'opérateur, que l'on place dans un tableau	
					System.out.print("cpt_op : "+cpt_op+", tab_op[cpt_op] : "+tab_op.get(cpt_op)+"\n");
					
				//}
			}
			catch (Exception e) {
				System.out.println("Problème POPO :"+e.getMessage());
			}
		}
		else { System.out.println("dernier nombre"); }
	
		System.out.println("====================");
		cpt_op++;
	}


	// =============================  NOUVELLE TECHNIQUE 18/10
	ArrayList<String> listSP2 = new ArrayList<>();
	
	String valNum_temp="";
	String oper_temp="";
	boolean flag_error = false;
	
	for (int i=0; i<bloc_recup_t.length(); i++) {
		if (String.valueOf(bloc_recup_t.charAt(i)).matches("[0-9\\.]")) {
			valNum_temp += bloc_recup_t.charAt(i); 
		}
		
		else if (String.valueOf(bloc_recup_t.charAt(i)).matches("\\+|\\*|[-x/]")){
			if (!(valNum_temp.equals(""))) { // on enregistre la valeur numérique précédente dans listSP2, si elle existe
				listSP2.add(valNum_temp);
				valNum_temp = ""; //on vide la string pour la prochaine occurence (valeur numérique)
			}
			if (String.valueOf(bloc_recup_t.charAt(i)).equals("x")) { oper_temp="*"; }
			else {
				oper_temp = String.valueOf(bloc_recup_t.charAt(i));
			}
			listSP2.add(oper_temp);
			oper_temp = "";
		}
		else { // tous les autres cas
			System.out.println("cas ELSE");
			listSP2.add("0");
			vp2.setJtaRes("SYNTAX ERROR");
			flag_error = true;
		}
		if (i==bloc_recup_t.length()-1) {listSP2.add(valNum_temp);} // cas de la dernière valeur rencontrée
		
		//System.out.println("valNum_temp : "+valNum_temp);
		
	}
	
	ListIterator<String> liSP2 = listSP2.listIterator();
	System.out.println("** Affichage ArrayList => Multiplications, divisions **");
	while (liSP2.hasNext()) {
		System.out.print(liSP2.next()+" ");
	}
	System.out.println("");
	System.out.println("taille ArrayList : "+listSP2.size());
	System.out.println("** FIN Affichage ArrayList => Multiplications, divisions **");
	
	Float calc_temp = 0f;
	Float calc_temp2 = 0f;
	String listDebug = String.join(" | ", listSP2);
	
	if (listSP2.get(0).equals("-")) { // traitement du cas : la première valeure est négative.
		listSP2.set(1, String.valueOf(Float.parseFloat(listSP2.get(1))*(-1)));
		listSP2.remove(0);
	}
	
	while (listSP2.contains("*") || listSP2.contains("/")) {
		for (int i=0; i<listSP2.size(); i++) {
			if (listSP2.get(i).equals("*")) {
				if (listSP2.get(i+1).equals("-") && i<listSP2.size()-1) { // traite le cas où la valeur suivante est un nombre négatif : exemple : 6*-7
					calc_temp = (Float.parseFloat(listSP2.get(i-1)))*(Float.parseFloat(listSP2.get(i+2)))*(-1);
				}
				else {
					
					calc_temp = (Float.parseFloat(listSP2.get(i-1)))*(Float.parseFloat(listSP2.get(i+1)));
				}
					listSP2.set(i, String.valueOf(calc_temp)); 
					listSP2.remove(i-1); // 
					listSP2.remove(i); //
					i+=2;
					System.out.println("Debug Mult  "+listDebug);
					System.out.println("taille l138 : "+listSP2.size()+" pour i="+i);
				
				//if (i<(listSP2.size())) { listSP2.remove(i+1); } // suppression de la valeur suivante si elle existe.
			}
			
		}
		for (int i=0; i<listSP2.size(); i++) {	
			
				if (listSP2.get(i).equals("/")) {
					if (listSP2.get(i+1).equals("-") && i<listSP2.size()-1) { // traite le cas où la valeur suivante est un nombre négatif : exemple : 6*-7
						calc_temp = (Float.parseFloat(listSP2.get(i-1)))/(Float.parseFloat(listSP2.get(i+2)))*(-1);
					}
					else {
						calc_temp = (Float.parseFloat(listSP2.get(i-1)))/(Float.parseFloat(listSP2.get(i+1)));
					}
					listSP2.set(i, String.valueOf(calc_temp)); 
					listSP2.remove(i-1); // 
					listSP2.remove(i); //
					i+=2;
					System.out.println("Debug Div  "+listDebug);
					System.out.println("taille l150 : "+listSP2.size()+" pour i="+i);
				}
				
		}
	}
	
	// affichage du calcul intermédiaire
	String calcul_intermediaire = "";
	for (int i=0; i<listSP2.size(); i++) {
		//if (listSP2.get(i-1).equals("+") || listSP2.get(i-1).equals("-")) { 
			calcul_intermediaire += listSP2.get(i);
		//}
	}
	// si listSP2.size()-1 différent de *,/,+,- => on remove le dernier élément calcul_intermediaire -= listSP2.get(listSP2.size()-1;
	vp2.setJt2(calcul_intermediaire);
	
	calc_temp2 = calc_temp; // permet d'obtenir le résultat final si il n'y a aucune Addition ni soustraction. 
	
	//gestion des additions / soustractions, après la simplification du calcul
	while (listSP2.contains("+") || listSP2.contains("-")) {
		for (int i=0; i<listSP2.size(); i++) {
			System.out.println("Début de boucle for pour les additions/soustractions, val i="+i);
			if (listSP2.get(i).equals("+")) {

				if (i==1) { // cas du premier élément (initialise l'élément si pas déjà fait ailleurs)
					calc_temp2 = Float.parseFloat(listSP2.get(0))+Float.parseFloat(listSP2.get(2));
					
				}
				else {
					calc_temp2 += Float.parseFloat(listSP2.get(i+1));
				}
				listSP2.set(i, "@"); // on remplace l'opérateur par un symbole quelquonque : permet la sortie de boucle While
				
				}
		
			
			// debug entre + et -
			ListIterator<String> liSP2c = listSP2.listIterator();
			System.out.println("** Affichage ArrayList => Entre Additions et soustractions **");
			while (liSP2c.hasNext()) {
				System.out.print(liSP2c.next()+" ");
			}
			System.out.println("");
			// fin debug
			
		
			if (i<listSP2.size()) {
				if (listSP2.get(i).equals("-")) {
				
					if (listSP2.get(i).equals("-")) {
						
						if (i==1) { // cas du premier élément (initialise l'élément si pas déjà fait)
							calc_temp2 = Float.parseFloat(listSP2.get(0))-Float.parseFloat(listSP2.get(2));
						}
						else {
							calc_temp2 -= Float.parseFloat(listSP2.get(i+1));
						}
						listSP2.set(i, "#"); // on remplace l'opérateur par un symbole quelquonque : permet la sortie de boucle While
						
					}
					
				}
			}
			
		} // fin boucle for
		
			
		} // fin while
		
	ListIterator<String> liSP2b = listSP2.listIterator();
	System.out.println("** Affichage ArrayList => Additions, soustractions **");
	while (liSP2b.hasNext()) {
		System.out.print(liSP2b.next()+" ");
	}
	System.out.println("");
	System.out.println("taille ArrayList : "+listSP2.size());
	System.out.println("** FIN Affichage ArrayList => Additions, soustractions **");
	System.out.println("\ncalc_temp2 : "+calc_temp2);
	
	if (!flag_error) { vp2.setJtaRes("Résultat :  "+calc_temp2); }
	
	
	
	}
}