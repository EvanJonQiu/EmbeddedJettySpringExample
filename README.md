# EmbeddedJettySpringExample
An example of embedded Jetty with Spring. It demostrates how to create a standalone web server.

## You should
1. There is not database in the example. You should use your database and create a database by yourself before run it.
To create table as following stetment:
```
CREATE TABLE "WEBGIS_UNIT_OBD_DETAIL_MID" (
	`CITY_ID`	NUMERIC NOT NULL,
	`COMMUNITY_ADDR_ID`	NUMERIC NOT NULL,
	`COMMUNITY_DETAILNAME`	TEXT NOT NULL,
	`TERMID`	NUMERIC,
	`TERMNAME`	TEXT
)
```
2. Config your database in applicationContext.xml (My database is oracle)

## Packing the example
- Open windows console shell and change directory to example's.
- Execute "mvn clean package", then the package should be built in ./target.
- Copy the "EmbeddedJettySpringExample-package.tar.gz" to other directory and uncompress it.
- Enter the new direcotry and execute "java -jar EmbeddedJettySpringExample.jar"

## Open browser and input
1. "http://localhost:8098/testResult" you will get "Hello World!" from example.
2. "http://loocalhost:8098/getData", it will return data.

