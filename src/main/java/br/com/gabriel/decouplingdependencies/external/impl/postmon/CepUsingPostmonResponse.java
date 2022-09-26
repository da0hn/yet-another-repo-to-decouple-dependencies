package br.com.gabriel.decouplingdependencies.external.impl.postmon;

public record CepUsingPostmonResponse(
  String logradouro,
  String bairro,
  String cidade,
  String estado
) {
}
