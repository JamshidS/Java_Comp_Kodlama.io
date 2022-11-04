package kodlama.io.rentACar.entities.concertes;

import lombok.*;

import javax.persistence.*;

@Table(name="brands")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Brand {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="name")
    private String name;

}

