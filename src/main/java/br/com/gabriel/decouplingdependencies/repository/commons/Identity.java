package br.com.gabriel.decouplingdependencies.repository.commons;

public sealed interface Identity<T> permits MongoIdentity, MySqlIdentity {

  T getValue();

}
