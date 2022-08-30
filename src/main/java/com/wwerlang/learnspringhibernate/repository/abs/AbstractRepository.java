package com.wwerlang.learnspringhibernate.repository.abs;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class AbstractRepository {

    @PersistenceContext
    protected EntityManager em;

}
