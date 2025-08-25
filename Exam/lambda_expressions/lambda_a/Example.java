package lambda_expressions.lambda_a;

public class Example {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            System.out.println("작업 스레드가 실행됩니다.");
            System.out.println("작업 스레드가 실행됩니다.");
            System.out.println("작업 스레드가 실행됩니다.");
        });
        thread.start();
    }
}
