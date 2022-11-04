package kodlama.io.rentACar.dataAccess.abstructs;

import kodlama.io.rentACar.entities.concertes.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BrandRepository extends JpaRepository<Brand,Integer> {

}
