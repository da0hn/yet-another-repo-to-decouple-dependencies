package br.com.gabriel.decouplingdependencies.repository.mysql;


import br.com.gabriel.decouplingdependencies.domain.entities.Client;
import br.com.gabriel.decouplingdependencies.domain.entities.Gender;
import br.com.gabriel.decouplingdependencies.repository.commons.MySqlIdentity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "clients")
public class MySqlClientEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;

  @Enumerated(EnumType.STRING)
  private Gender gender;

  private String user;

  private String password;

  @Column(name = "cep")
  private String CEP;

  @Column(name = "birth_date")
  private LocalDate birthDate;


  public static MySqlClientEntity toEntity(final Client client) {
    final var instance = new MySqlClientEntity();
    instance.setName(client.getName());
    instance.setGender(client.getGender());
    instance.setUser(client.getUser());
    instance.setPassword(client.getPassword());
    instance.setCEP(client.getCEP());
    instance.setBirthDate(client.getBirthDate());
    return instance;
  }

  public Client toDomain() {
    final var instance = new Client();
    instance.setId(MySqlIdentity.of(this.id));
    instance.setName(this.name);
    instance.setGender(this.gender);
    instance.setUser(this.user);
    instance.setPassword(this.password);
    instance.setCEP(this.CEP);
    instance.setBirthDate(this.birthDate);
    return instance;
  }


}
