package br.com.gabriel.decouplingdependencies.external.impl.viacep;

import br.com.gabriel.decouplingdependencies.domain.dtos.CepResponse;
import br.com.gabriel.decouplingdependencies.external.FetchCep;
import br.com.gabriel.decouplingdependencies.external.FetchCepResponse;
import org.springframework.stereotype.Component;

@Component
public class ViaCepFetchCepAdapter implements FetchCep {

  private final FetchCepUsingViaCep fetchCepUsingViaCep;

  public ViaCepFetchCepAdapter(final FetchCepUsingViaCep fetchCepUsingViaCep) {this.fetchCepUsingViaCep = fetchCepUsingViaCep;}

  @Override
  public FetchCepResponse fetch(final String cep) {
    final var response = this.fetchCepUsingViaCep.fetch(cep);
    return new CepResponse(
      response.logradouro(),
      response.bairro(),
      response.localidade(),
      response.uf()
    );
  }


}
