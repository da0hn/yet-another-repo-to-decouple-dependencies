package br.com.gabriel.decouplingdependencies.domain.dtos;

import br.com.gabriel.decouplingdependencies.external.FetchCepResponse;

public record CepResponse(
  String logradouro,
  String bairro,
  String localidade,
  String uf
) implements FetchCepResponse {


  public static Builder newBuilder() {
    return new Builder();
  }

  public boolean realizaEntrega() {
    return "SP".equalsIgnoreCase(this.localidade) || "RJ".equalsIgnoreCase(this.localidade);
  }

  public static final class Builder {

    private String logradouro;

    private String bairro;

    private String localidade;

    private String uf;

    private Builder() {
    }

    public Builder withLogradouro(final String val) {
      this.logradouro = val;
      return this;
    }

    public Builder withBairro(final String val) {
      this.bairro = val;
      return this;
    }

    public Builder withLocalidade(final String val) {
      this.localidade = val;
      return this;
    }

    public Builder withUf(final String val) {
      this.uf = val;
      return this;
    }


    public CepResponse build() {
      return new CepResponse(
        this.logradouro,
        this.bairro,
        this.localidade,
        this.uf
      );
    }

  }

}
