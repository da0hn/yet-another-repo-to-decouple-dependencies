package br.com.gabriel.decouplingdependencies.external.impl.viacep;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(
  name = "via-cep-api",
  url = "${app.external-api.via-cep}"
)
public interface FetchCepUsingViaCep {

  @GetMapping("/{cep}/json")
  CepUsingViaCepResponse fetch(@PathVariable String cep);


}
