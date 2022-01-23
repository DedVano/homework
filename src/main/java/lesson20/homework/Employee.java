package lesson20.homework;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
@JsonAutoDetect
public class Employee {
    private String id;
    private String login;
    private String name;
    private Department department;
    private Position position;
}
