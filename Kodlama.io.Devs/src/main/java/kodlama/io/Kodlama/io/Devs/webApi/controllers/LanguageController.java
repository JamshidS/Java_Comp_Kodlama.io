package kodlama.io.Kodlama.io.Devs.webApi.controllers;


import kodlama.io.Kodlama.io.Devs.business.abstracts.LanguageService;
import kodlama.io.Kodlama.io.Devs.business.requestes.CreateLanguageRequest;
import kodlama.io.Kodlama.io.Devs.business.responses.LanguagesResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/languages")
public class LanguageController {
    private LanguageService languageService;

    @Autowired
    public LanguageController(LanguageService languageService){
        this.languageService=languageService;
    }

    @GetMapping
    public List<LanguagesResponse> getAll(){
        return languageService.getAll();
    }

    @PostMapping
    public void add(@RequestBody CreateLanguageRequest createLanguageRequest) throws Exception {
        languageService.add(createLanguageRequest);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable(name="id")int id){
        languageService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@RequestBody CreateLanguageRequest createLanguageRequest,@PathVariable(name="id")int id){
        languageService.update(createLanguageRequest,id);
    }
    @GetMapping("/{id}")
    public LanguagesResponse getById(@PathVariable(name="id")int id){
        return languageService.getById(id);
    }


}
