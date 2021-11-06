package web.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
    @Id
    private long id;

    @Column
    private String firstname;

    @Column
    private String lastname;

    @Column
    private byte age;
}
