package hello;

import javax.persistence.*;

/**
 * Created by admin on 2/12/17.
 */

@Entity
@Table(name="Customer")
public class Customer {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="id")
    private long id;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    protected Customer(){}

    public Customer(String firstName, String lastName){
        this.firstName=firstName;
        this.lastName=lastName;
    }

    @Override
    public String toString(){
        return String.format("[id=%d, Fitst Name='%s', Last Name='%s']",
                id, firstName, lastName);
    }

}
