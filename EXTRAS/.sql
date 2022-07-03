create database air_metar_icao;
grant all on air_metar_icao.* to 'air_user'@'localhost';

SELECT * FROM air_metar_icao.subscription_entity;

SELECT * FROM air_metar_icao.metar_entity;

INSERT INTO `air_metar_icao`.`subscription_entity`
(`id`, `icao_code`)
VALUES
(6, 'EDDF');

