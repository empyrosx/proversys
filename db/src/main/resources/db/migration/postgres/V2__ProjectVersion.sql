CREATE TABLE project_version (
  id         INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  project_id INTEGER,
  name      VARCHAR(100)      NOT NULL
);