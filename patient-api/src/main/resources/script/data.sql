CREATE DATABASE IF NOT EXISTS mediscreen_db;

USE mediscreen_db;

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

insert into patients (last_name, first_name, date_of_birth, sex, address, phone_number) values ('Sauvain', 'Gwenora', '2021-01-14', 'F', '33 Commercial Lane', '6594182516');
insert into patients (last_name, first_name, date_of_birth, sex, address, phone_number) values ('Braney', 'Alena', '2021-05-24', 'F', '1 Golf Hill', '9806688114');
insert into patients (last_name, first_name, date_of_birth, sex, address, phone_number) values ('Ellph', 'Russ', '2021-04-05', 'M', '0002 Moulton Pass', '1625035718');
insert into patients (last_name, first_name, date_of_birth, sex, address, phone_number) values ('Rodell', 'Bernadette', '2021-01-23', 'F', '484 High Crossing Alley', '2325368619');
insert into patients (last_name, first_name, date_of_birth, sex, address, phone_number) values ('Sellar', 'Debi', '2021-06-06', 'F', '0148 Blaine Road', '8142768524');
insert into patients (last_name, first_name, date_of_birth, sex, address, phone_number) values ('Romaynes', 'Cathie', '2021-06-13', 'F', '42819 Columbus Hill', '7169836214');
insert into patients (last_name, first_name, date_of_birth, sex, address, phone_number) values ('Cartner', 'Hartwell', '2021-03-12', 'M', '02 Milwaukee Pass', '8674511069');
insert into patients (last_name, first_name, date_of_birth, sex, address, phone_number) values ('Balfre', 'Franzen', '2021-02-20', 'M', '65 Johnson Drive', '5564353334');
insert into patients (last_name, first_name, date_of_birth, sex, address, phone_number) values ('Crenage', 'Diann', '2021-03-04', 'F', '0 7th Court', '6316721449');
insert into patients (last_name, first_name, date_of_birth, sex, address, phone_number) values ('Kuschel', 'Franklin', '2021-11-27', 'M', '21362 Southridge Terrace', '6896698729');
insert into patients (last_name, first_name, date_of_birth, sex, address, phone_number) values ('MacAlroy', 'Fidole', '2021-03-23', 'M', '69 Bayside Court', '3297190669');
insert into patients (last_name, first_name, date_of_birth, sex, address, phone_number) values ('MacConnal', 'Bevon', '2021-08-03', 'M', '167 Rockefeller Crossing', '7731051856');
insert into patients (last_name, first_name, date_of_birth, sex, address, phone_number) values ('Rankling', 'Sven', '2021-10-25', 'M', '16 Mccormick Trail', '7501350501');
insert into patients (last_name, first_name, date_of_birth, sex, address, phone_number) values ('Dincey', 'Meryl', '2021-05-09', 'F', '9466 Ruskin Junction', '5031785593');
insert into patients (last_name, first_name, date_of_birth, sex, address, phone_number) values ('McNulty', 'Penny', '2021-10-22', 'M', '61 Union Pass', '6282298436');
insert into patients (last_name, first_name, date_of_birth, sex, address, phone_number) values ('Fluit', 'Tomas', '2021-10-11', 'M', '54 Golf Course Parkway', '3725574661');
insert into patients (last_name, first_name, date_of_birth, sex, address, phone_number) values ('Sarten', 'Benni', '2021-01-15', 'F', '01 Gerald Avenue', '7909595284');
insert into patients (last_name, first_name, date_of_birth, sex, address, phone_number) values ('Clapton', 'Cchaddie', '2020-12-11', 'M', '22353 Messerschmidt Drive', '4225299188');
insert into patients (last_name, first_name, date_of_birth, sex, address, phone_number) values ('Zorzin', 'Hannie', '2021-09-15', 'F', '08333 Garrison Place', '4209483057');
insert into patients (last_name, first_name, date_of_birth, sex, address, phone_number) values ('Prendeguest', 'Hobart', '2021-11-24', 'M', '1 Aberg Street', '2279674794');
insert into patients (last_name, first_name, date_of_birth, sex, address, phone_number) values ('Adamovsky', 'Jason', '2021-10-30', 'M', '89 Sheridan Drive', '7675607132');
insert into patients (last_name, first_name, date_of_birth, sex, address, phone_number) values ('Pyecroft', 'Marcella', '2021-06-27', 'F', '3 Thierer Parkway', '2253595965');
insert into patients (last_name, first_name, date_of_birth, sex, address, phone_number) values ('Sudron', 'Justino', '2021-08-14', 'M', '69467 Oneill Pass', '6065520415');
insert into patients (last_name, first_name, date_of_birth, sex, address, phone_number) values ('Badsworth', 'Alley', '2021-10-23', 'M', '1 Mifflin Plaza', '2907098391');
insert into patients (last_name, first_name, date_of_birth, sex, address, phone_number) values ('Sambrook', 'Rochella', '2021-08-28', 'F', '9 Twin Pines Way', '5498723701');
insert into patients (last_name, first_name, date_of_birth, sex, address, phone_number) values ('Ugolotti', 'Sheelagh', '2021-01-09', 'F', '16 Grim Pass', '5837732931');
insert into patients (last_name, first_name, date_of_birth, sex, address, phone_number) values ('Kobpal', 'Angus', '2021-05-02', 'M', '53 Michigan Crossing', '8909765730');
insert into patients (last_name, first_name, date_of_birth, sex, address, phone_number) values ('Schiersch', 'Cindra', '2021-06-26', 'F', '01203 Moland Court', '4798326513');
insert into patients (last_name, first_name, date_of_birth, sex, address, phone_number) values ('Perrie', 'Boycey', '2021-12-02', 'M', '45 Corben Road', '5808415460');
insert into patients (last_name, first_name, date_of_birth, sex, address, phone_number) values ('Iacomettii', 'Car', '2021-03-17', 'M', '9732 Russell Point', '1397032426');
insert into patients (last_name, first_name, date_of_birth, sex, address, phone_number) values ('Pittham', 'Cathy', '2020-12-16', 'F', '5 Sycamore Street', '1973426103');
insert into patients (last_name, first_name, date_of_birth, sex, address, phone_number) values ('Southwell', 'Randee', '2021-05-13', 'F', '33 Arrowood Terrace', '2863622511');
insert into patients (last_name, first_name, date_of_birth, sex, address, phone_number) values ('Morrell', 'Felipe', '2021-06-12', 'M', '189 Harbort Circle', '8622737446');
insert into patients (last_name, first_name, date_of_birth, sex, address, phone_number) values ('Janczyk', 'Alain', '2021-01-17', 'M', '5 Marquette Street', '3267424130');
insert into patients (last_name, first_name, date_of_birth, sex, address, phone_number) values ('Mion', 'Kelley', '2021-02-05', 'F', '6 Moulton Drive', '4634570101');
insert into patients (last_name, first_name, date_of_birth, sex, address, phone_number) values ('Samsworth', 'Warden', '2021-09-07', 'M', '6330 Vahlen Point', '3417099623');
insert into patients (last_name, first_name, date_of_birth, sex, address, phone_number) values ('Scough', 'Ceil', '2021-04-19', 'F', '265 Westport Center', '7868770330');
insert into patients (last_name, first_name, date_of_birth, sex, address, phone_number) values ('Redmond', 'Electra', '2021-05-14', 'F', '24801 Stuart Crossing', '9794291998');
insert into patients (last_name, first_name, date_of_birth, sex, address, phone_number) values ('Beldam', 'Rogerio', '2021-03-07', 'M', '60 Elmside Trail', '3833317206');
insert into patients (last_name, first_name, date_of_birth, sex, address, phone_number) values ('Bettenay', 'Nannie', '2021-06-14', 'F', '4754 Magdeline Parkway', '1421546218');
insert into patients (last_name, first_name, date_of_birth, sex, address, phone_number) values ('Dennett', 'Torr', '2021-02-21', 'M', '11872 Maple Plaza', '3008117173');
insert into patients (last_name, first_name, date_of_birth, sex, address, phone_number) values ('Torbet', 'Benyamin', '2021-09-12', 'M', '83 Elgar Terrace', '9769956943');
insert into patients (last_name, first_name, date_of_birth, sex, address, phone_number) values ('Balaam', 'Garreth', '2021-09-25', 'M', '298 Parkside Court', '9219251289');
insert into patients (last_name, first_name, date_of_birth, sex, address, phone_number) values ('Radin', 'Herbert', '2021-10-07', 'M', '4712 Erie Way', '3193294546');
insert into patients (last_name, first_name, date_of_birth, sex, address, phone_number) values ('Leyson', 'Leena', '2021-02-21', 'F', '3778 Lillian Road', '9191909053');
insert into patients (last_name, first_name, date_of_birth, sex, address, phone_number) values ('Ferens', 'Tish', '2021-06-26', 'F', '6 Annamark Court', '2748341677');
insert into patients (last_name, first_name, date_of_birth, sex, address, phone_number) values ('Stocky', 'Garold', '2020-12-13', 'M', '08072 Buhler Avenue', '1945099556');
insert into patients (last_name, first_name, date_of_birth, sex, address, phone_number) values ('Safe', 'Cece', '2021-01-09', 'M', '99 Oak Court', '9791338418');
insert into patients (last_name, first_name, date_of_birth, sex, address, phone_number) values ('Tofful', 'Clarita', '2021-02-24', 'F', '2 Manufacturers Alley', '7296386402');
insert into patients (last_name, first_name, date_of_birth, sex, address, phone_number) values ('Fright', 'Mia', '2021-01-08', 'F', '9929 8th Road', '4261325677');
insert into patients (last_name, first_name, date_of_birth, sex, address, phone_number) values ('Bragg', 'Austine', '2021-07-13', 'F', '5650 Fuller Lane', '7251032407');
insert into patients (last_name, first_name, date_of_birth, sex, address, phone_number) values ('Duffell', 'Kimberlyn', '2020-12-11', 'F', '721 Jenna Point', '8835001042');
insert into patients (last_name, first_name, date_of_birth, sex, address, phone_number) values ('Hopkynson', 'Parsifal', '2021-09-16', 'M', '22345 Drewry Terrace', '7442214269');
insert into patients (last_name, first_name, date_of_birth, sex, address, phone_number) values ('Calcraft', 'Perry', '2021-03-12', 'M', '2 Heffernan Point', '4102227364');
insert into patients (last_name, first_name, date_of_birth, sex, address, phone_number) values ('Walesa', 'Garfield', '2021-03-03', 'M', '260 Steensland Parkway', '7081256174');
insert into patients (last_name, first_name, date_of_birth, sex, address, phone_number) values ('Wolfit', 'Kalila', '2021-07-26', 'F', '82 Pankratz Road', '8037956958');
insert into patients (last_name, first_name, date_of_birth, sex, address, phone_number) values ('Tullett', 'Betteanne', '2021-09-26', 'F', '367 Drewry Drive', '9582780584');
insert into patients (last_name, first_name, date_of_birth, sex, address, phone_number) values ('Bello', 'Collette', '2021-07-05', 'F', '5852 Union Place', '4943630540');
insert into patients (last_name, first_name, date_of_birth, sex, address, phone_number) values ('Sustin', 'Querida', '2021-11-03', 'F', '33634 Warner Street', '2255251027');
insert into patients (last_name, first_name, date_of_birth, sex, address, phone_number) values ('Feare', 'Berri', '2021-09-13', 'F', '87724 Namekagon Drive', '9646667871');
insert into patients (last_name, first_name, date_of_birth, sex, address, phone_number) values ('Beaudry', 'Jeremie', '2021-10-05', 'M', '435 Kenwood Way', '2512562079');
insert into patients (last_name, first_name, date_of_birth, sex, address, phone_number) values ('Billyard', 'Ewart', '2021-01-19', 'M', '9148 Gateway Terrace', '4459651232');
insert into patients (last_name, first_name, date_of_birth, sex, address, phone_number) values ('Royall', 'Emelyne', '2021-07-04', 'F', '58 Sutteridge Trail', '8043224798');
insert into patients (last_name, first_name, date_of_birth, sex, address, phone_number) values ('Chatt', 'Dasha', '2021-01-16', 'F', '09 Coleman Place', '8573789286');
insert into patients (last_name, first_name, date_of_birth, sex, address, phone_number) values ('Janowski', 'Jordan', '2021-01-20', 'M', '60 Portage Park', '3617646526');
insert into patients (last_name, first_name, date_of_birth, sex, address, phone_number) values ('Burrett', 'Allyn', '2021-02-04', 'M', '51107 Summer Ridge Drive', '2256084441');
insert into patients (last_name, first_name, date_of_birth, sex, address, phone_number) values ('Krout', 'Orsola', '2021-01-05', 'F', '724 Oak Valley Crossing', '5901776237');
insert into patients (last_name, first_name, date_of_birth, sex, address, phone_number) values ('Cummungs', 'Ashly', '2021-03-02', 'F', '4360 Towne Pass', '7036272315');
insert into patients (last_name, first_name, date_of_birth, sex, address, phone_number) values ('Skaife', 'Tammy', '2021-07-04', 'M', '7309 Grover Parkway', '2019522527');
insert into patients (last_name, first_name, date_of_birth, sex, address, phone_number) values ('Lowde', 'Electra', '2021-02-27', 'F', '42395 Nevada Place', '9118629727');
insert into patients (last_name, first_name, date_of_birth, sex, address, phone_number) values ('Lief', 'Gaylene', '2021-10-18', 'F', '23 Fulton Lane', '4474408945');
insert into patients (last_name, first_name, date_of_birth, sex, address, phone_number) values ('Colaco', 'Gwynne', '2021-05-29', 'F', '157 Thierer Alley', '9792950267');
insert into patients (last_name, first_name, date_of_birth, sex, address, phone_number) values ('Dovington', 'Darb', '2021-07-24', 'F', '01610 Sunnyside Alley', '8145123974');
insert into patients (last_name, first_name, date_of_birth, sex, address, phone_number) values ('Petrescu', 'Lonnie', '2021-10-10', 'M', '06 Raven Crossing', '9891591393');
insert into patients (last_name, first_name, date_of_birth, sex, address, phone_number) values ('Alessandone', 'Mil', '2021-04-10', 'F', '1652 Golf Road', '1675415563');
insert into patients (last_name, first_name, date_of_birth, sex, address, phone_number) values ('Kimmince', 'Melisse', '2021-01-22', 'F', '97 Lyons Trail', '5619063157');
insert into patients (last_name, first_name, date_of_birth, sex, address, phone_number) values ('Beavon', 'Roseann', '2021-04-08', 'F', '85 Arrowood Hill', '3977098202');
insert into patients (last_name, first_name, date_of_birth, sex, address, phone_number) values ('Cockhill', 'Vanya', '2021-01-07', 'F', '36 Sullivan Avenue', '7931832498');
insert into patients (last_name, first_name, date_of_birth, sex, address, phone_number) values ('Norewood', 'Tadd', '2021-02-20', 'M', '78749 Schurz Lane', '9939624711');
insert into patients (last_name, first_name, date_of_birth, sex, address, phone_number) values ('Abercrombie', 'Roarke', '2021-06-21', 'M', '54 Forest Lane', '1615145842');
insert into patients (last_name, first_name, date_of_birth, sex, address, phone_number) values ('Hazelgreave', 'Harry', '2021-09-24', 'M', '8300 Kropf Crossing', '8004962224');
insert into patients (last_name, first_name, date_of_birth, sex, address, phone_number) values ('Jeffels', 'Arly', '2021-02-04', 'F', '0 Fairfield Place', '7669891698');
insert into patients (last_name, first_name, date_of_birth, sex, address, phone_number) values ('Brumbie', 'Felix', '2021-01-09', 'M', '338 Pleasure Terrace', '3504640918');
insert into patients (last_name, first_name, date_of_birth, sex, address, phone_number) values ('Cahalan', 'Annabella', '2021-04-05', 'F', '545 Grasskamp Point', '1283763769');
insert into patients (last_name, first_name, date_of_birth, sex, address, phone_number) values ('Titcombe', 'Archibaldo', '2021-07-11', 'M', '67494 Spaight Circle', '8241557181');
insert into patients (last_name, first_name, date_of_birth, sex, address, phone_number) values ('O''Leahy', 'Lani', '2021-10-24', 'F', '02 Independence Place', '1983414764');
insert into patients (last_name, first_name, date_of_birth, sex, address, phone_number) values ('Schutt', 'Faythe', '2021-06-25', 'F', '2585 Mallory Avenue', '5731504441');
insert into patients (last_name, first_name, date_of_birth, sex, address, phone_number) values ('Hoggetts', 'Livy', '2021-02-15', 'F', '918 Washington Pass', '6028597249');
insert into patients (last_name, first_name, date_of_birth, sex, address, phone_number) values ('Robers', 'Hobie', '2021-03-10', 'M', '99290 Dottie Park', '8563747914');
insert into patients (last_name, first_name, date_of_birth, sex, address, phone_number) values ('Durbyn', 'Bary', '2021-09-27', 'M', '98 Eagle Crest Lane', '9593177510');
insert into patients (last_name, first_name, date_of_birth, sex, address, phone_number) values ('Andreix', 'Daisy', '2021-06-29', 'F', '892 Dixon Hill', '2344806463');
insert into patients (last_name, first_name, date_of_birth, sex, address, phone_number) values ('Nana', 'Vittorio', '2021-01-10', 'M', '046 Calypso Junction', '1746381979');
insert into patients (last_name, first_name, date_of_birth, sex, address, phone_number) values ('Mitie', 'Kelsi', '2021-09-16', 'F', '2 Muir Trail', '7635388797');
insert into patients (last_name, first_name, date_of_birth, sex, address, phone_number) values ('Birth', 'Nikolas', '2021-04-14', 'M', '64 Eliot Street', '4746843780');
insert into patients (last_name, first_name, date_of_birth, sex, address, phone_number) values ('Rayburn', 'Deirdre', '2021-01-30', 'F', '3286 Mandrake Circle', '2751979893');
insert into patients (last_name, first_name, date_of_birth, sex, address, phone_number) values ('Gebuhr', 'Hunfredo', '2021-08-21', 'M', '44988 East Avenue', '4139357454');
insert into patients (last_name, first_name, date_of_birth, sex, address, phone_number) values ('McOmish', 'Zondra', '2021-08-15', 'F', '320 Green Ridge Trail', '9082585176');
insert into patients (last_name, first_name, date_of_birth, sex, address, phone_number) values ('Shatford', 'Julianna', '2021-03-10', 'F', '1 Veith Way', '7631585511');
insert into patients (last_name, first_name, date_of_birth, sex, address, phone_number) values ('Strothers', 'Ethan', '2020-12-26', 'M', '96 Londonderry Way', '8002688182');
insert into patients (last_name, first_name, date_of_birth, sex, address, phone_number) values ('Harrower', 'Torrence', '2021-07-07', 'M', '56 Sunnyside Center', '5174044014');

