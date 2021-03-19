package model;

import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@lombok.Getter
@lombok.Setter
@Entity
@Table(name = "store")
public class Store {
    @Id
    @Column(name = "store_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "store_store_id_seq")
    @SequenceGenerator(name = "store_store_id_seq", allocationSize = 1)
    private int storeId;

    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;
    @ManyToOne // OneToOne ?
    @JoinColumn(name = "manager_id")
    private Staff manager;

    public Store(Address address, Staff manager) {
        this.address = address;
        this.manager = manager;
    }
}
