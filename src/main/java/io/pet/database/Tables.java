/*
 * This file is generated by jOOQ.
 */
package io.pet.database;


import io.pet.database.tables.Comment;
import io.pet.database.tables.Event;
import io.pet.database.tables.Tag;
import io.pet.database.tables.User;

import javax.annotation.Generated;


/**
 * Convenience access to all tables in public
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.9"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Tables {

    /**
     * The table <code>public.comment</code>.
     */
    public static final Comment COMMENT = io.pet.database.tables.Comment.COMMENT;

    /**
     * The table <code>public.event</code>.
     */
    public static final Event EVENT = io.pet.database.tables.Event.EVENT;

    /**
     * The table <code>public.tag</code>.
     */
    public static final Tag TAG = io.pet.database.tables.Tag.TAG;

    /**
     * The table <code>public.user</code>.
     */
    public static final User USER = io.pet.database.tables.User.USER;
}
