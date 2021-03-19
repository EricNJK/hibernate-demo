package model;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor
@lombok.Getter
@lombok.Setter
@Entity
@Table(name = "customer")
public class Customer {
    @Column(name = "customer_id")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_customer_id_seq")
    @SequenceGenerator(name = "customer_customer_id_seq", allocationSize = 1)
    private int customerId;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    private String email;
    private boolean active;
    @Column(name = "create_date")
    private Date createDate;

    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;
    @ManyToOne
    @JoinColumn(name = "store_id")
    private Store store;

    //public List<Payment> paymentList;
    //public Rental rental; // 0 or 1


    public Customer(String firstName, String lastName, String email, boolean active, Date createDate, Address address, Store store) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.active = active;
        this.createDate = createDate;
        this.address = address;
        this.store = store;
    }
}
