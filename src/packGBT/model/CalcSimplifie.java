package packGBT.model;

import java.util.ArrayList;

public class CalcSimplifie {

	public float valeur;
	//public char op_pre = 0;
	//public Character op_now = 0;
	public Character op_next = 0;
	private ArrayList<CalcSimplifie> listeCalcSimplifie;
	
	public CalcSimplifie(float val, Character next) {
		this.valeur = val;
		//this.op_pre = pre;
		//this.op_now = now;
		this.op_next = next;
	}
	
	public void affiche_CalcSimplifie() {
		//System.out.println("CalcSimplifie : "+this.valeur+"\t opérateur prcédent : "+this.op_pre+"\t opérateur actuel : "+this.op_now+"\t opérateur suivant : "+this.op_next);
		System.out.println("CalcSimplifie : "+this.valeur+"\t opérateur suivant : "+this.op_next);
	}

	public ArrayList<CalcSimplifie> getListeCalcSimplifie() {
		return listeCalcSimplifie;
	}

	public void setListeCalcSimplifie(ArrayList<CalcSimplifie> listeCalcSimplifie) {
		this.listeCalcSimplifie = listeCalcSimplifie;
	}
}
