

#!/bin/bash

module add --name=com.oracle --resources=/home/jboss/ojdbc6.jar --dependencies=javax.api,javax.transaction.api

/subsystem=datasources/jdbc-driver=oracle:add(driver-module-name=com.oracle,driver-name=oracle,driver-xa-datasource-class-name=oracle.jdbc.xa.client.OracleXADataSource)

data-source add --name=OracleDS --jndi-name=java:jboss/datasources/OracleDS --driver-name=oracle --connection-url=jdbc:oracle.example.com:thin:@oracle:1521:XE --enabled=true --user-name=student --password=redhat --min-pool-size=5 --max-pool-size=10 --use-java-context=true
