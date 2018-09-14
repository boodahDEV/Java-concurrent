package mult_concurrent;

public class TestMultConcurrent {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N=3;
		double [][] C;
		double [][] A = new double [][] {{1,1,1},{1,1,1},{1,1,1}};
		double [][] B = new double [][] {{1,1,1},{1,1,1},{1,1,1}};
		
		MultConcurrent mult = new MultConcurrent(A,B,N);
		C = mult.calcular();
		System.out.println("MATRIZ A");
		mult.desplegar(A);
		System.out.println("MATRIZ B");
		mult.desplegar(B);
		System.out.println("MATRIZ C");
		mult.desplegar(C);
	}

}
