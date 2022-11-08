package kodlama.io.Kodlama.io.Devs.webApi.controllers;


import kodlama.io.Kodlama.io.Devs.business.abstracts.TechnologyService;
import kodlama.io.Kodlama.io.Devs.business.requestes.CreateTechnologyRequest;
import kodlama.io.Kodlama.io.Devs.business.responses.TechnologiesResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/technologies")
public class TechnologyController {
    private TechnologyService technologyService;

    @Autowired
    public TechnologyController(TechnologyService technologyService){
        this.technologyService=technologyService;
    }

    @GetMapping("/getall")
    public List<TechnologiesResponse> getAll(){
       return technologyService.getAll();
    }

    @PostMapping("/add")
    public void add(@RequestBody CreateTechnologyRequest createTechnologyRequest) throws Exception {
        technologyService.add(createTechnologyRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(name="id")int id) throws Exception {
        technologyService.delete(id);
    }
    @PutMapping("/{id}")
    public void update(@RequestBody CreateTechnologyRequest createTechnologyRequest,
                       @PathVariable(name="id")int id) throws Exception {

        technologyService.update(createTechnologyRequest,id);
    }

    @GetMapping("/{id}")
    public TechnologiesResponse getById(@PathVariable(name="id")int id){
        return technologyService.getByID(id);
    }


}
