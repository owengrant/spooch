/*
 * This file is generated by jOOQ.
 */
package io.pet.spooch.database.tables.records;


import io.github.jklingsporn.vertx.jooq.shared.internal.VertxPojo;
import io.pet.spooch.database.tables.Event;
import io.pet.spooch.jooq.types.Point;

import java.time.LocalDateTime;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record9;
import org.jooq.Row9;
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
public class EventRecord extends UpdatableRecordImpl<EventRecord> implements VertxPojo, Record9<Integer, Integer, String, String, LocalDateTime, Point, String, String, String> {

    private static final long serialVersionUID = 2004631744;

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
     * Setter for <code>public.event.uid</code>.
     */
    public EventRecord setUid(Integer value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>public.event.uid</code>.
     */
    public Integer getUid() {
        return (Integer) get(1);
    }

    /**
     * Setter for <code>public.event.caption</code>.
     */
    public EventRecord setCaption(String value) {
        set(2, value);
        return this;
    }

    /**
     * Getter for <code>public.event.caption</code>.
     */
    public String getCaption() {
        return (String) get(2);
    }

    /**
     * Setter for <code>public.event.description</code>.
     */
    public EventRecord setDescription(String value) {
        set(3, value);
        return this;
    }

    /**
     * Getter for <code>public.event.description</code>.
     */
    public String getDescription() {
        return (String) get(3);
    }

    /**
     * Setter for <code>public.event.posted</code>.
     */
    public EventRecord setPosted(LocalDateTime value) {
        set(4, value);
        return this;
    }

    /**
     * Getter for <code>public.event.posted</code>.
     */
    public LocalDateTime getPosted() {
        return (LocalDateTime) get(4);
    }

    /**
     * Setter for <code>public.event.location</code>.
     */
    public EventRecord setLocation(Point value) {
        set(5, value);
        return this;
    }

    /**
     * Getter for <code>public.event.location</code>.
     */
    public Point getLocation() {
        return (Point) get(5);
    }

    /**
     * Setter for <code>public.event.photo</code>.
     */
    public EventRecord setPhoto(String value) {
        set(6, value);
        return this;
    }

    /**
     * Getter for <code>public.event.photo</code>.
     */
    public String getPhoto() {
        return (String) get(6);
    }

    /**
     * Setter for <code>public.event.category</code>.
     */
    public EventRecord setCategory(String value) {
        set(7, value);
        return this;
    }

    /**
     * Getter for <code>public.event.category</code>.
     */
    public String getCategory() {
        return (String) get(7);
    }

    /**
     * Setter for <code>public.event.event</code>.
     */
    public EventRecord setEvent(String value) {
        set(8, value);
        return this;
    }

    /**
     * Getter for <code>public.event.event</code>.
     */
    public String getEvent() {
        return (String) get(8);
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
    // Record9 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row9<Integer, Integer, String, String, LocalDateTime, Point, String, String, String> fieldsRow() {
        return (Row9) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row9<Integer, Integer, String, String, LocalDateTime, Point, String, String, String> valuesRow() {
        return (Row9) super.valuesRow();
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
    public Field<Integer> field2() {
        return Event.EVENT.UID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return Event.EVENT.CAPTION;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field4() {
        return Event.EVENT.DESCRIPTION;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<LocalDateTime> field5() {
        return Event.EVENT.POSTED;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Point> field6() {
        return Event.EVENT.LOCATION;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field7() {
        return Event.EVENT.PHOTO;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field8() {
        return Event.EVENT.CATEGORY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field9() {
        return Event.EVENT.EVENT_;
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
        return getUid();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component3() {
        return getCaption();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component4() {
        return getDescription();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LocalDateTime component5() {
        return getPosted();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Point component6() {
        return getLocation();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component7() {
        return getPhoto();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component8() {
        return getCategory();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component9() {
        return getEvent();
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
        return getUid();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value3() {
        return getCaption();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value4() {
        return getDescription();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LocalDateTime value5() {
        return getPosted();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Point value6() {
        return getLocation();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value7() {
        return getPhoto();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value8() {
        return getCategory();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value9() {
        return getEvent();
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
    public EventRecord value2(Integer value) {
        setUid(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EventRecord value3(String value) {
        setCaption(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EventRecord value4(String value) {
        setDescription(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EventRecord value5(LocalDateTime value) {
        setPosted(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EventRecord value6(Point value) {
        setLocation(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EventRecord value7(String value) {
        setPhoto(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EventRecord value8(String value) {
        setCategory(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EventRecord value9(String value) {
        setEvent(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EventRecord values(Integer value1, Integer value2, String value3, String value4, LocalDateTime value5, Point value6, String value7, String value8, String value9) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        value9(value9);
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
    public EventRecord(Integer id, Integer uid, String caption, String description, LocalDateTime posted, Point location, String photo, String category, String event) {
        super(Event.EVENT);

        set(0, id);
        set(1, uid);
        set(2, caption);
        set(3, description);
        set(4, posted);
        set(5, location);
        set(6, photo);
        set(7, category);
        set(8, event);
    }

    public EventRecord(io.vertx.core.json.JsonObject json) {
        this();
        fromJson(json);
    }

    @Override
    public EventRecord fromJson(io.vertx.core.json.JsonObject json) {
        setId(json.getInteger("id"));
        setUid(json.getInteger("uid"));
        setCaption(json.getString("caption"));
        setDescription(json.getString("description"));
        setPosted(json.getString("posted")==null?null:LocalDateTime.parse(json.getString("posted")));
        setLocation(json.getJsonArray("location")==null?null:new Point(json.getJsonArray("location")));
        // Omitting unrecognized type io.pet.spooch.jooq.types.Point for column location!
        setPhoto(json.getString("photo"));
        setCategory(json.getString("category"));
        setEvent(json.getString("event"));
        return this;
    }


    @Override
    public io.vertx.core.json.JsonObject toJson() {
        io.vertx.core.json.JsonObject json = new io.vertx.core.json.JsonObject();
        json.put("id",getId());
        json.put("uid",getUid());
        json.put("caption",getCaption());
        json.put("description",getDescription());
        json.put("posted",getPosted()==null?null:getPosted().toString());
        json.put("location",getLocation()==null?null:getLocation().toType());
        // Omitting unrecognized type io.pet.spooch.jooq.types.Point for column location!
        json.put("photo",getPhoto());
        json.put("category",getCategory());
        json.put("event",getEvent());
        return json;
    }

}
