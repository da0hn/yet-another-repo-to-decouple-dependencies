package br.com.gabriel.decouplingdependencies.repository.commons;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public final class MySqlIdentity implements Identity<Long> {

  private final Long value;

  public static MySqlIdentity of(final Long id) {
    return new MySqlIdentity(id);
  }


  @Override
  public Long getValue() {
    return this.value;
  }

}
