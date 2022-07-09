package br.com.gabriel.decouplingdependencies;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableFeignClients
public class DecouplingDependenciesApplication {

  public static void main(final String[] args) {
    SpringApplication.run(DecouplingDependenciesApplication.class, args);
  }

}
