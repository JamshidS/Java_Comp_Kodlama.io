package kodlama.io.rentACar.webApi.controllers;

import kodlama.io.rentACar.business.abstructs.BrandService;
import kodlama.io.rentACar.business.requestes.CreateBrandRequest;
import kodlama.io.rentACar.business.responses.GetAllBrandsResponse;
import kodlama.io.rentACar.entities.concertes.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //Annotation
@RequestMapping("api/brands") //addressing
public class BrandsController {

    private BrandService brandService;
    @Autowired // surdaki constructor'un parametrelerine bak demek
    public  BrandsController(BrandService brandService){
        this.brandService=brandService;
    }
    @GetMapping("/getall")
    public List<GetAllBrandsResponse> getAll(){
        return brandService.getAll();
    }

    @PutMapping("/add")
    public void add(@RequestBody CreateBrandRequest createBrandRequest){
        this.brandService.add(createBrandRequest);

    }

}
