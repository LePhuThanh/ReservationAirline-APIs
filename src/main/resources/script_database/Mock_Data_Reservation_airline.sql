USE reservation_airline;
INSERT INTO reservation_airline.user VALUES (1, 'Truong', 'Trinh Cong','$2a$12$Ifghbh9itPCFrguqLALsmuLiE//ep.o62qY9.bkGX2WUIc9Sf0You', '0375254687','trinhtruong');
INSERT INTO reservation_airline.user VALUES (2, 'Phu Thanh', 'Le','$2a$12$Ifghbh9itPCFrguqLALsmuLiE//ep.o62qY9.bkGX2WUIc9Sf0You', '0325468752','phuthanh');
INSERT INTO reservation_airline.user VALUES (3, 'Thanh Long', 'Nguyen','$2a$12$Ifghbh9itPCFrguqLALsmuLiE//ep.o62qY9.bkGX2WUIc9Sf0You', '0325467853','thanhlong');
INSERT INTO reservation_airline.user VALUES (4, 'Minh Tam', 'Tran Dang','$2a$12$Ifghbh9itPCFrguqLALsmuLiE//ep.o62qY9.bkGX2WUIc9Sf0You', '0327564853','minhtam');
INSERT INTO reservation_airline.user VALUES (5, 'Quang Long', 'Banh','$2a$12$Ifghbh9itPCFrguqLALsmuLiE//ep.o62qY9.bkGX2WUIc9Sf0You', '0232457861','quanglong');

INSERT INTO reservation_airline.airline VALUES (1001, 300);
INSERT INTO reservation_airline.airline VALUES (1002, 300);
INSERT INTO reservation_airline.airline VALUES (1003, 300);
INSERT INTO reservation_airline.airline VALUES (2001, 250);
INSERT INTO reservation_airline.airline VALUES (2002, 250);

INSERT INTO reservation_airline.employee VALUES (1,1000 ,4);
INSERT INTO reservation_airline.employee VALUES (2,500 ,5);

INSERT INTO reservation_airline.passenger VALUES (1,1, 'Nguyen Van Teo' ,231256488 ,5024532465538);
INSERT INTO reservation_airline.passenger VALUES (2,2, 'Le Van Ti' ,231524746 ,5055632545587);
INSERT INTO reservation_airline.passenger VALUES (3,3, 'Tran Thi Nhung' ,231023654 ,5056325485674);

INSERT INTO reservation_airline.seat_type VALUES (50,1,'Normal');
INSERT INTO reservation_airline.seat_type VALUES (250,2,'VIP');

INSERT INTO reservation_airline.seat VALUES (1001,1,1);
INSERT INTO reservation_airline.seat VALUES (1001,2,1);
INSERT INTO reservation_airline.seat VALUES (1001,3,1);
INSERT INTO reservation_airline.seat VALUES (1001,20,2);
INSERT INTO reservation_airline.seat VALUES (1001,21,2);


INSERT INTO reservation_airline.flight VALUES ( 1001 ,'2023-02-06','07:30',0 ,'2023-02-06 11:30' ,'Ho Chi Minh','Hanoi' ,'VN001');
INSERT INTO reservation_airline.flight VALUES ( 1001 ,'2023-02-07','07:30',0 ,'2023-02-07 11:30' ,'Hanoi','Ho Chi Minh' ,'VN002');
INSERT INTO reservation_airline.flight VALUES ( 1002 ,'2023-02-07','15:30',0 ,'2023-02-07 20:30' ,'Ho Chi Minh','Mumbai' ,'OS001');
INSERT INTO reservation_airline.flight VALUES ( 1003 ,'2023-02-07','14:30',0 ,'2023-02-07 18:30' ,'Mumbai','Hanoi' ,'OS002');


INSERT INTO reservation_airline.ticket VALUES (0, 1, 1, 1, 'VN001');
INSERT INTO reservation_airline.ticket VALUES (0, 2, 2, 2, 'VN001');
INSERT INTO reservation_airline.ticket VALUES (0, 3, 3, 3, 'VN001');

/*check table*/ 
SELECT* FROM user;
SELECT* FROM passenger;
SELECT* FROM airline;
SELECT* FROM employee;
SELECT* FROM passenger;
SELECT* FROM flight;
SELECT* FROM seat_type;
SELECT* FROM seat;
SELECT* FROM ticket;
SELECT @@version;