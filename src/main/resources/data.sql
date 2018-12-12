insert into category (id,parent_id, name, description) values(1, null, 'Продукты', '');
insert into category (id,parent_id, name, description) values(2, 1, 'Молочные продукты', 'Молоко, кефир, сыр и т.д.');
insert into category (id,parent_id, name, description) values(4, 2, 'Сырные изделия', 'Молоко, кефир, сыр и т.д.');
insert into category (id,parent_id, name, description) values(3, 1, 'Хлебобулочные изделия', 'Булки и т.д.');

insert into product (id,category_id, name, description, price) values(1, 3, 'Хлеб', 'Бородинский', 30.44);
insert into product (id,category_id, name, description, price) values(2, 2, 'Молоко', 'Козлиное', 162.55);