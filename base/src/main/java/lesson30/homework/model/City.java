package lesson30.homework.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.Hibernate;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "CITY")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name_in_russian")
    private String nameInRussian;

    @Column(name = "name_in_english")
    private String nameInEnglish;

    @Column(name = "population_size")
    private long populationSize;

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy = "city", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PhoneCode> phoneCodes = new ArrayList<>();

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy = "city", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RegionCode> regionCodes = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        City city = (City) o;
        return Objects.equals(nameInRussian, city.nameInRussian);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    public String toString() {
        return "\nГород:\n\tid: " + this.getId()
                + "\n\tназвание на русском языке: " + this.getNameInRussian() + ";"
                + "\n\tназвание на английском языке: " + this.getNameInEnglish() + ";"
                + "\n\tчисленность населения: " + this.getPopulationSize() + ";"
                + "\n\tтелефонные коды: " + this.getPhoneCodes() + ";"
                + "\n\tномера регионов: " + this.getRegionCodes();
    }

    public City(String nameInRussian, String nameInEnglish, long populationSize) {
        this.nameInRussian = nameInRussian;
        this.nameInEnglish = nameInEnglish;
        this.populationSize = populationSize;
    }
}
