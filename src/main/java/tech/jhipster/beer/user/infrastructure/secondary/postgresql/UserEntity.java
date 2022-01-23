package tech.jhipster.beer.user.infrastructure.secondary.postgresql;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.Instant;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.annotations.BatchSize;

import tech.jhipster.beer.user.domain.UserConstants;

/**
 * A user.
 */
@Entity
@Table(name = "jhi_user")
public class UserEntity extends AbstractAuditingEntity {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
  @SequenceGenerator(name = "seq_sqlUser_postgresql")
  private Long id;

  @NotNull
  @Pattern(regexp = UserConstants.LOGIN_REGEX)
  @Size(min = 1, max = 50)
  @Column(length = 50, unique = true, nullable = false)
  private String login;

  @JsonIgnore
  @NotNull
  @Size(min = 60, max = 60)
  @Column(name = "password_hash", length = 60, nullable = false)
  private String password;

  @Size(max = 50)
  @Column(name = "first_name", length = 50)
  private String firstName;

  @Size(max = 50)
  @Column(name = "last_name", length = 50)
  private String lastName;

  @Email
  @Size(min = 5, max = 254)
  @Column(length = 254, unique = true)
  private String email;

  @NotNull
  @Column(nullable = false)
  private boolean activated = false;

  @Size(min = 2, max = 10)
  @Column(name = "lang_key", length = 10)
  private String langKey;

  @Size(max = 256)
  @Column(name = "image_url", length = 256)
  private String imageUrl;

  @Size(max = 20)
  @Column(name = "activation_key", length = 20)
  @JsonIgnore
  private String activationKey;

  @Size(max = 20)
  @Column(name = "reset_key", length = 20)
  @JsonIgnore
  private String resetKey;

  @Column(name = "reset_date")
  private Instant resetDate = null;

  @JsonIgnore
  @ManyToMany
  @JoinTable(
    name = "jhi_user_authority",
    joinColumns = { @JoinColumn(name = "user_id", referencedColumnName = "id") },
    inverseJoinColumns = { @JoinColumn(name = "authority_name", referencedColumnName = "name") }
  )
  @BatchSize(size = 20)
  private Set<AuthorityEntity> authorities = new HashSet<>();

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getLogin() {
    return login;
  }

  public void setLogin(String login) {
    this.login = StringUtils.lowerCase(login, Locale.ENGLISH);
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public boolean isActivated() {
    return activated;
  }

  public void setActivated(boolean activated) {
    this.activated = activated;
  }

  public String getLangKey() {
    return langKey;
  }

  public void setLangKey(String langKey) {
    this.langKey = langKey;
  }

  public String getImageUrl() {
    return imageUrl;
  }

  public void setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
  }

  public String getActivationKey() {
    return activationKey;
  }

  public void setActivationKey(String activationKey) {
    this.activationKey = activationKey;
  }

  public String getResetKey() {
    return resetKey;
  }

  public void setResetKey(String resetKey) {
    this.resetKey = resetKey;
  }

  public Instant getResetDate() {
    return resetDate;
  }

  public void setResetDate(Instant resetDate) {
    this.resetDate = resetDate;
  }

  public Set<AuthorityEntity> getAuthorities() {
    return authorities;
  }

  public void setAuthorities(Set<AuthorityEntity> authorities) {
    this.authorities = authorities;
  }

  public UserEntity id(Long id) {
    this.id = id;
    return this;
  }

  public UserEntity login(String login) {
    this.login = StringUtils.lowerCase(login, Locale.ENGLISH);
    return this;
  }

  public UserEntity password(String password) {
    this.password = password;
    return this;
  }

  public UserEntity firstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  public UserEntity lastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  public UserEntity email(String email) {
    this.email = email;
    return this;
  }

  public UserEntity activated(boolean activated) {
    this.activated = activated;
    return this;
  }

  public UserEntity langKey(String langKey) {
    this.langKey = langKey;
    return this;
  }

  public UserEntity imageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
    return this;
  }

  public UserEntity activationKey(String activationKey) {
    this.activationKey = activationKey;
    return this;
  }

  public UserEntity resetKey(String resetKey) {
    this.resetKey = resetKey;
    return this;
  }

  public UserEntity resetDate(Instant resetDate) {
    this.resetDate = resetDate;
    return this;
  }

  public UserEntity authorities(Set<AuthorityEntity> authorities) {
    this.authorities = authorities;
    return this;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof UserEntity)) {
      return false;
    }
    return id != null && id.equals(((UserEntity) o).id);
  }

  @Override
  public int hashCode() {
    return getClass().hashCode();
  }

  // prettier-ignore
  @Override
  public String toString() {
    return "User{" +
      "login='" + login + '\'' +
      ", firstName='" + firstName + '\'' +
      ", lastName='" + lastName + '\'' +
      ", email='" + email + '\'' +
      ", imageUrl='" + imageUrl + '\'' +
      ", activated='" + activated + '\'' +
      ", langKey='" + langKey + '\'' +
      ", activationKey='" + activationKey + '\'' +
      "}";
  }
}
