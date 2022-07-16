package br.com.gabriel.decouplingdependencies.entity;

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
