select * from car


create table car_feedback
(name VARCHAR2(25),
email VARCHAR2(25),
subject varchar2(25),
message CLOB,
message_date date
);

CREATE OR REPLACE TRIGGER GIVE_DATE_FOR_MESSAGE 
after update on car_feedback for each row
begin
    insert into car_feedback (message_date)
    values(sysdate);
end;

select * from car_feedback;

------------------------------
SET SERVEROUTPUT ON;
DECLARE
CURSOR c1 IS SELECT * FROM car;
v_car_rec car%rowtype;
BEGIN
OPEN c1;
loop
FETCH c1 INTO v_car_rec;
EXIT WHEN c1%NOTFOUND;
DBMS_OUTPUT.PUT_LINE('Mark :' || v_car_rec.mark || '      Model: ' || v_car_rec.model || '         Year:   ' || v_car_rec.year);
END LOOP;
CLOSE c1;
END;
------------------------------------------------------------------
SET SERVEROUTPUT ON;
DECLARE
CURSOR c2 IS SELECT * FROM car;
v_car_rec car%rowtype;
BEGIN
OPEN c2;
loop
FETCH c2 INTO v_car_rec;
EXIT WHEN c2%NOTFOUND;
DBMS_OUTPUT.PUT_LINE('Mark :' || v_car_rec.mark || '      Model: ' || v_car_rec.model || '         Price:   ' || v_car_rec.price);
END LOOP;
CLOSE c2;
END;


------------------------------------------------------------------
SET SERVEROUTPUT ON;
DECLARE
CURSOR c3 IS SELECT * FROM car;
v_car_rec car%rowtype;
BEGIN
OPEN c3;
loop
FETCH c3 INTO v_car_rec;
EXIT WHEN c3%NOTFOUND;
DBMS_OUTPUT.PUT_LINE('Mark :' || v_car_rec.mark || '      Drive: ' || v_car_rec.drive || '         Transmission:   ' || v_car_rec.transmission);
END LOOP;
CLOSE c3;
END;
---------------------------------------------------------------------


SET SERVEROUTPUT ON;
DECLARE
CURSOR c4 IS SELECT * FROM car;
v_car_rec car%rowtype;
BEGIN
OPEN c4;
loop
FETCH c4 INTO v_car_rec;
EXIT WHEN c4%NOTFOUND;
DBMS_OUTPUT.PUT_LINE('Mark :' || v_car_rec.mark || '      Model: ' || v_car_rec.model || '         Engine Capacity:   ' || v_car_rec.engine_capacity);
END LOOP;
CLOSE c4;
END;


create table deleted_car(
PRICE	NUMBER(38,0),
MARK	VARCHAR2(26 BYTE),
MODEL	VARCHAR2(26 BYTE),
YEAR	NUMBER(38,0),
MILEAGE	NUMBER(38,0),
ENGINE_CAPACITY	NUMBER(38,0),
TRANSMISSION	VARCHAR2(26 BYTE),
DRIVE	VARCHAR2(26 BYTE),
HAND_DRIVE	VARCHAR2(26 BYTE),
FUEL	VARCHAR2(26 BYTE),
deleted_date date
);

CREATE OR REPLACE TRIGGER save_dropped_car_trigg
before delete on car for each row
begin
    insert into deleted_car (price, mark, model, year, mileage, ENGINE_CAPACITY, TRANSMISSION, DRIVE, HAND_DRIVE, FUEL,DELETED_DATE)
    values(:old.price, :old.mark, :old.model, :old.year, :old.mileage, :old.ENGINE_CAPACITY, :old.TRANSMISSION, :old.DRIVE, :old.HAND_DRIVE, :old.FUEL,SYSDATE);
end;

delete from car where model='m3 series';

select * from deleted_car;

create table new_car
( PRICE	NUMBER(38,0),
MARK	VARCHAR2(26 BYTE),
MODEL	VARCHAR2(26 BYTE),
YEAR	NUMBER(38,0),
MILEAGE	NUMBER(38,0),
ENGINE_CAPACITY	NUMBER(38,0),
TRANSMISSION	VARCHAR2(26 BYTE),
DRIVE	VARCHAR2(26 BYTE),
HAND_DRIVE	VARCHAR2(26 BYTE),
FUEL	VARCHAR2(26 BYTE),
insert_date date
);

CREATE OR REPLACE TRIGGER save_new_car_trigg
after insert on car for each row
begin
    insert into new_car (price, mark, model, year, mileage, ENGINE_CAPACITY, TRANSMISSION, DRIVE, HAND_DRIVE, FUEL,INSERT_DATE)
    values(:new.price, :new.mark, :new.model, :new.year, :new.mileage, :new.ENGINE_CAPACITY, :new.TRANSMISSION, :new.DRIVE, :new.HAND_DRIVE, :new.FUEL,SYSDATE);
end;
---- 1 package, 2 procedure - 1 procedure insert, 2 procedure update price ---
CREATE OR REPlACE PACKAGE PACKAGE_1
AS
PROCEDURE CAR_INS(p_price VARCHAR2, p_mark VARCHAR2, p_model VARCHAR2, p_year VARCHAR2 , p_mileage VARCHAR2, p_engine VARCHAR2, p_transmission VARCHAR2
, p_drive VARCHAR2, p_hand_drive VARCHAR2, p_fuel VARCHAR2);
PROCEDURE CAR_UPD_PRICE(p_id NUMBER, p_price VARCHAR2);

end PACKAGE_1;
/
CREATE OR REPLACE PACKAGE BODY PACKAGE_1
AS 
PROCEDURE CAR_INS(p_price VARCHAR2, p_mark VARCHAR2, p_model VARCHAR2, p_year VARCHAR2 , p_mileage VARCHAR2, p_engine VARCHAR2, p_transmission VARCHAR2
, p_drive VARCHAR2, p_hand_drive VARCHAR2, p_fuel VARCHAR2) IS
BEGIN
     INSERT INTO car(price, mark, model, year, mileage, engine_capacity, transmission, drive, hand_drive, fuel)
    VALUES(p_price, p_mark, p_model, p_year, p_mileage, p_engine, p_transmission, p_drive, p_hand_drive, p_fuel);
    COMMIT;
END CAR_INS;
PROCEDURE CAR_UPD_PRICE(p_id NUMBER, p_price VARCHAR2) IS
BEGIN
    UPDATE car SET
    price = p_price
    WHERE id = p_id;
    COMMIT;
END CAR_UPD_PRICE; 
END PACKAGE_1;





CREATE OR REPLACE PACKAGE PACKAGE_2 
AS
PROCEDURE select_info(p_id NUMBER);
PROCEDURE CAR_DEL(p_id NUMBER);
PROCEDURE DEL_MESSAGE(p_email VARCHAR2);
END PACKAGE_2;
/
CREATE OR REPLACE PACKAGE BODY PACKAGE_2 
AS
PROCEDURE select_info(p_id NUMBER) IS
BEGIN 
    EXECUTE IMMEDIATE 'SELECT * FROM car WHERE id = '' ' || p_id || '''';
END select_info;
PROCEDURE CAR_DEL(p_id NUMBER) IS
BEGIN
   EXECUTE IMMEDIATE 'DELETE FROM car WHERE id = ''' || p_id || '''';
END CAR_DEL;
PROCEDURE DEL_MESSAGE(p_email VARCHAR2) IS
BEGIN
    EXECUTE IMMEDIATE 'DELETE FROM car_feedback WHERE email = ''' || p_email || '''';
END DEL_MESSAGE;
END PACKAGE_2;

execute package_2.select_info(1);
execute package_2.car_del(1);
execute package_2.del_message('wuicvb@wdvcuwv');

select * from car_feedback