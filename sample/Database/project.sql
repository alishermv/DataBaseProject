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