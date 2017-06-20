CREATE SEQUENCE global_seq START 100000;

CREATE TABLE project (
  id        INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
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