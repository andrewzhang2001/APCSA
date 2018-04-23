package linearAlgebra;
import java.util.Arrays;
public class Matrix {
	protected MixedNumber[][] matrix;
	protected int numRows;
	protected int numCols;
	public Matrix(int r, int c){
		matrix = new MixedNumber[r][c];
		numRows = r;
		numCols = c;
	}
	public Matrix(MixedNumber[][] vals){
		numRows = vals.length;
		numCols = vals[0].length;
		matrix = new MixedNumber[numRows][numCols];
		for(int i=0;i<numRows;i++){
			for(int j=0;j<numCols;j++){
				matrix[i][j]=vals[i][j];
			}
		}
	}
	public void setValue(int r, int c, MixedNumber t){
		matrix[r][c]=t;
	}
	public MixedNumber[][] getValues(){
		return matrix;
	}
	public int getNumRows(){
		return numRows;
	}
	public int getNumCols(){
		return numCols;
	}
	public MixedNumber getVal(int r, int c){
		return matrix[r][c];
	}
	public void fillZeroes(){
		for(int i=0;i<numRows;i++){
			for(int j=0;j<numCols;j++){
				matrix[i][j]=new MixedNumber(0);
			}
		}
	}
	
	//Matrix Operations
	public Matrix transpose(){
		MixedNumber[][] ans = new MixedNumber[numCols][numRows];
		for(int i=0;i<numRows;i++){
			for(int j=0;j<numCols;j++){
				ans[j][i]=matrix[i][j];
			}
		}
		return new Matrix(ans);
	}
	public Matrix add(Matrix m){
		if(numRows==m.getNumRows()&&numCols==m.getNumCols()){
			MixedNumber[][] ans = new MixedNumber[numRows][numCols];
			for(int i=0;i<numRows;i++){
				for(int j=0;j<numCols;j++){
					ans[i][j]=matrix[i][j].add(m.getVal(i, j));
				}
			}
			return new Matrix(ans);
		}
		else{
			System.out.println("INVALID OPERATION: CANNOT ADD TWO MATRICES OF DIFFERENT SIZES");
			return null;
		}
	}
	
	public Matrix scale(int n){
		MixedNumber[][] ans = matrix.clone();
		for(int i=0;i<matrix.length;i++){
			for(int j=0;j>matrix[0].length;j++){
				ans[i][j].multiply(MixedNumber.valueOf(n));
			}
		}
		return new Matrix(ans);
	}
	public Matrix multiply(Matrix m){
		if(numCols==m.getNumRows()){
			int ansRows = numRows;
			int ansCols = m.getNumCols();
			MixedNumber[][] ans = new MixedNumber[ansRows][ansCols];
			for(int i=0;i<ansRows;i++){
				for(int j=0;j<ansCols;j++){
					ans[i][j]=new MixedNumber(0);
				}
			}
			for(int i=0;i<ansRows;i++){
				for(int j=0;j<ansCols;j++){
					for(int k=0;k<numCols;k++){
						ans[i][j]=ans[i][j].add(this.getVal(i, k).multiply(m.getVal(k, j)));
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
		int maxLength=0;
		for(int i=0;i<numRows;i++){
			for(int j=0;j<numCols;j++){
				matrix[i][j].simplify();
				int curLen = matrix[i][j].toString().length();
				maxLength = curLen>maxLength ? curLen : maxLength;
				
			}
		}
		String output = "{ ";
		for(int i=0;i<numRows;i++){
			if(i>0) output +="  ";
			for(int j=0;j<numCols;j++){
				String curMixNum = matrix[i][j].toString();
				output+=curMixNum;
				for(int l=curMixNum.length();l<maxLength;l++) output +=" ";
				if(j!=numCols-1) output +=", ";
			}
			if(i!=numRows-1) output +="\n";
			else output +=" }\n";
		}
		return output;
	}
}
