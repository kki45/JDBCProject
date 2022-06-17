USE word;

SELECT * FROM form;
SELECT * FROM myword;
SELECT * FROM word;
SELECT * FROM wordgame;

DESC form;
DESC myword;
DESC word;
DESC wordgame;

-- SELECT COUNT(*) 
-- FROM word
-- WHERE korean_word = '애완동물'
-- AND english_word = '';

-- DELETE FROM wordgame;
-- ALTER TABLE wordgame auto_increment = 1;
-- commit;
-- INSERT INTO wordgame(user_name, score, date) VALUES("감자", 20, sysdate());

-- SELECT user_name, score, date
-- FROM wordgame
-- WHERE user_name = '감자'
-- AND score = 5;

-- UPDATE wordgame SET user_name="check2" WHERE game_number=3;
-- commit;