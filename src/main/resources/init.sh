#!/bin/sh

curl --location --request POST 'localhost:8081/api/v1/patient/save' \
--header 'Content-Type: application/json' \
--data-raw '{
    "firstName": "lebron",
    "lastName": "James",
    "dateOfBirth": "1960-03-12",
    "gender": "M",
    "address": "8 mile road, Detroit",
    "phone": "000-111-222"
}'

curl --location --request POST 'localhost:8081/api/v1/patient/save' \
--header 'Content-Type: application/json' \
--data-raw '{
    "firstName": "Jah",
    "lastName": "Morant",
    "dateOfBirth": "1987-11-23",
    "gender": "M",
    "address": "1 Brookside St, Chicago",
    "phone": "200-333-4444"
}'

curl --location --request POST 'localhost:8081/api/v1/patient/save' \
--header 'Content-Type: application/json' \
--data-raw '{
    "firstName": "ray",
    "lastName": "Allen",
    "dateOfBirth": "1979-08-15",
    "gender": "M",
    "address": "2 High St, Denver",
    "phone": "400-555-6666"
}'

curl --location --request POST 'localhost:8081/api/v1/patient/save' \
--header 'Content-Type: application/json' \
--data-raw '{
    "firstName": "candice",
    "lastName": "Parker",
    "dateOfBirth": "1998-12-02",
    "gender": "F",
    "address": "4 Valley Dr",
    "phone": "300-444-5555"
}'


