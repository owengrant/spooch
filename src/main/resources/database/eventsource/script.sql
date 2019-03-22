CREATE  TABLE  eventsource(
    id serial PRIMARY KEY,
    stored timestamp NOT NULL DEFAULT now(),
    sent boolean NOT NULL DEFAULT false,
    event varchar(100) not null check(length(event) > 0),
    "eventType" varchar(10) not null check(length("eventType") > 0),
    entity varchar(100) not null check(length(entity) > 0),
    "entityId" varchar(100) not null check(length("entityId") > 31),
    revision serial not null unique,
    version integer  not null default 1 check(version > -1),
    data VARCHAR not null
);

CREATE FUNCTION source_events()
    RETURNS trigger
    LANGUAGE 'plpgsql'
AS $BODY$
DECLARE
    version int := 1;
    entity varchar := TG_TABLE_NAME;
    entity_id varchar;
    data varchar;
    rec record;
    event varchar;
BEGIN
    IF(TG_OP = 'INSERT') THEN
        entity_id := MD5(NEW.id::varchar);
        data := json_build_object('data',row_to_json(NEW))->> 'data';
        INSERT INTO eventsource(event,"eventType",entity,"entityId",version,data) VALUES (NEW.event, TG_OP, entity, entity_id, version, data);
        return NEW;
    ELSEIF (TG_OP = 'UPDATE') THEN
        entity_id := MD5(OLD.id::varchar);
        data := json_build_object('data',row_to_json(NEW))->> 'data';
        INSERT INTO eventsource(event,"eventType",entity,"entityId",version,data) VALUES (NEW.event, TG_OP, entity, entity_id, version, data);
        return NEW;
    ELSE
        entity_id := MD5(OLD.id::varchar);
        event := upper(entity||'_DELETED');
        rec := OLD;
        rec.event := event;
        data := json_build_object('data',row_to_json(rec))->> 'data';
        INSERT INTO eventsource(event,"eventType",entity,"entityId",version,data) VALUES (event, TG_OP, entity, entity_id, version, data);
        return OLD;
    END IF;
END;
$BODY$;

CREATE TRIGGER events_source_trigger
    AFTER INSERT OR DELETE OR UPDATE
    ON "user"
    FOR EACH ROW
    EXECUTE PROCEDURE source_events();

CREATE TRIGGER events_source_trigger
    AFTER INSERT OR DELETE OR UPDATE
    ON "tag"
    FOR EACH ROW
    EXECUTE PROCEDURE source_events();

CREATE TRIGGER events_source_trigger
    AFTER INSERT OR DELETE OR UPDATE
    ON "comment"
    FOR EACH ROW
    EXECUTE PROCEDURE source_events();

CREATE TRIGGER events_source_trigger
    AFTER INSERT OR DELETE OR UPDATE
    ON "event"
    FOR EACH ROW
    EXECUTE PROCEDURE source_events();
