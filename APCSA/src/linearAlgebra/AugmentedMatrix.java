package linearAlgebra;

public class AugmentedMatrix {
	private Matrix lhs,rhs;
	public AugmentedMatrix(Matrix one, Matrix two){
		if(one.getNumRows()!=two.getNumRows()){
			System.out.println("AUGMENTED MATRIX ERROR: THE TWO MATRICES DO NOT HAVE THE SAME # OF ROWS");
		}
		lhs = one;
		rhs = two;
	}
	public void rowEchelon(){
		while(!isEchelon()){
			
		}
	}
	public void rowReducedEchelon(){
		
	}
	public boolean isEchelon(){
		
	}
	public boolean isReducedEchelon(){
		
	}
	public void swapRows(int rowOne, int rowTwo){
		
	}
}
