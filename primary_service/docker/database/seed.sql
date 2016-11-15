--
-- PostgreSQL database dump
--

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;

--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


--
-- Name: pgcrypto; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS pgcrypto WITH SCHEMA public;

--
-- Name: EXTENSION pgcrypto; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION pgcrypto IS 'cryptographic functions';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

CREATE TABLE primary_resource (
    id integer NOT NULL,
    attribute_one character varying(250),
    attribute_two character varying(250),
    date_created timestamp without time zone,
    date_modified timestamp without time zone
);

CREATE SEQUENCE primary_resource_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER TABLE primary_resource OWNER TO primary_user;

ALTER TABLE ONLY primary_resource ALTER COLUMN id SET DEFAULT nextval('primary_resource_id_seq'::regclass);

COPY primary_resource (id, attribute_one, attribute_two, date_created, date_modified) FROM stdin;
1	entity one attribute one	entity one attribute two	2016-11-15 00:00:00.000	2016-11-15 00:00:00.000
2	entity two attribute one	entity two attribute two	2016-11-15 00:00:00.000	2016-11-15 00:00:00.000
\.


