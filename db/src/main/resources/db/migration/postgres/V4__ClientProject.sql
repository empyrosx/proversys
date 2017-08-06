CREATE TABLE client_project (
  id         INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  client_id INTEGER NOT NULL REFERENCES client(id),
  project_id INTEGER NOT NULL REFERENCES project(id)
);