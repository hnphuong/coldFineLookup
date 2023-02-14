package hnp.selenium.chromedriver.repository;

import hnp.selenium.chromedriver.model.SanctionInformation;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SanctionInformationRepository extends MongoRepository<SanctionInformation, String> {

}
