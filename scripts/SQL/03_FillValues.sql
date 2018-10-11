-- (id, zip_code, state_name, country, city, street)
INSERT INTO address VALUES (nextval('address_id_seq'), '1192', 'Budapest', 'Hungary', 'Budapest', 'Peterdy utca 2' );
INSERT INTO address VALUES (nextval('address_id_seq'), '4000', 'Hajdu-Bihar', 'Hungary', 'Debrecen', 'Petofi utca 30' );
INSERT INTO address VALUES (nextval('address_id_seq'), '1092', 'Budapest', 'Hungary', 'Budapest', 'Raday utca 10' );

-- (id, name, tax_number, logo, addres_id)
INSERT INTO client VALUES (nextval('client_id_seq'), 'Nagy Bela', '8413941008', 'logo1.png', 1);
INSERT INTO client VALUES (nextval('client_id_seq'), 'Majoros Nikoletta', '5413241023', 'logo2.png', 2);

-- (id, dtype, first_name, last_name, position, profile_picture)
-- position: MANAGER, SALES, CTO, CEO, DEVELOPER
INSERT INTO person VALUES(nextval('person_id_seq'), 'P', 'Peter', 'Virag', 'MANAGER', 'picture1.jpg');
INSERT INTO person VALUES(nextval('person_id_seq'), 'U', 'Miklos', 'Varga', 'DEVELOPER', 'picture2.jpg');
INSERT INTO person VALUES(nextval('person_id_seq'), 'C', 'Hajnalka', 'Munkus', 'SALES', 'picture3.jpg');
INSERT INTO person VALUES(nextval('person_id_seq'), 'P', 'Béla', 'Nagy', 'CTO', 'picture4.jpg');
INSERT INTO person VALUES(nextval('person_id_seq'), 'U', 'József', 'Kis', 'CEO', 'picture5.jpg');
INSERT INTO person VALUES(nextval('person_id_seq'), 'C', 'Katalin', 'Kovács', 'SALES', 'picture6.jpg');
INSERT INTO person VALUES(nextval('person_id_seq'), 'P', 'Aladár', 'Lakatos', 'SALES', 'picture7.jpg');
INSERT INTO person VALUES(nextval('person_id_seq'), 'U', 'Gusztáv', 'Orosz', 'DEVELOPER', 'picture8.jpg');
INSERT INTO person VALUES(nextval('person_id_seq'), 'C', 'Mariann', 'Tóth', 'MANAGER', 'picture9.jpg');
INSERT INTO person VALUES(nextval('person_id_seq'), 'P', 'Eszter', 'Barna', 'SALES', 'picture10.jpg');
INSERT INTO person VALUES(nextval('person_id_seq'), 'U', 'Kálmán', 'Hajas', 'CTO', 'picture11.jpg');
INSERT INTO person VALUES(nextval('person_id_seq'), 'C', 'Éva', 'Gábor', 'CEO', 'picture12.jpg');
INSERT INTO person VALUES(nextval('person_id_seq'), 'P', 'Lajos', 'Tar', 'MANAGER', 'picture13.jpg');
INSERT INTO person VALUES(nextval('person_id_seq'), 'U', 'Nándor', 'Máté', 'CTO', 'picture14.jpg');
INSERT INTO person VALUES(nextval('person_id_seq'), 'C', 'Viktória', 'Illés', 'DEVELOPER', 'picture15.jpg');

-- (id, username, password)
INSERT INTO user_table VALUES (2, 'Miki', 'aA12.,');
INSERT INTO user_table VALUES (5, 'Józsi', 'aA12.,');
INSERT INTO user_table VALUES (8, 'Guszti', 'aA12.,');
INSERT INTO user_table VALUES (11, 'Kálmi', 'aA12.,');
INSERT INTO user_table VALUES (14, 'Viki', 'aA12.,');


-- (id, client_id)
INSERT INTO contact_person VALUES(3, 1);
INSERT INTO contact_person VALUES(6, 2);
INSERT INTO contact_person VALUES(9, 1);
INSERT INTO contact_person VALUES(12, 2);
INSERT INTO contact_person VALUES(15, 1);

-- (id, type, type_value, person_id)
-- type: EMAIL, TELEPHONE, FAX
INSERT INTO contact_channel VALUES (nextval('contact_channel_id_seq'), 'EMAIL', 'business@ownmail.com', 3);
INSERT INTO contact_channel VALUES (nextval('contact_channel_id_seq'), 'TELEPHONE', '06306985214', 3);

-- (id, type, start_date, finish_date, event_name, client_id, address_id)
-- type: MEETING, OPENING, CONFERENCE
INSERT INTO event_table VALUES (nextval('event_table_id_seq'), 'OPENING', '2017-05-16', '2017-05-16', 'Opening', 2, 3);
INSERT INTO event_table VALUES (nextval('event_table_id_seq'), 'CONFERENCE', '2017-06-20', '2017-06-23', 'IT Conference', 1, 3);

-- (id, description, event_id)
INSERT INTO invitation VALUES (nextval('invitation_id_seq'), 'You are cordially invited to our IT Conference', 2);

-- (id, label, text,person_id, event_id)
INSERT INTO note VALUES (nextval('note_id_seq'), 'Have to invite Mr.Peter', 'Need to call him', 1, 1);

-- (id, project_name, deadline, project_state, client_id)
-- project states: ANALYSIS, DESIGN, IMPLEMENTATION, TESTING, MAINTENANCE
INSERT INTO project VALUES (nextval('project_id_seq'), 'Mobile application', '2017-09-20', 'DESIGN', 1);

-- (id, role_type)
-- role types: ADMIN, USER
INSERT INTO role_table VALUES (nextval('role_table_id_seq'), 'ADMIN');
INSERT INTO role_table VALUES (nextval('role_table_id_seq'), 'USER');