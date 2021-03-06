/*
 * This file is generated by jOOQ.
 */
package io.pet.spooch.database.tables.daos;


import io.github.jklingsporn.vertx.jooq.shared.async.AbstractAsyncVertxDAO;
import io.pet.spooch.database.tables.Tag;
import io.pet.spooch.database.tables.records.TagRecord;

import java.util.List;

import javax.annotation.Generated;

import org.jooq.Configuration;


import io.vertx.core.Future;
import io.github.jklingsporn.vertx.jooq.classic.async.AsyncClassicQueryExecutor;
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
public class TagDao extends AbstractAsyncVertxDAO<TagRecord, io.pet.spooch.database.tables.pojos.Tag, Integer, Future<List<io.pet.spooch.database.tables.pojos.Tag>>, Future<io.pet.spooch.database.tables.pojos.Tag>, Future<Integer>, Future<Integer>> implements io.github.jklingsporn.vertx.jooq.classic.VertxDAO<TagRecord,io.pet.spooch.database.tables.pojos.Tag,Integer> {

    /**
     * @param configuration Used for rendering, so only SQLDialect must be set and must be one of the MYSQL types or POSTGRES.
     * @param delegate A configured AsyncSQLClient that is used for query execution
     */
    public TagDao(Configuration configuration, io.vertx.ext.asyncsql.AsyncSQLClient delegate) {
        super(Tag.TAG, io.pet.spooch.database.tables.pojos.Tag.class, new AsyncClassicQueryExecutor<TagRecord,io.pet.spooch.database.tables.pojos.Tag,Integer>(configuration,delegate,io.pet.spooch.database.tables.pojos.Tag::new, Tag.TAG));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Integer getId(io.pet.spooch.database.tables.pojos.Tag object) {
        return object.getId();
    }

    /**
     * Find records that have <code>eid IN (values)</code> asynchronously
     */
    public Future<List<io.pet.spooch.database.tables.pojos.Tag>> findManyByEid(List<Integer> values) {
        return findManyByCondition(Tag.TAG.EID.in(values));
    }

    /**
     * Find records that have <code>value IN (values)</code> asynchronously
     */
    public Future<List<io.pet.spooch.database.tables.pojos.Tag>> findManyByValue(List<String> values) {
        return findManyByCondition(Tag.TAG.VALUE.in(values));
    }

    /**
     * Find records that have <code>event IN (values)</code> asynchronously
     */
    public Future<List<io.pet.spooch.database.tables.pojos.Tag>> findManyByEvent(List<String> values) {
        return findManyByCondition(Tag.TAG.EVENT.in(values));
    }

    @Override
    public AsyncClassicQueryExecutor<TagRecord,io.pet.spooch.database.tables.pojos.Tag,Integer> queryExecutor(){
        return (AsyncClassicQueryExecutor<TagRecord,io.pet.spooch.database.tables.pojos.Tag,Integer>) super.queryExecutor();
    }

    @Override
    protected java.util.function.Function<Object,Integer> keyConverter(){
        return lastId -> Integer.valueOf(((io.vertx.core.json.JsonArray)lastId).getLong(0).intValue());
    }
}
