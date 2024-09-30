DROP TABLE IF EXISTS "chat_message";
CREATE SEQUENCE messages_id_seq INCREMENT 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1;

CREATE TABLE "chat_message" (
                         "id" bigint DEFAULT nextval('messages_id_seq') NOT NULL,
                         "message" text NOT NULL,
                         CONSTRAINT "chat-pkey" PRIMARY KEY ("id")
);
