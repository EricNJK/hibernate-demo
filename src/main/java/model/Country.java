package model;

import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@lombok.Getter
@lombok.Setter
@lombok.ToString
@Entity
@Table(name = "country")
public class Country {
    @Id
    @Column(name = "country_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "country_country_id_seq")
    @SequenceGenerator(name = "country_country_id_seq", allocationSize = 1)
    private int countryId;
    private String country;

    public Country(String country) {
        this.country = country;
    }
}
