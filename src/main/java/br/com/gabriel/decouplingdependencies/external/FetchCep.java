package br.com.gabriel.decouplingdependencies.external;

@FunctionalInterface
public interface FetchCep {

  FetchCepResponse fetch(String cep);

}
