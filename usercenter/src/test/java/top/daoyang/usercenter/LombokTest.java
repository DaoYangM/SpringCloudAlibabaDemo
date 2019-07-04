package top.daoyang.usercenter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LombokTest {
    public static void main(String[] args) {
        Dog dog = Dog.builder()
                .name("dada")
                .age(32)
                .build();
        log.info("This dog is {}", dog);
    }
}

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
class Dog {

    private String name;

    private Integer age;
}
