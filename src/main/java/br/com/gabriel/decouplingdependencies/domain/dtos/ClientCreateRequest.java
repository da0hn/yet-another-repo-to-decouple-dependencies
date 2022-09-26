package br.com.gabriel.decouplingdependencies.domain.dtos;

import br.com.gabriel.decouplingdependencies.domain.orm.Gender;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;


public record ClientCreateRequest(
  String name,
  Gender gender,
  String user,
  String password,
  String CEP,
  @JsonFormat(pattern = "dd/MM/yyyy")
  LocalDate birthDate
) {
}
