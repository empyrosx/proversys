CREATE SEQUENCE GLOBAL_SEQ AS INTEGER START WITH 100000;

CREATE TABLE project (
  id         BIGINT            IDENTITY NOT NULL PRIMARY KEY,
  name      VARCHAR(100)      NOT NULL
);

-- insert into project(id, name)
-- values (1, 'Web-consolidation');
--
-- insert into project(id, name)
-- values (2, 'Web-planning');
--
-- insert into project(id, name)
-- values (3, 'Web-budget');