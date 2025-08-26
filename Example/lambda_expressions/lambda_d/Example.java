package lambda_expressions.lambda_d;

public class Example {
    private static int[] scores = {10, 50, 3};

    public static int maxOrMin(Operator operator) {
        int result = scores[0];
        for(int score : scores) {
            // Operator.apply()의 람다식 실행
            // 람다식을 통해 return된 result를 this.result에 대입
            result = operator.apply(result, score);
        }
        return result;
    }

    public static void main(String[] args) {
        int max = maxOrMin((result, score) -> {if(result < score){
                result = score;
            } return result; 
        });
        System.out.println("최대값: " + max);
        int min = maxOrMin((result, score) -> {if(result > score) {
            result = score;
            } return result;
        });
        System.out.println("최소값: " + min);
    }
}
