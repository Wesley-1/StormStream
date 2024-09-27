DROP TABLE IF EXISTS "chat-messages";
DROP SEQUENCE IF EXISTS messages_id_seq;
CREATE SEQUENCE messages_id_seq INCREMENT 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1;

CREATE TABLE "chat-messages" (
                         "id" bigint DEFAULT nextval('messages_id_seq') NOT NULL,
                         "message" text NOT NULL,
                         CONSTRAINT "chat-pkey" PRIMARY KEY ("id")
);
