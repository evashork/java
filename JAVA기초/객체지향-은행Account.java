/*
 *  �ɹ� ���� balane
 *  �ɹ��޼ҵ� 
 *  �Ա� : void deposit(int amount)
 *  ��� : void withdraw(int amount)
 *  �ܾ׸��� : int getBalnce(); return 3
 */
public class Account {
	
	int balance;
	
	void deposit(int amount){
		balance += amount;
	}
	
	void withdraw(int amount){
		balance -= amount;
	}
	
	int getBalnce(){
		return balance;
	}

}
