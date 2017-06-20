CREATE TABLE client (
  id         INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  name      VARCHAR(100)      NOT NULL
);