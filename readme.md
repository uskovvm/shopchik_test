1. Старт приложения:
java -Dfile.encoding=UTF-8 -jar target/shopchik-test-0.0.1-SNAPSHOTik.jar

2. Роуты:
Категории:
GET - http://localhost:8080/categories - возвращает все категории
GET - http://localhost:8080/category/{id} - возвращает определенную категорию
GET - http://localhost:8080//categories/{name}/{page}/{size}
	Возвращает список категорий постранично. 
	name - название категории. 
	page - страница (0...). 
	size - к-во категорий на странице.
	Пример:
	http://localhost:8080/categories/сырные изделия/0/10
	
GET - http://localhost:8080//categories/{name}/{parentname}/{page}/{size}
	Возвращает список категорий постранично. 
	name - название категории. 
	parentname - название родительской категории. 
	page - страница (0...). 
	size - к-во категорий на странице.
	Пример:
	http://localhost:8080/categories/сырные изделия/молочные продукты/0/10
	
	
DELETE - http://localhost:8080/category/{id} - удаляет категорию
POST - http://localhost:8080/category - добавляет категорию
POST - http://localhost:8080/category/{id} - обновляет категорию

Продукты:
GET - http://localhost:8080/products - возвращает все продукты
GET - http://localhost:8080/product/{id} - возвращает определенный продукт
GET - http://localhost:8080//products/{name}/{page}/{size}
	Возвращает список продуктов постранично. 
	name - название продукта. 
	page - страница (0...). 
	size - к-во продуктов на странице.
	Пример:
	http://localhost:8080/products/молоко/0/10
	
GET - http://localhost:8080//products/{name}/{categoryname}/{page}/{size}
	Возвращает список продуктов постранично. 
	name - название продукта. 
	categoryname - название категории. 
	page - страница (0...). 
	size - к-во продуктов на странице.
	Пример:
	http://localhost:8080/products/молоко/молочные продукты/0/10
	
DELETE - http://localhost:8080/product/{id} - удаляет продукт
POST - http://localhost:8080/product - добавляет продукт
POST - http://localhost:8080/product/{id} - обновляет продукт
