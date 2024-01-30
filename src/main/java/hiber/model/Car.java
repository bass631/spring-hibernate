package hiber.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "cars")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "model")
    private String model;
    @Column(name = "series")
    private int series;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "userCar")
    private User user;

    public Car(String model, int series) {
        this.model = model;
        this.series = series;
    }
}
