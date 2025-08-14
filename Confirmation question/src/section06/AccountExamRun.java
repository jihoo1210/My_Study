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
		System.out.println("1.계좌 생성 | 2.계좌 목록 | 3.예금 | 4.출금 | 5.종료");
		System.out.println("+----------------------------------+");
		System.out.print("선택 :>>");
		String user = scanner.nextLine();
		System.out.println("");
		System.out.println("+----------------------------------+");
		
		switch(user) {
		case "1" : {
			System.out.print("계좌번호 :>>");
			String num = scanner.nextLine();
			System.out.println("");
			System.out.print("계좌주 :>>");
			String name = scanner.nextLine();
			System.out.println("");
			System.out.print("초기입금액 :>>");
			int money = scanner.nextInt();
			System.out.println("");
			account.setInfo(num, name, money);
			System.out.println("계좌가 성공적으로 개설되었습니다.\n");
			scanner.nextLine();
			break;
		}
		case "2" : {
			System.out.println("계좌 목록\n");
			account.getInfo();
			break;
		}
		case "3" : 
		{
			System.out.println("+--------+");
			System.out.println("예금");
			System.out.println("+--------+");
			System.out.print("계좌번호 :>>");
			String num = scanner.nextLine();
			System.out.println("");
			System.out.print("예금액 :>>");
			int money = scanner.nextInt();
			System.out.println("");
			account.plusMoney(num, money);
			scanner.nextLine();
			break;
		}
		case "4": {
			System.out.println("+--------+");
			System.out.println("출금");
			System.out.println("+--------+");
			System.out.print("계좌번호 :>>");
			String num = scanner.nextLine();
			System.out.println("");
			System.out.print("출금액 :>>");
			int money = scanner.nextInt();
			System.out.println("");
			account.minusMoney(num, money);
			scanner.nextLine();
			break;
		}
		case "5" : 
			System.out.println("시스템을 종료합니다.");
			run = false;
			break;
		default : System.out.println("한 번 더 실행됨");
		}
	}
		
		
	}
}
