CREATE TYPE public.event_status AS ENUM('CANCELLED','IN_PROGRESS', 'RESERVATION','AUTHENTICATION'); -- Reservation, Authentication
CREATE TYPE public.technical_faults_status AS ENUM('REPORTED','IN_PROGRESS','SOLVED');
CREATE TYPE public.events_has_clients_roles AS ENUM('Organizer', 'Ticket_Seller');

CREATE SEQUENCE IF NOT EXISTS id_seq
AS BIGINT
INCREMENT BY 1
START WITH 10000;

CREATE TABLE IF NOT EXISTS public.Clients (
  ID BIGINT NOT NULL DEFAULT nextval('id_seq') PRIMARY KEY,
  email VARCHAR(45) NOT NULL UNIQUE,
  first_name VARCHAR(45) NOT NULL,
  last_name VARCHAR(45) NOT NULL,
  phone_number VARCHAR(9) NOT NULL,
  address VARCHAR(45),
  password VARCHAR(50) NOT NULL,
  created_time DATE NOT NULL,
  NIP VARCHAR(10),
  name_of_company VARCHAR(50));

CREATE TABLE IF NOT EXISTS public.Types_Of_Events (
  ID BIGINT NOT NULL,
  name VARCHAR(45) NOT NULL UNIQUE,
  CONSTRAINT types_of_events_id_pkey PRIMARY KEY (ID));

CREATE TABLE IF NOT EXISTS public.Payments (
  ID BIGINT NOT NULL DEFAULT nextval('id_seq') PRIMARY KEY,
  price DECIMAL(7,2) NOT NULL,
  client_id BIGINT NOT NULL,
  date_of_payment DATE NOT NULL,
  CONSTRAINT client_id_fkey FOREIGN KEY (client_id) REFERENCES Clients(ID));

CREATE TABLE IF NOT EXISTS public.Positions (
  ID BIGINT NOT NULL,
  position VARCHAR(45) NOT NULL UNIQUE,
  CONSTRAINT positions_id_pkey PRIMARY KEY (ID));

CREATE TABLE IF NOT EXISTS public.Employees (
  ID BIGINT NOT NULL,
  first_name VARCHAR(45) NOT NULL,
  last_name VARCHAR(45) NOT NULL,
  position_id BIGINT NOT NULL,
  email VARCHAR(45) NOT NULL,
  password VARCHAR(45) NOT NULL,
  CONSTRAINT employees_id_pkey PRIMARY KEY (ID),
  CONSTRAINT position_id_fkey FOREIGN KEY (position_id) REFERENCES Positions(ID));

CREATE TABLE IF NOT EXISTS public.Events (
  ID BIGINT NOT NULL DEFAULT nextval('id_seq') PRIMARY KEY,
  type_Of_Event_id BIGINT NOT NULL,
  price DECIMAL(7,2) NOT NULL,
  payment_id BIGINT NOT NULL,
  head_employee_of_event_id BIGINT NOT NULL,
  date_start_of_event DATE NOT NULL,
  date_end_of_event DATE NOT NULL,
  status event_status NOT NULL,
  client_id BIGINT NOT NULL,
  CONSTRAINT type_of_event_id_fkey FOREIGN KEY (type_Of_Event_id) REFERENCES Types_Of_Events (ID),
  CONSTRAINT payment_id_fkey FOREIGN KEY (payment_id) REFERENCES Payments (ID),
  CONSTRAINT head_employee_of_event_id_fkey FOREIGN KEY (head_employee_of_event_id) REFERENCES Employees (ID),
  CONSTRAINT client_id_fkey FOREIGN KEY (client_id) REFERENCES Clients (ID));

CREATE TABLE IF NOT EXISTS public.Tickets (
  ID BIGINT NOT NULL PRIMARY KEY,
  client_id BIGINT NOT NULL,
  price_per_unit DECIMAL(7,2) NOT NULL,
  event_id BIGINT NOT NULL,
  CONSTRAINT client_id_fkey FOREIGN KEY (client_id) REFERENCES Clients (ID),
  CONSTRAINT event_id_fkey FOREIGN KEY (event_id) REFERENCES Events (ID));

CREATE TABLE IF NOT EXISTS public.Types_Of_Faults (
  ID BIGINT NOT NULL,
  type VARCHAR(45) NOT NULL UNIQUE,
  CONSTRAINT types_of_faults_id_pkey PRIMARY KEY (ID));

CREATE TABLE IF NOT EXISTS public.Technical_Faults (
  ID BIGINT NOT NULL PRIMARY KEY,
  type_Of_Fault_id BIGINT NOT NULL,
  description VARCHAR(75) NOT NULL,
  status technical_faults_status NOT NULL,
  employee_id BIGINT NOT NULL,
  CONSTRAINT type_of_fault_id_fkey FOREIGN KEY (type_Of_Fault_id) REFERENCES Types_Of_Faults (ID),
  CONSTRAINT employee_id_fkey FOREIGN KEY (employee_id) REFERENCES Employees (ID));

CREATE TABLE IF NOT EXISTS public.Types_Of_Services (
  ID BIGINT NOT NULL,
  name VARCHAR(40) NOT NULL UNIQUE,
  CONSTRAINT types_of_services_id_pkey PRIMARY KEY (ID));

CREATE TABLE IF NOT EXISTS public.Intermediary_Compianies (
  NIP VARCHAR(10) NOT NULL PRIMARY KEY,
  name_of_company VARCHAR(50) NOT NULL,
  type_Of_Service_id BIGINT NOT NULL,
  CONSTRAINT type_of_service_id_fkey FOREIGN KEY (type_Of_Service_id) REFERENCES Types_Of_Services (ID));

CREATE TABLE IF NOT EXISTS public.Supplies (
  ID BIGINT NOT NULL,
  name VARCHAR(50) NOT NULL UNIQUE,
  units VARCHAR(45) NOT NULL,
  CONSTRAINT supplies_id_pkey PRIMARY KEY (ID));

CREATE TABLE IF NOT EXISTS public.Order_Supplies (
  ID BIGINT NOT NULL,
  orders_id BIGINT NOT NULL,
  supplies_id BIGINT NOT NULL,
  CONSTRAINT order_supplies_id_pkey PRIMARY KEY (ID),
  CONSTRAINT orders_id_fkey FOREIGN KEY (orders_id) REFERENCES Events (id),
  CONSTRAINT supplies_id_fkey FOREIGN KEY (supplies_id) REFERENCES Supplies (id));

CREATE TABLE IF NOT EXISTS public.Events_has_Intermediary_Compianies (
  events_id BIGINT NOT NULL,
  intermediary_Compianies_NIP VARCHAR(10) NOT NULL,
  PRIMARY KEY (Events_id, Intermediary_Compianies_NIP),
  CONSTRAINT events_id_fkey FOREIGN KEY (events_id) REFERENCES Events (ID),
  CONSTRAINT intermediary_companies_NIP_fkey FOREIGN KEY (intermediary_Compianies_NIP) REFERENCES Intermediary_Compianies (NIP));