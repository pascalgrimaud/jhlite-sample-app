package tech.jhipster.beer.dummy.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import tech.jhipster.beer.UnitTest;
import tech.jhipster.beer.error.domain.MissingMandatoryValueException;

@UnitTest
class DummyTest {

  @Test
  void shouldBuild() {
    Dummy dummy = new Dummy("chips");

    assertThat(dummy.name()).isEqualTo("chips");
  }

  @Test
  void shouldOf() {
    Dummy dummy = Dummy.of("chips");

    assertThat(dummy.name()).isEqualTo("chips");
  }

  @Test
  void shouldNotBuildWithNullName() {
    assertThatThrownBy(() -> new Dummy(null)).isExactlyInstanceOf(MissingMandatoryValueException.class).hasMessageContaining("name");
  }

  @Test
  void shouldNotBuildWithBlankName() {
    assertThatThrownBy(() -> new Dummy(" ")).isExactlyInstanceOf(MissingMandatoryValueException.class).hasMessageContaining("name");
  }
}
