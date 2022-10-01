package br.com.gabriel.decouplingdependencies.repository.mongodb;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MongoClientRepository extends MongoRepository<MongoClientEntity, String> {

  Optional<MongoClientEntity> findByUser(String user);

}
