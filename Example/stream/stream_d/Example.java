package stream.stream_d;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Example {
    public static void main(String[] args) {
        List<Member> list = Arrays.asList(
            new Member("홍길동", "개발자"),
            new Member("김나리", "디자이너"),
            new Member("박지후", "개발자")
        );

        Map<String, List<Member>> groupingMap = list.stream()
        .collect(Collectors.groupingBy(Member :: getJob));

        
        
    }
}
