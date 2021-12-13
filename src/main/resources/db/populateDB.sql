DELETE FROM meals;
DELETE FROM user_roles;
DELETE FROM users;

ALTER SEQUENCE global_seq RESTART WITH 100000;

INSERT INTO users (name, email, password)
VALUES ('User', 'user@yandex.ru', 'password'),
       ('Admin', 'admin@gmail.com', 'admin');

INSERT INTO user_roles (role, user_id)
VALUES ('USER', 100000),
       ('ADMIN', 100001);

INSERT INTO meals (dateTime, description, calories, user_id)
VALUES (to_timestamp('14 00 00 1 Jun 2015', 'HH24:MI:SS DD Mon YYYY'), 'Админ ланч', 510, 100001),
       (to_timestamp('21 00 00 1 Jun 2015', 'HH24:MI:SS DD Mon YYYY'), 'Админ ужин', 1500, 100001);

