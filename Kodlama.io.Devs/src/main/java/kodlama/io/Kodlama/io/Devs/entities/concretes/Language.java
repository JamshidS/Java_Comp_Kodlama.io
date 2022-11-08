package kodlama.io.Kodlama.io.Devs.entities.concretes;


import lombok.*;
import javax.persistence.*;
import java.util.List;

@Data
@Table(name = "languages")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Language {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "languageId")
    private int languageId;
    @Column(name="languageName")
    private String languageName;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Technology> technologies;



}
