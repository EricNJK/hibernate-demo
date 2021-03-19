package model;

import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@lombok.Getter
@lombok.Setter
@Entity
@Table(name = "staff")
public class Staff {
    @Id
    @GeneratedValue(generator = "staff_staff_id_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "staff_staff_id_seq", allocationSize = 1)
    @Column(name = "staff_id")
    private int staffId;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    private String email;
    private boolean active;
    @Column(name = "username")
    private String userName;
    private String password;

    private byte[] picture;

    @ManyToOne
    @JoinColumn(name = "store_id")
    private Store store; // 0 or 1
    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;

    public Staff(String firstName, String lastName, String email, boolean active, String userName, String password, byte[] picture, Store store, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.active = active;
        this.userName = userName;
        this.password = password;
        this.picture = picture;
        this.store = store;
        this.address = address;
    }
}
