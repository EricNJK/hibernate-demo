package model;

import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@lombok.Getter
@lombok.Setter
@lombok.ToString
@Entity
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address_address_id_seq")
    @SequenceGenerator(name = "address_address_id_seq", allocationSize = 1)
    @Column(name = "address_id")
    private int addressId;
    private String address;
    private String address2;
    private String district;
    @Column(name = "postal_code")
    private String postalCode;
    private String phone;
    @JoinColumn(name = "city_id")
    @ManyToOne
    private City city;

    public Address(String address, String address2, String district, String postalCode, String phone, City city) {
        this.address = address;
        this.address2 = address2;
        this.district = district;
        this.postalCode = postalCode;
        this.phone = phone;
        this.city = city;
    }
}
