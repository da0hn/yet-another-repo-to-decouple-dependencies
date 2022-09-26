package br.com.gabriel.decouplingdependencies.external;

public interface FetchCepResponse {

  String logradouro();

  String bairro();

  String localidade();

  String uf();

  boolean realizaEntrega();
}
