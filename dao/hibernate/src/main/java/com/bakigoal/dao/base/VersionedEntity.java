package com.bakigoal.dao.base;

import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

/**
 * Created by ilmir on 03.06.16.
 */
@MappedSuperclass
public abstract class VersionedEntity extends LongIdentifiedEntity {
  private long version;

  @Version
  public long getVersion() {
    return version;
  }

  public void setVersion(long version) {
    this.version = version;
  }

  @Override
  public String toString() {
    return getClass().getSimpleName() + "{" +
        "id=" + getId() +
        ", version=" + getVersion() +
        '}';
  }
}
