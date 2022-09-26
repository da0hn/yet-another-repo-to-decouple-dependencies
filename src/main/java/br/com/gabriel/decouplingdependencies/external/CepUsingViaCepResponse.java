package br.com.gabriel.decouplingdependencies.external;

public record CepUsingViaCepResponse(
  String logradouro,
  String bairro,
  String localidade,
  String uf
) {
}
