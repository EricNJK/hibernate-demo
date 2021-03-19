package model;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor
@lombok.Getter
@lombok.Setter
@Entity
@Table(name = "payment")
public class Payment {
    @Id
    @Column(name = "payment_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "payment_payment_id_seq")
    @SequenceGenerator(name = "payment_payment_id_seq", allocationSize = 1)
    private int paymentId;
    private float amount;
    @Column(name = "payment_date")
    private Date paymentDate;

    @JoinColumn(name = "rental_id")
    @ManyToOne
    private Rental rental;
    @JoinColumn(name = "staff_id")
    @ManyToOne
    private Staff staff;
    @JoinColumn(name = "customer_id")
    @ManyToOne
    private Customer customer;

    public Payment(float amount, Date paymentDate, Rental rental, Staff staff, Customer customer) {
        this.amount = amount;
        this.paymentDate = paymentDate;
        this.rental = rental;
        this.staff = staff;
        this.customer = customer;
    }
}
