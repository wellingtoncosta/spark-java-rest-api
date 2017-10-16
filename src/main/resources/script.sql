create table "user" (
  id bigserial primary key not null,
  "name" varchar not null,
  email varchar not null,
  password text not null
);

create table contact (
  id bigserial primary key not null,
  "name" varchar not null,
  email varchar not null,
  phone varchar not null,
  user_id bigint not null references "user"
);