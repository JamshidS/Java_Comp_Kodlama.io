package kodlama.io.Kodlama.io.Devs.entities.concretes;


import lombok.*;

import javax.persistence.*;
import java.util.Optional;

@Data
@Table(name = "technologies")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Technology {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "technologyId")
    private int technologyId;
    @Column(name= "technologyName")
    private String technologyName;

    @ManyToOne
    private Language language;

}
