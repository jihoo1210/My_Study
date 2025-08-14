package section06;

public class MemberExamRun {
	public static void main(String args[]) {
		MemberExam member = new MemberExam("ȫ�浿", "hong");
		System.out.println(member.name + member.id + member.pass + member.age);
		
		System.out.println(member.login("hong", "12345"));
		member.logout("hong");
	}
}
