create table "Organisation"
(
	organisation_id serial
		constraint organisation_pk
			primary key,
	name varchar(100) not null,
	special int
);

create table "Department"
(
	department_id serial
		constraint department_pk
			primary key,
	organisation_id int not null,
	name varchar(100) not null,
	test text,
	notes text,
	location varchar(100)
);

create table "Person"
(
	person_id serial
		constraint person_pk
			primary key,
	name varchar(100),
	address_block varchar(100),
	email varchar(100)
);

create table "Special_Contact"
(
	special_contact_id serial
		constraint special_contact_pk
			primary key,
	organisation_id int not null,
	person_id int not null
);