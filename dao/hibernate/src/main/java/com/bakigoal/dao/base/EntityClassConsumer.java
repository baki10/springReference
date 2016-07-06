package com.bakigoal.dao.base;

/**
 * Created by ilmir on 02.06.16.
 */
public interface EntityClassConsumer {

	void setEntityClass(Class<? extends IdentifiedEntity> entityClass);

	Class<? extends IdentifiedEntity> getEntityClass();
}
