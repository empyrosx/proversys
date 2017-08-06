CREATE TABLE client_project (
  id         BIGINT            IDENTITY NOT NULL PRIMARY KEY,
  client_id BIGINT NOT NULL REFERENCES client(id),
  project_id BIGINT NOT NULL REFERENCES project(id)
);