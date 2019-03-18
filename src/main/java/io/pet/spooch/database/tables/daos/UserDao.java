/*
 * This file is generated by jOOQ.
 */
package io.pet.spooch.database.tables.daos;


import io.github.jklingsporn.vertx.jooq.shared.reactive.AbstractReactiveVertxDAO;
import io.pet.spooch.database.tables.User;
import io.pet.spooch.database.tables.records.UserRecord;

import java.util.List;

import javax.annotation.Generated;

import org.jooq.Configuration;


import io.vertx.core.Future;
import io.github.jklingsporn.vertx.jooq.classic.reactivepg.ReactiveClassicQueryExecutor;
/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.9"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class UserDao extends AbstractReactiveVertxDAO<UserRecord, io.pet.spooch.database.tables.pojos.User, Integer, Future<List<io.pet.spooch.database.tables.pojos.User>>, Future<io.pet.spooch.database.tables.pojos.User>, Future<Integer>, Future<Integer>> implements io.github.jklingsporn.vertx.jooq.classic.VertxDAO<UserRecord,io.pet.spooch.database.tables.pojos.User,Integer> {

    /**
     * @param configuration Used for rendering, so only SQLDialect must be set and must be one of the POSTGREs types.
     * @param delegate A configured AsyncSQLClient that is used for query execution
     */
    public UserDao(Configuration configuration, io.reactiverse.pgclient.PgClient delegate) {
        super(User.USER, io.pet.spooch.database.tables.pojos.User.class, new ReactiveClassicQueryExecutor<UserRecord,io.pet.spooch.database.tables.pojos.User,Integer>(configuration,delegate,io.pet.spooch.database.tables.mappers.RowMappers.getUserMapper()));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Integer getId(io.pet.spooch.database.tables.pojos.User object) {
        return object.getId();
    }

    /**
     * Find records that have <code>username IN (values)</code> asynchronously
     */
    public Future<List<io.pet.spooch.database.tables.pojos.User>> findManyByUsername(List<String> values) {
        return findManyByCondition(User.USER.USERNAME.in(values));
    }

    /**
     * Find a unique record that has <code>username = value</code> asynchronously
     */
    public Future<io.pet.spooch.database.tables.pojos.User> findOneByUsername(String value) {
        return findOneByCondition(User.USER.USERNAME.eq(value));
    }

    /**
     * Find records that have <code>password IN (values)</code> asynchronously
     */
    public Future<List<io.pet.spooch.database.tables.pojos.User>> findManyByPassword(List<String> values) {
        return findManyByCondition(User.USER.PASSWORD.in(values));
    }

    @Override
    public ReactiveClassicQueryExecutor<UserRecord,io.pet.spooch.database.tables.pojos.User,Integer> queryExecutor(){
        return (ReactiveClassicQueryExecutor<UserRecord,io.pet.spooch.database.tables.pojos.User,Integer>) super.queryExecutor();
    }
}