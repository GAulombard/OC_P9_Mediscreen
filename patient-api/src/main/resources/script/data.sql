CREATE TABLE IF NOT EXISTS patients (
                                        id BIGINT AUTO_INCREMENT NOT NULL,
                                        last_name VARCHAR(50) NOT NULL,
                                        first_name VARCHAR(50) NOT NULL,
                                        date_of_birth VARCHAR(10) NOT NULL,
                                        sex CHAR(1) NOT NULL,
                                        address VARCHAR(50) DEFAULT NULL,
                                        phone_number VARCHAR(10) DEFAULT NULL,
                                        PRIMARY KEY (id)
);

insert ignore into patients (id,last_name, first_name, date_of_birth, sex, address, phone_number) values (1,'TestNone', 'Test', '1966-12-31', 'F', '1 Brookside St', '1002223333');
insert ignore into patients (id,last_name, first_name, date_of_birth, sex, address, phone_number) values (2,'TestBorderline', 'Test', '1945-06-24', 'M', '2 High St', '2003334444');
insert ignore into patients (id,last_name, first_name, date_of_birth, sex, address, phone_number) values (3,'TestInDanger', 'Test', '2004-06-18', 'M', '3 Club Road', '3004445555');
insert ignore into patients (id,last_name, first_name, date_of_birth, sex, address, phone_number) values (4,'TestEarlyOnset', 'Test', '2002-06-28', 'F', '4 Valley Dr', '4005556666');
insert ignore into patients (id,last_name, first_name, date_of_birth, sex, address, phone_number) values (5,'Braney', 'Alena', '2021-05-24', 'F', '1 Golf Hill', '9806688114');
insert ignore into patients (id,last_name, first_name, date_of_birth, sex, address, phone_number) values (6,'Romaynes', 'Cathie', '2021-06-13', 'F', '42819 Columbus Hill', '7169836214');
insert ignore into patients (id,last_name, first_name, date_of_birth, sex, address, phone_number) values (7,'Cartner', 'Hartwell', '2021-03-12', 'M', '02 Milwaukee Pass', '8674511069');
insert ignore into patients (id,last_name, first_name, date_of_birth, sex, address, phone_number) values (8,'Balfre', 'Franzen', '2021-02-20', 'M', '65 Johnson Drive', '5564353334');
insert ignore into patients (id,last_name, first_name, date_of_birth, sex, address, phone_number) values (9,'Crenage', 'Diann', '2021-03-04', 'F', '0 7th Court', '6316721449');
insert ignore into patients (id,last_name, first_name, date_of_birth, sex, address, phone_number) values (10,'Kuschel', 'Franklin', '2021-11-27', 'M', '21362 Southridge Terrace', '6896698729');
insert ignore into patients (id,last_name, first_name, date_of_birth, sex, address, phone_number) values (11,'MacAlroy', 'Fidole', '2021-03-23', 'M', '69 Bayside Court', '3297190669');
insert ignore into patients (id,last_name, first_name, date_of_birth, sex, address, phone_number) values (12,'MacConnal', 'Bevon', '2021-08-03', 'M', '167 Rockefeller Crossing', '7731051856');
insert ignore into patients (id,last_name, first_name, date_of_birth, sex, address, phone_number) values (13,'Rankling', 'Sven', '2021-10-25', 'M', '16 Mccormick Trail', '7501350501');
insert ignore into patients (id,last_name, first_name, date_of_birth, sex, address, phone_number) values (14,'Dincey', 'Meryl', '2021-05-09', 'F', '9466 Ruskin Junction', '5031785593');
insert ignore into patients (id,last_name, first_name, date_of_birth, sex, address, phone_number) values (15,'McNulty', 'Penny', '2021-10-22', 'M', '61 Union Pass', '6282298436');
insert ignore into patients (id,last_name, first_name, date_of_birth, sex, address, phone_number) values (16,'Fluit', 'Tomas', '2021-10-11', 'M', '54 Golf Course Parkway', '3725574661');
insert ignore into patients (id,last_name, first_name, date_of_birth, sex, address, phone_number) values (17,'Sarten', 'Benni', '2021-01-15', 'F', '01 Gerald Avenue', '7909595284');
insert ignore into patients (id,last_name, first_name, date_of_birth, sex, address, phone_number) values (18,'Clapton', 'Cchaddie', '2020-12-11', 'M', '22353 Messerschmidt Drive', '4225299188');
insert ignore into patients (id,last_name, first_name, date_of_birth, sex, address, phone_number) values (19,'Zorzin', 'Hannie', '2021-09-15', 'F', '08333 Garrison Place', '4209483057');
insert ignore into patients (id,last_name, first_name, date_of_birth, sex, address, phone_number) values (20,'Prendeguest', 'Hobart', '2021-11-24', 'M', '1 Aberg Street', '2279674794');
insert ignore into patients (id,last_name, first_name, date_of_birth, sex, address, phone_number) values (21,'Adamovsky', 'Jason', '2021-10-30', 'M', '89 Sheridan Drive', '7675607132');
insert ignore into patients (id,last_name, first_name, date_of_birth, sex, address, phone_number) values (22,'Pyecroft', 'Marcella', '2021-06-27', 'F', '3 Thierer Parkway', '2253595965');
insert ignore into patients (id,last_name, first_name, date_of_birth, sex, address, phone_number) values (23,'Sudron', 'Justino', '2021-08-14', 'M', '69467 Oneill Pass', '6065520415');
insert ignore into patients (id,last_name, first_name, date_of_birth, sex, address, phone_number) values (24,'Badsworth', 'Alley', '2021-10-23', 'M', '1 Mifflin Plaza', '2907098391');
insert ignore into patients (id,last_name, first_name, date_of_birth, sex, address, phone_number) values (25,'Sambrook', 'Rochella', '2021-08-28', 'F', '9 Twin Pines Way', '5498723701');
insert ignore into patients (id,last_name, first_name, date_of_birth, sex, address, phone_number) values (26,'Ugolotti', 'Sheelagh', '2021-01-09', 'F', '16 Grim Pass', '5837732931');
insert ignore into patients (id,last_name, first_name, date_of_birth, sex, address, phone_number) values (27,'Kobpal', 'Angus', '2021-05-02', 'M', '53 Michigan Crossing', '8909765730');
insert ignore into patients (id,last_name, first_name, date_of_birth, sex, address, phone_number) values (28,'Schiersch', 'Cindra', '2021-06-26', 'F', '01203 Moland Court', '4798326513');
insert ignore into patients (id,last_name, first_name, date_of_birth, sex, address, phone_number) values (29,'Perrie', 'Boycey', '2021-12-02', 'M', '45 Corben Road', '5808415460');
insert ignore into patients (id,last_name, first_name, date_of_birth, sex, address, phone_number) values (30,'Iacomettii', 'Car', '2021-03-17', 'M', '9732 Russell Point', '1397032426');
insert ignore into patients (id,last_name, first_name, date_of_birth, sex, address, phone_number) values (31,'Pittham', 'Cathy', '2020-12-16', 'F', '5 Sycamore Street', '1973426103');
insert ignore into patients (id,last_name, first_name, date_of_birth, sex, address, phone_number) values (32,'Southwell', 'Randee', '2021-05-13', 'F', '33 Arrowood Terrace', '2863622511');
insert ignore into patients (id,last_name, first_name, date_of_birth, sex, address, phone_number) values (33,'Morrell', 'Felipe', '2021-06-12', 'M', '189 Harbort Circle', '8622737446');
insert ignore into patients (id,last_name, first_name, date_of_birth, sex, address, phone_number) values (34,'Janczyk', 'Alain', '2021-01-17', 'M', '5 Marquette Street', '3267424130');
insert ignore into patients (id,last_name, first_name, date_of_birth, sex, address, phone_number) values (35,'Mion', 'Kelley', '2021-02-05', 'F', '6 Moulton Drive', '4634570101');
insert ignore into patients (id,last_name, first_name, date_of_birth, sex, address, phone_number) values (36,'Samsworth', 'Warden', '2021-09-07', 'M', '6330 Vahlen Point', '3417099623');
insert ignore into patients (id,last_name, first_name, date_of_birth, sex, address, phone_number) values (37,'Scough', 'Ceil', '2021-04-19', 'F', '265 Westport Center', '7868770330');
insert ignore into patients (id,last_name, first_name, date_of_birth, sex, address, phone_number) values (38,'Redmond', 'Electra', '2021-05-14', 'F', '24801 Stuart Crossing', '9794291998');
insert ignore into patients (id,last_name, first_name, date_of_birth, sex, address, phone_number) values (39,'Beldam', 'Rogerio', '2021-03-07', 'M', '60 Elmside Trail', '3833317206');
insert ignore into patients (id,last_name, first_name, date_of_birth, sex, address, phone_number) values (40,'Bettenay', 'Nannie', '2021-06-14', 'F', '4754 Magdeline Parkway', '1421546218');
insert ignore into patients (id,last_name, first_name, date_of_birth, sex, address, phone_number) values (41,'Dennett', 'Torr', '2021-02-21', 'M', '11872 Maple Plaza', '3008117173');
insert ignore into patients (id,last_name, first_name, date_of_birth, sex, address, phone_number) values (42,'Torbet', 'Benyamin', '2021-09-12', 'M', '83 Elgar Terrace', '9769956943');
insert ignore into patients (id,last_name, first_name, date_of_birth, sex, address, phone_number) values (43,'Balaam', 'Garreth', '2021-09-25', 'M', '298 Parkside Court', '9219251289');
insert ignore into patients (id,last_name, first_name, date_of_birth, sex, address, phone_number) values (44,'Radin', 'Herbert', '2021-10-07', 'M', '4712 Erie Way', '3193294546');
insert ignore into patients (id,last_name, first_name, date_of_birth, sex, address, phone_number) values (45,'Leyson', 'Leena', '2021-02-21', 'F', '3778 Lillian Road', '9191909053');
insert ignore into patients (id,last_name, first_name, date_of_birth, sex, address, phone_number) values (46,'Ferens', 'Tish', '2021-06-26', 'F', '6 Annamark Court', '2748341677');
insert ignore into patients (id,last_name, first_name, date_of_birth, sex, address, phone_number) values (47,'Stocky', 'Garold', '2020-12-13', 'M', '08072 Buhler Avenue', '1945099556');
insert ignore into patients (id,last_name, first_name, date_of_birth, sex, address, phone_number) values (48,'Safe', 'Cece', '2021-01-09', 'M', '99 Oak Court', '9791338418');
insert ignore into patients (id,last_name, first_name, date_of_birth, sex, address, phone_number) values (49,'Tofful', 'Clarita', '2021-02-24', 'F', '2 Manufacturers Alley', '7296386402');
insert ignore into patients (id,last_name, first_name, date_of_birth, sex, address, phone_number) values (50,'Fright', 'Mia', '2021-01-08', 'F', '9929 8th Road', '4261325677');
insert ignore into patients (id,last_name, first_name, date_of_birth, sex, address, phone_number) values (51,'Bragg', 'Austine', '2021-07-13', 'F', '5650 Fuller Lane', '7251032407');
insert ignore into patients (id,last_name, first_name, date_of_birth, sex, address, phone_number) values (52,'Duffell', 'Kimberlyn', '2020-12-11', 'F', '721 Jenna Point', '8835001042');
insert ignore into patients (id,last_name, first_name, date_of_birth, sex, address, phone_number) values (53,'Hopkynson', 'Parsifal', '2021-09-16', 'M', '22345 Drewry Terrace', '7442214269');
insert ignore into patients (id,last_name, first_name, date_of_birth, sex, address, phone_number) values (54,'Calcraft', 'Perry', '2021-03-12', 'M', '2 Heffernan Point', '4102227364');
insert ignore into patients (id,last_name, first_name, date_of_birth, sex, address, phone_number) values (55,'Walesa', 'Garfield', '2021-03-03', 'M', '260 Steensland Parkway', '7081256174');
insert ignore into patients (id,last_name, first_name, date_of_birth, sex, address, phone_number) values (56,'Wolfit', 'Kalila', '2021-07-26', 'F', '82 Pankratz Road', '8037956958');
insert ignore into patients (id,last_name, first_name, date_of_birth, sex, address, phone_number) values (57,'Tullett', 'Betteanne', '2021-09-26', 'F', '367 Drewry Drive', '9582780584');
insert ignore into patients (id,last_name, first_name, date_of_birth, sex, address, phone_number) values (58,'Bello', 'Collette', '2021-07-05', 'F', '5852 Union Place', '4943630540');
insert ignore into patients (id,last_name, first_name, date_of_birth, sex, address, phone_number) values (59,'Sustin', 'Querida', '2021-11-03', 'F', '33634 Warner Street', '2255251027');
insert ignore into patients (id,last_name, first_name, date_of_birth, sex, address, phone_number) values (60,'Feare', 'Berri', '2021-09-13', 'F', '87724 Namekagon Drive', '9646667871');
insert ignore into patients (id,last_name, first_name, date_of_birth, sex, address, phone_number) values (61,'Beaudry', 'Jeremie', '2021-10-05', 'M', '435 Kenwood Way', '2512562079');
insert ignore into patients (id,last_name, first_name, date_of_birth, sex, address, phone_number) values (62,'Billyard', 'Ewart', '2021-01-19', 'M', '9148 Gateway Terrace', '4459651232');
insert ignore into patients (id,last_name, first_name, date_of_birth, sex, address, phone_number) values (63,'Royall', 'Emelyne', '2021-07-04', 'F', '58 Sutteridge Trail', '8043224798');
insert ignore into patients (id,last_name, first_name, date_of_birth, sex, address, phone_number) values (64,'Chatt', 'Dasha', '2021-01-16', 'F', '09 Coleman Place', '8573789286');
insert ignore into patients (id,last_name, first_name, date_of_birth, sex, address, phone_number) values (65,'Janowski', 'Jordan', '2021-01-20', 'M', '60 Portage Park', '3617646526');
insert ignore into patients (id,last_name, first_name, date_of_birth, sex, address, phone_number) values (66,'Burrett', 'Allyn', '2021-02-04', 'M', '51107 Summer Ridge Drive', '2256084441');
insert ignore into patients (id,last_name, first_name, date_of_birth, sex, address, phone_number) values (67,'Krout', 'Orsola', '2021-01-05', 'F', '724 Oak Valley Crossing', '5901776237');
insert ignore into patients (id,last_name, first_name, date_of_birth, sex, address, phone_number) values (68,'Cummungs', 'Ashly', '2021-03-02', 'F', '4360 Towne Pass', '7036272315');
insert ignore into patients (id,last_name, first_name, date_of_birth, sex, address, phone_number) values (69,'Skaife', 'Tammy', '2021-07-04', 'M', '7309 Grover Parkway', '2019522527');
insert ignore into patients (id,last_name, first_name, date_of_birth, sex, address, phone_number) values (70,'Lowde', 'Electra', '2021-02-27', 'F', '42395 Nevada Place', '9118629727');
insert ignore into patients (id,last_name, first_name, date_of_birth, sex, address, phone_number) values (71,'Lief', 'Gaylene', '2021-10-18', 'F', '23 Fulton Lane', '4474408945');
insert ignore into patients (id,last_name, first_name, date_of_birth, sex, address, phone_number) values (72,'Colaco', 'Gwynne', '2021-05-29', 'F', '157 Thierer Alley', '9792950267');
insert ignore into patients (id,last_name, first_name, date_of_birth, sex, address, phone_number) values (73,'Dovington', 'Darb', '2021-07-24', 'F', '01610 Sunnyside Alley', '8145123974');
insert ignore into patients (id,last_name, first_name, date_of_birth, sex, address, phone_number) values (74,'Petrescu', 'Lonnie', '2021-10-10', 'M', '06 Raven Crossing', '9891591393');
insert ignore into patients (id,last_name, first_name, date_of_birth, sex, address, phone_number) values (75,'Alessandone', 'Mil', '2021-04-10', 'F', '1652 Golf Road', '1675415563');
insert ignore into patients (id,last_name, first_name, date_of_birth, sex, address, phone_number) values (76,'Kimmince', 'Melisse', '2021-01-22', 'F', '97 Lyons Trail', '5619063157');
insert ignore into patients (id,last_name, first_name, date_of_birth, sex, address, phone_number) values (77,'Beavon', 'Roseann', '2021-04-08', 'F', '85 Arrowood Hill', '3977098202');
insert ignore into patients (id,last_name, first_name, date_of_birth, sex, address, phone_number) values (78,'Cockhill', 'Vanya', '2021-01-07', 'F', '36 Sullivan Avenue', '7931832498');
insert ignore into patients (id,last_name, first_name, date_of_birth, sex, address, phone_number) values (79,'Norewood', 'Tadd', '2021-02-20', 'M', '78749 Schurz Lane', '9939624711');
insert ignore into patients (id,last_name, first_name, date_of_birth, sex, address, phone_number) values (80,'Abercrombie', 'Roarke', '2021-06-21', 'M', '54 Forest Lane', '1615145842');
insert ignore into patients (id,last_name, first_name, date_of_birth, sex, address, phone_number) values (81,'Hazelgreave', 'Harry', '2021-09-24', 'M', '8300 Kropf Crossing', '8004962224');
insert ignore into patients (id,last_name, first_name, date_of_birth, sex, address, phone_number) values (82,'Jeffels', 'Arly', '2021-02-04', 'F', '0 Fairfield Place', '7669891698');
insert ignore into patients (id,last_name, first_name, date_of_birth, sex, address, phone_number) values (83,'Brumbie', 'Felix', '2021-01-09', 'M', '338 Pleasure Terrace', '3504640918');
insert ignore into patients (id,last_name, first_name, date_of_birth, sex, address, phone_number) values (84,'Cahalan', 'Annabella', '2021-04-05', 'F', '545 Grasskamp Point', '1283763769');
insert ignore into patients (id,last_name, first_name, date_of_birth, sex, address, phone_number) values (85,'Titcombe', 'Archibaldo', '2021-07-11', 'M', '67494 Spaight Circle', '8241557181');
insert ignore into patients (id,last_name, first_name, date_of_birth, sex, address, phone_number) values (86,'O''Leahy', 'Lani', '2021-10-24', 'F', '02 Independence Place', '1983414764');
insert ignore into patients (id,last_name, first_name, date_of_birth, sex, address, phone_number) values (87,'Schutt', 'Faythe', '2021-06-25', 'F', '2585 Mallory Avenue', '5731504441');
insert ignore into patients (id,last_name, first_name, date_of_birth, sex, address, phone_number) values (88,'Hoggetts', 'Livy', '2021-02-15', 'F', '918 Washington Pass', '6028597249');
insert ignore into patients (id,last_name, first_name, date_of_birth, sex, address, phone_number) values (89,'Robers', 'Hobie', '2021-03-10', 'M', '99290 Dottie Park', '8563747914');
insert ignore into patients (id,last_name, first_name, date_of_birth, sex, address, phone_number) values (90,'Durbyn', 'Bary', '2021-09-27', 'M', '98 Eagle Crest Lane', '9593177510');
insert ignore into patients (id,last_name, first_name, date_of_birth, sex, address, phone_number) values (91,'Andreix', 'Daisy', '2021-06-29', 'F', '892 Dixon Hill', '2344806463');
insert ignore into patients (id,last_name, first_name, date_of_birth, sex, address, phone_number) values (92,'Nana', 'Vittorio', '2021-01-10', 'M', '046 Calypso Junction', '1746381979');
insert ignore into patients (id,last_name, first_name, date_of_birth, sex, address, phone_number) values (93,'Mitie', 'Kelsi', '2021-09-16', 'F', '2 Muir Trail', '7635388797');
insert ignore into patients (id,last_name, first_name, date_of_birth, sex, address, phone_number) values (94,'Birth', 'Nikolas', '2021-04-14', 'M', '64 Eliot Street', '4746843780');
insert ignore into patients (id,last_name, first_name, date_of_birth, sex, address, phone_number) values (95,'Rayburn', 'Deirdre', '2021-01-30', 'F', '3286 Mandrake Circle', '2751979893');
insert ignore into patients (id,last_name, first_name, date_of_birth, sex, address, phone_number) values (96,'Gebuhr', 'Hunfredo', '2021-08-21', 'M', '44988 East Avenue', '4139357454');
insert ignore into patients (id,last_name, first_name, date_of_birth, sex, address, phone_number) values (97,'McOmish', 'Zondra', '2021-08-15', 'F', '320 Green Ridge Trail', '9082585176');
insert ignore into patients (id,last_name, first_name, date_of_birth, sex, address, phone_number) values (98,'Shatford', 'Julianna', '2021-03-10', 'F', '1 Veith Way', '7631585511');
insert ignore into patients (id,last_name, first_name, date_of_birth, sex, address, phone_number) values (99,'Strothers', 'Ethan', '2020-12-26', 'M', '96 Londonderry Way', '8002688182');
insert ignore into patients (id,last_name, first_name, date_of_birth, sex, address, phone_number) values (100,'Harrower', 'Torrence', '2021-07-07', 'M', '56 Sunnyside Center', '5174044014');

