BEGIN;
SET CONSTRAINTS ALL DEFERRED;

INSERT INTO Users (user_name)
VALUES ('alice'),
       ('bob'),
       ('charlie');

INSERT INTO Users (user_name, email)
VALUES ('email', 'email@example.com');

INSERT INTO Worlds (user_name, date_created, world_name, world_desc)
VALUES ('alice', '2023-01-01', 'Aetheria', 'A world of elemental balance'),
       ('bob', '2023-06-15', 'Drakoria', 'Land of dragons and flame'),
       ('charlie', '2024-03-20', 'Zephyria', 'Skybound cities of floating tech');

INSERT INTO Locations (location_name)
VALUES ('Crystal Forest'),
       ('Volcano Keep'),
       ('Sky Harbor'),
       ('Moonlit Bay'),
       ('Obsidian Tower');

INSERT INTO Characters (user_name, character_name, character_age, character_bio)
VALUES ('alice', 'Kael', 32, 'A guardian of elemental gates.'),
       ('bob', 'Lira', 24, 'A flame dancer from the south.'),
       ('email', 'Orin', 45, 'Inventor of sky gear.'),
       ('email', 'Mira', 19, 'Moon priestess in exile.');

INSERT INTO Timelines (world_id, start_date, end_date, timeline_name)
VALUES (1, '1000-01-01', '1100-01-01', 'Age of Discovery'),
       (2, '1500-01-01', '1550-01-01', 'War of Flame'),
       (3, '3000-01-01', '3050-01-01', 'Era of Innovation');

INSERT INTO Events (timeline_id, location_id,
                    event_name, event_type, event_focus,
                    event_date, event_outcome, event_consequence)
VALUES (1, 1, 'Gate Opening', 'Ritual', 'Magic', '1010-01-01', 'Elemental balance restored', 'Forest awakened'),
       (2, 2, 'Flame War', 'Battle', 'Territory', '1520-05-10', 'Victory for Drakoria', 'Ashlands expanded'),
       (3, 3, 'Airship Launch', 'Innovation', 'Travel', '3010-08-01', 'Successful flight', 'New trade routes'),
       (3, 5, 'Tower Collapse', 'Disaster', 'Politics', '3040-03-17', 'Council dissolved', 'Reconstruction begun');

INSERT INTO WorldCharacters (world_id, character_id)
VALUES (1, 1),
       (2, 2),
       (3, 3),
       (1, 4);

INSERT INTO TimelineCharacters (timeline_id, character_id)
VALUES (1, 1),
       (2, 2),
       (3, 3),
       (3, 4);

COMMIT;