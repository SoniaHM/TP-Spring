CREATE TABLE team
(
    id IDENTITY NOT NULL PRIMARY KEY,
    name   VARCHAR(200),
    slogan VARCHAR(500)
);

CREATE TABLE player (
                        id bigint(20) NOT NULL AUTO_INCREMENT,
                        name varchar(200) NOT NULL,
                        number varchar(2) DEFAULT NULL,
                        position varchar(100) DEFAULT NULL,
                        team_id bigint(20) NOT NULL,
                        UNIQUE KEY name (name),
                        CONSTRAINT player_ibfk_1 FOREIGN KEY (team_id) REFERENCES team (id) ON DELETE CASCADE ON UPDATE CASCADE
);