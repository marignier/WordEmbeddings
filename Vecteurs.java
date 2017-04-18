import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.lang.Math;
									//on part du principe que les vecteurs sont de mêmes dimensions et de
public class Vecteurs{

	protected String label;
	protected double[] ve;
	
	// Vecteur tout court
	public Vecteurs(){
		this.label = "defaut";// Problème : comment l'appeler, pour l'instant défaut (voir les fonction d'addition etc.)
		this.ve = new double[50];
	}
	// Vecteur de Mots
	public Vecteurs(String s){
		this.label = s;
		this.ve = new double[50];
	}
	
	public Vecteurs(String s, double[] tab){
		this.label = s;
		this.ve = tab;
	}
	
	
	/*public static void afficherTab(double[] tab){
        assert tab != null : "Erreur: tab == null";
        System.out.print("[");
        for (int i = 0; i < tab.length; i++){
            System.out.print(" " + tab[i]);
        }
        System.out.println(" ] size=" + tab.length);
    }*/
	public String toString(){
		assert ve != null : "Erreur: tableau de vecteurs == null";
		String res = "[";
		for (int i = 0; i < ve.length; i++){
            res += " " +ve[i];
        }
        res += "]";
		return label+ " "+ res;
		
	} 
	
	public static Vecteurs addition(Vecteurs un, Vecteurs deux) throws ExceptionOperation, LengthVectorException{
		if(un.ve.length != deux.ve.length){
			throw new LengthVectorException("erreur: les deux vecteurs n'ont pas la même longueur");
		}
		else{
			Vecteurs trois = new Vecteurs(); // Problème : comment l'appeler, pour l'instant défaut
			for (int i = 0; i < un.ve.length ; i++){
				trois.ve[i] = un.ve[i] + deux.ve[i];
			}
			return trois;
		}
	}
	
	public static Vecteurs soustraction(Vecteurs un, Vecteurs deux) throws ExceptionOperation, LengthVectorException{
		if(un.ve.length != deux.ve.length){
			throw new LengthVectorException("erreur: les deux vecteurs n'ont pas la même longueur");
		}
		else{
			Vecteurs trois = new Vecteurs();// Problème : comment l'appeler, pour l'instant défaut
			for (int i = 0; i < un.ve.length ; i++){
				trois.ve[i] = un.ve[i] - deux.ve[i];
			}
			return trois;
		}
	}
	
	
	public static Vecteurs MultiplicationScalaire(Vecteurs un, double lambda) throws ExceptionOperation{ 
		Vecteurs trois = new Vecteurs();// Problème : comment l'appeler, pour l'instant défaut
		for (int i = 0; i < un.ve.length ; i++){
			trois.ve[i] = un.ve[i] * lambda;
		}
		return trois;
	}
		
		
	public static double ProduitScalaire(Vecteurs un, Vecteurs deux) throws ExceptionOperation, LengthVectorException{
		if(un.ve.length != deux.ve.length){
			throw new LengthVectorException("erreur: les deux vecteurs n'ont pas la même longueur");
		}
		else{
			double produit_scalaire = 0.0;
			for (int i = 0; i < un.ve.length ; i++){
				produit_scalaire += un.ve[i] * deux.ve[i];
			}
			return produit_scalaire;
		}
	}
	
	public static double Norme(Vecteurs un) throws ExceptionOperation, LengthVectorException{
		return Math.sqrt(ProduitScalaire(un, un));					 //forcement positif car le produit scalaire d'un vecteur avec lui même rend toutes les coordonnées au carré, donc positives
	}
	
	public static double Distance(Vecteurs un, Vecteurs deux) throws ExceptionOperation, LengthVectorException{
		if(un.ve.length != deux.ve.length){
			throw new LengthVectorException("erreur: les deux vecteurs n'ont pas la même longueur");
		}
		else{
			return Norme(soustraction(un, deux));
		}
	}


	

		
		
		// faire exception pour vérifier que la similarité est comprise entre -1 et 1?
	

}
