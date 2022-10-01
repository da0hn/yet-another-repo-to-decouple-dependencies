package br.com.gabriel.decouplingdependencies.repository.adapters;

import br.com.gabriel.decouplingdependencies.commons.annotations.Adapter;
import br.com.gabriel.decouplingdependencies.domain.entities.Client;
import br.com.gabriel.decouplingdependencies.repository.ClientRepository;
import br.com.gabriel.decouplingdependencies.repository.RepositoryProvider;
import br.com.gabriel.decouplingdependencies.repository.mysql.MySqlClientEntity;
import br.com.gabriel.decouplingdependencies.repository.mysql.MySqlClientRepository;

@Adapter
@RepositoryProvider("mysql")
public class MySqlClientRepositoryAdapter implements ClientRepository {

  private final MySqlClientRepository repository;

  public MySqlClientRepositoryAdapter(final MySqlClientRepository repository) {
    this.repository = repository;
  }


  @Override
  public void create(final Client client) {
    final MySqlClientEntity entity = MySqlClientEntity.toEntity(client);
    this.repository.save(entity);
  }

  @Override
  public Client findByUser(final String user) {
    return this.repository.findByUser(user)
      .map(MySqlClientEntity::toDomain)
      .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
  }

}
