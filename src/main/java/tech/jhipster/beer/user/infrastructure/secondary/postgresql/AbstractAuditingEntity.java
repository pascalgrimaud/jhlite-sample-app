package tech.jhipster.beer.user.infrastructure.secondary.postgresql;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.time.Instant;
import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 * Base abstract class for entities which will hold definitions for created, last modified, created by,
 * last modified by attributes.
 */
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class AbstractAuditingEntity implements Serializable {

  private static final long serialVersionUID = 1L;

  @CreatedBy
  @Column(name = "created_by", nullable = false, length = 50, updatable = false)
  @JsonIgnore
  private String createdBy;

  @CreatedDate
  @Column(name = "created_date", updatable = false)
  @JsonIgnore
  private Instant createdDate = Instant.now();

  @LastModifiedBy
  @Column(name = "last_modified_by", length = 50)
  @JsonIgnore
  private String lastModifiedBy;

  @LastModifiedDate
  @Column(name = "last_modified_date")
  @JsonIgnore
  private Instant lastModifiedDate = Instant.now();

  public String getCreatedBy() {
    return createdBy;
  }

  public void setCreatedBy(String createdBy) {
    this.createdBy = createdBy;
  }

  public AbstractAuditingEntity createdBy(String createdBy) {
    this.createdBy = createdBy;
    return this;
  }

  public Instant getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(Instant createdDate) {
    this.createdDate = createdDate;
  }

  public AbstractAuditingEntity createdDate(Instant createdDate) {
    this.createdDate = createdDate;
    return this;
  }

  public String getLastModifiedBy() {
    return lastModifiedBy;
  }

  public void setLastModifiedBy(String lastModifiedBy) {
    this.lastModifiedBy = lastModifiedBy;
  }

  public AbstractAuditingEntity lastModifiedBy(String lastModifiedBy) {
    this.lastModifiedBy = lastModifiedBy;
    return this;
  }

  public Instant getLastModifiedDate() {
    return lastModifiedDate;
  }

  public void setLastModifiedDate(Instant lastModifiedDate) {
    this.lastModifiedDate = lastModifiedDate;
  }

  public AbstractAuditingEntity lastModifiedDate(Instant lastModifiedDate) {
    this.lastModifiedDate = lastModifiedDate;
    return this;
  }
}
