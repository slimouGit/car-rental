create table account (id integer not null auto_increment, customer integer not null, primary key (id)) engine=InnoDB
create table adress (id integer not null auto_increment, housenumber varchar(255), location varchar(255), street varchar(255), zipcode integer, primary key (id)) engine=InnoDB
create table car (id integer not null auto_increment, engine varchar(255), fuelstatus double precision, horsepower integer, licence_number varchar(255), mileage double precision, model varchar(255), registration_date date, seat integer, fleet_id integer, primary key (id)) engine=InnoDB
create table clientele (id integer not null auto_increment, office integer not null, primary key (id)) engine=InnoDB
create table communication (id integer not null auto_increment, email varchar(255), phone varchar(255), primary key (id)) engine=InnoDB
create table customer (id integer not null auto_increment, entrydate date, clientele_id integer, person integer not null, primary key (id)) engine=InnoDB
create table drive (id integer not null auto_increment, completion boolean default false, consumption double precision, distance double precision, end datetime, start datetime, primary key (id)) engine=InnoDB
create table employee (id integer not null auto_increment, date_of_employment date, role varchar(255), salary double precision, person integer not null, staff_id integer, primary key (id)) engine=InnoDB
create table fleet (id integer not null auto_increment, office integer not null, primary key (id)) engine=InnoDB
create table invoice (id integer not null auto_increment, amount double precision, marked_date date, marked_out boolean default false, settled_date date, settled_in boolean default false, primary key (id)) engine=InnoDB
create table office (id integer not null auto_increment, name varchar(255), primary key (id)) engine=InnoDB
create table office_data (id integer not null auto_increment, adress integer not null, communication integer not null, office integer not null, primary key (id)) engine=InnoDB
create table orderbook (id integer not null auto_increment, employee integer not null, primary key (id)) engine=InnoDB
create table person (id integer not null auto_increment, forname varchar(255), lastname varchar(255), primary key (id)) engine=InnoDB
create table person_data (id integer not null auto_increment, adress integer not null, communication integer not null, person integer not null, primary key (id)) engine=InnoDB
create table reservation (id integer not null auto_increment, rental_end date, rental_start date, account_id integer, car integer not null, drive integer not null, invoice integer not null, orderbook_id integer, primary key (id)) engine=InnoDB
create table staff (id integer not null auto_increment, office integer not null, primary key (id)) engine=InnoDB
alter table account add constraint UK_kk7112ff7gilh9y2nb0nuupr unique (customer)
alter table clientele add constraint UK_fqgo2nj0bjnl5xcjk44s3qlvy unique (office)
alter table customer add constraint UK_6lnkebo3ag84hrlnrjjx85agp unique (person)
alter table employee add constraint UK_aj5wplw5nam9r5q7b79bxqpu9 unique (person)
alter table fleet add constraint UK_6371k3n8xue02lx03a99ihk11 unique (office)
alter table office_data add constraint UK_tbg1dayiapxsx0vudjn2qrwgm unique (adress)
alter table office_data add constraint UK_8d6s9w3tu46pt6l4oxac378p6 unique (communication)
alter table office_data add constraint UK_sryl4pucpjrul4dndle557ynh unique (office)
alter table orderbook add constraint UK_9wpeycakhohik20lnonn08am4 unique (employee)
alter table person_data add constraint UK_3ve4f34avmvam4lqwpcjhf103 unique (adress)
alter table person_data add constraint UK_a96fi27mj4guiwfu102cl9bsa unique (communication)
alter table person_data add constraint UK_b1hh0itnrxrbbxh43f13il2u3 unique (person)
alter table reservation add constraint UK_34i7y7vrqhha9jopqxjkpabuw unique (car)
alter table reservation add constraint UK_qsok73rs2ixylvnkc34seo5pn unique (drive)
alter table reservation add constraint UK_6vogv9d4yufwsmrp8eeh57tbt unique (invoice)
alter table reservation add constraint UK_thl315lfs4hbfg468pni4bovg unique (account_id)
alter table reservation add constraint UK_luacm7r1qktyw6l0obtjeuunu unique (orderbook_id)
alter table staff add constraint UK_e5s1nysrsiri3ib3gwccsfxjn unique (office)
alter table account add constraint FK8b6nou36bcycey2spg7xer75w foreign key (customer) references customer (id)
alter table car add constraint FKomwkr4vgkdgcn65emgq5j84t5 foreign key (fleet_id) references fleet (id)
alter table clientele add constraint FKr8og6f2wgij4fxabjn17ryk7u foreign key (office) references office (id)
alter table customer add constraint FKrvovsod480rjiagntdmd2bann foreign key (clientele_id) references clientele (id)
alter table customer add constraint FKihbint30ismdy1hy7or8yx221 foreign key (person) references person (id)
alter table employee add constraint FKherextttrn6l7tlg2qsf51dut foreign key (person) references person (id)
alter table employee add constraint FK259rb4jv6gollge94ui9jf89b foreign key (staff_id) references staff (id)
alter table fleet add constraint FKascyyw408gyx9wo3qr47rhkif foreign key (office) references office (id)
alter table office_data add constraint FKoliqkvuahhc2u8yyw194f8rhh foreign key (adress) references adress (id)
alter table office_data add constraint FKc1k2lfjjwk34mqrqoxuttx0po foreign key (communication) references communication (id)
alter table office_data add constraint FKsjwy397xfgqnptcp79ipf7v13 foreign key (office) references office (id)
alter table orderbook add constraint FKltnk3cc2x3ws0atx0b84ac7by foreign key (employee) references employee (id)
alter table person_data add constraint FKst3j5c9p4uv00eobsbeveib4u foreign key (adress) references adress (id)
alter table person_data add constraint FKengxul5tkwmwnr3gmidynqqa3 foreign key (communication) references communication (id)
alter table person_data add constraint FKccrlmut65tk2o0e9ynuhsievn foreign key (person) references person (id)
alter table reservation add constraint FKpuht7aanh4i4be0i58jofg56b foreign key (account_id) references account (id)
alter table reservation add constraint FKqrw270imhbcxr1uaspnkaphf8 foreign key (car) references car (id)
alter table reservation add constraint FKt5k5ij6urrg3stvg690qccjvn foreign key (drive) references drive (id)
alter table reservation add constraint FK88s1k06icb6vm26rguqwxj22a foreign key (invoice) references invoice (id)
alter table reservation add constraint FK2vuvinm7hq8bo6r7uambwkuyv foreign key (orderbook_id) references orderbook (id)
alter table staff add constraint FKppmuw43cr8mmiiavjpv9tej15 foreign key (office) references office (id)
