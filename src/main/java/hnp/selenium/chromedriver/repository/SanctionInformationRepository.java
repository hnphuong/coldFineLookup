package hnp.selenium.chromedriver.repository;

import hnp.selenium.chromedriver.model.SanctionInformation;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface SanctionInformationRepository extends MongoRepository<SanctionInformation, String> {
    Optional<SanctionInformation> findByUniqueKey(String uniqueKey);
}
