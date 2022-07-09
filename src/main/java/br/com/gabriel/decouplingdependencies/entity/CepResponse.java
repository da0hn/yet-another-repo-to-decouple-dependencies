package br.com.gabriel.decouplingdependencies.entity;

public record CepResponse(
  String logradouro,
  String bairro,
  String localidade,
  String uf,
  boolean realizaEntrega
) {

  public static Builder newBuilder() {
    return new Builder();
  }

  public static final class Builder {

    private String logradouro;

    private String bairro;

    private String localidade;

    private String uf;

    private boolean realizaEntrega;

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

    public Builder withRealizaEntrega(final boolean val) {
      this.realizaEntrega = val;
      return this;
    }

    public CepResponse build() {
      return new CepResponse(
        this.logradouro,
        this.bairro,
        this.localidade,
        this.uf,
        this.realizaEntrega
      );
    }

  }

}
