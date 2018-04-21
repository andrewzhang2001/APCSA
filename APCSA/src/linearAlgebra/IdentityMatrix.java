package linearAlgebra;

public class IdentityMatrix extends Matrix {
	public IdentityMatrix(int n){
		super(n,n);
		this.fillZeroes();
		for(int i=0;i<n;i++){
			this.setValue(i, i, 1);
		}
	}
}
