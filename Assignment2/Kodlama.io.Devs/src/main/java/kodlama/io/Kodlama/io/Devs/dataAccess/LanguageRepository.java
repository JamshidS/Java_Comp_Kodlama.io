package kodlama.io.Kodlama.io.Devs.dataAccess;

import kodlama.io.Kodlama.io.Devs.entities.concretes.Language;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LanguageRepository extends JpaRepository<Language,Integer> {
}
