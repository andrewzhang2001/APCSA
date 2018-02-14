package unit6;

public class Lab08g {

	public static void main(String[] args) {
		LoopStats bbb = new LoopStats(1,5);
		bbb.findTotal();
		bbb.pairCount();
		bbb.setValue(2,8);
		bbb.findTotal();
		bbb.pairCount();
		bbb.setValue(5, 15);
		bbb.findTotal();
		bbb.pairCount();
		
	}

}
class LoopStats{
	private int start, end;
	public LoopStats(int a, int b){
		start = a; end = b;
		System.out.println(start + " " + end);
	}
	public void setValue(int a, int b){
		start = a;
		end = b;
		System.out.println(start + " " + end);
	}
	public void findTotal(){
		int total = 0;
		for(int i = start; i <= end; i++){
			total += i;
		}
		System.out.println("Total is "+ total);
	}
	public void pairCount(){
		int evens = 0;
		int odds = 0;
		for (int i = start; i <= end; i++){
			if (i % 2 == 0){
				evens += 1;
			}
			else if(i % 2 == 1){
				odds += 1;
			}
		}
		System.out.println("Even count: " + evens);
		System.out.println("Odd count: " + odds+"\n");
		
	}
	
}