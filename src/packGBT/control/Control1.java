package packGBT.control;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.ListIterator;

import packGBT.view.ViewMain;
import packGBT.view.ViewPanel2;
import packGBT.model.CalcSimplifie;

public class Control1 {

	public int taille_x, taille_y;
	
	public Control1(ViewMain vm, ViewPanel2 vp2) {
	taille_x = vm.getWidth();
	taille_y = vm.getHeight();
	//System.out.println("[Control1.java] dimensions vm : "+taille_x+" - "+taille_y+" .");
	vp2.getJtaRes().setText("On avance bien !");

	String bloc_recup = vp2.getJT1().getText(); // récupération du JTextField jt1
	String bloc_recup_t = bloc_recup.replaceAll(" ","");
	System.out.println("bloc_recup size : "+bloc_recup.length());
	System.out.println("bloc_recup_t size : "+bloc_recup_t.length());
	String[] splitted_bloc = bloc_recup_t.split("\\+|\\*|[-x/]"); // split suivant le regex (on récupère chaque nombre)
	System.out.println("splitted_bloc[0] : "+splitted_bloc[0]);
	System.out.println("splitted_bloc[1] : "+splitted_bloc[1]);
	System.out.println("tab splitted_bloc : "+Arrays.toString(splitted_bloc));
	System.out.println("tab splitted_bloc length -1 (index of last element): "+String.valueOf(splitted_bloc.length-1));
	
	/*
	String op0 = String.valueOf(bloc_recup_t.charAt(splitted_bloc[0].length()));
	String op1 = String.valueOf(bloc_recup_t.charAt(splitted_bloc[1].length()));
	System.out.println("op0 : "+op0);
	System.out.println("op1 : "+op1);
	*/
	
	ArrayList<Character> tab_op = new ArrayList<Character>(); // tableau des opérateurs qui seront détectés au fur et à mesure 
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
		//if (cpt_op==0) { longueur_cumulee = longueur_cumulee +1; } // si c'est ni le premier ni le dernier élément 
		
		System.out.println("longueur_elem : "+String.valueOf(longueur_elem));
		System.out.println("longueur_cumulee : "+longueur_cumulee);
		System.out.println("position : "+position);
		if (cpt_op!=(splitted_bloc.length-1)) { // si ce n'est pas le dernier nombre
			
			System.out.println("bloc_recup_t.charAt(position) : "+bloc_recup_t.charAt(position));
			try {
				//if (!(String.valueOf(tab_op.get(cpt_op)).isEmpty())) { // si l'élément de tableau à l'indice cpt_op n'existe pas
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
		//if (!(String.valueOf(bloc_recup_t.charAt(elem.length()-1)).equals(""))) { // si le dernier opérateur existe
		//if (String.valueOf(bloc_recup_t.charAt(elem.length())).matches("\\+|\\*|[-x/]") ){
		
		System.out.println("====================");
		cpt_op++;
	}
	//System.out.println("## tab_op :"+ArrayList.toString(tab_op));
	ArrayList<Float> tab_simplifie = new ArrayList<>();
	ArrayList<CalcSimplifie> laListe = new ArrayList<>();
	
	
	Float calc = 0f;
	System.out.println("splitted_bloc.length : "+splitted_bloc.length);
	
	float memoire_calc = 0f; // init mémorisation de la valeur calc
	char memoire_oper = '+'; // init mémorisation de l'opérateur
	
	try {
		int index=0;
		
		for (int i=0; i<splitted_bloc.length-1; i++) { // pour toutes les valeurs numériques sauf la dernière
			if (index < tab_op.size()) {
				System.out.print("tab_op : "+tab_op.get(index)+"\t");
				
				// ===================================== MULTIPLICATION
				if (String.valueOf(tab_op.get(index)).matches("\\*|x")) { //cas Multiplication / division
					if (index==0) { // sinon risque d'avoir calc=0 à cause de l'initialisation de calc à 0.
						calc = Float.parseFloat(splitted_bloc[0]) * Float.parseFloat(splitted_bloc[1]);
						//res_temp.add(Float.parseFloat(splitted_bloc[0]) * Float.parseFloat(splitted_bloc[1]));
					}
					else if (!(String.valueOf(tab_op.get(index-1)).matches("\\+|-"))){ // si l'opérateur précédent n'était pas + ou -
						calc *= Float.parseFloat(splitted_bloc[i+1]);
						// res_temp.add(Float.parseFloat(splitted_bloc[i]) * Float.parseFloat(splitted_bloc[i+1]));
					}
					else {
						//System.out.println("Dans le ELSE, ligne 106");
						if (index < tab_op.size()-1) {
							//laListe.add(new CalcSimplifie(calc, tab_op.get(index-1), tab_op.get(index), tab_op.get(index+1)));
						}
						else { // si pas d'index suivant (dernier opérateur)
							//laListe.add(new CalcSimplifie(calc, tab_op.get(index-1), tab_op.get(index), '0'));
						}
						//memoire_calc = calc;
						//memoire_oper = tab_op.get(index-1);
					}
					
				}
				// ===================================== DIVISION
				if (String.valueOf(tab_op.get(index)).matches("/")) { //cas Multiplication / division
					if(Float.parseFloat(splitted_bloc[1])==0f) { vp2.getJtaRes().setText("Division par 0 !");}
					
					if (index==0 && Float.parseFloat(splitted_bloc[1])!=0) { // avec gestion div par zéro
						calc = Float.parseFloat(splitted_bloc[0]) / Float.parseFloat(splitted_bloc[1]);
						//res_temp.add(Float.parseFloat(splitted_bloc[0]) * Float.parseFloat(splitted_bloc[1]));
					}
					else if (!(String.valueOf(tab_op.get(index-1)).matches("\\+|-"))){ // si l'opérateur précédent n'était pas + ou -
						calc /= Float.parseFloat(splitted_bloc[i+1]);
						// res_temp.add(Float.parseFloat(splitted_bloc[i]) * Float.parseFloat(splitted_bloc[i+1]));
					}
					else {
						//memoire_calc = calc;
						//memoire_oper = tab_op.get(index-1);
					}
				}
				// ===================================== ADDITION
				try {
					if (String.valueOf(tab_op.get(index)).matches("\\+") && !(String.valueOf(tab_op.get(index+1)).matches("\\*|x|/"))) { //cas addition avec opérateur suivant différent de mult ou div				
						//if (index==0) {	
							//calc = Float.parseFloat(splitted_bloc[0]) + Float.parseFloat(splitted_bloc[1]);
						//}
						//else {
						System.out.println("cas addition avec opérateur suivant différent de mult ou div");
						
							calc += Float.parseFloat(splitted_bloc[i+1]);
						//}
					}
					else if (String.valueOf(tab_op.get(index)).matches("\\+")){ // cas addition, avec opérateur suivant => x,* ou /
						//memoire_calc = calc;
						//memoire_oper = '+';
						//tab_simplifie.add(Float.parseFloat(splitted_bloc[i]));
					}
					//res_temp.add(Float.parseFloat(splitted_bloc[i]) + Float.parseFloat(splitted_bloc[i+1]));
					
					}
				catch (IndexOutOfBoundsException e_oob) { // gère le cas tab_op.get(index+1)) hors limites
					System.out.println("Hors limites : "+e_oob.getMessage());
					}
				
				
				System.out.println("in the boucle "+i+", "+index);
				index++;
			} // fin if (index < tab_op.size())
			System.out.println("Fin if (index < tab_op.size())");
		} // fin boucle for (pour toutes valeurs numériques sauf la dernière)
		
	}
	catch (Exception e) {
		System.out.println("Exception l162 - "+e.getMessage());
	}
	int id=0;
	while(!tab_simplifie.isEmpty()) {
		System.out.println("res_temp.get(id) : "+tab_simplifie.get(id));
		id++;
	}
	System.out.println("calc : "+calc);
	//System.out.println("memoire_calc : "+memoire_calc);
	//System.out.println("memoire_oper : "+memoire_oper);
	ListIterator<CalcSimplifie> li = laListe.listIterator();
	while (li.hasNext()) {
		System.out.println("** Listing laListe **");
		System.out.println(li.next().valeur);
		//System.out.println(li.next().op_pre);
		//System.out.println(li.next().op_now);
		//System.out.println(li.next().op_next);
	}
	
	
	
	
	
/*	
	
	
	String[] splitted_bloc_plus = bloc_recup.trim().split("\\+");
	String[] splitted_bloc_moins = bloc_recup.trim().split("-");
	String[] splitted_bloc_mult1 = bloc_recup.trim().split("\\*");
	String[] splitted_bloc_mult2 = bloc_recup.trim().split("x");
	String[] splitted_bloc_div = bloc_recup.trim().split("/");
	
	
	float res_f1 = 1f;
	float res_f2 = 1f;
	float res_f3 = 0f;
	float res_f4 = 0f;
	
	
	int brt = bloc_recup_t.length();
	int sbl = splitted_bloc.length;
	int cpt = 0;
	
		
	int[] mult_pos = new int[40];
	int[] div_pos = new int[40];
	int[] plus_pos = new int[40];
	int[] moins_pos = new int[40];
	
	for (int c=0, c2=0; c<bloc_recup.length(); c++, c2++) {
		if (String.valueOf(bloc_recup.charAt(c)).matches("\\*|x")) {
			mult_pos[c2] = c;
		}
		else if (String.valueOf(bloc_recup.charAt(c)).matches("/")) {
			div_pos[c2] = c;
		}
		else if (String.valueOf(bloc_recup.charAt(c)).matches("\\+")) {
			plus_pos[c2] = c;
		}
		else if (String.valueOf(bloc_recup.charAt(c)).matches("/")) {
			moins_pos[c2] = c;
		}
		
	}
	*/
	
	/*
	try {
		for (int elem : mult_pos) {
	
			System.out.println("mult_pos : " + mult_pos[elem]);
	
		}
	}
		catch (Exception e){
		System.out.println("exception l69 "+ e.getMessage());
		}
	
		
		if (splitted_bloc_mult1.length>1) { // au moins 2 éléments de tableau sinon le split n'est pas valable.
		
			for (int i=0; i<splitted_bloc_mult1.length; i++) {
				System.out.println("mult1 str"+i+" (splitted_bloc) : "+splitted_bloc_mult1[i]+" - length : "+splitted_bloc_mult1.length);
				res_f1 *= Float.parseFloat(splitted_bloc_mult1[i]); // on multiplie tous les membres du tableau
				
				//System.out.println("cat1 : "+cat1);
				
			}
			System.out.println("res_f1 (*): "+res_f1);
		}
	
		if (splitted_bloc_mult2.length>1) {	// au moins 2 éléments de tableau sinon le split n'est pas valable.
			for (int i=0; i<splitted_bloc_mult2.length; i++) {
				System.out.println("mult2 str"+i+" (splitted_bloc) : "+splitted_bloc_mult2[i]+" - length : "+splitted_bloc_mult2.length);
				res_f1 *= Float.parseFloat(splitted_bloc_mult2[i]); // on multiplie tous les membres du tableau
			}
			System.out.println("res_f1 (x): "+res_f1);
		}
		if (splitted_bloc_div.length>1) { // au moins 2 éléments de tableau sinon le split n'est pas valable.	
			for (int i=0; i<splitted_bloc_div.length; i++) {
				res_f2 = Float.parseFloat(splitted_bloc_div[0]); // init avec le premier élément de tableau
				System.out.println("div str"+i+" (splitted_bloc) : "+splitted_bloc_div[i]+" - length : "+splitted_bloc_div.length);
				res_f2 /= Float.parseFloat(splitted_bloc_div[i]); // on divise tous les membres du tableau
			}
			System.out.println("res_f2 (div): "+res_f2);
		}
*/

	}
	
	public float multiplie(float n1, float n2) {
		return n1*n2;
	}
	public int multiplie(int n1, int n2) {
		return n1*n2;
	}
	public float divise(float n1, float n2) {
		float res = 0f;
		if (n2!=0) {
		res = n1/n2;
		}
		else {
			res = 0;
			System.out.println("Division par zéro !");
		}
		return res;
		
		
	}
	public float addition(float n1, float n2) {
		return n1+n2;
	}
	public int addition(int n1, int n2) {
		return n1+n2;
	}
}
