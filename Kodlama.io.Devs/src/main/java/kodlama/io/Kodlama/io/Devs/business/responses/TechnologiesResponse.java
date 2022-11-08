package kodlama.io.Kodlama.io.Devs.business.responses;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TechnologiesResponse {
    private int id;
    private String name;
    private int languageID;
    private String languageName;
}
