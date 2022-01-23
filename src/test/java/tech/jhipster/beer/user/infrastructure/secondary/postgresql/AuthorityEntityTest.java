package tech.jhipster.beer.user.infrastructure.secondary.postgresql;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import tech.jhipster.beer.UnitTest;

@UnitTest
class AuthorityEntityTest {

  private static final String ROLE_USER = "ROLE_USER";
  private static final String ROLE_ADMIN = "ROLE_ADMIN";

  @Test
  void shouldBuildWithSetters() {
    AuthorityEntity authority = authorityEntityWithSetters();

    assertThat(authority.getName()).isEqualTo(ROLE_USER);
  }

  @Test
  void shouldBuildWithFluentSetters() {
    AuthorityEntity authorityEntity = authorityEntityWithFluentSetters();

    assertThat(authorityEntity.getName()).isEqualTo(ROLE_ADMIN);
  }

  @Test
  void shouldToString() {
    AuthorityEntity authorityEntity = new AuthorityEntity().name(ROLE_USER);

    assertThat(authorityEntity.toString()).contains(ROLE_USER);
  }

  @Nested
  class AuthorityEntityEqualsTest {

    @Test
    void shouldEqualsToForSameObject() {
      AuthorityEntity authorityEntity1 = authorityEntityWithSetters();

      assertThat(authorityEntity1).isEqualTo(authorityEntity1);
    }

    @Test
    void shouldNotEqualsToForDifferentObject() {
      AuthorityEntity authorityEntity1 = authorityEntityWithSetters();

      assertThat(authorityEntity1).isNotEqualTo("chips");
    }

    @Test
    void shouldNotEqualsToForDifferentName() {
      AuthorityEntity authorityEntity1 = authorityEntityWithSetters();
      AuthorityEntity authorityEntity2 = authorityEntityWithFluentSetters();

      assertThat(authorityEntity1).isNotEqualTo(authorityEntity2);
    }

    @Test
    void shouldEqualsTo() {
      AuthorityEntity authorityEntity1 = authorityEntityWithSetters();
      AuthorityEntity authorityEntity2 = authorityEntityWithSetters();

      assertThat(authorityEntity1).isEqualTo(authorityEntity2);
    }
  }

  @Test
  void shouldHashCode() {
    AuthorityEntity authorityEntity1 = authorityEntityWithSetters();
    AuthorityEntity authorityEntity2 = authorityEntityWithSetters();

    assertThat(authorityEntity1).hasSameHashCodeAs(authorityEntity2);
  }

  private AuthorityEntity authorityEntityWithSetters() {
    AuthorityEntity authorityEntity = new AuthorityEntity();
    authorityEntity.setName(ROLE_USER);
    return authorityEntity;
  }

  private AuthorityEntity authorityEntityWithFluentSetters() {
    return new AuthorityEntity().name(ROLE_ADMIN);
  }
}
