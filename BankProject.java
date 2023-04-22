package training;

import java.util.Scanner;

public class BankProject {

	public static void main(String[] args) {
	BankAccount b1 = new BankAccount(112233, "Wisher");
	b1.show();

	}

}
class BankAccount
{
	double balance;
	double previousTransaction;
	int customerId;
	String customerName;
	BankAccount(int id, String name)
	{
		customerId = id;
		customerName = name;
	}
	void deposit(double amount)
	{
		if(amount !=0)
		{
			balance += amount;
			previousTransaction = amount;
		}
	}
	void withdraw(double amount)
	{
		if(balance >= amount)
		{
			balance -= amount;
			previousTransaction = -amount;
		}
		else
			System.out.println("Insufficient balance!");
		
	}
	void previous()
	{
		if(previousTransaction > 0)
		{
			System.out.println("-----------------------------------------------");
			System.out.println("Deposited: "+ previousTransaction);
			System.out.println("-----------------------------------------------");
		}
		else if(previousTransaction < 0)
		{
			System.out.println("-----------------------------------------------");
			System.out.println("Withdrawn: "+Math.abs(previousTransaction));
			System.out.println("-----------------------------------------------");
		}
		else
			System.out.println("No transaction occured!");
	}
	void checkBalance()
	{
		System.out.println("-----------------------------------------------");
		System.out.println("Balance = "+balance);
		System.out.println("-----------------------------------------------");
	}
	
	void show()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome Dear "+customerName);
		System.out.println("Your ID: "+customerId);
		System.out.println("\n\n");
		int ch;
		System.out.println("1. Check Balance\n2. Deposit\n3. Withdraw\n4. Previous transaction\n5. Exit");
		
		
		do {
			System.out.println("\n\n");
			System.out.println("*******************************************************************");
			System.out.println("Enter an option");
			System.out.println("*******************************************************************");
			ch = sc.nextInt();
			switch(ch)
			{
			case 1:
				checkBalance();
				break;
			case 2:
				System.out.println("-----------------------------------------------");
				System.out.println("Enter an amount to deposit:");
				System.out.println("-----------------------------------------------");
				double depo = sc.nextDouble();
				deposit(depo);
				break;
			case 3:
				System.out.println("----------------------------------------------");
				System.out.println("Enter an amount to withdraw:");
				System.out.println("----------------------------------------------");
				double with = sc.nextDouble();
				withdraw(with);
				break;
			case 4:
				previous();
				break;
			case 5:
				System.out.println("----------------------------------------------");
				System.out.println("Thank you for using our services!!!");
				System.out.println("----------------------------------------------");
				System.exit(0);
			default:
				System.out.println("----------------------------------------------");
				System.out.println("Entered invalid option... Please try again:");
				System.out.println("----------------------------------------------");
			}	
			
		}while(ch!=5);
	}
}
