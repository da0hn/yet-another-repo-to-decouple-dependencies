package br.com.gabriel.decouplingdependencies.controllers;

import br.com.gabriel.decouplingdependencies.entity.CepResponse;
import br.com.gabriel.decouplingdependencies.entity.ClientCreateRequest;
import br.com.gabriel.decouplingdependencies.entity.ClientCreatedResponse;
import br.com.gabriel.decouplingdependencies.services.ClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/clients")
public class ClientController {

  private final ClientService clientService;

  public ClientController(final ClientService clientService) {
    this.clientService = clientService;
  }

  @PostMapping
  public ResponseEntity<ClientCreatedResponse> create(@RequestBody final ClientCreateRequest request) {
    final var response = this.clientService.create(request);
    return ResponseEntity.ok(response);
  }

  @GetMapping("/{user}/validation")
  public ResponseEntity<CepResponse> validation(@PathVariable("user") final String user) {
    final var response = this.clientService.validation(user);
    return ResponseEntity.ok(response);
  }

}
