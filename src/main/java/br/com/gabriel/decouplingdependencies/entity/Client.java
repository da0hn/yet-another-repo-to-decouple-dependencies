package br.com.gabriel.decouplingdependencies.entity;


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

  private Long id;

  private String name;

  private Gender gender;

  private String user;

  private String password;

  private String CEP;

  private LocalDate birthDate;


}
