package lambda_expressions.lambda_c;

public class Example {
    public static double calc(Function fun) {
        double x = 10;
        double y = 4;
        return fun.apply(x, y);
    }

    public static void main(String[] args) {
        // 함수형 인터페이스 Function의 apply 오버라이딩
        double result = calc((x, y) -> (x / y));
        System.out.println("result: " + result);
    }
}
