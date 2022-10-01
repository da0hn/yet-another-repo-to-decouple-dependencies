package br.com.gabriel.decouplingdependencies.repository.mongodb;

import br.com.gabriel.decouplingdependencies.domain.entities.Gender;
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

}
