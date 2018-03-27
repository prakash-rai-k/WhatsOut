-- ==================================================================================
-- Author:      Prakash Rai
-- Create date: 03/18/2018
-- Description: Start up dummy data for database
-- 
use BookSharing; --from master

-- Create new Organizer ---------------------------------------------------------------------------------
INSERT INTO Organizer(organizer_name, description, address, logo, email, phone, organizer_status, username, password, register_date) 
VALUES('MUM Futsal group', 'We organize futsal tournaments.', 'Maharishi university of management', 'logo.png', 'soccer@mum.edu', 
'465-773672', 'approved', 'mumsoccer', 'mumsoccer', CURDATE());

-- Create WOEmployee--------------------------------------------------------------------------------------
INSERT INTO WOEmployee(fullname, address, email, phone,profile_picture,username,password,register_date)
VALUES('Rupendra Maharjan', 'Fairfield, IOWA', 'rpundra@mum.edu','456443', 'rupendra.jpg','rupendra', 'abc', CURDATE());

-- Create new category -----------------------------------------------------------------------------------
INSERT INTO Category(name,description,created_by,created_date) 
VALUES('Sports', 'Get updates what events are happening around you!! Cool!!', 1 , CURDATE());

-- Create new user ----------------------------------------------------------------------------------------
INSERT INTO User(fullname, address, email, phone, profile_picture, username, password, register_date)
VALUES('Prakash Rai', 'Fairfield IOWA', 'prai@mum.edu', '987654788', 'prakash.jpg', 'prakashrai', 'pass', CURDATE());


-- Create new Event ---------------------------------------------------------------------------------------
	
INSERT INTO Event(title, category_id, description, logo, event_date, event_time, duration, capacity, created_date)
VALUES('MUM futsal tournament', 1, '5A side futsal tournament. The winner receives medal and giftcard.', 'logo.png', 
CURDATE(), '3:30 PM', '3 Hours', 30, curdate());

-- Create new Gallery --------------------------------------------------------------------------------------
	
INSERT INTO Gallery(event_id, photos) VALUES(1, 'test.png, abc.png');

-- Create new comment ---------------------------------------------------------------------------------------
	
INSERT INTO Comment(event_id, commentor_id, commentText) VALUES(1,1, 'That was awsome!!'); 

-- Create new Rating ----------------------------------------------------------------------------------------
	
INSERT INTO Rating(event_id, rator_id, rating) VALUES(1,1,8);

--- Create new CategoryPreference ---------------------------------------------------------------------------
INSERT INTO CategoryPreference(user_id, category_id) VALUES(1,1)
