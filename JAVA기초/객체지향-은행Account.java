/*
 *  맴버 변수 balane
 *  맴버메소드 
 *  입금 : void deposit(int amount)
 *  출급 : void withdraw(int amount)
 *  잔액리턴 : int getBalnce(); return 3
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
