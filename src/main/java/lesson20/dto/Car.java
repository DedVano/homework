package lesson20.dto;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.math.BigDecimal;

@Data
@XmlRootElement(name = "auto")
@XmlType(propOrder = {"model", "price", "mark", "owner"})
@XmlAccessorType(XmlAccessType.FIELD)

public class Car {

    @XmlAttribute(name = "m")
    private String mark;

    @XmlAttribute(name = "ml")
    private String model;

    @XmlAttribute
    private BigDecimal price;

//    @XmlTransient  исключить из отправки в xml
    @XmlElement(name = "driver")
    private /*transient*/ Owner owner;

//    @XmlElement(name = "m")
//    public String getMark() {
//        return mark;
//    }
}
