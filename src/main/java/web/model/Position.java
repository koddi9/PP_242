package web.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "position")
public class Position {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    String name;
    @OneToMany(mappedBy = "position",cascade = CascadeType.ALL, orphanRemoval = true)
    Set<Employee> employees;
}
