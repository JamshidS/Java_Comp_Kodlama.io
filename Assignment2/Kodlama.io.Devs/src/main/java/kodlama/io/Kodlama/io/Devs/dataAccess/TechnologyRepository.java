package kodlama.io.Kodlama.io.Devs.dataAccess;

import kodlama.io.Kodlama.io.Devs.entities.concretes.Technology;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TechnologyRepository extends JpaRepository<Technology,Integer> {
}
