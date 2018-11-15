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

<<<<<<< HEAD
    @Column
    private ArrayList<Vehicle> invoices = new ArrayList<Vehicle>();
=======
    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(
            inverseJoinColumns =
                    @JoinColumn(name = "vehicle_id"),
            joinColumns =
                    @JoinColumn(name = "driver_id")
    )
    private ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
>>>>>>> 4cb1144ecd12486094d3f97280f740a158da7483

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

    public ArrayList<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(ArrayList<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }
}