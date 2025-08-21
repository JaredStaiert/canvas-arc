-- DROP ALL TABLES
DROP TABLE IF EXISTS Events CASCADE;
DROP TABLE IF EXISTS Timelines CASCADE;
DROP TABLE IF EXISTS Worlds CASCADE;
DROP TABLE IF EXISTS Characters CASCADE;
DROP TABLE IF EXISTS TimelineCharacters CASCADE;
DROP TABLE IF EXISTS WorldCharacters CASCADE;
DROP TABLE IF EXISTS Users CASCADE;
DROP TABLE IF EXISTS locations CASCADE;

-- INITIAL TABLE DEFINITIONS
CREATE TABLE Events
(
    event_id INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY
);

CREATE TABLE Timelines
(
    timeline_id INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY
);

CREATE TABLE Worlds
(
    world_id INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY
);

CREATE TABLE Characters
(
    character_id INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY
);

CREATE TABLE Users
(
    user_name VARCHAR UNIQUE PRIMARY KEY
);

CREATE TABLE locations
(
    location_id INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY
);

-- DEFINE TABLE RELATIONS --------------------------------------------------------------------------------------------

-- WorldCharacters [M:N Worlds and Characters]
CREATE TABLE WorldCharacters
(
    world_id     INTEGER REFERENCES Worlds (world_id) ON DELETE CASCADE,
    character_id INTEGER REFERENCES Characters (character_id) ON DELETE CASCADE,
    PRIMARY KEY (world_id, character_id)
);

-- TimelineCharacters [M:N Timelines and Characters]
CREATE TABLE TimelineCharacters
(
    timeline_id  INTEGER REFERENCES Timelines (timeline_id) ON DELETE CASCADE,
    character_id INTEGER REFERENCES Characters (character_id) ON DELETE CASCADE,
    PRIMARY KEY (timeline_id, character_id)
);

-- Timelines [M:1 Worlds]
ALTER TABLE Timelines
    ADD COLUMN world_id INTEGER,
    ADD CONSTRAINT world_fk
        FOREIGN KEY (world_id)
            REFERENCES Worlds (world_id);

-- Events [M:1 Timelines]
ALTER TABLE Events
    ADD COLUMN timeline_id INTEGER,
    ADD CONSTRAINT timeline_fk
        FOREIGN KEY (timeline_id)
            REFERENCES Timelines (timeline_id),
    ADD COLUMN location_id INTEGER,
    ADD CONSTRAINT location_fk
        FOREIGN KEY (location_id)
            REFERENCES locations (location_id);

-- Characters [M:1 Users]
ALTER TABLE Characters
    ADD COLUMN user_name VARCHAR,
    ADD CONSTRAINT user_fk
        FOREIGN KEY (user_name)
            REFERENCES Users (user_name);

-- Worlds [M:1 Users]
ALTER TABLE Worlds
    ADD COLUMN user_name VARCHAR,
    ADD CONSTRAINT user_fk
        FOREIGN KEY (user_name)
            REFERENCES Users (user_name);

-- DEFINE TABLE COLUMNS --------------------------------------------------------------------------------------------

-- Timelines
ALTER TABLE Timelines
    ADD COLUMN start_date    DATE,
    ADD COLUMN end_date      DATE,
    ADD COLUMN timeline_name VARCHAR;

-- Events
ALTER TABLE events
    ADD COLUMN event_name        VARCHAR NOT NULL DEFAULT 'event_name',
    ADD COLUMN event_type        VARCHAR NOT NULL DEFAULT 'event_type',
    ADD COLUMN event_focus       VARCHAR NOT NULL DEFAULT 'event_focus',
    ADD COLUMN event_date        DATE,
    ADD COLUMN event_outcome     VARCHAR NOT NULL DEFAULT 'event_outcome',
    ADD COLUMN event_consequence VARCHAR NOT NULL DEFAULT 'event_consequences';

-- Characters
ALTER TABLE Characters
    ADD COLUMN character_name VARCHAR  NOT NULL DEFAULT 'character_name',
    ADD COLUMN character_age  SMALLINT NOT NULL DEFAULT 0,
    ADD COLUMN character_bio  TEXT     NOT NULL DEFAULT 'character_bio';

-- Worlds
ALTER TABLE Worlds
    ADD COLUMN date_created DATE,
    ADD COLUMN world_name   VARCHAR,
    ADD COLUMN world_desc   TEXT;

-- Users
ALTER TABLE Users
    ADD COLUMN email VARCHAR;

-- Locations
ALTER TABLE Locations
    ADD COLUMN location_name VARCHAR;