INSERT INTO user ( id, admin, name, password, username )
	VALUES
    ( 1, true, "admin", "$2a$10$4.g07w9xl9pf4Z/BRVNkfeAQnXyKjCCb8ul32mGW6tGV0RJo8vT/C", "admin"),
	  ( 2, false, "axel", "$2a$10$4.g07w9xl9pf4Z/BRVNkfeAQnXyKjCCb8ul32mGW6tGV0RJo8vT/C", "axel");

INSERT INTO category ( id, discount, name )
   VALUES
   ( 1, 0.10, "Cosméticos" ),
   ( 2, 0.15, "Higiene Pessoal" ),
   ( 3, 0.25, "Medicamentos" ),
   ( 4, 0.50, "Alimentos" );

INSERT INTO product ( barcode, available, manufacturer, name, price, category_id )
	VALUES
    ( "12345678", true, "Fab1", "Perfume 1", 35.0, 1),
    ( "98765431", true, "Fab2", "Cloro", 10.0, 2);

INSERT INTO lot ( id, expiration_date, available_products_quantity,
					products_quantity_total, product_id )
	VALUES
    ( 1, "2018-12-12", 5, 10, "12345678"),
    ( 2, "2018-12-11", 3, 10, "98765431"),
    ( 3, "2016-05-23", 20, 30, "12345678"),
    ( 4, "2017-03-19", 35, 40,"98765431"),
	  ( 5, "2018-10-13", 12, 20, "12345678"),
    ( 6, "2019-09-05", 10, 20, "98765431");

INSERT INTO sale ( id, sale_date, value )
	VALUES
    ( 1, "2019-12-12", 30.00);

INSERT INTO sold_product ( id, products_quantity, product_id, sale_id )
	VALUES
    (1, 4, "12345678", 1),
	(2, 7, "98765431", 1);

INSERT INTO sale ( id, sale_date, value )
	VALUES
    ( 2, "2019-12-23", 45.00);

INSERT INTO sold_product ( id, products_quantity, product_id, sale_id )
	VALUES
    (3, 15, "98765431", 2);

INSERT INTO sold_product ( id, products_quantity, product_id, sale_id )
	VALUES
    (5, 2, "12345678", 2);