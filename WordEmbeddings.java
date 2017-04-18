import java.io.IOException;

public class WordEmbeddings extends Vecteurs{

	public static void main(String[] args) throws LengthVectorException{
		Bibliotheque bibli = new Bibliotheque("vecs50.txt", 200000);
		try{
			bibli.restaure();
		}
		catch(IOException ioe){
			System.out.println(ioe);
		}
		//bibli.tousLesVecteurs();
		
		try{
			System.out.println("addition du premier et du second vecteur : " + addition(bibli.vec[0],bibli.vec[1]));
			System.out.println("soustraction du premier et du second vecteur : " + soustraction(bibli.vec[0],bibli.vec[1]));
			System.out.println("multiplication scalaire du premier vecteur avec le scalaire 3.2 : " + MultiplicationScalaire(bibli.vec[0], 3.2));
			System.out.println("produit scalaire du premier et du second vecteur : " + ProduitScalaire(bibli.vec[0],bibli.vec[1]));
			System.out.println("norme du premier vecteur : "+ Norme(bibli.vec[0]));
			System.out.println("distance entre le premier et le second vecteur : "+ Distance(bibli.vec[0], bibli.vec[1]));
			System.out.println("similarité cosinus entre le premier et le second vecteur : "+ Similarite(bibli.vec[0],bibli.vec[1]));
			//System.out.println("similarité cosinus entre un vecteur et ses k similaires : ");
			//Similaritek(bibli.vec[1996],10);
		}
		catch(ExceptionOperation eo){
			System.out.println(eo);
		}
		
		// Si l'utilisateur entre un mot, lui renvoyer les k mots les plus similaires, à faire après
		/*if (args.length > 0){
			for (int i = 0;i < args.length; i++){
				System.out.print(args[i]+ " ");
				
			}
			System.out.println();
		}
		else if (args.length == 0){
			try {
				String line;
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				while((line = br.readLine()) != null){
					System.out.println(line);
				}
			}
			catch(IOException ioe){
				System.out.println(ioe);
			}
		}*/
	}
	
}
