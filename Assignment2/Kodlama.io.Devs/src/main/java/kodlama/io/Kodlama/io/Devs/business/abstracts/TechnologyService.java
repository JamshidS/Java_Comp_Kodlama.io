package kodlama.io.Kodlama.io.Devs.business.abstracts;

import kodlama.io.Kodlama.io.Devs.business.requestes.CreateTechnologyRequest;
import kodlama.io.Kodlama.io.Devs.business.responses.TechnologiesResponse;
import kodlama.io.Kodlama.io.Devs.entities.concretes.Language;

import java.util.List;

public interface TechnologyService {
    List<TechnologiesResponse> getAll();
    void add(CreateTechnologyRequest createTechnologyRequest) throws Exception;
    void delete(int id) throws Exception;
    void update(CreateTechnologyRequest createTechnologyRequest,int id) throws Exception;

    TechnologiesResponse getByID(int id);
}
