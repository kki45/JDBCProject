USE word;

SELECT * FROM form;
SELECT * FROM myword;
SELECT * FROM word;
SELECT * FROM wordgame;

DESC form;
DESC myword;
DESC word;
DESC wordgame;

SELECT COUNT(*) 
FROM word
WHERE korean_word = '애완동물'
AND english_word = '';