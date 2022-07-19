CREATE TABLE IF NOT EXISTS User(
                                   id bigint auto_increment,
                                   constraint PK_U PRIMARY KEY (id),
    username nvarchar(255),
    email varchar(255),
    password varchar(255),
    role varchar(255),
    funds mediumint,
    UNIQUE(email),
    UNIQUE(username)
    );

CREATE TABLE IF NOT EXISTS Monster(
                                      id bigint auto_increment,
                                      constraint PK_M PRIMARY KEY(id),
    level int,
    hp int,
    power int,
    reward int,
    name varchar(255)
    );

CREATE TABLE IF NOT EXISTS Champion(
                                       id bigint auto_increment,
                                       constraint PK_C PRIMARY KEY (id),
    name varchar(255) unique,
    hp int,
    power int
    );

CREATE TABLE IF NOT EXISTS Item(
                                   id bigint auto_increment,
                                   constraint PK_I PRIMARY KEY (id),
    name varchar(255),
    bonus_power int,
    bonus_hp int,
    price int,
    type varchar(255)
    );

CREATE TABLE IF NOT EXISTS Ability(
                                      id bigint auto_increment,
                                      constraint PK_A PRIMARY KEY (id),
    name varchar(255) unique,
    type varchar(255),
    damage int,
    healing int
    );

CREATE TABLE IF NOT EXISTS IU_LINK(
                                      item_id bigint,
                                      user_id bigint,
                                      constraint FK_itemIU FOREIGN KEY (item_id) REFERENCES Item(id),
    constraint FK_userIU FOREIGN KEY (user_id) REFERENCES User(id)
    );

CREATE TABLE IF NOT EXISTS CA_LINK(
                                      champion_id bigint,
                                      ability_id bigint,
                                      constraint FK_championCA FOREIGN KEY (champion_id) REFERENCES Champion(id),
                                      constraint FK_abilityCA FOREIGN KEY (ability_id) REFERENCES Ability(id)
);

CREATE TABLE IF NOT EXISTS UC_Link(
                                      champion_id bigint,
                                      user_id bigint,
                                      constraint FK_userUC FOREIGN KEY (user_id) REFERENCES User(id),
    constraint FK_championUC FOREIGN KEY (champion_id) REFERENCES Champion(id),
                                  constraint row_constraint UNIQUE KEY (user_id, champion_id)
    );

/*drop table iu_link;
drop table uc_link;
drop table ca_link;
drop table ability;
drop table champion;
drop table item;
drop table user;
drop table monster;*/

CREATE INDEX idx_champName ON Champion(name);
CREATE INDEX idx_itemName ON Item(name);
CREATE INDEX idx_abilityName ON Ability(name);

INSERT INTO User (username, email, password, role, funds) VALUES ("Y33t", "yeet@ex.com" , "1234", "player", 1500);
INSERT INTO User (username, email, password, role, funds) VALUES ("Shr3k", "shrek@ex.com" , "nimda", "admin", 3000);
INSERT INTO User (username, email, password, role, funds) VALUES ("I0h4nnis", "yohaniis@ex.com" , "admin", "admin", 2000);
INSERT INTO User (username, email, password, role, funds) VALUES ("N00b", "pro@ex.com" , "best", "player", 2500);

INSERT INTO Item (name, bonus_power, bonus_hp, price, type) VALUES ("Tunica de 2 tone", 0 , 100, 100, "Armor");
INSERT INTO Item (name, bonus_power, bonus_hp, price, type) VALUES ("Toporceanu", 50 , 0, 200, "Weapon");
INSERT INTO Item (name, bonus_power, bonus_hp, price, type) VALUES ("Lapte caldut", 0 , 20, 50, "Potion");
INSERT INTO Item (name, bonus_power, bonus_hp, price, type) VALUES ("Papusa Chucky", 300, 0, 500, "Throwable");

INSERT INTO Champion (name, hp, power) VALUES ("Cargus Radioactivus", 200, 50);
INSERT INTO Champion (name, hp, power) VALUES ("Yamato Elementus Ixus", 100, 80);
INSERT INTO Champion (name, hp, power) VALUES ("Temploloid Armoid", 60, 150);
INSERT INTO Champion (name, hp, power) VALUES ("Amodo Bazuka", 1, 1000);
INSERT INTO Champion (name, hp, power) VALUES ("Tankinatus Nuclearus", 500, 100);

INSERT INTO Ability (name, type, damage, healing) VALUES ("Adus coletul mai repede decat trebe", "Attack", 50, 0);
INSERT INTO Ability (name, type, damage, healing) VALUES ("Creare element nou", "Heal", 0, 60);
INSERT INTO Ability (name, type, damage, healing) VALUES ("Creare templu meditatie", "Heal", 0, 100);
INSERT INTO Ability (name, type, damage, healing) VALUES ("Rachetus subacvaticus", "Attack", 150, 0);
INSERT INTO Ability (name, type, damage, healing) VALUES ("Dezrazburdare Iminenta", "Attack", 500, 0);

INSERT INTO Monster (level, hp, power, reward, name) VALUES (3, 100, 100, 100, "Mina anti-tankinatus");
INSERT INTO Monster (level, hp, power, reward, name) VALUES (1, 20, 15, 10, "Musca Tzetze");
INSERT INTO Monster (level, hp, power, reward, name) VALUES (2, 50, 50, 60, "Costel Vulcanizare");

# INSERT INTO IU_LINK (item_id, user_id) VALUES (1,2);
# INSERT INTO IU_LINK (item_id, user_id) VALUES (1,3);
# INSERT INTO IU_LINK (item_id, user_id) VALUES (1,4);
# INSERT INTO IU_LINK (item_id, user_id) VALUES (2,1);
# INSERT INTO IU_LINK (item_id, user_id) VALUES (3,2);
# INSERT INTO IU_LINK (item_id, user_id) VALUES (3,3);

/*INSERT INTO UC_LINK (champion_id, user_id) VALUES (1,1);
INSERT INTO UC_LINK (champion_id, user_id) VALUES (1,3);
INSERT INTO UC_LINK (champion_id, user_id) VALUES (2,2);
INSERT INTO UC_LINK (champion_id, user_id) VALUES (2,4);
INSERT INTO UC_LINK (champion_id, user_id) VALUES (3,4);
INSERT INTO UC_LINK (champion_id, user_id) VALUES (5,4);*/