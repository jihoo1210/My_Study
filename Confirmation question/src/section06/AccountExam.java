package section06;

public class AccountExam {
	String[] arr = new String[100] ;
	int[] money = new int[100];
	String[] account = new String[100];
	String[] name = new String[100];
	private static int i = 0;
	final static int MIN_BALANCE = 0;
	final static int MAX_BALANCE = 1000000;
	
	public void setInfo(String num, String name, int money) {
		if(MIN_BALANCE <= money &&  money <= MAX_BALANCE) {
			this.money[i] = money;
			this.account[i] = num;
			this.name[i] = name;
			arr[i] = "계좌번호: " + this.account[i] + "\t이름: " + this.name[i] + "\t\t입금액: " + this.money[i];
			i++;
		} else {System.out.println("초기입금액을 다시 입력해주세요.");}
	}
	
	public void getInfo() {
		for(int j = 0; j < i; j++)
		System.out.println(arr[j] + "\n");
	}
	
	public void plusMoney(String num, int money) {
		if(MIN_BALANCE < money && money < MAX_BALANCE) {
		for(int j = 0; j < i; j++) {
		if(num.equals(this.account[j])) {
			this.money[j] += money;
			arr[j] = "계좌번호: " + this.account[j] + "\t이름: " + name[j] + "\t\t입금액: " + this.money[j];
			System.out.println(num + " 계좌에 " + money + " \t원이 예금되었습니다.");
			break;
	} else System.out.println("계좌번호가 잘못되었습니다.");
			}
		} else {System.out.println("예금액이 잘못되었습니다.");}
	}
	
	public void minusMoney(String num, int money) {
		if(MIN_BALANCE < money && money < MAX_BALANCE) {
			for(int j = 0; j < i; j++) {
			if(num.equals(this.account[j])) {
				this.money[j] -= money;
				arr[j] = "계좌번호: " + this.account[j] + "\t이름: " + name[j] + "\t\t입금액: " + this.money[j];
				System.out.println(num + " 계좌에 " + money + " 원이 출금되었습니다.");
				break;
		} else System.out.println("계좌번호가 잘못되었습니다.");
				}
			} else {System.out.println("예금액이 잘못되었습니다.");}
	}
}
