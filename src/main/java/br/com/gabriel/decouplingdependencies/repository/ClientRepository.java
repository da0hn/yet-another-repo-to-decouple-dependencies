package br.com.gabriel.decouplingdependencies.repository;

import br.com.gabriel.decouplingdependencies.domain.entities.Client;
import br.com.gabriel.decouplingdependencies.repository.commons.Identity;

public interface ClientRepository {

  Identity<?> create(Client client);

  Client findByUser(String user);

}
