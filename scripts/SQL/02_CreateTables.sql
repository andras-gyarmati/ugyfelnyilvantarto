CREATE TABLE "client" (
	"id" serial NOT NULL,
	"name" character varying(255) NOT NULL,
	"tax_number" character varying(255) NOT NULL UNIQUE,
	"logo" character varying(255),
	"address_id" bigint NOT NULL,
	CONSTRAINT client_pk PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "address" (
	"id" serial NOT NULL,
	"zip_code" character varying(10),
	"state_name" character varying(255),
	"country" character varying(255),
	"city" character varying(255) NOT NULL,
	"street" character varying(255) NOT NULL,
	CONSTRAINT address_pk PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "person" (
	"id" serial NOT NULL,
	"dtype" character varying(31) NOT NULL,
	"first_name" character varying(255) NOT NULL,
	"last_name" character varying(255) NOT NULL,
	"position" character varying(255),
	"profile_picture_path" character varying(255),
	CONSTRAINT person_pk PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "contact_person" (
	"id" bigint NOT NULL,
	"client_id" bigint NOT NULL,
	CONSTRAINT contact_person_pk PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "user_table" (
	"id" bigint NOT NULL,
	"username" character varying(255) NOT NULL UNIQUE,
	"password" character varying(255) NOT NULL,
	CONSTRAINT user_table_pk PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "contact_channel" (
	"id" serial NOT NULL,
	"type" character varying(255),
	"contact_channel_value" character varying(255),
	"person_id" bigint NOT NULL,
	CONSTRAINT contact_channel_pk PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "event_table" (
	"id" serial NOT NULL,
	"event_type" character varying(255),
	"start_date" DATE,
	"finish_date" DATE,
	"event_name" character varying(255),
	"client_id" bigint NOT NULL,
	"address_id" bigint NOT NULL,
	CONSTRAINT event_table_pk PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "invitation" (
	"id" serial NOT NULL,
	"description" character varying(255),
	"event_id" bigint NOT NULL,
	"status" character varying(30),
	CONSTRAINT invitation_pk PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "role_table" (
	"id" serial NOT NULL,
	"role_type" character varying(255) NOT NULL,
	CONSTRAINT role_table_pk PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "users_groups" (
	"user_fk" bigint NOT NULL,
	"role_fk" bigint NOT NULL,
	CONSTRAINT users_groups_pk PRIMARY KEY ("user_fk","role_fk")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "note" (
	"id" serial NOT NULL,
	"title" character varying(100),
	"content" character varying(255),
	"person_id" bigint NOT NULL,
	"event_id" bigint NOT NULL,
	CONSTRAINT note_pk PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "project" (
	"id" serial NOT NULL,
	"project_name" character varying(255) NOT NULL,
	"deadline" DATE,
	"project_state" character varying(255),
	"client_id" bigint NOT NULL,
	CONSTRAINT project_pk PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);



ALTER TABLE "client" ADD CONSTRAINT "client_fk0" FOREIGN KEY ("address_id") REFERENCES "address"("id");



ALTER TABLE "contact_person" ADD CONSTRAINT "contact_person_fk0" FOREIGN KEY ("id") REFERENCES "person"("id");
ALTER TABLE "contact_person" ADD CONSTRAINT "contact_person_fk1" FOREIGN KEY ("client_id") REFERENCES "client"("id");

ALTER TABLE "user_table" ADD CONSTRAINT "user_table_fk0" FOREIGN KEY ("id") REFERENCES "person"("id");

ALTER TABLE "contact_channel" ADD CONSTRAINT "contact_channel_fk0" FOREIGN KEY ("person_id") REFERENCES "person"("id");

ALTER TABLE "event_table" ADD CONSTRAINT "event_table_fk0" FOREIGN KEY ("client_id") REFERENCES "client"("id");
ALTER TABLE "event_table" ADD CONSTRAINT "event_table_fk1" FOREIGN KEY ("address_id") REFERENCES "address"("id");

ALTER TABLE "invitation" ADD CONSTRAINT "invitation_fk0" FOREIGN KEY ("event_id") REFERENCES "event_table"("id");


ALTER TABLE "users_groups" ADD CONSTRAINT "users_groups_fk0" FOREIGN KEY ("user_fk") REFERENCES "user_table"("id");
ALTER TABLE "users_groups" ADD CONSTRAINT "users_groups_fk1" FOREIGN KEY ("role_fk") REFERENCES "role_table"("id");

ALTER TABLE "note" ADD CONSTRAINT "note_fk0" FOREIGN KEY ("person_id") REFERENCES "person"("id");
ALTER TABLE "note" ADD CONSTRAINT "note_fk1" FOREIGN KEY ("event_id") REFERENCES "event_table"("id");

ALTER TABLE "project" ADD CONSTRAINT "project_fk0" FOREIGN KEY ("client_id") REFERENCES "client"("id");

