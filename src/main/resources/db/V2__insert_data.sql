INSERT INTO nations (name, description)
VALUES ('Kazakh', 'Native nation of Kazakhstan'),
       ('Russian', 'Slavic ethnic group'),
       ('Uighur', 'Turkic ethnic group'),
       ('Korean', 'Ethnic Koreans living in Central Asia'),
       ('Tatar', 'Turkic ethnic group');

INSERT INTO countries (name, continent, population)
VALUES ('Kazakhstan', 'Asia', 20000000),
       ('Russia', 'Europe/Asia', 146000000),
       ('China', 'Asia', 1400000000),
       ('Uzbekistan', 'Asia', 35000000);

INSERT INTO cities (name, population, country_id)
VALUES ('Almaty', 2000000, 1),
       ('Astana', 1200000, 1),
       ('Shymkent', 1200000, 1),
       ('Moscow', 13000000, 2),
       ('Saint Petersburg', 5500000, 2),
       ('Tashkent', 2700000, 4),
       ('Urumqi', 3500000, 3);

INSERT INTO city_nations (city_id, nation_id)
VALUES (1, 1),
       (1, 2),
       (1, 3);

INSERT INTO city_nations (city_id, nation_id)
VALUES (2, 1),
       (2, 2);

INSERT INTO city_nations (city_id, nation_id)
VALUES (3, 1),
       (3, 3);

INSERT INTO city_nations (city_id, nation_id)
VALUES (4, 2),
       (4, 5);

INSERT INTO city_nations (city_id, nation_id)
VALUES (5, 2);

INSERT INTO city_nations (city_id, nation_id)
VALUES (6, 1),
       (6, 4);

INSERT INTO city_nations (city_id, nation_id)
VALUES (7, 3),
       (7, 1);
