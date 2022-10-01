package br.com.gabriel.decouplingdependencies.repository.adapters;

import br.com.gabriel.decouplingdependencies.commons.annotations.Adapter;
import br.com.gabriel.decouplingdependencies.domain.entities.Client;
import br.com.gabriel.decouplingdependencies.repository.ClientRepository;
import br.com.gabriel.decouplingdependencies.repository.RepositoryProvider;
import br.com.gabriel.decouplingdependencies.repository.commons.Identity;
import br.com.gabriel.decouplingdependencies.repository.commons.MongoIdentity;
import br.com.gabriel.decouplingdependencies.repository.mongodb.MongoClientEntity;
import br.com.gabriel.decouplingdependencies.repository.mongodb.MongoClientRepository;

@Adapter
@RepositoryProvider("mongo")
public class MongoClientRepositoryAdapter implements ClientRepository {

  private final MongoClientRepository repository;

  public MongoClientRepositoryAdapter(final MongoClientRepository repository) {this.repository = repository;}


  @Override
  public Identity<?> create(final Client client) {
    final var entity = MongoClientEntity.toEntity(client);
    this.repository.save(entity);
    return MongoIdentity.of(entity.getId());
  }

  @Override
  public Client findByUser(final String user) {
    return this.repository.findByUser(user)
      .map(MongoClientEntity::toDomain)
      .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
  }

}
