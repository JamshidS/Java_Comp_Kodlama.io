package kodlama.io.Kodlama.io.Devs.business.responses;


import kodlama.io.Kodlama.io.Devs.entities.concretes.Language;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LanguagesResponse  {
    private int id;
    private String name;
}
