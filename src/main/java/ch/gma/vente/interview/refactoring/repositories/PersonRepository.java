package ch.gma.vente.interview.refactoring.repositories;

import ch.gma.vente.interview.refactoring.entities.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, String> {

}
