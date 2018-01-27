CREATE TABLE if not EXISTS `budgete`.`users` (
  `username` VARCHAR(16) NOT NULL,
  `email` VARCHAR(255) NOT NULL,
  `password` VARCHAR(32) NOT NULL,
  `create_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  `birthday` DATE NULL);

ALTER TABLE `budgete`.`users`
ADD PRIMARY KEY (`username`);

insert into budgete.users(username, email, password) values('user', 'user@budgete.com', 'qwerty');
