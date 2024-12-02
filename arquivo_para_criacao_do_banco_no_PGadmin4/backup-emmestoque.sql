--
-- PostgreSQL database cluster dump
--

-- Started on 2024-12-02 13:30:55

SET default_transaction_read_only = off;

SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;

--
-- Roles
--

CREATE ROLE postgres;
ALTER ROLE postgres WITH SUPERUSER INHERIT CREATEROLE CREATEDB LOGIN REPLICATION BYPASSRLS PASSWORD 'SCRAM-SHA-256$4096:0juseM8n5iEdmliGOwI/RQ==$UYSN9/JghmPkWn7MHlTTm6anLko3IY0K55kgwHQq0lM=:yVKpdSZV7w1Jij5MAsicCDshsHUFrg289fqdUyUdO44=';

--
-- User Configurations
--








-- Completed on 2024-12-02 13:30:56

--
-- PostgreSQL database cluster dump complete
--

