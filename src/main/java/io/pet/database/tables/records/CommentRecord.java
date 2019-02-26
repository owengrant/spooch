/*
 * This file is generated by jOOQ.
 */
package io.pet.database.tables.records;


import io.github.jklingsporn.vertx.jooq.shared.internal.VertxPojo;
import io.pet.database.tables.Comment;

import java.time.LocalDateTime;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record6;
import org.jooq.Row6;
import org.jooq.impl.UpdatableRecordImpl;


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
public class CommentRecord extends UpdatableRecordImpl<CommentRecord> implements VertxPojo, Record6<Integer, Integer, LocalDateTime, Integer, String, Short> {

    private static final long serialVersionUID = -1487838752;

    /**
     * Setter for <code>public.comment.id</code>.
     */
    public CommentRecord setId(Integer value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>public.comment.id</code>.
     */
    public Integer getId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>public.comment.eid</code>.
     */
    public CommentRecord setEid(Integer value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>public.comment.eid</code>.
     */
    public Integer getEid() {
        return (Integer) get(1);
    }

    /**
     * Setter for <code>public.comment.posted</code>.
     */
    public CommentRecord setPosted(LocalDateTime value) {
        set(2, value);
        return this;
    }

    /**
     * Getter for <code>public.comment.posted</code>.
     */
    public LocalDateTime getPosted() {
        return (LocalDateTime) get(2);
    }

    /**
     * Setter for <code>public.comment.uid</code>.
     */
    public CommentRecord setUid(Integer value) {
        set(3, value);
        return this;
    }

    /**
     * Getter for <code>public.comment.uid</code>.
     */
    public Integer getUid() {
        return (Integer) get(3);
    }

    /**
     * Setter for <code>public.comment.details</code>.
     */
    public CommentRecord setDetails(String value) {
        set(4, value);
        return this;
    }

    /**
     * Getter for <code>public.comment.details</code>.
     */
    public String getDetails() {
        return (String) get(4);
    }

    /**
     * Setter for <code>public.comment.rating</code>.
     */
    public CommentRecord setRating(Short value) {
        set(5, value);
        return this;
    }

    /**
     * Getter for <code>public.comment.rating</code>.
     */
    public Short getRating() {
        return (Short) get(5);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record6 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row6<Integer, Integer, LocalDateTime, Integer, String, Short> fieldsRow() {
        return (Row6) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row6<Integer, Integer, LocalDateTime, Integer, String, Short> valuesRow() {
        return (Row6) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field1() {
        return Comment.COMMENT.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field2() {
        return Comment.COMMENT.EID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<LocalDateTime> field3() {
        return Comment.COMMENT.POSTED;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field4() {
        return Comment.COMMENT.UID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field5() {
        return Comment.COMMENT.DETAILS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Short> field6() {
        return Comment.COMMENT.RATING;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component1() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component2() {
        return getEid();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LocalDateTime component3() {
        return getPosted();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component4() {
        return getUid();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component5() {
        return getDetails();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Short component6() {
        return getRating();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value1() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value2() {
        return getEid();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LocalDateTime value3() {
        return getPosted();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value4() {
        return getUid();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value5() {
        return getDetails();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Short value6() {
        return getRating();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CommentRecord value1(Integer value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CommentRecord value2(Integer value) {
        setEid(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CommentRecord value3(LocalDateTime value) {
        setPosted(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CommentRecord value4(Integer value) {
        setUid(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CommentRecord value5(String value) {
        setDetails(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CommentRecord value6(Short value) {
        setRating(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CommentRecord values(Integer value1, Integer value2, LocalDateTime value3, Integer value4, String value5, Short value6) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached CommentRecord
     */
    public CommentRecord() {
        super(Comment.COMMENT);
    }

    /**
     * Create a detached, initialised CommentRecord
     */
    public CommentRecord(Integer id, Integer eid, LocalDateTime posted, Integer uid, String details, Short rating) {
        super(Comment.COMMENT);

        set(0, id);
        set(1, eid);
        set(2, posted);
        set(3, uid);
        set(4, details);
        set(5, rating);
    }

    public CommentRecord(io.vertx.core.json.JsonObject json) {
        this();
        fromJson(json);
    }

    @Override
    public CommentRecord fromJson(io.vertx.core.json.JsonObject json) {
        setId(json.getInteger("id"));
        setEid(json.getInteger("eid"));
        setPosted(json.getString("posted")==null?null:LocalDateTime.parse(json.getString("posted")));
        setUid(json.getInteger("uid"));
        setDetails(json.getString("details"));
        setRating(json.getInteger("rating")==null?null:json.getInteger("rating").shortValue());
        return this;
    }


    @Override
    public io.vertx.core.json.JsonObject toJson() {
        io.vertx.core.json.JsonObject json = new io.vertx.core.json.JsonObject();
        json.put("id",getId());
        json.put("eid",getEid());
        json.put("posted",getPosted()==null?null:getPosted().toString());
        json.put("uid",getUid());
        json.put("details",getDetails());
        json.put("rating",getRating());
        return json;
    }

}
