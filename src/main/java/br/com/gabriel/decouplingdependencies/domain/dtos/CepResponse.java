package br.com.gabriel.decouplingdependencies.domain.dtos;

import br.com.gabriel.decouplingdependencies.external.FetchCepResponse;

public record CepResponse(
  String logradouro,
  String bairro,
  String localidade,
  String uf
) implements FetchCepResponse {

  public boolean realizaEntrega() {
    return "SP".equalsIgnoreCase(this.localidade) || "RJ".equalsIgnoreCase(this.localidade);
  }

}
