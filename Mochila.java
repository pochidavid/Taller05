package taller05;

public class Mochila {

	public static void main(String[] args) { 
		Mochila m = new Mochila();
		int[] pesos = {3,2,1,2};
		int[] valor= {6,9,5,6};
		m.resolve(pesos,valor,4);
		}

	public void resolve(int[] peso, int[] valor, int pesoMaximo){
		int N=4; //items
		int W=4; //max peso
		int[][] opt = new int[N][W]; //matriz que guarda el valor de cada escenario
		boolean[][] sol = new boolean[N][W]; //guarda si el elemento está presente
		
		for (int n=0; n<=N; n++){
			for (int w=0; w<W; w++){
				int option1 = n < 1 ? n : opt[n-1][w];
				int option2 = Integer.MIN_VALUE;
				
				if(peso[n]<=w){ //ASOFJAJFA
						option2 = valor[n]+opt[n-1][w-peso[n]];//ENTRA ACA EN LA PRIMERA ITERACION Y TIRA ERROR FUERA DE RANGO, NO DEBERIA
				}
				
				opt[n][w] = Math.max(option1, option2);
				sol[n][w] = (option2 > option1);
			}
		}
		
		//determinar la combinación óptima
		
		boolean[] esSolucion = new boolean[N];
		for (int n = N, w = W; n>=0; n--){
			if (sol[n-1][w]){
				esSolucion[n-1] = true;
				w = w - peso[n-1];
			}else{
				esSolucion [n] = false;
			}
		}
		
		System.out.println("Los objetos optimos son: \n");
		for(int i=0; i<N; i++){
			if(esSolucion[i])
				System.out.println("Objeto "+ i +" con peso "+ peso[i] + " y con valor "+valor[i]);
		}
	}
}
