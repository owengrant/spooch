/*
 * This file is generated by jOOQ.
 */
package io.pet.database.tables.daos;


import io.github.jklingsporn.vertx.jooq.shared.async.AbstractAsyncVertxDAO;
import io.pet.database.tables.Event;
import io.pet.database.tables.records.EventRecord;

import java.sql.Timestamp;
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
public class EventDao extends AbstractAsyncVertxDAO<EventRecord, io.pet.database.tables.pojos.Event, Integer, Future<List<io.pet.database.tables.pojos.Event>>, Future<io.pet.database.tables.pojos.Event>, Future<Integer>, Future<Integer>> implements io.github.jklingsporn.vertx.jooq.classic.VertxDAO<EventRecord,io.pet.database.tables.pojos.Event,Integer> {

    /**
     * @param configuration Used for rendering, so only SQLDialect must be set and must be one of the MYSQL types or POSTGRES.
     * @param delegate A configured AsyncSQLClient that is used for query execution
     */
    public EventDao(Configuration configuration, io.vertx.ext.asyncsql.AsyncSQLClient delegate) {
        super(Event.EVENT, io.pet.database.tables.pojos.Event.class, new AsyncClassicQueryExecutor<EventRecord,io.pet.database.tables.pojos.Event,Integer>(configuration,delegate,io.pet.database.tables.pojos.Event::new, Event.EVENT));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Integer getId(io.pet.database.tables.pojos.Event object) {
        return object.getId();
    }

    /**
     * Find records that have <code>caption IN (values)</code> asynchronously
     */
    public Future<List<io.pet.database.tables.pojos.Event>> findManyByCaption(List<String> values) {
        return findManyByCondition(Event.EVENT.CAPTION.in(values));
    }

    /**
     * Find records that have <code>description IN (values)</code> asynchronously
     */
    public Future<List<io.pet.database.tables.pojos.Event>> findManyByDescription(List<String> values) {
        return findManyByCondition(Event.EVENT.DESCRIPTION.in(values));
    }

    /**
     * Find records that have <code>timestamp IN (values)</code> asynchronously
     */
    public Future<List<io.pet.database.tables.pojos.Event>> findManyByTimestamp(List<Timestamp> values) {
        return findManyByCondition(Event.EVENT.TIMESTAMP.in(values));
    }

    /**
     * Find records that have <code>location IN (values)</code> asynchronously
     */
    public Future<List<io.pet.database.tables.pojos.Event>> findManyByLocation(List<String> values) {
        return findManyByCondition(Event.EVENT.LOCATION.in(values));
    }

    /**
     * Find records that have <code>photo IN (values)</code> asynchronously
     */
    public Future<List<io.pet.database.tables.pojos.Event>> findManyByPhoto(List<String> values) {
        return findManyByCondition(Event.EVENT.PHOTO.in(values));
    }

    /**
     * Find records that have <code>uid IN (values)</code> asynchronously
     */
    public Future<List<io.pet.database.tables.pojos.Event>> findManyByUid(List<Integer> values) {
        return findManyByCondition(Event.EVENT.UID.in(values));
    }

    @Override
    public AsyncClassicQueryExecutor<EventRecord,io.pet.database.tables.pojos.Event,Integer> queryExecutor(){
        return (AsyncClassicQueryExecutor<EventRecord,io.pet.database.tables.pojos.Event,Integer>) super.queryExecutor();
    }

    @Override
    protected java.util.function.Function<Object,Integer> keyConverter(){
        return lastId -> Integer.valueOf(((io.vertx.core.json.JsonArray)lastId).getLong(0).intValue());
    }
}
