CREATE TABLE "user"(
	id SERIAL NOT NULL PRIMARY KEY,
	username VARCHAR(20) NOT NULL UNIQUE,
	password VARCHAR(50) NOT NULL,
    event varchar(50) NOT NULL
);

CREATE TABLE "event"(
	id SERIAL NOT NULL PRIMARY KEY,
	uid SERIAL NOT NULL REFERENCES "user"(id),
	caption VARCHAR(40) NOT NULL,
	description VARCHAR(240),
	posted TIMESTAMP NOT NULL DEFAULT now(),
	location geometry(POINT,4326) NOT NULL,
	photo VARCHAR(50),
	category VARCHAR(15) NOT NULL DEFAULT 'OTHER',
	event varchar(50) NOT NULL
);

CREATE TABLE "tag"(
	id SERIAL NOT NULL PRIMARY KEY,
	eid SERIAL NOT NULL REFERENCES event(id),
	value VARCHAR(30) NOT NULL,
	event varchar(50) NOT NULL
);

CREATE TABLE "comment"(
	id SERIAL NOT NULL PRIMARY KEY,
	eid SERIAL NOT NULL REFERENCES event(id),
	posted TIMESTAMP NOT NULL DEFAULT now(),
	uid SERIAL NOT NULL REFERENCES "user"(id),
	details VARCHAR(120) NOT NULL,
	rating smallint CHECK(rating >= 0 AND rating <= 5),
	event varchar(50) NOT NULL
);