package lesson20.homework;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement(name = "Employees")
@XmlAccessorType(XmlAccessType.FIELD)

public class EmployeeWrapper {
    @XmlElement(name = "Employee")
    private List<Employee> employees;
}
