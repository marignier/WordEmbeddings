import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.lang.Math;
						


public class Bibliotheque{

	protected static Vecteurs[] vec;
	protected int size;
	protected static int taille; // utilisé dans vecteurs
	protected final String filename;
	
	
	public Bibliotheque(String fn, int t){
		this.vec = new Vecteurs[t]; // Dans le fichier vecs50.txt, il y a plus de 150 000 lignes 
		this.size = 0;
		this.filename = fn;
	}
		
	
	public Bibliotheque(Vecteurs[] v, String fn){ // sais pas si c'est utile, à voir à la fin
		this.vec = v;
		this.size = 0;
		this.filename = fn;
	} 
	
	public int getSize(){
		return this.size;
	}
	
	
	public void tousLesVecteurs(){ // Montre la bibliothque de vecteurs
        for (int i = 0; i < size; i++){
            System.out.println(vec[i]);
        }
    }
    
    public void ajouterVecteur(Vecteurs v){ // Ajoute un vecteur au tableau de vecteurs
		this.vec[size++] = v;
	}
	
	/*public static void afficherTab(double[] tab){
        assert tab != null : "Erreur: tab == null";
        System.out.print("[");
        for (int i = 0; i < tab.length; i++){
            System.out.print(" " + tab[i]);
        }
        System.out.println(" ] size=" + tab.length);
    }*/
    
    public void restaure() throws IOException{ // créé une bibliotèque à partir du fichier vecs50.txt
		FileReader fr = new FileReader(this.filename);
		BufferedReader br = new BufferedReader(fr);
		String line; 
		while((line = br.readLine()) != null){
			String[] bfr = line.split(" ");
			if (bfr.length == 51){
				double[] vect = new double[50];
				String mot = bfr[0];
				for (int i = 0; i < vect.length; i++){
					int j = i+1;
					vect[i] = Double.parseDouble(bfr[j]);
				}
				Vecteurs v = new Vecteurs(mot,vect);
				this.ajouterVecteur(v);
			}
		}
	}
	
	public static double Similarite(Vecteurs un, Vecteurs deux) throws ExceptionOperation, LengthVectorException{
		if(un.ve.length != deux.ve.length){
			throw new LengthVectorException("erreur: les deux vecteurs n'ont pas la même longueur");
		}
		else{
			return ProduitScalaire(un, deux)/(Norme(un)*Norme(deux));
		}
	}
	
	
	public static void quicksort(double[] tab, int g, int d) {
		if (tab == null || tab.length == 0){
			return;
		}
		if (d > g){
			int pospivot = pivoter(g,d,tab);
			System.out.println(pospivot);
			quicksort(tab, g, pospivot-1);
			quicksort(tab,pospivot+1,d);
		}
		
	}

	public static int pivoter(int g, int d,  double[] tab) {
		double pivot = tab[d];
		int pospivot = g;
		
		for (int i = g; i < d; i++){
			if (tab[i] <= pivot){
				double bfr = tab[i];
				tab[i] = tab[pospivot];
				tab[pospivot] = bfr;
				pospivot++;
			}
		}
		double bfr = tab[pospivot];
		tab[pospivot] = tab[d];
		tab[d] = bfr;
		return pospivot;
	}
	

	public static void Similaritek(Vecteurs un, int k) throws ExceptionOperation, LengthVectorException{
		double[] tab_similarite = new double[taille];
		for(int i=0; i<taille; i++){
			tab_similarite[i] = Similarite(un, vec[i]);
		}
		quicksort(tab_similarite, 0, tab_similarite.length-1);		//implementer sort de manière décroissante	
	
		for(int j = taille-1; j > taille -k -1; j--){
			System.out.println(tab_similarite[j]);
		}
		
	}
	
	
	public class Vecteurs {

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

}	
