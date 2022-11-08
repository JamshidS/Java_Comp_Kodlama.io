package kodlama.io.Kodlama.io.Devs.business.abstracts;

import kodlama.io.Kodlama.io.Devs.business.requestes.CreateLanguageRequest;
import kodlama.io.Kodlama.io.Devs.business.responses.LanguagesResponse;
import kodlama.io.Kodlama.io.Devs.entities.concretes.Language;

import java.util.List;

public interface LanguageService {
     List<LanguagesResponse> getAll();
     void add(CreateLanguageRequest createLanguageRequest) throws Exception;
     void delete(int id);
     void update(CreateLanguageRequest createLanguageRequest,int id);
     LanguagesResponse getById(int id);

     Language getLanguageById(int id);
}
