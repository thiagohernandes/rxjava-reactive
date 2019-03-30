CREATE DATABASE dbreative
  WITH OWNER = postgres
       ENCODING = 'UTF8'
       TABLESPACE = pg_default
       LC_COLLATE = 'Portuguese_Brazil.1252'
       LC_CTYPE = 'Portuguese_Brazil.1252'
       CONNECTION LIMIT = -1;

CREATE SEQUENCE public.funcionario_id_seq
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 12000000000
  START 1
  CACHE 0;
ALTER TABLE public.funcionario_id_seq
  OWNER TO postgres;

CREATE TABLE public.funcionario
(
  id integer NOT NULL DEFAULT nextval('funcionario_id_seq'::regclass),
  nome character varying(80) NOT NULL,
  salario numeric(10,2) NOT NULL
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.funcionario
  OWNER TO postgres;
