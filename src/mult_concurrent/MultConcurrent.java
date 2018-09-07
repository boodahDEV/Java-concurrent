//package mult_concurrent;

public class MultConcurrent {
 public int N;
 public static int hi=0;
 public double [][] A, B,C;
 Thread[] t;
	public MultConcurrent(double [][] A,double [][] B,int N) {
		this.N=N;this.A=A;this.B=B;
		C = new double [N][N];
		t = new Thread[N*N];
	}//Builder
	
	public double [][] calcular() {
		for(int i = 0;i<N;i++) {
			for(int j=0;j<N;j++) {
				t[hi]= new ProductoInterno(i,j);
				t[hi].start();
				hi++;
			}
		}
		esperaHilo();
		return C;
	}//fin metodo calcular
	
	public void esperaHilo() {
		for(int i=0;i<t.length;i++) {
			try {
				t[i].join();
			}catch(Exception e) {}
		}
	}//fin esperaHilo
	
	public void desplegar(double [][] C) {
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				System.out.print(C[i][j]+ " ");
			}
			System.out.println(" ");
		}
		System.out.println("\n");
	}//fin desplegar

	//inner class
	class ProductoInterno extends Thread{
		int i,j;
		
		
		public ProductoInterno(int i, int j) {
			this.i = i;
			this.j = j;
		}//builder


		public void run() {
			C[i][j] = 0.0;
			for(int k=0;k<N;k++) {
				C[i][j]+=A[i][k]*B[k][j];
			}
		}//end run
	}//end inner class
}//end class

