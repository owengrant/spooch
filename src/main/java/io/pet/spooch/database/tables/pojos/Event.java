/*
 * This file is generated by jOOQ.
 */
package io.pet.spooch.database.tables.pojos;


import io.github.jklingsporn.vertx.jooq.shared.internal.VertxPojo;
import io.pet.spooch.jooq.types.Point;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.annotation.Generated;


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
public class Event implements VertxPojo, Serializable {

    private static final long serialVersionUID = 2105598904;

    private Integer       id;
    private Integer       uid;
    private String        caption;
    private String        description;
    private LocalDateTime posted;
    private Point         location;
    private String        photo;
    private String        category;
    private String        event;

    public Event() {}

    public Event(Event value) {
        this.id = value.id;
        this.uid = value.uid;
        this.caption = value.caption;
        this.description = value.description;
        this.posted = value.posted;
        this.location = value.location;
        this.photo = value.photo;
        this.category = value.category;
        this.event = value.event;
    }

    public Event(
        Integer       id,
        Integer       uid,
        String        caption,
        String        description,
        LocalDateTime posted,
        Point         location,
        String        photo,
        String        category,
        String        event
    ) {
        this.id = id;
        this.uid = uid;
        this.caption = caption;
        this.description = description;
        this.posted = posted;
        this.location = location;
        this.photo = photo;
        this.category = category;
        this.event = event;
    }

    public Integer getId() {
        return this.id;
    }

    public Event setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getUid() {
        return this.uid;
    }

    public Event setUid(Integer uid) {
        this.uid = uid;
        return this;
    }

    public String getCaption() {
        return this.caption;
    }

    public Event setCaption(String caption) {
        this.caption = caption;
        return this;
    }

    public String getDescription() {
        return this.description;
    }

    public Event setDescription(String description) {
        this.description = description;
        return this;
    }

    public LocalDateTime getPosted() {
        return this.posted;
    }

    public Event setPosted(LocalDateTime posted) {
        this.posted = posted;
        return this;
    }

    public Point getLocation() {
        return this.location;
    }

    public Event setLocation(Point location) {
        this.location = location;
        return this;
    }

    public String getPhoto() {
        return this.photo;
    }

    public Event setPhoto(String photo) {
        this.photo = photo;
        return this;
    }

    public String getCategory() {
        return this.category;
    }

    public Event setCategory(String category) {
        this.category = category;
        return this;
    }

    public String getEvent() {
        return this.event;
    }

    public Event setEvent(String event) {
        this.event = event;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Event (");

        sb.append(id);
        sb.append(", ").append(uid);
        sb.append(", ").append(caption);
        sb.append(", ").append(description);
        sb.append(", ").append(posted);
        sb.append(", ").append(location);
        sb.append(", ").append(photo);
        sb.append(", ").append(category);
        sb.append(", ").append(event);

        sb.append(")");
        return sb.toString();
    }

    public Event(io.vertx.core.json.JsonObject json) {
        this();
        fromJson(json);
    }

    @Override
    public Event fromJson(io.vertx.core.json.JsonObject json) {
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
