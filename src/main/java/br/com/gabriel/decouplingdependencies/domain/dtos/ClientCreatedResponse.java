package br.com.gabriel.decouplingdependencies.domain.dtos;

public record ClientCreatedResponse<T>(
  T id,
  String username
) {}
