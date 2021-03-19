package model;

import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@lombok.Getter
@lombok.Setter
@Entity
@Table(name = "language")
public class Language {
    @Id
    @Column(name = "language_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "language_language_id_seq")
    @SequenceGenerator(name = "language_language_id_seq", allocationSize = 1)
    private int languageId;
    private String name;

    public Language(String name) {
        this.name = name;
    }
}
