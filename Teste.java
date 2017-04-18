public class Teste{

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
		
	public static void main(String [] args){
		double[] tab = {2.3,8.3 ,4.2, 7.8, 10.3, 40.5};
		quicksort(tab,0,tab.length-1);
		System.out.print("{");
		for (int i = 0; i < tab.length; i++){
			System.out.print(tab[i]+",");
		}
		System.out.println("}");
		System.out.println(tab);
		
		
		
	}
	
	
}
