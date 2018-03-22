
public class BankAccountMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BankAccount grannySaving= new BankAccount(3200000.00);
		BankAccount momSaving= new BankAccount();
		
		System.out.println("Granny balance is  " + grannySaving.getBalance());
		System.out.println("mom balance now is  " + momSaving.getBalance());
		grannySaving.withdraw(2000);
		System.out.println("Granny balance now is  " + grannySaving.getBalance());
		momSaving.deposite(50000);
		System.out.println("mom balance now is  " + momSaving.getBalance());
		
	}

}
