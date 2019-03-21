DROP DATABASE IF EXISTS moocproject;
CREATE DATABASE moocproject;
CREATE USER moocuser with encrypted password 'root';
GRANT ALL ON DATABASE moocproject TO moocuser;
CREATE TYPE child_entity_status AS ENUM (
  'NOT_STARTED',
  'FINISHED'
  );
CREATE TYPE parent_entity_status as ENUM (
  'NOT_STARTED',
  'IN_PROGRESS',
  'FINISHED'
  );
CREATE TABLE IF NOT EXISTS USERS
(
  ID              serial primary key,
  DATE_OF_SIGN_UP timestamp without time zone,
  USER_NAME       varchar(20) unique not null,
  IS_ADMIN        boolean,
  PASSWORD        varchar(100)       not null,
  FIRST_NAME      varchar(30)        not null,
  LAST_NAME       varchar(40)        not null,
  EMAIL           varchar(50)        not null,
  USER_PIC        varchar(100),
  ROLE            int,
  CONSTRAINT USERS_ROLE_FKEY FOREIGN KEY (ROLE)
    REFERENCES AUTHORITY (ID) ON DELETE RESTRICT ON UPDATE CASCADE
);
CREATE TABLE IF NOT EXISTS COURSES
(
  ID         serial primary key,
  TITLE      VARCHAR(30) not null,
  CREATOR_ID bigint,
  CONSTRAINT COURSES_CREATOR_ID_FKEY FOREIGN KEY (CREATOR_ID)
    REFERENCES USERS (ID) ON DELETE RESTRICT ON UPDATE CASCADE
);
CREATE TABLE IF NOT EXISTS MODULES
(
  ID          serial primary key,
  TITLE       varchar(40)  not null,
  DESCRIPTION varchar(355) not null,
  TITLE_IMG   varchar(60),
  "order"     smallint     not null,
  COURSE_ID   bigint,
  CONSTRAINT MODULES_COURSE_ID_FKEY FOREIGN KEY (COURSE_ID)
    REFERENCES COURSES (ID) ON DELETE CASCADE ON UPDATE CASCADE
);
CREATE TABLE IF NOT EXISTS LESSONS
(
  ID        serial primary key,
  TITLE     varchar(40) not null,
  "order"   smallint    not null,
  MODULE_ID bigint,
  CONSTRAINT LESSONS_MODULE_ID_FKEY FOREIGN KEY (MODULE_ID)
    REFERENCES MODULES (ID) ON DELETE CASCADE ON UPDATE CASCADE
);
CREATE TABLE IF NOT EXISTS LESSONS_ITEMS
(
  ID        serial primary key,
  NAME      varchar(40) not null,
  "order"   smallint    not null,
  CONTENT   varchar(355),
  TITLE_IMG varchar(60),
  LESSON_ID bigint,
  CONSTRAINT LESSONS_ITEMS_LESSON_ID_FKEY FOREIGN KEY (LESSON_ID)
    REFERENCES LESSONS (ID) ON DELETE CASCADE ON UPDATE CASCADE
);
CREATE TABLE IF NOT EXISTS USERS_COURSES
(
  ID        serial primary key,
  USER_ID   bigint,
  COURSE_ID bigint,
  STATUS    parent_entity_status NOT NULL,
  CONSTRAINT USERS_COURSES_USER_ID_FKEY FOREIGN KEY (USER_ID)
    REFERENCES USERS (ID) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT USERS_COURSES_COURSE_ID_FKEY FOREIGN KEY (COURSE_ID)
    REFERENCES COURSES (ID) ON DELETE CASCADE ON UPDATE CASCADE,
  UNIQUE (USER_ID, COURSE_ID)
);
CREATE TABLE IF NOT EXISTS USERS_MODULES
(
  ID        serial primary key,
  USER_ID   bigint,
  MODULE_ID bigint,
  STATUS    parent_entity_status NOT NULL,
  CONSTRAINT USERS_MODULES_USER_ID_FKEY FOREIGN KEY (USER_ID)
    REFERENCES USERS (ID) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT USERS_MODULES_MODULE_ID_FKEY FOREIGN KEY (MODULE_ID)
    REFERENCES MODULES (ID) ON DELETE CASCADE ON UPDATE CASCADE,
  UNIQUE (USER_ID, MODULE_ID)
);
CREATE TABLE IF NOT EXISTS USERS_LESSONS
(
  ID        serial primary key,
  USER_ID   bigint,
  LESSON_ID bigint,
  STATUS    parent_entity_status NOT NULL,
  CONSTRAINT USERS_LESSONS_USER_ID_FKEY FOREIGN KEY (USER_ID)
    REFERENCES USERS (ID) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT USERS_LESSONS_LESSON_ID_FKEY FOREIGN KEY (LESSON_ID)
    REFERENCES LESSONS (ID) ON DELETE CASCADE ON UPDATE CASCADE,
  UNIQUE (USER_ID, LESSON_ID)
);
CREATE TABLE IF NOT EXISTS USERS_LESSON_ITEMS
(
  ID             serial primary key,
  USER_ID        bigint,
  LESSON_ITEM_ID bigint,
  STATUS         child_entity_status NOT NULL,
  CONSTRAINT USERS_LESSON_ITEMS_USER_ID_FKEY FOREIGN KEY (USER_ID)
    REFERENCES USERS (ID) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT USERS_LESSON_ITEMS_LESSON_ITEM_ID_FKEY FOREIGN KEY (LESSON_ITEM_ID)
    REFERENCES LESSONS_ITEMS (ID) ON DELETE CASCADE ON UPDATE CASCADE,
  UNIQUE (USER_ID, LESSON_ITEM_ID)
);
CREATE TABLE IF NOT EXISTS AUTHORITY
(
  ID   serial primary key,
  NAME varchar(30) not null
);
CREATE TABLE USER_AUTHORITY
(
  USER_ID      bigint,
  AUTHORITY_ID bigint,
  CONSTRAINT USER_AUTHORITY_USER_ID_FKEY FOREIGN KEY (USER_ID)
    REFERENCES USERS (ID) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT USER_AUTHORITY_AUTHORITY_ID_FKEY FOREIGN KEY (AUTHORITY_ID)
    REFERENCES AUTHORITY (ID) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE OR REPLACE VIEW USER_COURSE_VIEW AS
SELECT C.ID AS COURSE_ID,
       C.title,
       C.creator_id,
       users_courses.id,
       users_courses.user_id,
       users_courses.status
FROM USERS_COURSES
       INNER JOIN COURSES C on USERS_COURSES.COURSE_ID = C.ID;

CREATE OR REPLACE VIEW USER_MODULE_VIEW AS
SELECT m.id                                          AS MODULE_ID,
       m.title,
       m.description,
       m.title_img,
       m."order",
       m.course_id,
       COALESCE(users_modules.user_id, -99)          AS user_id,
       COALESCE(users_modules.status, 'NOT_STARTED') AS status
FROM users_modules
       RIGHT JOIN modules m on users_modules.module_id = m.id;

CREATE OR REPLACE VIEW USER_LESSON_VIEW AS
SELECT l.id                                          AS LESSON_ID,
       l.title,
       l."order",
       l.module_id,
       COALESCE(users_lessons.id, -99)               AS id,
       COALESCE(users_lessons.user_id, -99)          AS user_id,
       COALESCE(users_lessons.status, 'NOT_STARTED') AS status
FROM users_lessons
       RIGHT JOIN lessons l on users_lessons.lesson_id = l.id;

CREATE OR REPLACE VIEW USER_LESSON_ITEM_VIEW AS
SELECT li.id                                              AS LESSON_ITEM_ID,
       li.name,
       li."order",
       li.content,
       li.title_img,
       li.lesson_id,
       COALESCE(users_lesson_items.id, -99)               AS id,
       COALESCE(users_lesson_items.user_id, -99)          AS user_id,
       COALESCE(users_lesson_items.status, 'NOT_STARTED') AS status
FROM users_lesson_items
       RIGHT JOIN lessons_items li on users_lesson_items.lesson_item_id = li.id;