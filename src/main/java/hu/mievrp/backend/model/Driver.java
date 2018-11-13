package hu.mievrp.backend.model;
import javax.persistence.*;
import java.util.ArrayList;


@Entity
@Table(name = "driver")
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;

/*    @Column
    private ArrayList<Vehicle> invoices = new ArrayList<Vehicle>();*/

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
