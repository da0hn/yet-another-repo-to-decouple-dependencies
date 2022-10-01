package br.com.gabriel.decouplingdependencies.repository.adapters;

import br.com.gabriel.decouplingdependencies.domain.entities.Client;
import br.com.gabriel.decouplingdependencies.commons.annotations.Adapter;
import br.com.gabriel.decouplingdependencies.repository.ClientRepository;

@Adapter
public class MongoClientRepositoryAdapter implements ClientRepository {

  @Override
  public void create(final Client client) {

  }

  @Override
  public Client findByUser(final String user) {
    return null;
  }

}
