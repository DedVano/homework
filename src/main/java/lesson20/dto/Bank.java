package lesson20.dto;

import com.opencsv.bean.CsvBindByName;
import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@Data
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder={"id", "bic", "name"})
public class Bank {

    @XmlAttribute(name = "id")
    @CsvBindByName(column = "Идентификатор Банка")
    private Long id;
    @CsvBindByName(column = "Наименование Банка")
    private String name;
    @XmlAttribute(name = "bic")
    @CsvBindByName(column = "БИК")
    private String bic;
}