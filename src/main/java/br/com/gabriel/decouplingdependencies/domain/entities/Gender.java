package br.com.gabriel.decouplingdependencies.domain.entities;

import java.util.Arrays;


public enum Gender {
  FEMALE('F'),
  MALE('M'),
  UNINFORMED('U');

  private final Character value;

  Gender(final char value) {
    this.value = value;
  }


  public static Gender from(final char value) {
    return Arrays.stream(Gender.values())
      .filter(gender -> gender.value == value)
      .findFirst()
      .orElse(Gender.UNINFORMED);
  }

  @Override public String toString() {
    return this.value.toString();
  }
}
