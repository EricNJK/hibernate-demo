package model;

import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@NoArgsConstructor
@lombok.Getter
@lombok.Setter
@ToString
@Entity
@Table(name = "city")
public class City {
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "city_city_id_seq")
    @SequenceGenerator(name = "city_city_id_seq", allocationSize = 1)
    @Id
    @Column(name = "city_id")
    private int cityId;
    private String city;
    @JoinColumn(name = "country_id")
    @ManyToOne
    private Country country;

    public City(String city, Country country) {
        this.city = city;
        this.country = country;
    }
}
