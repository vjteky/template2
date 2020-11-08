# template2

This app demonstrates these things

1) REST APIs
2) REST Controllers
3) ThymeLeaf - Fill and Submit a form
4) Unit and Integration test cases
5) Swagger
6) Metrics
7) Logging
8) Acutator
9) JDBC example using MySQL

POST - http://localhost:8080/api/v1/shortLink (In the body https://www.shoes.com/dr-martens-boots/category_52944)

GET - http://localhost:8080/api/v1/shortLink?url=https://www.shoes.com/dr-martens-boots/category_52944

http://localhost:8080/greeting
http://localhost:8080/welcome
http://localhost:8080/register
http://localhost:8080/abcdefg (Here abcdefg is the result of GET call above)


http://localhost:8080/actuator/health

http://localhost:8080/actuator/metrics

http://localhost:8080/actuator/beans

http://localhost:8080/actuator/metrics/emps.getAll

docker rm <conainer>
docker rmi <image>

docker run -d --name influx -p 8086:8086 influxdb

docker ps
docker ps -a

docker exec -it influx influx

show databases

show users

CREATE USER admin WITH PASSWORD 'adminpass' WITH ALL PRIVILEGES

CREATE USER telegraf WITH PASSWORD 'telegraf' WITH ALL PRIVILEGES

GRANT ALL PRIVILEGES TO <username>

docker run -d --name chronograf -p 8888:8888 chronograf
http://localhost:8888/

SHOW DATABASES 

USE EmpApp 

show series  -- to see the metrics

show measurements  --for list of metrics

select * from "emps_getAll"

select * from "emps_getAllTime"


https://medium.com/@rohansaraf/monitoring-in-springboot-2-0-micrometer-influxdb-chronograf-d049698bfa33

