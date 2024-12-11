--
-- PostgreSQL database dump
--

-- Dumped from database version 17.2
-- Dumped by pg_dump version 17.2

-- Started on 2024-12-09 21:11:26

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET transaction_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 4 (class 2615 OID 2200)
-- Name: public; Type: SCHEMA; Schema: -; Owner: pg_database_owner
--

CREATE SCHEMA public;


ALTER SCHEMA public OWNER TO pg_database_owner;

--
-- TOC entry 4897 (class 0 OID 0)
-- Dependencies: 4
-- Name: SCHEMA public; Type: COMMENT; Schema: -; Owner: pg_database_owner
--

COMMENT ON SCHEMA public IS 'standard public schema';


SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 217 (class 1259 OID 16408)
-- Name: produto; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.produto (
    id bigint NOT NULL,
    nome character varying(200) NOT NULL,
    quantidade integer NOT NULL,
    preco_unitario numeric(10,2) NOT NULL,
    data_cadastro timestamp without time zone
);


ALTER TABLE public.produto OWNER TO postgres;

--
-- TOC entry 218 (class 1259 OID 16411)
-- Name: produto_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.produto_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.produto_id_seq OWNER TO postgres;

--
-- TOC entry 4898 (class 0 OID 0)
-- Dependencies: 218
-- Name: produto_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.produto_id_seq OWNED BY public.produto.id;


--
-- TOC entry 4742 (class 2604 OID 16415)
-- Name: produto id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.produto ALTER COLUMN id SET DEFAULT nextval('public.produto_id_seq'::regclass);


--
-- TOC entry 4890 (class 0 OID 16408)
-- Dependencies: 217
-- Data for Name: produto; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.produto (id, nome, quantidade, preco_unitario, data_cadastro) FROM stdin;
3	RTX 3090	2	7.00	2025-02-01 12:20:50
4	RTX 3070	1	2.00	2021-02-01 12:20:50
5	RTX 2070	3	1.40	2020-02-01 12:20:50
6	RTX 2080	5	1.90	2020-02-01 11:20:20
2	RTX 4090	18	19.00	2020-02-01 00:00:00
7	Ryzen 5	1	5000.00	2024-11-30 09:29:37
8	Memoria ram 1T DDR7	1	50000.00	2029-11-30 09:29:37
9	teclado gamer	2	900.00	2029-11-30 09:29:37
10	Notebook Alien	60	15000.00	2023-11-30 09:29:37
\.


--
-- TOC entry 4899 (class 0 OID 0)
-- Dependencies: 218
-- Name: produto_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.produto_id_seq', 10, true);


--
-- TOC entry 4744 (class 2606 OID 16414)
-- Name: produto produto_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.produto
    ADD CONSTRAINT produto_pkey PRIMARY KEY (id);


-- Completed on 2024-12-09 21:11:26

--
-- PostgreSQL database dump complete
--

