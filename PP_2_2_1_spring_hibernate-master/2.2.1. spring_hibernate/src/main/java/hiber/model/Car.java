package hiber.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name ="cars")
public class Car {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "car_id")
    private Long id;
    @Column(name = "model")
    private String model;

    @Column(name = "series")
    private int series;

    @OneToOne(mappedBy = "car")
    private User user;

    public Car (String model, int series) {
        this.model=model;
        this.series=series;
    }


    public Car() {

    }

    public int getSeries() {
        return series;
    }

    public String getModel() {
        return model;
    }

    public long getID () {return  id;}

    public User getUser(){
        return user;
    }

    public void setModel(String model) {
        this.model = model;
    }


    public void setUser (User user) {
        this.user = user;
    }

    public void setSeries (int series) {
        this.series = series;
    }


}
