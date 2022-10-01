package br.com.gabriel.decouplingdependencies.repository.mongodb;

import br.com.gabriel.decouplingdependencies.domain.entities.Client;
import br.com.gabriel.decouplingdependencies.domain.entities.Gender;
import br.com.gabriel.decouplingdependencies.repository.commons.MongoIdentity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.MongoId;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "client")
public class MongoClientEntity {

  @MongoId
  private String id;

  private String name;
  @Enumerated(EnumType.STRING)
  private Gender gender;

  private String user;

  private String password;

  @Field(name = "cep")
  private String CEP;

  @Field(name = "birth_date")
  private LocalDate birthDate;

  public static MongoClientEntity toEntity(final Client client) {
    final var instance = new MongoClientEntity();
    instance.setName(client.getName());
    instance.setGender(client.getGender());
    instance.setUser(client.getUser());
    instance.setPassword(client.getPassword());
    instance.setCEP(client.getCEP());
    instance.setBirthDate(client.getBirthDate());
    return instance;
  }

  public Client toDomain() {
    return new Client(
      MongoIdentity.of(this.id),
      this.name,
      this.gender,
      this.user,
      this.password,
      this.CEP,
      this.birthDate
    );
  }


}
