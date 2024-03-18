package springworkspace;

import com.google.j2objc.annotations.ReflectionSupport;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
// @NoArgsConstructor   // 빈생성자가 생성됨
@AllArgsConstructor
@RequiredArgsConstructor   // final 을 대상으로 생성자를 만들어줌   
@Builder

class Person {
    private final String name;
    private int age;
}

public class App {
    public String getGreeting() {
        return "Hello World!";
    }

    public static void main(String[] args) {
        System.out.println(new App().getGreeting());

        Person person = new Person("홍길동", 30);
        person = new Person("혹낄똥");

        person = Person.builder().name("홍길동").age(20).build();
    
    }
}
