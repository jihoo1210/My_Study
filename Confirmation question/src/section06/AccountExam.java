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
			arr[i] = "���¹�ȣ: " + this.account[i] + "\t�̸�: " + this.name[i] + "\t\t�Աݾ�: " + this.money[i];
			i++;
		} else {System.out.println("�ʱ��Աݾ��� �ٽ� �Է����ּ���.");}
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
			arr[j] = "���¹�ȣ: " + this.account[j] + "\t�̸�: " + name[j] + "\t\t�Աݾ�: " + this.money[j];
			System.out.println(num + " ���¿� " + money + " \t���� ���ݵǾ����ϴ�.");
			break;
	} else System.out.println("���¹�ȣ�� �߸��Ǿ����ϴ�.");
			}
		} else {System.out.println("���ݾ��� �߸��Ǿ����ϴ�.");}
	}
	
	public void minusMoney(String num, int money) {
		if(MIN_BALANCE < money && money < MAX_BALANCE) {
			for(int j = 0; j < i; j++) {
			if(num.equals(this.account[j])) {
				this.money[j] -= money;
				arr[j] = "���¹�ȣ: " + this.account[j] + "\t�̸�: " + name[j] + "\t\t�Աݾ�: " + this.money[j];
				System.out.println(num + " ���¿� " + money + " ���� ��ݵǾ����ϴ�.");
				break;
		} else System.out.println("���¹�ȣ�� �߸��Ǿ����ϴ�.");
				}
			} else {System.out.println("���ݾ��� �߸��Ǿ����ϴ�.");}
	}
}
