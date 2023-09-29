package hiber.model;

import org.hibernate.annotations.ForeignKey;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name ="cars")
public class Car {

    //@OneToOne(cascade = CascadeType.ALL, mappedBy = "car")
    @OneToOne
    private User user;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "car_id")
    private Long id;
    @Column(name = "model")
    private String model;

    @Column(name = "series")
    private int series;

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
