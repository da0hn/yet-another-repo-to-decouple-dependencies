package br.com.gabriel.decouplingdependencies.services;

import br.com.gabriel.decouplingdependencies.domain.dtos.CepResponse;
import br.com.gabriel.decouplingdependencies.domain.orm.Client;
import br.com.gabriel.decouplingdependencies.domain.dtos.ClientCreateRequest;
import br.com.gabriel.decouplingdependencies.domain.dtos.ClientCreatedResponse;
import br.com.gabriel.decouplingdependencies.external.FetchCep;
import br.com.gabriel.decouplingdependencies.repository.ClientRepository;
import org.springframework.stereotype.Service;


@Service
public class ClientService {

  private final FetchCep fetchCep;

  private final ClientRepository clientRepository;

  public ClientService(
    final FetchCep fetchCep,
    final ClientRepository clientRepository
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

    this.clientRepository.save(client);

    return new ClientCreatedResponse(client.getId(), client.getUser());
  }

  public CepResponse validation(final String user) {
    final Client client = this.clientRepository.findByUser(user)
      .orElseThrow(() -> new RuntimeException("Usuário " + user + " não encontrado"));

    final var response = this.fetchCep.fetch(client.getCEP());

    return CepResponse.newBuilder()
      .withBairro(response.bairro())
      .withLogradouro(response.logradouro())
      .withLocalidade(response.localidade())
      .withUf(response.uf())
      .withRealizaEntrega(response.uf().equalsIgnoreCase("SP") || response.uf().equalsIgnoreCase("RJ"))
      .build();
  }

}
