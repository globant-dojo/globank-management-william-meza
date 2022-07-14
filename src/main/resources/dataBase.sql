-- DROP SCHEMA public;

CREATE SCHEMA public AUTHORIZATION postgres;

COMMENT ON SCHEMA public IS 'standard public schema';
-- public.account definition

-- Drop table

-- DROP TABLE public.account;

CREATE TABLE public.account (
	uuid_account uuid NOT NULL,
	"type" varchar(1) NOT NULL,
	balance numeric(10, 2) NULL,
	status varchar(1) NULL,
	creation_date timestamp NULL,
	creation_user varchar(255) NULL,
	modification_date timestamp NULL,
	modification_user varchar(255) NULL,
	id_account varchar(20) NULL,
	CONSTRAINT account_pk PRIMARY KEY (uuid_account)
);


-- public.customer definition

-- Drop table

-- DROP TABLE public.customer;

CREATE TABLE public.customer (
	uuid_customer uuid NOT NULL,
	"password" varchar(50) NULL,
	status varchar(1) NULL,
	"name" varchar(100) NULL,
	sex varchar(1) NULL,
	age varchar(3) NULL,
	identification varchar(20) NULL,
	address varchar(100) NULL,
	phone varchar(15) NULL,
	CONSTRAINT customer_pk PRIMARY KEY (uuid_customer)
);


-- public.journal definition

-- Drop table

-- DROP TABLE public.journal;

CREATE TABLE public.journal (
	uuid_journal uuid NOT NULL,
	creation_date date NULL,
	"type" varchar(1) NULL,
	amount numeric(10, 2) NULL,
	balance numeric(10, 2) NULL,
	uuid_account uuid NULL,
	CONSTRAINT journal_pk PRIMARY KEY (uuid_journal),
	CONSTRAINT journal_fk FOREIGN KEY (uuid_account) REFERENCES public.account(uuid_account)
);
