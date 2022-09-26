package br.com.gabriel.decouplingdependencies.external.impl.postmon;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(
  name = "postmon-api",
  url = "${app.external-api.postmon}"
)
public interface FetchCepUsingPostmon {

  @GetMapping("/cep/{cep}")
  CepUsingPostmonResponse fetch(@PathVariable String cep);


}
