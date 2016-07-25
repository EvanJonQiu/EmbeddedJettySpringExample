# EmbeddedJettySpringExample
An example of embedded Jetty with Spring. It demostrates how to create a standalone web server.

## You should
1. There is not database in the example. You should use your database and create a database by yourself before run it.
To create table as following stetment:
```
CREATE TABLE `webgis_unit_obd_detail_mid` (
  `CITY_ID` int(11) NOT NULL,
  `COMMUNITY_ADDR_ID` int(11) NOT NULL,
  `COMMUNITY_DETAILNAME` varchar(256) NOT NULL,
  `TERMID` int(11) DEFAULT NULL,
  `TERMNAME` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`CITY_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

CREATE TABLE `foo_info` (
  `ID` varchar(32) NOT NULL,
  `NAME` varchar(64) NOT NULL,
  `CREATE_USERNAME` varchar(64) NOT NULL,
  `CREATE_TIME` datetime NOT NULL,
  `MODIFY_USERNAME` varchar(64) DEFAULT NULL,
  `MODIFY_TIME` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

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

