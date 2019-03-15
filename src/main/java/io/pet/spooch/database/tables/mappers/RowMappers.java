package io.pet.spooch.database.tables.mappers;

import io.reactiverse.pgclient.Row;
import java.util.function.Function;

public class RowMappers {

    private RowMappers(){}

    public static Function<Row,io.pet.spooch.database.tables.pojos.Comment> getCommentMapper() {
        return row -> {
            io.pet.spooch.database.tables.pojos.Comment pojo = new io.pet.spooch.database.tables.pojos.Comment();
            pojo.setId(row.getInteger("id"));
            pojo.setEid(row.getInteger("eid"));
            pojo.setPosted(row.getLocalDateTime("posted"));
            pojo.setUid(row.getInteger("uid"));
            pojo.setDetails(row.getString("details"));
            pojo.setRating(row.getShort("rating"));
            return pojo;
        };
    }

    public static Function<Row,io.pet.spooch.database.tables.pojos.Event> getEventMapper() {
        return row -> {
            io.pet.spooch.database.tables.pojos.Event pojo = new io.pet.spooch.database.tables.pojos.Event();
            pojo.setId(row.getInteger("id"));
            pojo.setUid(row.getInteger("uid"));
            pojo.setCaption(row.getString("caption"));
            pojo.setDescription(row.getString("description"));
            pojo.setPosted(row.getLocalDateTime("posted"));
            // Omitting unrecognized type DataType [ t=USER-DEFINED; p=0; s=0; u="public"."geometry"; j=io.pet.spooch.jooq.types.Point ] (io.pet.spooch.jooq.types.Point) for column location!
            pojo.setPhoto(row.getString("photo"));
            pojo.setCategory(row.getString("category"));
            return pojo;
        };
    }

    public static Function<Row,io.pet.spooch.database.tables.pojos.Tag> getTagMapper() {
        return row -> {
            io.pet.spooch.database.tables.pojos.Tag pojo = new io.pet.spooch.database.tables.pojos.Tag();
            pojo.setId(row.getInteger("id"));
            pojo.setEid(row.getInteger("eid"));
            pojo.setValue(row.getString("value"));
            return pojo;
        };
    }

    public static Function<Row,io.pet.spooch.database.tables.pojos.User> getUserMapper() {
        return row -> {
            io.pet.spooch.database.tables.pojos.User pojo = new io.pet.spooch.database.tables.pojos.User();
            pojo.setId(row.getInteger("id"));
            pojo.setUsername(row.getString("username"));
            pojo.setPassword(row.getString("password"));
            return pojo;
        };
    }

}
