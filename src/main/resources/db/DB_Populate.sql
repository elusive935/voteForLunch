DELETE FROM USERS;
DELETE FROM RESTAURANTS;
DELETE FROM VOTES;
ALTER SEQUENCE GLOBAL_SEQ RESTART WITH 100000;

-- admin (somePass)
INSERT INTO users (name, login, password)
VALUES ('Misha', 'misha937', '$2a$10$rPprNrHPSOde0nlrdf2w1.qPB1b14KEiVhOwgAcRG3G5cq/7vgG42');

-- user (anyPass)
INSERT INTO users (name, login, password)
VALUES ('Sasha', 'sasha645', '$2a$10$CICVvXTd4KucYKbahuQ4SOAdnBncNO5mgFTxJcC6x5VwK9N3c/Y5C');

INSERT INTO user_roles (role, user_id) VALUES
  ('ROLE_USER', 100000),
  ('ROLE_ADMIN', 100000),
  ('ROLE_USER', 100001);

INSERT INTO RESTAURANTS (NAME)
VALUES
  ('Elf'),
  ('Mumu'),
  ('Vobla');

INSERT INTO DISHES (RESTAURANT_ID, NAME, PRICE, DATE)
    VALUES
      (100002, 'Tomato', 100, '2017-06-26'),
      (100002, 'Potato', 150, '2017-06-26'),
      (100002, 'Cheese', 50, '2017-06-26'),
      (100003, 'Venigret', 100, '2017-06-26'),
      (100003, 'Lapsha', 95, '2017-06-26'),
      (100004, 'Losos', 120, '2017-06-26'),
      (100004, 'TomYam', 80, '2017-06-26'),
      (100004, 'Semga', 100, '2017-06-26'),
      (100004, 'Seld', 60, '2017-06-26');

INSERT INTO VOTES(ID, DATE, USER_ID, RESTAURANT_ID)
    VALUES
      (100005, '2017-06-26', 100000, 100002),
      (100006, '2017-06-26', 100001, 100003),
      (100007, '2017-06-27', 100001, 100004);






