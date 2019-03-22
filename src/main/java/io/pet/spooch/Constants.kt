package io.pet.spooch

//entities
val USER_ENTITY = "USER"


//event types
val INSERT = "INSERT"
val UPDATE = "UPDATE"
val DELETE = "DELETE"

//events
val USER_CREATED = "USER_CREATED"
val PASSWORD_CHANGED = "PASSWORD_CHANGED"
val EVENT_CREATED = "EVENT_CREATED"
val TAG_CREATED = "TAG_CREATED"
val COMMENT_CREATED = "COMMENT_CREATED"

//response eventbus handler
val RES_HANDLER = "io.pet.spooch.response.handler"
val RES_HANDLER_PATH = "/io/pet/spooch/response/handler"