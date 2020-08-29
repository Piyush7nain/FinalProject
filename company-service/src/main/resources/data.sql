INSERT INTO COMPANY ( company_name, company_turnover, company_details) VALUES ( 'samsung', 100.99, 'details');
INSERT INTO COMPANY ( company_name, company_turnover, company_details) VALUES ( 'samsung1', 100.99, 'details');
INSERT INTO COMPANY ( company_name, company_turnover, company_details) VALUES ( 'samsung2', 100.99, 'details');
INSERT INTO COMPANY ( company_name, company_turnover, company_details) VALUES ('samsung3', 100.99, 'details');

INSERT INTO COMPANY_STOCK_CODES( company_name, stock_code, company_code) VALUES ('samsung', 1111, 1110);
INSERT INTO COMPANY_STOCK_CODES( company_name, stock_code, company_code) VALUES ('samsung', 2222, 2110);
INSERT INTO COMPANY_STOCK_CODES( company_name, stock_code, company_code) VALUES ('samsung', 3333, 3110);

INSERT INTO STOCK_PRICES(id, company_code,date_,time_,stock_code, current_price ) VALUES ( 12, 1110,'2020-11-19','20:20:20', 1111, 100);
INSERT INTO STOCK_PRICES(id, company_code,date_,time_,stock_code, current_price ) VALUES ( 13, 2110,'2020-07-21','20:20:20', 2222, 100);

INSERT INTO IPO(id, company_code, open_date, stock_code,price_per_share, remarks) VALUES (123, 1110, '2020-09-09',1111, 1000, 'remarks');
INSERT INTO IPO(id, company_code, open_date, stock_code,price_per_share, remarks) VALUES (1245, 2110, '2020-08-08',2222, 1000, 'remarks');


