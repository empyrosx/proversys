CREATE TABLE project_version (
  id         BIGINT            IDENTITY NOT NULL PRIMARY KEY,
  project_id BIGINT,
  name      VARCHAR(100)      NOT NULL
);