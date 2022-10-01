package br.com.gabriel.decouplingdependencies.domain.entities;


import br.com.gabriel.decouplingdependencies.repository.commons.Identity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Client {

  private Identity<?> id;
  private String name;
  private Gender gender;
  private String user;
  private String password;
  private String CEP;
  private LocalDate birthDate;

}
