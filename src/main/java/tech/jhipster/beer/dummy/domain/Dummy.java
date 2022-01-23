package tech.jhipster.beer.dummy.domain;

import tech.jhipster.beer.error.domain.Assert;

public record Dummy(String name) {
  public Dummy {
    Assert.notBlank("name", name);
  }

  public static Dummy of(String name) {
    return new Dummy(name);
  }
}
