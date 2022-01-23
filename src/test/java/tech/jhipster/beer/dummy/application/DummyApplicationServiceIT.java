package tech.jhipster.beer.dummy.application;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import tech.jhipster.beer.IntegrationTest;
import tech.jhipster.beer.dummy.domain.Dummy;

@IntegrationTest
class DummyApplicationServiceIT {

  @Autowired
  DummyApplicationService service;

  @BeforeEach
  void setUp() {
    service.clear();
  }

  @Test
  void shouldList() {
    List<Dummy> result = service.list();

    assertThat(result).isEmpty();
  }

  @Test
  void shouldAddAndList() {
    Dummy dummy = Dummy.of("beer");

    service.add(dummy);

    List<Dummy> result = service.list();
    assertThat(result).contains(dummy);
  }
}
