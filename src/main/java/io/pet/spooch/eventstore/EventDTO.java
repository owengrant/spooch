package io.pet.spooch.eventstore;

import io.vertx.core.json.Json;
import io.vertx.core.json.JsonObject;

public class EventDTO {
    private int eventId = -1;
    private String event;
    private int entityId = -1;
    private String entity;
    private int version;
    private JsonObject data;
    private boolean sent;
    private String received;
    private String eventType;
    private int eventWeight;
    private String hash;

    public EventDTO(){}

    public EventDTO(String hash, String event, String eventType, int eventWeight, int entityId, String entity, int version, JsonObject data) {
        this.hash = hash;
        this.eventId = eventId;
        this.event = event != null ? event.toUpperCase() : event;
        this.entityId = entityId;
        this.entity = entity != null ? entity.toUpperCase() : entity;
        this.version = version;
        this.data = data;
        this.eventType = eventType;
        this.eventWeight = eventWeight;
        this.sent = sent;
    }

    public EventDTO fromJson(JsonObject json){
        this.eventId = json.getInteger("eventId", -1);
        setEvent(json.getString("event", null));
        this.entityId = json.getInteger("entityId", -1);
        setEntity(json.getString("entity", null));
        this.version = json.getInteger("version", -1);
        this.data = json.getJsonObject("data", new JsonObject());
        this.sent = json.getBoolean("sent",false);
        this.received = json.getString("received", null);
        this.eventType = json.getString("eventType", null);
        this.eventWeight = json.getInteger("eventWeight", -1);
        this.hash = json.getString("hash", null);
        return this;
    }


    public JsonObject toJson(){
        return new JsonObject(Json.encode(this));
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int event_id) {
        this.eventId = event_id;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event != null ? event.toUpperCase() : event;
    }

    public int getEntityId() {
        return entityId;
    }

    public void setEntityId(int entity_id) {
        this.entityId = entity_id;
    }

    public String getEntity() {
        return entity;
    }

    public void setEntity(String entity) {
        this.entity = entity != null ? entity.toUpperCase() : entity;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public JsonObject getData() {
        return data;
    }

    public void setData(JsonObject data) {
        this.data = data;
    }

    public boolean isSent() {
        return sent;
    }

    public void setSent(boolean sent) {
        this.sent = sent;
    }

    public String getReceived() {
        return received;
    }

    public void setReceived(String received) {
        this.received = received;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public int getEventWeight() {
        return eventWeight;
    }

    public void setEventWeight(int eventWeight) {
        this.eventWeight = eventWeight;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }
}
