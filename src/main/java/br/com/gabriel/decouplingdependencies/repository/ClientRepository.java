package br.com.gabriel.decouplingdependencies.repository;

import br.com.gabriel.decouplingdependencies.domain.orm.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

  Optional<Client> findByUser(String user);

}
