package section06;

import java.util.Scanner;

public class AccountExamRun {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AccountExam account = new AccountExam();
		Scanner scanner = new Scanner(System.in);
		boolean run = true;
		while(run) {
		System.out.println("------------------------------------");
		System.out.println("1.���� ���� | 2.���� ��� | 3.���� | 4.��� | 5.����");
		System.out.println("+----------------------------------+");
		System.out.print("���� :>>");
		String user = scanner.nextLine();
		System.out.println("");
		System.out.println("+----------------------------------+");
		
		switch(user) {
		case "1" : {
			System.out.print("���¹�ȣ :>>");
			String num = scanner.nextLine();
			System.out.println("");
			System.out.print("������ :>>");
			String name = scanner.nextLine();
			System.out.println("");
			System.out.print("�ʱ��Աݾ� :>>");
			int money = scanner.nextInt();
			System.out.println("");
			account.setInfo(num, name, money);
			System.out.println("���°� ���������� �����Ǿ����ϴ�.\n");
			scanner.nextLine();
			break;
		}
		case "2" : {
			System.out.println("���� ���\n");
			account.getInfo();
			break;
		}
		case "3" : 
		{
			System.out.println("+--------+");
			System.out.println("����");
			System.out.println("+--------+");
			System.out.print("���¹�ȣ :>>");
			String num = scanner.nextLine();
			System.out.println("");
			System.out.print("���ݾ� :>>");
			int money = scanner.nextInt();
			System.out.println("");
			account.plusMoney(num, money);
			scanner.nextLine();
			break;
		}
		case "4": {
			System.out.println("+--------+");
			System.out.println("���");
			System.out.println("+--------+");
			System.out.print("���¹�ȣ :>>");
			String num = scanner.nextLine();
			System.out.println("");
			System.out.print("��ݾ� :>>");
			int money = scanner.nextInt();
			System.out.println("");
			account.minusMoney(num, money);
			scanner.nextLine();
			break;
		}
		case "5" : 
			System.out.println("�ý����� �����մϴ�.");
			run = false;
			break;
		default : System.out.println("�� �� �� �����");
		}
	}
		
		
	}
}
