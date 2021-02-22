About the Application:
Sample spring boot RESTful application which exposes GET, POST and PUT services to fetch/add/update product information

Technologies:
Spring boot, Maven, Couchbase, logback, lombok, JUnits

APIs available:
GET/PUT/POST for creating a new product, updating the product info and fetching the product details

Database:
Couchbase DB - Install the couchbase Server from : https://docs.couchdb.org/en/3.1.1/install/mac.html
Start the server, user name password is given in config file
Create a bucket called Product

Steps to run:
./mvnw clean install
./mvnw spring-boot:run

API calls:.md
POST http://localhost:8080/product/1212331
RequestBody:
{
  "id": 1212331,
  "sellerId": "8888888",
  "title": "apple-iphone-12-32gb--red",
  "manufacturer": "apple",
  "isLowQuantity": false,
  "isSoldOut": false,
  "isBackorder": false,
  "requiresShipping": true,
  "isVisible": true
}
GET http://localhost:8080/product/1212331
PUT http://localhost:8080/product/1212331
{
  "id": 1212331,
  "sellerId": "9999999",
  "title": "apple-iphone-12-32gb--UPDATED",
  "manufacturer": "SAMSUNG",
  "isLowQuantity": false,
  "isSoldOut": false,
  "isBackorder": false,
  "requiresShipping": true,
  "isVisible": true
}

Sample Document model :
{
  "id": 1212331,
  "sellerId": "9999999",
  "title": "apple-iphone-12-32gb--UPDATED",
  "manufacturer": "SAMSUNG",
  "isLowQuantity": false,
  "isSoldOut": false,
  "isBackorder": false,
  "requiresShipping": true,
  "isVisible": true
}

Packages:
config : couchbaseconfig 
Controller
Exception
Models
Repository
Resources
test : Junit tests




