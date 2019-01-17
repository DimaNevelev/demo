create table "events" (
  id bigserial not null,
  date timestamp without time zone not null,
  description text,
  primary key (id)
);