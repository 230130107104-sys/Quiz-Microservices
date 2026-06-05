--
-- PostgreSQL database dump
--

\restrict CsuSdG1gNKTm6OSCyBzB94qUOdK1VK7LmWt4aO4FybSOx5yW5GQ75nEKOrCUpwe

-- Dumped from database version 18.1
-- Dumped by pg_dump version 18.1

-- Started on 2026-06-05 13:13:08

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

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 219 (class 1259 OID 49153)
-- Name: question; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.question (
    id integer NOT NULL,
    option1 character varying(255) NOT NULL,
    option2 character varying(255) NOT NULL,
    option3 character varying(255) NOT NULL,
    option4 character varying(255) NOT NULL,
    category character varying(255) NOT NULL,
    difficulty_level character varying(255) NOT NULL,
    question_title character varying(255) NOT NULL,
    right_answer character varying(255) NOT NULL,
    difficultylevel character varying(255)
);


ALTER TABLE public.question OWNER TO postgres;

--
-- TOC entry 224 (class 1259 OID 57406)
-- Name: question_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.question ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.question_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 4915 (class 0 OID 49153)
-- Dependencies: 219
-- Data for Name: question; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.question (id, option1, option2, option3, option4, category, difficulty_level, question_title, right_answer, difficultylevel) FROM stdin;
1	Programming Language	Database	Operating System	Browser	computer science	easy	What is Java?	Programming Language	\N
2	JVM	JRE	JDK	JIT	java	easy	Which component is used to compile Java code?	JDK	\N
3	.java	.class	.txt	.exe	java	easy	What is the extension of Java bytecode files?	.class	\N
4	this	super	extends	implements	java	medium	Which keyword is used for inheritance in Java?	extends	\N
5	start()	main()	run()	init()	java	easy	Which method is the entry point of a Java program?	main()	\N
6	Inheritance	Encapsulation	Polymorphism	Abstraction	java	medium	Which concept allows multiple methods with same name?	Polymorphism	\N
7	try-catch	if-else	loops	switch	java	easy	What is used to handle exceptions in Java?	try-catch	\N
8	List	Set	Map	Queue	java	medium	Which collection does not allow duplicate elements?	Set	\N
9	DELETE	DROP	TRUNCATE	REMOVE	database	easy	Which SQL command is used to remove all records from a table?	TRUNCATE	\N
10	1NF	2NF	3NF	BCNF	database	medium	Which normal form removes partial dependency?	2NF	\N
11	Hyper Text Transfer Protocol	High Transfer Text Protocol	Hyperlink Transfer Process	None	computer science	easy	What does HTTP stand for?	Hyper Text Transfer Protocol	\N
12	Stack	Queue	Tree	Graph	computer science	easy	Which data structure uses FIFO?	Queue	\N
14	implement	extends	inherits	super	Java	Easy	Which keyword is used to inherit a class in Java?	extends	\N
15	implement	extends	inherits	super	Java	Easy	Which keyword is used to inherit a class in Java?	extends	\N
16	implement	extends	inherits	super	Java	Easy	Which keyword is used to inherit a class in Java?	extends	\N
17	implement	extends	inherits	super	Java	Easy	Which keyword is used to inherit a class in Java?	extends	\N
18	public	private	protected	All of the above	Java	Medium	Which of the following are access modifiers in Java?	All of the above	\N
\.


--
-- TOC entry 4922 (class 0 OID 0)
-- Dependencies: 224
-- Name: question_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.question_id_seq', 18, true);


--
-- TOC entry 4766 (class 2606 OID 49160)
-- Name: question question_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.question
    ADD CONSTRAINT question_pkey PRIMARY KEY (id);


-- Completed on 2026-06-05 13:13:09

--
-- PostgreSQL database dump complete
--

\unrestrict CsuSdG1gNKTm6OSCyBzB94qUOdK1VK7LmWt4aO4FybSOx5yW5GQ75nEKOrCUpwe

