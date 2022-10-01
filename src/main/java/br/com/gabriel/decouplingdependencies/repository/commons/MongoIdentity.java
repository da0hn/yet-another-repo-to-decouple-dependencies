package br.com.gabriel.decouplingdependencies.repository.commons;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public final class MongoIdentity implements Identity<String> {

  private final String value;

  public static MongoIdentity of(final String id) {
    return new MongoIdentity(id);
  }


  @Override
  public String getValue() {
    return this.value;
  }

}
