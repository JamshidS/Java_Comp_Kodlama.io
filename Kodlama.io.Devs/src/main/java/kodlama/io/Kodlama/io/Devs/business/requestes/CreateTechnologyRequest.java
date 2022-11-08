package kodlama.io.Kodlama.io.Devs.business.requestes;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateTechnologyRequest {
    private int languageID;
    private String name;
}
