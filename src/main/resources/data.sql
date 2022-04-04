DROP TABLE IF EXISTS PRICES;

CREATE TABLE PRICES (
  ID NUMBER AUTO_INCREMENT PRIMARY KEY,
  PRODUCT_ID NUMBER NOT NULL,
  BRAND_ID NUMBER NOT NULL,
  START_DATE TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT SYSDATE,
  END_DATE TIMESTAMP WITH TIME ZONE NOT NULL,
  PRICE_LIST NUMBER(1) NOT NULL,
  PRIORITY NUMBER(1) ,
  PRICE NUMBER(10,2) NOT NULL,
  CURR VARCHAR(3) DEFAULT 'EUR'
);

INSERT INTO PRICES (BRAND_ID, START_DATE, END_DATE, PRICE_LIST, PRODUCT_ID, PRIORITY, PRICE, CURR) VALUES
  (1, TO_TIMESTAMP('2020-06-14-00.00.00','YYYY-MM-DD-HH24.MI.SS'), TO_TIMESTAMP('2020-12-31-23.59.59','YYYY-MM-DD-HH24.MI.SS'), 1, 35455, 0, 35.50, 'EUR'),
  (1, TO_TIMESTAMP('2020-06-14-15.00.00','YYYY-MM-DD-HH24.MI.SS'), TO_TIMESTAMP('2020-06-14-18.30.00','YYYY-MM-DD-HH24.MI.SS'), 2, 35455, 1, 25.45, 'EUR'),
  (1, TO_TIMESTAMP('2020-06-15-00.00.00','YYYY-MM-DD-HH24.MI.SS'), TO_TIMESTAMP('2020-06-15-11.00.00','YYYY-MM-DD-HH24.MI.SS'), 3, 35455, 1, 30.50, 'EUR'),
  (1, TO_TIMESTAMP('2020-06-15-16.00.00','YYYY-MM-DD-HH24.MI.SS'), TO_TIMESTAMP('2020-12-31-23.59.59','YYYY-MM-DD-HH24.MI.SS'), 4, 35455, 1, 38.95, 'EUR');
