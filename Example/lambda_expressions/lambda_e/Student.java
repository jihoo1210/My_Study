package lambda_expressions.lambda_e;

public class Student {
    private String name;
    private int engScore;
    private int mathScore;

    public Student(String name, int engScore, int mathScore) {
        super();
        this.name = name;
        this.engScore = engScore;
        this.mathScore = mathScore;
    }

    public String getName() {return name;};
    public int getEngScore() {return engScore;};
    public int getMathScore() {return mathScore;};

}
