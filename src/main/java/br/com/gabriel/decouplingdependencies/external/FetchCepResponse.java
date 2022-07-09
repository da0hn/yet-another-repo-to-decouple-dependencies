package br.com.gabriel.decouplingdependencies.external;

public record FetchCepResponse(
  String logradouro,
  String bairro,
  String localidade,
  String uf
) {
}
