# Spring Boot Credit
RESTful application for adding credit information and retrieving.

## Created with
- Java
- Spring(Boot, Web, Data)
- H2
- Lombok

## Creating Docker image
For the entire project, you need to create images separately using in the IDE.
We can do this with the code below.
```
mvn spring-boot:build-image
```
Next start images in docker:
```
docker run -p 8080:8080 -d hrynowieckip/springbootcredit:0.0.1-SNAPSHOT
docker run -p 8081:8081 -d hrynowieckip/springbootproduct:0.0.1-SNAPSHOT
docker run -p 8082:8082 -d hrynowieckip/springbootcustomer:0.0.1-SNAPSHOT
```

## Example
#### Sample usage:
For submitting information about credit:
```
http://localhost:8080/createcredit
```
we need to provide JSON as the body.
Example:
```
{
    "customer": {
        "firstName" : "John",
        "surname" : "Kowalski",
        "pesel" : "01234567891"
    },
    "product": {
        "productName" : "Okazja Roku",
        "value" : 9999
    },
    "credit": {
        "creditName" : "CreditZero"
    }
}
```

To retrieve information about credit:
```
http://localhost:8080/getcredits
```
