package model;

import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@lombok.Getter
@lombok.Setter
@lombok.Data
@Entity
@Table(name="category")
public class Category {
    @Id
    @Column(name = "category_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "category_category_id_seq")
    @SequenceGenerator(name = "category_category_id_seq", allocationSize = 1)
    private int categoryId;
    private String name;

    //private List<Film> films;


    public Category(String name) {
        this.name = name;
    }
}
