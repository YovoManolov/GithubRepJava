SQL
SQL(Sructured Query Language )

 numeric types,
  date 
  time types, 
  string (
  character
  byte
  spatial type
  JSON data type.


INT(L)– Цяло число, може да бъде signed или За signed стойностите
 му варират в интервала от -2147483648 до 2147483647. 
 За unsigned: от 0 до 4294967295. Може да специфицирате дължина
  до 11 ЦИФРИ.
BIT(L) – приема две стойности – 0 или 1, ако не му се специфицира 
L(length). В противен случай приема до 64 бита.
TINYINT(L) – Много малко цяло число, което отново може да бъде 
signed или unsigned. За signed стойностите му варират от 32768 
до 32767. За unsigned са от 0 до 65535. Можете да специфицирате 
дължина до 5 ЦИФРИ.
MEDIUMINT(L) – Средно по големина цяло число, което отново може 
да бъде signed или unsigned. За signed стойностите му варират в 
интервала от -8388608 до 8388607. За unsigned са от 0 до 16777215.
 Можете да специфицирате дължина до 9 ЦИФРИ.
BIGINT(L) – Голямо цяло число, което отново може да бъде signed 
или unsigned. За signed стойностите му варират в интервала
 от -9223372036854775808 до 9223372036854775807. За unsigned са 
 от 0 до 18446744073709551615. Можете да специфицирате дължина до 20 ЦИФРИ.
BOOL, BOOLEAN –Булев(логически) тип. Синоними е на TINYINT(1).
 Работи със стойности 0 (false) или която и да е друга цифра (true).
FLOAT(M,D) – Число с плаваща запетая, което не може да бъде
 беззнаково. Можете да дефинирате дължина на числото(M), както 
 и брой числа след запетаята(D). И двата атрибута не са задължителни. 
 Стойностите на M и на D по подразбиране са 10 и 2. Тоест 10 е
  броя на цифрите на числото, а 2 – броят на цифрите след десетичната 
  запетая. Точността може да варира до максимум 24 знака след запетаята.
DOUBLE(M,D) – Число с плаваща запетая с двойна точност и НЕ МОЖЕ 
ДА БЪДЕ БЕЗЗНАКОВО. Можете да дефинирате дължина на числото(M), 
както и брой числа след запетаята(D). И двата атрибута не са 
задължителни. Стойностите на M И НА D ПО ПОДРАЗБИРАНЕ СА 16 И 4.
 Точността може да варива ДО 54 ЗНАКА СЛЕД ЗАПЕТАЯТА. Типът
  REAL е синоним на DOUBLE.
DECIMAL(М, D) – Число с плаваща запетая с двойна точност, 
като DOUBLE, но е записано по такъв начин, че различните клиенти
 на БД ще прочетат числото с неговата оригинална точност . 
 При DOUBLE, например, винаги съществува опасност от загуба 
 на точност от закръгляне. За сметка на това предимство, работата
  с DECIMAL е по-бавна отколкото с DOUBLE.
NUMERAL(М, D),
 DEC(M,D), 
 FIXED(M,D) –всички са СИНОНИМИ на DECIMAL.


BLOB - case insensitive 

TEXT - case sensitive работят с референции , 
по-бавно извличане на инфото

TINYBLOB или TINYTEXT – Символни низове с максимална
 дължина до 255 символа. Без специфициране на дължина.


MEDIUMBLOB или MEDIUMTEXT – 
Символни низове с максимална дължина до 16777215 знака.
LONGBLOB или LONGTEXT –
 Символни низове с максимална дължина до 4294967295.

 BYNARY(byte) - подобно на Char , работи директно с битове 
 сравняването на полета от този тип става побитово
 Работи мн. по-бързо от char 

 ENUM() – Изброим тип данни. Например ENUM (‘X’, ‘Y’, ‘Z’). В 
 скобите се подава списък с възможните стойности на полето. 
 Може да бъде и NULL. Стойностите могат да бъдат максимум 65535.

 SET() - позволява в една клетка от таблицата да бъдат запзени повече
 от една от изброените стойности .

 Year(2) deprecated


 DDL– съдържа команди, с които се дефинира структурата на базата данни – схеми, таблици, ограничения и 
 връзки между таблиците. Това са всички заявки от типа:
 CREATE DATABASE/ CREATE TABLE – създаване на база данни/ създаване на таблица
ALTER DATABASE/ALTER TABLE – промяна дефиницията на база/ на таблица
DROP DATABASE/ DROP TABLE – изтриване на база/ на таблица
CREATE INDEX – създаване на индекс
DROP INDEX – изтриване на индекс





----------------------------------
DML – съдържа команди за обработка над данните – вмъкване, извличане, промяна, изтриване на данни:

INSERT- вмъкване на данни
SELECT – извличане на данни
UPDATE – промяна на данни
DELETE – изтриване на данни


----------------------------------
DDL –  dATA DEFINITION Language


ALTER DATABASE /ALTER TABLE 
DROP DATABASE /DROP TABLE 

CREATE TABLE books(
	id INT NULL AUTO_INCREMENT PRIMARY KEY,
	name VARCHAR(255) NOT NULL;
	publishedYear YEAR ,
	author_number INT NOT NULL
);

CREATE TABLE customers(
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	name VARCHAR(255) NOT NULL,
	egn VARCHAR(10) NOT NULL
);
CREATE TABLE cars (
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	brand VARCHAR(255) NOT NULL,
	model VARCHAR(255) NOT NULL,
	owner_id INT,
	CONSTRAINT FOREIGN KEY (owner_id) REFERENCES customers(id)
);

ALTER TABLE <tableName>
ADD column1 <dataType> <constraints>

ALTER TABLE <tableName>
ADD CONSTRAINT FOREIGN KEY(ime na kolona ot referirashtata tablica)
REFERENCES (колона от реферираната табл)

Change <ime na kolona> <novo ime nakolona> <dataType><constraints>

Drop<ime na kolona>  iztrivame kolona ;) ;


1 определеянена обектите в нашата база 
2 определяне  на връзките м/у тях
3 определяне на ключови атрибути
4 определяне на останалите атрибути
5 изчертаване на ЕR диаграма 
6 писане на SQL create table код

group int default 1 - задава стойност по подразбиране 1


ограничения за FK 

ON DELETE SET NULL 
ON DELETE  RESTRICT (default setting ) 
ON DELETE CASCADE 

insert into table(column0,column1,column2)
	values (v1,v2,v3),(v1,v2,v3),(v1,v2,v3),(v1,v2,v3);




Drop DATABASE if exists emp_depts;
create DATABASE emp_depts CHARACTER SET utf8 COLLATE utf8_general_ci;
use emp_depts;

create table departments (
	id int AUTO_INCREMENT PRIMARY KEY,
	name varchar(255) not NULL
)ENGINE= InnoDB;

create table person (
	id int AUTO_INCREMENT PRIMARY KEY,
	name varchar(255) not NULL,
	egn varchar(10) not null unique,
	departmentID INT default NULL,
	 CONSTRAINT  FOREIGN KEY (`departmentID`) REFERENCES `departments` (`id`)
)ENGINE= InnoDB;

create table programmers (
	person_id int AUTO_INCREMENT PRIMARY KEY,
	front_back_end ENUM('FRONT_END','BACK_END','FULL_STACK') DEFAULT NULL,
	CONSTRAINT FOREIGN KEY (`person_id`) REFERENCES person(id)

)ENGINE = InnoDB;

create table qas (
	person_id int AUTO_INCREMENT PRIMARY KEY,
	isAutomation BIT (1) DEFAULT NULL,
	CONSTRAINT FOREIGN KEY (`person_id`) REFERENCES person(id)

)ENGINE = InnoDB;

create table languages (
	id int AUTO_INCREMENT PRIMARY KEY,
	name VARCHAR(100) NOT NULL
)ENGINE = InnoDB;

create table programmer_language (
	programmer_id int NOT NULL,
	language_id int NOT NULL,
	PRIMARY KEY(programmer_id,language_id),
	CONSTRAINT FOREIGN KEY (`programmer_id`) REFERENCES programmers(person_id),
	CONSTRAINT FOREIGN KEY (`language_id`) REFERENCES languages(id)
)ENGINE = InnoDB;


–––––––––––––––––––––––––––––––––––––––
(SELECT a....)
UNION или UNION ALL 
(SELECT b....);



SELECT sofiaSg.sg_id as SportGroupNumber,
       sp.name as Sport,
       sofiaSg.loc as SportsGroupLocation
FROM sports as sp JOIN  (SELECT id as sg_id,
								location as loc,
								sport_id
						FROM sportgroups
						WHERE location LIKE '%Sofia%'
						) as sofiaSg  /**sportgroups from Sofia**/
ON sp.id = sofiaSg.sport_id;


USE school_sport_clubs;
SELECT firstpl.name AS firstPlayer,
 secondpl.name AS secondPlayer,
 sports.name AS sportName

FROM students AS firstpl 
JOIN students AS secondpl

ON firstpl.id > secondpl.id

JOIN student_sport AS ss
ON firstpl.id = ss.student_id

JOIN sportgroups AS sp
ON sp.id = ss.sportGroup_id

JOIN sports ON
sports.id = sp.sport_id

WHERE firstPL.id IN(
	SELECT student_id
	FROM student_sport
	WHERE sportGroup_id IN(
		SELECT sportGroup_id
		FROM student_sport
		WHERE student_id = secondPl.id
	)
)
ORDER BY sportName;



USE school_sport_clubs;
SELECT firstpl.name as firstPlayer, 
secondpl.name as secondPlayer, 
sports.name as sportName
FROM students as firstpl JOIN students as secondpl
ON firstpl.id > secondpl.id 
JOIN sports ON (
		secondpl.id IN(
		SELECT student_id 
        FROM student_sport
		WHERE sportGroup_id IN(
			SELECT id 
            FROM sportgroups
			WHERE sport_id = sports.id
			) 
		)	
AND (firstPl.id IN( SELECT student_id 
FROM student_sport
WHERE sportGroup_id IN(
						SELECT id 
						FROM sportgroups							
						WHERE sport_id = sports.id						
					) 
				)
    )
)
WHERE firstPL.id IN(
	  SELECT student_id
	  FROM student_sport
	  WHERE sportGroup_id IN(
			SELECT sportGroup_id
			FROM student_sport
			WHERE student_id = secondPl.id
	   )
)
ORDER BY sportName;


върху view можем да изпълняваме  insert ,UPDATE,DELETE, 
но не се препоръчва .
Най -често view  се използва само за четене съответно
потребителните се рестриктират да имат права 
само за SELECT върху тези таблици :) ;Д 

триене на view DROP VIEW <ime> CASCADE 
cascade значи , ако има производно на това VIew ,
то също да бъде изтрито. СЪЩЕСТВУВА СИНТАКТИЧНО,
НО НЕ РАБОТИ ФУНКЦИОНАЛНО , което означава , че 
в други СУБД работи и е дорбе да го знаете.

Ако използваме RESTRICT вместо cascade и има
производно VIEW ,Query-то ще върне грешка :) :Д 

default value na Drop view Cascade 


За да направим Updateable View 
трябва да са спазени следните правила : 

Изгледът ни не трябва да съдържа от изброените :

Агрегатна функция
DISTINCT 
GROUP BY клауза
HAVING клауза
UNION или UNION ALL клауза
Left join или outer join
Подзаявка в select или where клауза,която да извлича 
информация от таблица,която да се споменава във фром 
клаузата на същата заявка.

SELELCT, който извежда информация от друго non-updateable 
view във FROM клаузата си.

set @customer_number = "A454647"
деклариране на променлива 
select @customer_number;

set @coach_name = 'Иван Тодоров Петров';
SELECT * 
FROM coaches
WHERE name = @coach_name;

DELIMITER | 
create procedure inParamProc(IN nameParam Varchar(255))
BEGIN
	SET @coachName = nameParam;
	end;
END | 
DELIMITER ;

OUT параметър - не се предава реална стойност. Каквато и
стойност да има записана в предавания параметър , тя се приема 
null  на входа на процедурата .Използва се за да им се задават
стойности в рамките на процедурата , които стойности , евентуално
да се използват извън нея .След приключване на процедурата в 
out параметрите ще има записана стойност :): :Д
Използват се често , за да може процедурата да върне резултат по
този начин .


DELIMTIER |
create procedure outParamProc(OUT nameParam VARCHAR(255))
BEGIN 
SELECT nameParam;
SET nameParam = 'Иван Тодоров Петров';
END; |
DELIMITER ; 



SET @testOutParam = 'Some name';
call outParamProc(@testOutParam);
SELECT @testOutParam;


Select coaches.name INTO name 
FROM coaches WHERE id = 1;

OUT /INOUT подаването на несъществуващи промениви е забранено

call inOutProc('Ivan Petrov') //zabraneno !!!!

локална променлива

DECLARE name varchar(100);
Set name = 'Ivan Petrov';

SELECT coaches.name INTO name
FROM coaches 
WHERE id = 1;



IF 
THEN 
ELSE 
END IF ;

CASE Var 
WHEN condition
THEN Query
WHEN condition 
THEN Query
ELSE Query
END CASE ;	

CREATE TEMPORARY TABLE 
(,)ENGINE = MEMORY;

memory e известен още като heap


Задача: създайте процедура, с необходимите входни
 параметри, с които да може да премествате ученици от 
 една група в друга група. Направете нужните проверки
  и извеждайте коректни съобщения. Удобно е да използвате 
  фукнцията ROW_COUNT, която връща броя на засегнатите 
  редове след последната заявка Update ili Delete.

student_sport

DROP PROCEDURE IF exists updateGroups;

DELIMITER |
create procedure updateGroups
		(IN groupToBeDel INT,
		 IN groupToBeUpd INT)
BEGIN
	
	DECLARE numberOfRows INT;
	CREATE TEMPORARY TABLE tempTbl(
		id int AUTO_INCREMENT not null;
		studentId int 
	)engine = memory ;

	Insert into tempTbl
	SELECT student_id 
	FROM student_sport
	WHERE sportgroup_id = groupToBeDel;

	select count(*)
	into numberOfRows
	from tempTbl;

	while(numberOfRows = 0)
	DO
		ALTER TABLE student_sport
		set student_id = groupToBeUpd 
		where student_id IN(
			select studentId
			from tempTbl
			where id = numberOfRows
		)
		numberOfRows = numberOfRows -1 ;
	END WHILE ;
END | 	
DELIMITER ;


declare action handeler for condit_value statement;


DECLARE CONTINUE HANDLER FOR SQLSTATE '42S01' 
SELECT 'SQLSTATE 42S01 occured'



DECLARE EXIT HANDLER 

condition_values :
SQLWARNING,NOTFOUND,SQLEXCEPTION


declare CONTINUE HANDLER FOR NOTFOUND SELECT 'NOT FOUND EXCEPTION OCCURED';


изход от SAFE режим
SET SQL_SAFE_UPDATES = 0;
SET SQL_SAFE_UPDATES = 1; Включен safe режим


DROP procedure if exists monthSalaryPayment;
DELIMITER |
CREATE procedure monthSalaryPayment(
	IN monthOfPayment INT,
	IN yearOfPayment INT,
	OUT success bit)
procLab: BEGIN
	declare tempCoachSalary decimal;
	declare currentCoachSalary decimal;
	declare iterator int;
	declare countOfCoaches int;
	declare tempCoachId int;
	declare updatedSalaryCounter int;
	declare countOfCoachesWithoutMonthSalary int;
	DECLARE CONTINUE HNADLER FOR SQLEXCEPTION
	SELECT 'SQLException occured';

create temporary table tempCoach(
	id int AUTO_INCREMENT PRIMARY KEY,
	coach_id int not null,
	month_salary int not null
)Enginge = Memory ;


	INSERT INTO tempCoach(coach_id,month_salary)
	SELECT coaches.id,coaches.month_salary
	FROM coaches
	WHERE month_salary IS NOT NULL ;

	SELECT COUNT(*)
	INTO countOfCoaches
	FROM tempCoach;

	SET countOfCoachesWithoutMonthSalary = 0;
	SET iterator =1;
	WHILE (iterator >= 1 AND iterator <= countOfCoaches)
	DO 
	#преброяваме колко са треньорите , коиот не са си получили заплатата
	#все още
		SELECT coach_id,month_salary
		INTO tempCoach_id, tempCoachSalary
		FROM tempCoach
		WHERE id = iterator;

#има ли заплата вече предвидена за този месец,година на този треньор	
		SELECT salaryAmount
		INTO currentCoachSalary 
		FROM salaryPayments
		WHERE month = monthOfPayment
		AND year = yearOfPayment
		AND coach_id = tempCoachId;

		IF(IFNULL(currentCoachSalary,0) <= tempCoachSalary)
		THEN SET countOfCoachesWithoutMonthSalary = 
					countOfCoachesWithoutMonthSalary +1;
		END IF;
		SET iterator = iterator +1;
	END WHILE ;

	#ако няма треньори , които да си чакат превод на заплатата
	IF(countOfCoachesWithoutMonthSalary = 0)
	ТHEN drop table tempCoach
		 set success = 0;
	LEAVE procLab;
	ELSE set iterator = 1;
	SET updatedSalaryCounter = 0;
	START TRANSACTION;
	WHILE(iterator >=1  AND iterator <= countOfCoaches)
	DO
		SELECT coach_id,month_salary
		INTO tempCoachId,tempCoachSalary
		FROM tempCoach
		WHERE id = iterator;

		SELECT salaryAmount
		INTO currentCoachSalary 
		FROM salaryPayments
		WHERE 'month' = monthOfPayment
		AND year = yearOfPayment
		AND cocach_id = tempCoachId


		IF(IFNULL(currentCoachSalary,0) < tempCoachSalary)
		THEN 
		INSERT INTO salaryPayments(coach_id,month,year,salaryAmount,
			dateOfPayment)
		VALUES (tempCoachId,monthOfPayment,yearOfPayment,tempCoachSalary,
			NOW())
		ON duplicate key update
		salaryAmount = salaryAmount + tempCoachSalary,
		dateOfPayment = NOW();
		set updatedSalaryCounter = updatedSalaryCounter +1;
		ELSE 
			SELECT 'The coach has a month salary yet!'
		END IF;

		SET iterator  = iterator +1;
		END WHILE ;
		if(countOfCoachesWithoutMonthSalary = updatedSalaryCounter) 
		#преведени са толкова заплати , колкто е трябвало
			THEN commit;
			SET success =1;
			drop table tempCoach;
			
		ElSE 
			rollback;
			SET success = 0;
			drop table tempCoach;
		END if;
	END IF;
	END
	|
	DELIMTIER ;		



Курсори

use school_sport_clubs;
drio procedure if exists CursorTest;
DELIMITER | 
create procedure CursorTest()
BEGIN
	declare finished int ;
	declare tempName varchar(100);
	declare tempEgn varchar(10);
	
	DECLARE coachCursor CURSOR for 
		SELECT name , egn
		FROM coaches
		WHERE month_salary is not null;
	DECLARE CONTINUE HANDLER FOR NOT FOUND set finished = 1;

	set finished = 0;
	OPEN coachCursor ;
	coach_loop : WHILE(finished = 0)
	DO 
	    FETCH coachCursor INTO tempName,tempEgn
		IF(finished = 1)
		THEN LEAVE coach_loop;
		END IF;
		SELECT tempName,tempEgn;
		#or do something elsewith this var's
	END WHILE;
	CLOSE coachCursor;
	SET finished = 0;
	SELECT 'FINISHED !';
END |
DELIMITER ;


drop procedure if exists OPTIMIZED_monthHorariumPayment;
DELIMITER |
create procedure OPTIMIZED_monthHorariumPayment(
	IN monthOfPayment INT 
	IN yearOfPayment INT)
procLabel: BEGIN
declare countOfCoaches int;
declare iterator int;
declare countOfRowsBeforeUpdate int;
declare countOfRowsAfterUpdate int;
declare finished int;
declare tempCoachId int;
declare tempSumOfHours int;

DECLARE tempCoachCursor CURSOR FOR 
SELECT coach_id, SUM(number_of_hours)
FROM coach_work
WHERE month(coach_work.date) = monthOfPayment
AND YEAR(coach_work.date) = yearOfPayment
AND isPayed = 0
GROUP BY coach_work.coach_id;


DECLARE CONTINUE HANDLER FOR SQLEXCEPTION
 SELECT 'SQL EXCEPTION';
 DECLARE CONTINUE HANDLER FOR NOT FOUND SET finished =1;

create temporary table tempTbl(
 	id int AUTO_INCREMENT PRIMARY KEY,
 	coach_id int,
 	number_of_hours int,
 	pay_for_hour decimal,
 	amount decimal,
 	paymentMonth int,
 	paymentYear int
)Engine = Memory; 


SET @RESULT = 0;
call monthSalaryPayment(monthOfPayment,
						yearOfPayment,
						@RESULT);
SELECT @RESULT as resultFromMothPayment; 
#onlyForCOntrolAndTest 
SELECT COUNT(*)
INTO countOfRowsBeforeUpdate
FROM coach_work
WHERE month(coach_work.date) = monthOfPayment
AND YEAR(coach_work.date) = yearOfPayment
AND isPayed = 0;

START TRANSACTION;
OPEN tempCoachCursor;
set finished = 0;
while_loop_label :WHILE (finished = 0)
 DO 
 FETCH tempCoachCursor INTO tempCoachId,tempSumOfHours;
	 IF( finished = 1 ) 
	 THEN leave while_loop_label;
 ELSE SELECT tempCoachId,tempSumOfHours;
 	  INSERT INTO tempTbl(coach_id,number_of_hours,
 	  					  pay_for_hour,amount,
 	  					  paymentMonth,paymentYear)
 	  SELECT tempCoachId,tempSumOfHours,c.hour_salary,
 	  tempSumOfHours*c.hour_salary,monthOfPayment,
 	  yearOfPayment
 	  FROM coaches as c 
 	  WHERE c.id = tempCoachId
  END IF;
END WHILE ;
CLOSE tempCoachCursor;

SELECT * FROM tempTbl #control.test 
INSERT INTO salaryPayments(coach_id,month,
		year,salaryAmount,dateOfPayment)
SELECT coach_id ,paymentMonth,paymentYear,amount,NOW()
FROM tempTbl
ON duplicate KEY UPDATE
salaryAmount = salaryAmount + amount,
dateOfPayment = NOW();


UPDATE coach_work
SET isPayed 
WHERE month(coach_work.date)  = monthOfPayment
AND YEAR(coach_work.date) = yearOfPayment
AND isPayed = 0;
SELECT ROW_COUNT() INTO countOfRowsBeforeUpdate
SELECT countOfRowsAfterUpdate as countOfRowsAfterUpdate;
SELECT countOfRowsBeforeUpdate as countOfRowsBeforeUpdate;

if(countOfRowsBeforeUpdate = countOfRowsAfterUpdate)
THEN commit;
ELSE rollback;
END IF;
DROP tempTbl;
END | 
DELIMITER ;


use school_sport_clubs;
drop table if exists salarypayments_log;
create table salarypayments_log(
	id int auto_increment primary key,
	operation ENUM('INSERT','UPDATE','DELETE') not null,
	old_coach_id int,
	new_coach_id int,
	old_month int,
	new_month int,
	old_year int,
	new_year int,
	old_salaryAmount decimal,
	new_salaryAmount decimal,
	old_dateOfPayment datetime,
	new_dateOfPayment datetime,
	dateOfLog datetime
)Engine = Innodb;

В BEFORE trigger стойността на auto_increment колона = 0 ;
Тригерите не трябва да съдържат изрази с които се управлява 
транзакция: START,TRANSACTION,COMMIT ,rollback
Тригерите не се активират при каскадни операции



DELIMITER |
CREATE TRIGGER before_salarypayments_isert BEFORE INSERT ON 
salaryPayments 
FOR EACH ROW 
BEGIN 
IF(new.salaryAmount < 0) THEN SET new.salaryAmount = 0;
END IF;
END | 
DELIMITER ;


DECLARE no_such_table CONDITION for 1051;
DECLARE CONTINUE HANDLER FOR no_such_table;

CONDITION information item
CONSTRAINT_CATALOG/SCHEMA/NAME
CATALOG_NAME
SCHEMA_NAME
TABLE_NAME
COLUMN_NAME
CURSOR_NAME


drop procedure if exists signalTest;  
delimiter |
CREATE PROCEDURE signalTest(IN testVar INT)
BEGIN
  DECLARE testCondition CONDITION FOR SQLSTATE '45000';
  IF testVar = 0 THEN
    	SIGNAL SQLSTATE '01000'; # warning
  ELSEIF testVar = 1 THEN
		SIGNAL SQLSTATE '45000'
		SET MESSAGE_TEXT = 'Erro from case 1 - signal with handled SQLSTATE.';
  ELSEIF testVar = 2 THEN
		SIGNAL testCondition
		SET MESSAGE_TEXT = 'Error from case 2 - signal with handled condition.';
  ELSE
      SIGNAL SQLSTATE '01000'
      SET MESSAGE_TEXT = 'Warning! It will not be terminated. 
      The procedure will continue.', MYSQL_ERRNO = 1000;
      SIGNAL SQLSTATE '45000'
      SET MESSAGE_TEXT = 'After the warning, the error 
      reset the message and it apper on the screen!', MYSQL_ERRNO = 1001;
  END IF;
END ;
|
DELIMITER ;

datetime = 'dddd-dd-dd tt:tt:tt'


DELIMITER |
CREATE EVENT <name> 
ON SCHEDULE AT some date /
ON SCHEDULE EVERY 2 DAY
STARTS '2017-04-18 03:00:00'
DO <тяло>
BEGIN 
END |
DELIMITER ;


Ако събитието е еднократно 
използваме АТ Timestamp или по желание да го отместим с 
+ интервал 
или периодично с EVERY 

