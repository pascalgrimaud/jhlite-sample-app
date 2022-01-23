package tech.jhipster.beer.technical.infrastructure.secondary.logstash;

import static org.assertj.core.api.Assertions.assertThat;

import tech.jhipster.beer.UnitTest;
import org.junit.jupiter.api.Test;

@UnitTest
class LogstashTcpPropertiesTest {

  @Test
  void shouldDisableByDefault() {
    assertThat(new LogstashTcpProperties().isEnabled()).isFalse();
  }
}
