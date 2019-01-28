/*
 * This file is generated by jOOQ.
 */
package io.pet.database.tables.records;


import io.github.jklingsporn.vertx.jooq.shared.internal.VertxPojo;
import io.pet.database.tables.Event;

import java.sql.Timestamp;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record7;
import org.jooq.Row7;
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
public class EventRecord extends UpdatableRecordImpl<EventRecord> implements VertxPojo, Record7<Integer, String, String, Timestamp, String, String, Integer> {

    private static final long serialVersionUID = 475839483;

    /**
     * Setter for <code>public.event.id</code>.
     */
    public EventRecord setId(Integer value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>public.event.id</code>.
     */
    public Integer getId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>public.event.caption</code>.
     */
    public EventRecord setCaption(String value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>public.event.caption</code>.
     */
    public String getCaption() {
        return (String) get(1);
    }

    /**
     * Setter for <code>public.event.description</code>.
     */
    public EventRecord setDescription(String value) {
        set(2, value);
        return this;
    }

    /**
     * Getter for <code>public.event.description</code>.
     */
    public String getDescription() {
        return (String) get(2);
    }

    /**
     * Setter for <code>public.event.timestamp</code>.
     */
    public EventRecord setTimestamp(Timestamp value) {
        set(3, value);
        return this;
    }

    /**
     * Getter for <code>public.event.timestamp</code>.
     */
    public Timestamp getTimestamp() {
        return (Timestamp) get(3);
    }

    /**
     * Setter for <code>public.event.location</code>.
     */
    public EventRecord setLocation(String value) {
        set(4, value);
        return this;
    }

    /**
     * Getter for <code>public.event.location</code>.
     */
    public String getLocation() {
        return (String) get(4);
    }

    /**
     * Setter for <code>public.event.photo</code>.
     */
    public EventRecord setPhoto(String value) {
        set(5, value);
        return this;
    }

    /**
     * Getter for <code>public.event.photo</code>.
     */
    public String getPhoto() {
        return (String) get(5);
    }

    /**
     * Setter for <code>public.event.uid</code>.
     */
    public EventRecord setUid(Integer value) {
        set(6, value);
        return this;
    }

    /**
     * Getter for <code>public.event.uid</code>.
     */
    public Integer getUid() {
        return (Integer) get(6);
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
    // Record7 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row7<Integer, String, String, Timestamp, String, String, Integer> fieldsRow() {
        return (Row7) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row7<Integer, String, String, Timestamp, String, String, Integer> valuesRow() {
        return (Row7) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field1() {
        return Event.EVENT.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return Event.EVENT.CAPTION;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return Event.EVENT.DESCRIPTION;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field4() {
        return Event.EVENT.TIMESTAMP;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field5() {
        return Event.EVENT.LOCATION;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field6() {
        return Event.EVENT.PHOTO;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field7() {
        return Event.EVENT.UID;
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
    public String component2() {
        return getCaption();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component3() {
        return getDescription();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp component4() {
        return getTimestamp();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component5() {
        return getLocation();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component6() {
        return getPhoto();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component7() {
        return getUid();
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
    public String value2() {
        return getCaption();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value3() {
        return getDescription();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value4() {
        return getTimestamp();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value5() {
        return getLocation();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value6() {
        return getPhoto();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value7() {
        return getUid();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EventRecord value1(Integer value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EventRecord value2(String value) {
        setCaption(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EventRecord value3(String value) {
        setDescription(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EventRecord value4(Timestamp value) {
        setTimestamp(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EventRecord value5(String value) {
        setLocation(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EventRecord value6(String value) {
        setPhoto(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EventRecord value7(Integer value) {
        setUid(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EventRecord values(Integer value1, String value2, String value3, Timestamp value4, String value5, String value6, Integer value7) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached EventRecord
     */
    public EventRecord() {
        super(Event.EVENT);
    }

    /**
     * Create a detached, initialised EventRecord
     */
    public EventRecord(Integer id, String caption, String description, Timestamp timestamp, String location, String photo, Integer uid) {
        super(Event.EVENT);

        set(0, id);
        set(1, caption);
        set(2, description);
        set(3, timestamp);
        set(4, location);
        set(5, photo);
        set(6, uid);
    }

    public EventRecord(io.vertx.core.json.JsonObject json) {
        this();
        fromJson(json);
    }

    @Override
    public EventRecord fromJson(io.vertx.core.json.JsonObject json) {
        setId(json.getInteger("id"));
        setCaption(json.getString("caption"));
        setDescription(json.getString("description"));
        // Omitting unrecognized type java.sql.Timestamp for column timestamp!
        setLocation(json.getString("location"));
        setPhoto(json.getString("photo"));
        setUid(json.getInteger("uid"));
        return this;
    }


    @Override
    public io.vertx.core.json.JsonObject toJson() {
        io.vertx.core.json.JsonObject json = new io.vertx.core.json.JsonObject();
        json.put("id",getId());
        json.put("caption",getCaption());
        json.put("description",getDescription());
        // Omitting unrecognized type java.sql.Timestamp for column timestamp!
        json.put("location",getLocation());
        json.put("photo",getPhoto());
        json.put("uid",getUid());
        return json;
    }

}