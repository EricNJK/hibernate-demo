package model;

import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@lombok.Getter
@lombok.Setter
@Entity
@Table(name = "actor")
public class Actor {
    @Id @Column(name = "actor_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "actor_actor_id_seq")
    @SequenceGenerator(name = "actor_actor_id_seq", allocationSize = 1) // same name db... sequences
    private int actorId;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;

    //private List<Film> films;


    public Actor(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
