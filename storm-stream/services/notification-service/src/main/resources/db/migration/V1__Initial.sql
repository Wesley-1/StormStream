DROP TABLE IF EXISTS "notification";
CREATE SEQUENCE notifications_id_seq INCREMENT 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1;

CREATE TABLE "notification" (
                         "id" bigint DEFAULT nextval('notifications_id_seq') NOT NULL,
                         "message" text NOT NULL,
                         "service" text NOT NULL,
                         "timestamp" timestamp NOT NULL,
                         CONSTRAINT "notification-pkey" PRIMARY KEY ("id")
);
