package unit2;

public class SavingsAccount {
	private double balance;
    private double interest;


    public SavingsAccount(double initialBalance, double savingsRate)
    {
        balance = initialBalance;
        interest = savingsRate;
        interest = interest/100D;
    }


    public void addInterest()
    {
        balance *= 1+interest;
    }

    public void print(){
    	System.out.println("Your balance is " + String.format("%.2f", balance));
    }
   

	public static void main(String[] args) {
		SavingsAccountTester xd = new SavingsAccountTester();
		
	}

}

class SavingsAccountTester{
	public SavingsAccountTester(){
		SavingsAccount test = new SavingsAccount(1000, 10);
		test.addInterest();
		test.print();
	}
}
    