package web.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "project")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    String name;

    @ManyToOne(fetch = FetchType.LAZY)
    Customer customer;
}
