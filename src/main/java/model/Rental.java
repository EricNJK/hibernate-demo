package model;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor
@lombok.Getter
@lombok.Setter
@Entity
@Table(name = "rental")
public class Rental {
    @Id
    @Column(name = "rental_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rental_rental_id_seq")
    @SequenceGenerator(name = "rental_rental_id_seq", allocationSize = 1)
    private int rentalId;
    @Column(name = "rental_date")
    private Date rentalDate;
    @Column(name = "return_date")
    private Date returnDate;

    @ManyToOne
    @JoinColumn(name = "staff_id")
    private Staff staff;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
    @ManyToOne
    @JoinColumn(name = "inventory_id")
    private Inventory inventory;

    public Rental(Date rentalDate, Date returnDate, Staff staff, Customer customer, Inventory inventory) {
        this.rentalDate = rentalDate;
        this.returnDate = returnDate;
        this.staff = staff;
        this.customer = customer;
        this.inventory = inventory;
    }
}
