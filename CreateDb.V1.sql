-- ==================================================================================
-- Author:      Prakash Rai
-- Create date: 03/18/2018
-- Description: Sql queries for creating and tables
-- ===================================================================================

-- 1. Create database if not exist---------------------------------------------------
CREATE DATABASE IF NOT EXISTS WhatsOut;

-- 2. Create Organizer table----------------------------------------------------------
USE WhatsOut;

CREATE TABLE IF NOT EXISTS Organizer  (
    orgaizer_id int NOT NULL AUTO_INCREMENT,
    organizer_name varchar(255) NOT NULL UNIQUE,
    description varchar(500) NOT NULL,
    address varchar(255) NOT NULL,
	logo varchar(255) NOT NULL,
	email varchar(255) NOT NULL,
	phone varchar(255) NOT NULL,
	organizer_status varchar(10) NOT NULL,
	username varchar(255) NOT NULL UNIQUE,
    password varchar(255) NOT NULL,
	register_date Date,
    PRIMARY KEY (orgaizer_id)
);

-- 3. Create WOEmplyee table----------------------------------------------------------
USE WhatsOut;

CREATE TABLE IF NOT EXISTS WOEmployee  (
    woemployee_id int NOT NULL AUTO_INCREMENT,
    fullname varchar(100) NOT NULL,
	address varchar(255) NOT NULL,
	email varchar(255) NOT NULL,
	phone varchar(20) NOT NULL,
	profile_picture varchar(100) NOT NULL,
	username varchar(255) NOT NULL UNIQUE,
    password varchar(255) NOT NULL,
	register_date Date,
    PRIMARY KEY (woemployee_id)
);

-- 4. Create Users table----------------------------------------------------------
USE WhatsOut;

CREATE TABLE IF NOT EXISTS User  (
    user_id int NOT NULL AUTO_INCREMENT,
    fullname varchar(100) NOT NULL,
	address varchar(255) NOT NULL,
	email varchar(255) NOT NULL,
	phone varchar(20) NOT NULL,
	profile_picture varchar(100) NOT NULL,
	username varchar(255) NOT NULL UNIQUE,
    password varchar(255) NOT NULL,
    register_date Date,
    PRIMARY KEY (user_id)
);

-- 5. Create Category table----------------------------------------------------------
USE WhatsOut;

CREATE TABLE IF NOT EXISTS Category  (
    category_id int NOT NULL AUTO_INCREMENT,
    name varchar(30) NOT NULL UNIQUE,
	description varchar(255) NOT NULL,
	created_by int NOT NULL,
	created_date Date,
    PRIMARY KEY (category_id),
	FOREIGN KEY (created_by) REFERENCES WOEmployee(woemployee_id)
);

-- 6. Create Event table----------------------------------------------------------
USE WhatsOut;

CREATE TABLE IF NOT EXISTS Event  (
    event_id int NOT NULL AUTO_INCREMENT,
    title varchar(100) NOT NULL,
	category_id int NOT NULL,
	description varchar(500) NOT NULL,
	logo varchar(100) NOT NULL,
	event_date Date,
	event_time varchar(30) NOT NULL,
    duration varchar(25) NOT NULL,
	capacity int,
    created_date Date,
    PRIMARY KEY (event_id),
	FOREIGN KEY (category_id) REFERENCES Category(category_id)
);

-- 7. Create Gallery table----------------------------------------------------------
USE WhatsOut;

CREATE TABLE IF NOT EXISTS Gallery  (
    gallery_id int NOT NULL AUTO_INCREMENT,
    event_id int NOT NULL,
	photos varchar(1000),
    PRIMARY KEY (gallery_id),
	FOREIGN KEY (event_id) REFERENCES Event(event_id)
);

-- 8. Create Comment table----------------------------------------------------------
USE WhatsOut;

CREATE TABLE IF NOT EXISTS Comment  (
    comment_id int NOT NULL AUTO_INCREMENT,
    event_id int NOT NULL,
	commentor_id int NOT NULL,
	commentText varchar(500),
    comment_date Date,
    PRIMARY KEY (comment_id),
	FOREIGN KEY (event_id) REFERENCES Event(event_id),
	FOREIGN KEY (commentor_id) REFERENCES User(user_id)
);

-- 9. Create Rating table----------------------------------------------------------
USE WhatsOut;

CREATE TABLE IF NOT EXISTS Rating  (
    rating_id int NOT NULL AUTO_INCREMENT,
    event_id int NOT NULL,
	rator_id int NOT NULL,
	rating int NOT NULL,
    PRIMARY KEY (rating_id),
	FOREIGN KEY (event_id) REFERENCES Event(event_id),
	FOREIGN KEY (rator_id) REFERENCES User(user_id)
);

-- 10. Create CategoryPreference-----------------------------------------------------

USE WhatsOut;
CREATE TABLE IF NOT EXISTS CategoryPreference(
	category_preference_id int NOT NULL AUTO_INCREMENT,
	user_id int NOT NULL,
	category_id int NOT NULL,
	PRIMARY KEY(category_preference_id),
	FOREIGN KEY(user_id) REFERENCES User(user_id),
	FOREIGN KEY(category_id) REFERENCES Category(category_id)
);



