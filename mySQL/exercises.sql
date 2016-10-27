Exercise 1
----------

SELECT * FROM votes
ORDER BY votes DESC, name ASC


Exercise 2
----------
CREATE FUNCTION `initcap` (word VARCHAR(255))
RETURNS varchar(255)
BEGIN
DECLARE letter CHAR(1);  
DECLARE aux VARCHAR(255);  
DECLARE i INT DEFAULT 1;
DECLARE flag INT DEFAULT 1;   	  
SET aux = LCASE( word );  
	  
WHILE i < LENGTH( word ) DO  		
	SET letter = SUBSTRING( aux, i, 1 );  	
	IF letter >= 'a' AND letter <= 'z' AND flag = 1 THEN  
		SET aux = CONCAT(LEFT(aux,i-1),UCASE(letter),SUBSTRING(aux,i+1));
		SET flag = 0;
	END IF;
	
	IF letter = ' ' AND flag = 0 THEN
	SET flag = 1;
	END IF;
		
	SET i = i+1;
END WHILE;
            
RETURN aux;
END


Exercise 3
----------
CREATE PROCEDURE getNames(IN p_id INT) 
	BEGIN  
		DECLARE v_finished INTEGER DEFAULT 0;
		DECLARE proceed INT DEFAULT 1;
		DECLARE aux INT DEFAULT 0;  
		DECLARE name_aux VARCHAR(50);

		DECLARE cursor_exe3 CURSOR FOR 
			SELECT NAME 
	          FROM sometbl
			 WHERE id = p_id;
	    DECLARE CONTINUE HANDLER FOR NOT FOUND 
			SET v_finished = 1;
	        
		DROP TEMPORARY TABLE IF EXISTS table_aux;
	    CREATE TEMPORARY TABLE table_aux (ID INT, NAME VARCHAR(50));    
	    
		OPEN cursor_exe3;
	    
	    f1: LOOP
			FETCH cursor_exe3 INTO name_aux;
	    
			if v_finished = 1 THEN
				LEAVE f1;
			END IF;
	    
			WHILE proceed = 1 DO  
				BEGIN  
	            
	            SET aux = INSTR(name_aux, '|');
	
				IF aux = 0 THEN
					BEGIN					
	                INSERT INTO table_aux VALUES (p_id, name_aux);
	                     
					SET proceed = 0;
	                
	                END;
				ELSE 
					BEGIN
	                
	                INSERT INTO table_aux VALUES (p_id, SUBSTRING(name_aux, 1, aux - 1));
	                
	                SET name_aux = SUBSTRING(name_aux, aux + 1);
	                
	                END;
				END IF;
				END;  
			END WHILE;  
	    END LOOP;
	    
	    SELECT *
	      FROM table_aux
		 WHERE id = p_id;
	      
		DROP TEMPORARY TABLE IF EXISTS table_aux;	    
	END
	
Exercise 4
----------
SET @dateStart 	= '2016-10-02';            
SET @dateEnd 	= '2016-10-04';
	
SELECT open_date, count(1) as bugs_opened FROM bugs
WHERE open_date >= @dateStart  AND open_date <= @dateEnd  AND close_date <= @dateEnd
GROUP BY open_date;