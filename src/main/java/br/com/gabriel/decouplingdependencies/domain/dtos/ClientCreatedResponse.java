package br.com.gabriel.decouplingdependencies.domain.dtos;

import br.com.gabriel.decouplingdependencies.repository.commons.Identity;

public record ClientCreatedResponse(
  Identity<?> id,
  String username
) {}
