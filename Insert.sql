

-- Create new category ----------------------------------------------------------------------------------

INSERT INTO Category(name,description,created_by,created_date) 
VALUES('Sports', 'Get updates what events are happening around you!! Cool!!', 1 , CURDATE());

-- Create new Organizer ---------------------------------------------------------------------------------

 orgaizer_id int NOT NULL AUTO_INCREMENT,
    organizer_name varchar(255) NOT NULL,
    description varchar(500) NOT NULL,
    address varchar(255) NOT NULL,
	logo varchar(255) NOT NULL,
	email varchar(255) NOT NULL,
	phone varchar(255) NOT NULL,
	organizer_status varchar(10) NOT NULL,
	username varchar(255) NOT NULL,
    password varchar(255) NOT NULL,
	register_date Date,
	
INSERT INTO Organizer();