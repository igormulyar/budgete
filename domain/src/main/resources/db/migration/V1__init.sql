/*CREATE USERS TABLE*/
CREATE TABLE if not EXISTS USERS (
  id INTEGER(20) PRIMARY KEY,
  userName VARCHAR(16) NOT NULL,
  email VARCHAR(255) NOT NULL,
  userPassword VARCHAR(32) NOT NULL,
  creationTimestamp TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  dateOfBirth DATE NULL,
  CONSTRAINT UC_userName UNIQUE (userName));

/*INSERT INITIAL DEFAULT USER*/
INSERT INTO USERS(id, userName, email, userPassword) values(1, 'user', 'user@budgete.com', 'Password1');
