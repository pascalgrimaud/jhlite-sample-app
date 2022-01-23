package tech.jhipster.beer.user.infrastructure.secondary.postgresql;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import tech.jhipster.beer.UnitTest;

@UnitTest
class UserEntityTest {

  @Test
  void shouldBuildWithSetters() {
    UserEntity userEntity = userEntityWithSetters();

    assertUserEntity(userEntity);
  }

  @Test
  void shouldBuildWithFluentSetters() {
    UserEntity userEntity = userEntityWithFluentSetters();

    assertUserEntity(userEntity);
  }

  @Test
  void shouldToString() {
    UserEntity userEntity = userEntityWithSetters();

    assertThat(userEntity.toString()).contains("myFirstName");
    assertThat(userEntity.toString()).doesNotContain("myPassword");
  }

  @Nested
  class UserEntityEqualsTest {

    @Test
    void shouldEqualsToForSameObject() {
      UserEntity userEntity1 = userEntityWithSetters();

      assertThat(userEntity1).isEqualTo(userEntity1);
    }

    @Test
    void shouldNotEqualsToForDifferentObject() {
      UserEntity userEntity1 = userEntityWithSetters();

      assertThat(userEntity1).isNotEqualTo("chips");
    }

    @Test
    void shouldNotEqualsToForNullId() {
      UserEntity userEntity1 = userEntityWithSetters().id(null);
      UserEntity userEntity2 = userEntityWithFluentSetters();

      assertThat(userEntity1).isNotEqualTo(userEntity2);
    }

    @Test
    void shouldNotEqualsToForDifferentId() {
      UserEntity userEntity1 = userEntityWithSetters();
      UserEntity userEntity2 = userEntityWithFluentSetters().id(1664L);

      assertThat(userEntity1).isNotEqualTo(userEntity2);
    }

    @Test
    void shouldEqualsTo() {
      UserEntity userEntity1 = userEntityWithSetters();
      UserEntity userEntity2 = userEntityWithFluentSetters();

      assertThat(userEntity1).isEqualTo(userEntity2);
    }
  }

  @Test
  void shouldHashCode() {
    UserEntity userEntity1 = userEntityWithSetters();
    UserEntity userEntity2 = userEntityWithFluentSetters();

    assertThat(userEntity1).hasSameHashCodeAs(userEntity2);
  }

  private UserEntity userEntityWithSetters() {
    UserEntity userEntity = new UserEntity();
    userEntity.setActivated(true);
    userEntity.setActivationKey("myActivationKey");
    userEntity.setAuthorities(Set.of(new AuthorityEntity().name("myAuthority")));
    userEntity.setCreatedBy("creator");
    userEntity.setCreatedDate(Instant.parse("2022-01-22T10:11:12.000Z"));
    userEntity.setEmail("user@email.com");
    userEntity.setFirstName("myFirstName");
    userEntity.setLastName("myLastName");
    userEntity.setId(1L);
    userEntity.setImageUrl("myImageUrl");
    userEntity.setLangKey("fr");
    userEntity.setLastModifiedBy("modifier");
    userEntity.setLastModifiedDate(Instant.parse("2022-01-23T10:11:12.000Z"));
    userEntity.setLogin("myLogin");
    userEntity.setPassword("myPassword");
    userEntity.setResetDate(Instant.parse("2022-01-24T10:11:12.000Z"));
    userEntity.setResetKey("myResetKey");
    return userEntity;
  }

  private UserEntity userEntityWithFluentSetters() {
    UserEntity userEntity = new UserEntity()
      .activated(true)
      .activationKey("myActivationKey")
      .authorities(Set.of(new AuthorityEntity().name("myAuthority")))
      .email("user@email.com")
      .firstName("myFirstName")
      .lastName("myLastName")
      .id(1L)
      .imageUrl("myImageUrl")
      .langKey("fr")
      .login("myLogin")
      .password("myPassword")
      .resetDate(Instant.parse("2022-01-24T10:11:12.000Z"))
      .resetKey("myResetKey");

    userEntity
      .lastModifiedBy("modifier")
      .lastModifiedDate(Instant.parse("2022-01-23T10:11:12.000Z"))
      .createdBy("creator")
      .createdDate(Instant.parse("2022-01-22T10:11:12.000Z"));

    return userEntity;
  }

  private void assertUserEntity(UserEntity userEntity) {
    assertThat(userEntity.isActivated()).isTrue();
    assertThat(userEntity.getActivationKey()).isEqualTo("myActivationKey");
    assertThat(userEntity.getCreatedBy()).isEqualTo("creator");
    assertThat(userEntity.getCreatedDate()).isEqualTo(Instant.parse("2022-01-22T10:11:12.000Z"));
    assertThat(userEntity.getEmail()).isEqualTo("user@email.com");
    assertThat(userEntity.getFirstName()).isEqualTo("myFirstName");
    assertThat(userEntity.getLastName()).isEqualTo("myLastName");
    assertThat(userEntity.getId()).isEqualTo(1L);
    assertThat(userEntity.getImageUrl()).isEqualTo("myImageUrl");
    assertThat(userEntity.getLangKey()).isEqualTo("fr");
    assertThat(userEntity.getLastModifiedBy()).isEqualTo("modifier");
    assertThat(userEntity.getLastModifiedDate()).isEqualTo(Instant.parse("2022-01-23T10:11:12.000Z"));
    assertThat(userEntity.getLogin()).isEqualTo("mylogin");
    assertThat(userEntity.getPassword()).isEqualTo("myPassword");
    assertThat(userEntity.getResetDate()).isEqualTo(Instant.parse("2022-01-24T10:11:12.000Z"));
    assertThat(userEntity.getResetKey()).isEqualTo("myResetKey");
    assertThat(userEntity.getAuthorities()).isNotEmpty();
    assertThat(userEntity.getAuthorities()).contains(new AuthorityEntity().name("myAuthority"));
  }
}
