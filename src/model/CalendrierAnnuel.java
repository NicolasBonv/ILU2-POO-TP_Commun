package model;

public class CalendrierAnnuel {
	private Mois[] calendrier;
	private String[] listeNomMois = {"Janvier","Fevrier","Mars","Avril","Mai","Juin","Juillet","Aout","Septembre","Octobre","Novembre","Decembre"};
	private int[] listeNbJours = {31,28,31,30,31,30,31,31,30,31,30,31};
	
	public CalendrierAnnuel() {
		calendrier = new Mois[12];
		for (int i=0;i<12;i++) {
			calendrier[i] = new Mois(listeNomMois[i],listeNbJours[i]);
		}
	}
	private static class Mois{
		private String nom;
		private boolean[] jours;
		public Mois(String nom,int nbJour) {
			this.nom = nom;
			jours = new boolean[nbJour];
			for(int i=0;i<nbJour;i++) {
				this.jours[i] = false;
			}
		}
		boolean estLibre(int jour){
			return !jours[jour];
		}
		void reserver(int jour) throws IllegalStateException{
			if(estLibre(jour))
				jours[jour] = true;
			else
				throw new IllegalStateException();
		}
	}
	boolean estLibre(int jour,int mois) {
		return (calendrier[mois-1].estLibre(jour-1));
	}
	boolean reserver(int jour,int mois) {
		try{
			if(estLibre(jour-1,mois-1)) {
				calendrier[mois-1].reserver(jour-1);
				return true;
			}
		}catch (IllegalStateException e) {
			e.printStackTrace();
		}
		return false;
		
	}
}
	