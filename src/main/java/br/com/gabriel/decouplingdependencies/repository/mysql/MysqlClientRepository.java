package br.com.gabriel.decouplingdependencies.repository.mysql;

import br.com.gabriel.decouplingdependencies.repository.adapters.MysqlClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface MysqlClientRepository extends JpaRepository<MysqlClientEntity, Long> {

  Optional<MysqlClientEntity> findByUser(String user);

}
