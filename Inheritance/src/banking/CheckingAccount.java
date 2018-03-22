package banking;

public class CheckingAccount extends BankAccount{
	private static final int FREE_TRANSACTIONS=3;
	private static final double TRANSACTION_FEE =1.50;
	private int transcatinCount;
	
	public CheckingAccount(){
		super();
		this.transcatinCount=0;
		
	}
	
	public CheckingAccount(double initialBalance){
		super(initialBalance);
		this.transcatinCount=0;
	}
	@Override 
	public void deposit(double amount){
		this.transcatinCount++;
		super.deposit(amount);
	}
	
	@Override 
	public void withdraw(double amount){
		this.transcatinCount++;
		super.withdraw(amount);
	}
	
	public void deductFees(){
		if(this.transcatinCount> FREE_TRANSACTIONS){
			double fees=TRANSACTION_FEE* (this.transcatinCount-FREE_TRANSACTIONS);
			super.withdraw(fees);
			this.transcatinCount=0;
		}
		
	}

}
