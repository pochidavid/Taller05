package taller05;

public class Mochila {

	public static void main(String[] args) { 
		Mochila m = new Mochila();
		int[] pesos = {3,2,1,2};
		int[] valor= {6,9,5,6};
		m.solve(pesos,valor,4);
		}

	public void solve(int[] peso, int[] valor, int pesoMaximo){
		int N=4; //items
		int W=4; //max peso
		int[][] opt = new int[N][W]; //matriz que guarda el valor de cada escenario
		boolean[][] sol = new boolean[N][W]; //guarda si el elemento está presente
		
		for (int n=0; n<=N; n++){
			for (int w=0; w<W; w++){
				int option1 = n < 1 ? n : opt[n-1][w];
				int option2 = Integer.MIN_VALUE;
				
				//if(hay espacio en la mochila){
						//option2 = actualizar el valor de agregar a la mochila el elemento
				//}
				
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
		
		//imprimir la solución
	}
}
