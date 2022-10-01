package br.com.gabriel.decouplingdependencies.repository.mysql;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface MySqlClientRepository extends JpaRepository<MySqlClientEntity, Long> {

  Optional<MySqlClientEntity> findByUser(String user);

}
