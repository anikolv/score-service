CREATE TABLE users_scoreboard (
  id          INT(8) PRIMARY KEY AUTO_INCREMENT,
  user_id 	  INT(8),
  total_games INT(8) DEFAULT 0,
  total_points INT(8)
 );