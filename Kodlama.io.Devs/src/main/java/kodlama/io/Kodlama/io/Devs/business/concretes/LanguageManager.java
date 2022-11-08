package kodlama.io.Kodlama.io.Devs.business.concretes;


import kodlama.io.Kodlama.io.Devs.business.abstracts.LanguageService;
import kodlama.io.Kodlama.io.Devs.business.requestes.CreateLanguageRequest;
import kodlama.io.Kodlama.io.Devs.business.responses.LanguagesResponse;
import kodlama.io.Kodlama.io.Devs.dataAccess.LanguageRepository;
import kodlama.io.Kodlama.io.Devs.entities.concretes.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LanguageManager implements LanguageService {

    private LanguageRepository languageRepository;

    @Autowired
    public LanguageManager(LanguageRepository languageRepository){
        this.languageRepository=languageRepository;
    }

    private boolean isThereName(String data){
        for(Language language1: languageRepository.findAll()){
            if(language1.getLanguageName().equals(data)){
                return true;
            }
        }
        return false;
    }

    @Override
    public List<LanguagesResponse> getAll() {
        List<Language> languages = languageRepository.findAll();
        List<LanguagesResponse> languagesResponses = new ArrayList<>();
        for(Language language: languages){
            LanguagesResponse responseItem =  new LanguagesResponse();
            responseItem.setId(language.getLanguageId());
            responseItem.setName(language.getLanguageName());
            languagesResponses.add(responseItem);
        }
        return languagesResponses;
    }

    @Override
    public void add(CreateLanguageRequest createLanguageRequest) throws Exception {
        Language language = new Language();
        language.setLanguageName(createLanguageRequest.getName());
        if( isThereName(createLanguageRequest.getName())){
            throw  new Exception("The programing language can't repeat!");
        }
        this.languageRepository.save(language);
    }

    @Override
    public void delete(int id) {
        languageRepository.deleteById(id);
    }

    @Override
    public void update(CreateLanguageRequest createLanguageRequest, int id) {
        for (Language language:languageRepository.findAll()){
            if(language.getLanguageId()==id){
                language.setLanguageName(createLanguageRequest.getName());
                languageRepository.save(language);
                break;
            }
        }
    }

    @Override
    public LanguagesResponse getById(int id) {
        Language  language1 =languageRepository.getReferenceById(id);
        LanguagesResponse languagesResponse= new LanguagesResponse();
        languagesResponse.setName(language1.getLanguageName());
        languagesResponse.setId(language1.getLanguageId());
        return languagesResponse;
    }

    @Override
    public Language getLanguageById(int id) {
        return languageRepository.findById(id).get();
    }
}
