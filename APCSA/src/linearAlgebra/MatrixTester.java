package linearAlgebra;

public class MatrixTester {
	public static void main(String[] args) {
		double[][] m1 = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		double[][] m2 = { { 1, 2 }, { 4, 5 }, { 7, 8 } };
		Matrix one = new Matrix(m1);
		Matrix two = new Matrix(m2);
		Matrix multiply = one.multiply(two);
		Matrix add = one.add(two);
		System.out.println(add);
		System.out.println(multiply);
	}
}