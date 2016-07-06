package com.bakigoal.dao.base;

import org.hibernate.proxy.HibernateProxy;

import javax.persistence.MappedSuperclass;
import java.io.Serializable;

/**
 * Created by ilmir on 02.06.16.
 */
@MappedSuperclass
public abstract class IdentifiedEntity implements Identified, Serializable {

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if (o instanceof HibernateProxy) {
      return o.equals(this);
    }

    if (o == null || (getClass() != o.getClass())) {
      return false;
    }

    IdentifiedEntity that = (IdentifiedEntity) o;

    if (getId() == null) {
      return this == that;
    } else {
      return getId().equals(that.getId());
    }

  }

  @Override
  public int hashCode() {
    return getId() != null ? getId().hashCode() : 0;
  }

  @Override
  public String toString() {
    return getClass().getSimpleName() + "{" + "id=" + getId() + '}';
  }

}
