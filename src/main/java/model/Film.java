package model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "film")
public class Film {
    @Column(name = "film_id")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "film_film_id_seq")
    @SequenceGenerator(name = "film_film_id_seq", allocationSize = 1)
    private int filmId;
    private String title;
    private String description;
    @Column(name = "release_year")
    private int releaseYear;
    @Column(name = "rental_duration")
    private int rentalDuration;
    @Column(name = "rental_rate")
    private float rentalRate;
    @Column(name = "replacement_cost")
    private float replacementCost;
    private int rating;
    @Column(name = "special_features")
    private String[] specialFeatures;// = new ArrayList<>();
    @Column(name = "fulltext")
    private String fullText;

    @ManyToOne
    @JoinColumn(name = "language_id")
    private Language language;
    /*
    @ManyToOne
    @Column(name = "category_id")
    private Category category; // zero or one, nullable? todo: link
     */
    //private Actor actors; // zero or one


    public Film(String title, String description, int releaseYear, int rentalDuration, float rentalRate, float replacementCost, int rating, String[] specialFeatures, String fullText, Language language) {
        this.title = title;
        this.description = description;
        this.releaseYear = releaseYear;
        this.rentalDuration = rentalDuration;
        this.rentalRate = rentalRate;
        this.replacementCost = replacementCost;
        this.rating = rating;
        this.specialFeatures = specialFeatures;
        this.fullText = fullText;
        this.language = language;
    }
}
