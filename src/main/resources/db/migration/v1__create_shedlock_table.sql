DROP TABLE IF EXISTS shedlock;
CREATE TABLE shedlock(
name VARCHAR(65) PRIMARY KEY NOT NULL,
lock_until TIMESTAMP(3) NOT NULL

)