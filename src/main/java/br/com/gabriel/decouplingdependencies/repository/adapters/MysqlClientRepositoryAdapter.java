package br.com.gabriel.decouplingdependencies.repository.adapters;

import br.com.gabriel.decouplingdependencies.domain.entities.Client;
import br.com.gabriel.decouplingdependencies.repository.ClientRepository;
import br.com.gabriel.decouplingdependencies.repository.mysql.MysqlClientRepository;
import org.springframework.stereotype.Component;

@Component
public class MysqlClientRepositoryAdapter implements ClientRepository {

  private final MysqlClientRepository repository;

  public MysqlClientRepositoryAdapter(final MysqlClientRepository repository) {
    this.repository = repository;
  }


  @Override
  public void create(final Client client) {
    final MysqlClientEntity entity = MysqlClientEntity.toEntity(client);
    this.repository.save(entity);
  }

  @Override
  public Client findByUser(final String user) {
    return this.repository.findByUser(user)
      .map(MysqlClientEntity::toDomain)
      .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
  }

}
