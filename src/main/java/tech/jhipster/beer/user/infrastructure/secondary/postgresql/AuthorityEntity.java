package tech.jhipster.beer.user.infrastructure.secondary.postgresql;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * An authority (a security role) used by Spring Security.
 */
@Entity
@Table(name = "jhi_authority")
public class AuthorityEntity implements Serializable {

  private static final long serialVersionUID = 1L;

  @NotNull
  @Size(max = 50)
  @Id
  @Column(length = 50)
  private String name;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public AuthorityEntity name(String name) {
    this.name = name;
    return this;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof AuthorityEntity)) {
      return false;
    }
    return Objects.equals(name, ((AuthorityEntity) o).name);
  }

  @Override
  public int hashCode() {
    return getClass().hashCode();
  }

  // prettier-ignore
  @Override
  public String toString() {
    return "Authority{" +
      "name='" + name + '\'' +
      "}";
  }
}
