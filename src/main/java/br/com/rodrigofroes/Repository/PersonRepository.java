package br.com.rodrigofroes.Repository;

import br.com.rodrigofroes.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository  extends JpaRepository<Person, Long> {}
