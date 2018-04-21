package linearAlgebra;
import java.util.Arrays;
public class Matrix {
	protected double[][] matrix;
	protected int numRows;
	protected int numCols;
	public Matrix(int r, int c){
		matrix = new double[r][c];
		numRows = r;
		numCols = c;
	}
	public Matrix(double[][] vals){
		numRows = vals.length;
		numCols = vals[0].length;
		matrix = new double[numRows][numCols];
		for(int i=0;i<numRows;i++){
			for(int j=0;j<numCols;j++){
				matrix[i][j]=vals[i][j];
			}
		}
	}
	public void setValue(int r, int c, double t){
		matrix[r][c]=t;
	}
	public double[][] getValues(){
		return matrix;
	}
	public int getNumRows(){
		return numRows;
	}
	public int getNumCols(){
		return numCols;
	}
	public double getVal(int r, int c){
		return matrix[r][c];
	}
	public void fillZeroes(){
		for(int i=0;i<numRows;i++){
			for(int j=0;j<numCols;j++){
				matrix[i][j]=0.0;
			}
		}
	}
	
	//Matrix Operations
	public Matrix transpose(){
		double[][] ans = new double[numCols][numRows];
		for(int i=0;i<numRows;i++){
			for(int j=0;j<numCols;j++){
				ans[j][i]=matrix[i][j];
			}
		}
		return new Matrix(ans);
	}
	public Matrix add(Matrix m){
		if(numRows==m.getNumRows()&&numCols==m.getNumCols()){
			double[][] ans = new double[numRows][numCols];
			for(int i=0;i<numRows;i++){
				for(int j=0;j<numCols;j++){
					ans[i][j]=matrix[i][j]+m.getVal(i, j);
				}
			}
			return new Matrix(ans);
		}
		else{
			System.out.println("INVALID OPERATION: CANNOT ADD TWO MATRICES OF DIFFERENT SIZES");
			return null;
		}
	}
	
	public Matrix multiply(Matrix m){
		if(numCols==m.getNumRows()){
			int ansRows = numRows;
			int ansCols = m.getNumCols();
			double[][] ans = new double[ansRows][ansCols];
			for(int i=0;i<ansRows;i++){
				for(int j=0;j<ansCols;j++){
					ans[i][j]=0.0;
				}
			}
			for(int i=0;i<ansRows;i++){
				for(int j=0;j<ansCols;j++){
					for(int k=0;k<numCols;k++){
						ans[i][j]=ans[i][j]+this.getVal(i, k)*m.getVal(k, j);
					}
				}
			}
			return new Matrix(ans);
		}
		else{
			System.out.println("INVALID OPERATION: CANNOT MULTIPLY THESE TWO MATRICES TOGETHER.");
			return null;
		}
	}
	
	public String toString(){
		String output = "{ ";
		for(int i=0;i<numRows;i++){
			if(i>0) output +="  ";
			for(int j=0;j<numCols;j++){
				String curDouble = Double.toString(matrix[i][j]);
				for(int d=0;d<5;d++){
					if(d<curDouble.length())
					output+=curDouble.charAt(d);
					else output+="0";
				}
				if(j!=numCols-1) output +=", ";
			}
			if(i!=numRows-1) output +="\n";
			else output +=" }\n";
		}
		return output;
	}
}
