package codeforces;
import java.lang.Math;
public class OMO24 {
	private static long a,b,c,total;
	public static void main(String[] args){
		int cnt = 0;
		for(int i=0;i<=1000;i++){
			for(int j=0;j<=1000;j++){
				for(int k=0;k<=1000;k++){
					a = i;
					b = j;
					c =k;
					if(((long) Math.pow(a, 3)+(long) Math.pow(b, 3)+(long) Math.pow(c,3))%1001==(long)(3*a*b*c+1)%1001) cnt++;
				}
			}
		}
		System.out.println(cnt);
	}
}
