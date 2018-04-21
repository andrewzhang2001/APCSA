package linearAlgebra;

public class Vector extends Matrix{
	public Vector(int n){
		super(n,1);
	}
	public Vector(double[] vals){
		super(vals.length,1);
		for(int i=0;i<vals.length;i++){
			this.setValue(i, 0, vals[i]);
		}
	}
}
