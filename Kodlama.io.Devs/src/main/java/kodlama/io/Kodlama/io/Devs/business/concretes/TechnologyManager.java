package kodlama.io.Kodlama.io.Devs.business.concretes;

import kodlama.io.Kodlama.io.Devs.business.abstracts.LanguageService;
import kodlama.io.Kodlama.io.Devs.business.abstracts.TechnologyService;
import kodlama.io.Kodlama.io.Devs.business.requestes.CreateTechnologyRequest;
import kodlama.io.Kodlama.io.Devs.business.responses.LanguagesResponse;
import kodlama.io.Kodlama.io.Devs.business.responses.TechnologiesResponse;
import kodlama.io.Kodlama.io.Devs.dataAccess.TechnologyRepository;
import kodlama.io.Kodlama.io.Devs.entities.concretes.Language;
import kodlama.io.Kodlama.io.Devs.entities.concretes.Technology;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.util.Optional.*;

@Service
public class TechnologyManager implements TechnologyService {

    private TechnologyRepository technologyRepository;
    private LanguageService languageService;

    @Autowired
    public TechnologyManager(TechnologyRepository technologyRepository, LanguageService languageService) {
        this.technologyRepository = technologyRepository;
        this.languageService = languageService;
    }

    private boolean isThereName(String data) {
        for (Technology technology : technologyRepository.findAll()) {
            if (technology.getTechnologyName().equals(data)) {
                return true;
            }
        }
        return false;
    }

    private boolean isThereID(int id) {
        List<Technology> technologies = technologyRepository.findAll();
        for (Technology technology : technologies) {
            if (technology.getTechnologyId() == id) {
                return true;
            }
        }
        return false;
    }

    @Override
    public List<TechnologiesResponse> getAll() {
        List<Technology> technologies = technologyRepository.findAll();
        List<TechnologiesResponse> technologiesResponses = new ArrayList<>();
        for (Technology technology : technologies) {
            TechnologiesResponse responseItem = new TechnologiesResponse();
            responseItem.setName(technology.getTechnologyName());
            responseItem.setId(technology.getTechnologyId());
            responseItem.setLanguageID(technology.getLanguage().getLanguageId());
            responseItem.setLanguageName(technology.getLanguage().getLanguageName());
            technologiesResponses.add(responseItem);
        }
        return technologiesResponses;
    }

    @Override
    public void add(CreateTechnologyRequest createTechnologyRequest) throws Exception {
        Technology technology = new Technology();
        LanguagesResponse language = languageService.getById(createTechnologyRequest.getLanguageID());
        if (isThereName(createTechnologyRequest.getName())) {
            throw new Exception("Technology is already exists");
        }
        technology.setTechnologyName(createTechnologyRequest.getName());
        technology.setLanguage(languageService.getLanguageById(createTechnologyRequest.getLanguageID()));
        this.technologyRepository.save(technology);

    }

    @Override
    public void delete(int id) throws Exception {
        if (!isThereID(id)) {
            throw new Exception("ID can not found");
        }
        technologyRepository.deleteById(id);
    }

    @Override
    public void update(CreateTechnologyRequest createTechnologyRequest, int id) throws Exception {
        if(!isThereID(id)){
            throw new Exception("Can not find the ID");
        }
          LanguagesResponse language1 = languageService.getById(createTechnologyRequest.getLanguageID());
            Language language = new Language();
            language.setLanguageId(language1.getId());
            language.setLanguageName(language1.getName());
        for (Technology technology : technologyRepository.findAll()) {
            if (technology.getTechnologyId() == id) {
                technology.setTechnologyName(createTechnologyRequest.getName());
                    technology.setLanguage(languageService.getLanguageById(createTechnologyRequest.getLanguageID()));

                technologyRepository.save(technology);
                break;
            }
        }

    }
    @Override
    public TechnologiesResponse getByID(int id) {
        Technology technology = technologyRepository.findById(id).get();
        TechnologiesResponse response = new TechnologiesResponse();
        response.setName(technology.getTechnologyName());
        response.setId(technology.getTechnologyId());
        response.setLanguageName(technology.getLanguage().getLanguageName());
        response.setLanguageID(technology.getLanguage().getLanguageId());
        return response;
    }

}
