package br.com.gabriel.decouplingdependencies.services;

import br.com.gabriel.decouplingdependencies.domain.dtos.CepResponse;
import br.com.gabriel.decouplingdependencies.domain.dtos.ClientCreateRequest;
import br.com.gabriel.decouplingdependencies.domain.dtos.ClientCreatedResponse;
import br.com.gabriel.decouplingdependencies.domain.entities.Client;
import br.com.gabriel.decouplingdependencies.external.CepProvider;
import br.com.gabriel.decouplingdependencies.external.FetchCep;
import br.com.gabriel.decouplingdependencies.repository.ClientRepository;
import br.com.gabriel.decouplingdependencies.repository.RepositoryProvider;
import org.springframework.stereotype.Service;


@Service
public class ClientService {

  private final FetchCep fetchCep;

  private final ClientRepository clientRepository;

  public ClientService(
    @CepProvider("postmon") final FetchCep fetchCep,
    @RepositoryProvider("mongo") final ClientRepository clientRepository
  ) {
    this.fetchCep = fetchCep;
    this.clientRepository = clientRepository;
  }

  public ClientCreatedResponse create(final ClientCreateRequest request) {
    final var client = new Client();
    client.setName(request.name());
    client.setGender(request.gender());
    client.setUser(request.user());
    client.setPassword(request.password());
    client.setCEP(request.CEP());
    client.setBirthDate(request.birthDate());

    final var newId = this.clientRepository.create(client);

    return new ClientCreatedResponse(newId, client.getUser());
  }

  public CepResponse validation(final String user) {
    final Client client = this.clientRepository.findByUser(user);
    return (CepResponse) this.fetchCep.fetch(client.getCEP());
  }

}
