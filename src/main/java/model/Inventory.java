package model;

import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@lombok.Getter
@lombok.Setter
@Entity
@Table(name = "inventory")
public class Inventory {
    @Id
    @Column(name = "inventory_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "inventory_inventory_id_seq")
    @SequenceGenerator(name = "inventory_inventory_id_seq", allocationSize = 1)
    private int inventoryId;

    @JoinColumn(name = "film_id")
    @ManyToOne
    private Film film;
    @ManyToOne
    @JoinColumn(name = "store_id")
    private Store store;

    public Inventory(Film film, Store store) {
        this.film = film;
        this.store = store;
    }
}
