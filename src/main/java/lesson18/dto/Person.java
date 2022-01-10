package lesson18.dto;

import lombok.*;

import java.io.Serial;
import java.io.Serializable;
//@Data

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
//@RequiredArgsConstructor
@EqualsAndHashCode//(of = "name") (exclude = "height")
public class Person implements Serializable {
    @Serial
    private static final long serialVersionUID = 6019336254744142579L;
    private  String name;
    private int age;
    private Sex sex;
    private double height;

    public Person(String name) {
        this.name = name;
    }

    public void beOlder() throws Exception {
        this.age++;
    }
}


