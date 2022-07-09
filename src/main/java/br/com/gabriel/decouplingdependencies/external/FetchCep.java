package br.com.gabriel.decouplingdependencies.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(
  name = "cadastro-entrega",
  url = "${app.external-api.via-cep}"
)
public interface FetchCep {

  @GetMapping("/{cep}/json")
  FetchCepResponse fetch(@PathVariable String cep);


}
