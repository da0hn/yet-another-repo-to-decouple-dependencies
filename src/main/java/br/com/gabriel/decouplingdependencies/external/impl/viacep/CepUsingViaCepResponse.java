package br.com.gabriel.decouplingdependencies.external.impl.viacep;

public record CepUsingViaCepResponse(
  String logradouro,
  String bairro,
  String localidade,
  String uf
) {
}
