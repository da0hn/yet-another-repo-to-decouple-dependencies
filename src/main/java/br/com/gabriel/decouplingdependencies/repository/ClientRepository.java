package br.com.gabriel.decouplingdependencies.repository;

import br.com.gabriel.decouplingdependencies.domain.entities.Client;

public interface ClientRepository {

  void create(Client client);

  Client findByUser(String user);

}
