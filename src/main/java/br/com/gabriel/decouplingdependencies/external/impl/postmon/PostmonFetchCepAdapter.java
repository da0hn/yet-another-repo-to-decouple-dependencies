package br.com.gabriel.decouplingdependencies.external.impl.postmon;

import br.com.gabriel.decouplingdependencies.domain.dtos.CepResponse;
import br.com.gabriel.decouplingdependencies.external.FetchCep;
import br.com.gabriel.decouplingdependencies.external.FetchCepResponse;
import org.springframework.stereotype.Component;

@Component
public class PostmonFetchCepAdapter implements FetchCep {

  private final FetchCepUsingPostmon fetchCepUsingPostmon;

  public PostmonFetchCepAdapter(final FetchCepUsingPostmon fetchCepUsingPostmon) {this.fetchCepUsingPostmon =
    fetchCepUsingPostmon;}

  @Override
  public FetchCepResponse fetch(final String cep) {
    final var response = this.fetchCepUsingPostmon.fetch(cep);
    return new CepResponse(
      response.logradouro(),
      response.bairro(),
      response.cidade(),
      response.estado()
    );
  }


}
