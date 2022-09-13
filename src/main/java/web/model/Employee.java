package web.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "emploee")
public class Employee {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    String name;
    @ManyToOne(fetch = FetchType.LAZY)
    Position position;

    @ManyToMany(fetch = FetchType.EAGER)
    Set<Project> projects;
}
