This application is named Pricing which tries to helps the end customer to decide which website or retail shop they can use to buy their product by comparing data from different providers.It has been deployed to Azure and Docker image is in the Azure registry.

This service uses Spring Boot which helps to scale up and scale down applications easily. The DB can be changed easily with config changes without changing code as it used Spring Data JPA. The current DB used is H2 due to limited resources to deploy it on the Azure cloud.

Service provides an endpoint that accepts product name and category as search options and returns a list of product info that matches it.

https://spring-boot-pricing.azurewebsites.net/main?category=iphone&productName=mobile

There is a dummy AI service that uses customer reviews for different products and provides recommendations on product providers, so you need to return the search result ranked based on results from the recommendation service.

The below endpoint calls a recommendation service (recommendation service is a dummy service which sorts the results by rating)

https://spring-boot-pricing.azurewebsites.net/ranked?category=iphone&productName=mobile


Swagger endpoints for the services.

Pricing application: https://spring-boot-pricing.azurewebsites.net/swagger-ui.html

Recommendation application: https://spring-boot-recommend.azurewebsites.net/swagger-ui.html

Health status using Actuator :

https://spring-boot-pricing.azurewebsites.net/actuator/health

https://spring-boot-recommend.azurewebsites.net/actuator/health

The service supports multiple data sources for importing new products to the service database

1. via SQL or Command Line Runner (used this in case) when application boots up

2. By uploading CSV, on this UI, https://spring-boot-pricing.azurewebsites.net/upload . The sample has been attached.

3. Spring Batch (configured but ItemWriter needs to completed)

4. REST endpoints. User can directly upload the data

Project Information :

1. The models use basic JPA annotation and resides in "com.relayr.model" package. JPA provides flexibility to use frameworks like Hibernate,iBatis, etc. which in turn makes code independent of DB used.

It creates three tables

Product -> id, name, category

Store -> id, name

Product_Store_Details - > id,link,storeId,productId,mrp,sp,discount,rating

This will help us with the cases where products might not be in a store, sold out, etc.

2. Repos resides in "com.relayr.repo" package and uses Spring Data JPA which provides many queries out of the box and also helps write queries independent of DB used.

3. Services uses "Programming to an Interface" pattern. Interfaces are in package "com.relayr.service" and their implementations in "com.relayr.service.impl". They communicate with repo and recommendation service and passes data to the controller layer.

4. The package "com.relayr.controller" provides the basic controllers.

5. Other packages "com.relayr.config" and "com.relayr.processor" have basic configurations for Swagger and Batch.

