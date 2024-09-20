package com.sist.main2;

import org.apache.commons.dbcp.BasicDataSource;
/*
 * <bean id="ds" class="org.apache.commons.dbcp.BasicDataSource"
      p:driverClassName="oracle.jdbc.driver.OracleDriver"
      p:url="jdbc:oracle:thin:@localhost:1521:XE"
      p:username="hr"
      p:password="happy"
      />
 */
public class MyBatisDataSource extends BasicDataSource{
    public MyBatisDataSource()
    {
    	setDriverClassName("oracle.jdbc.driver.OracleDriver");
    	setUrl("jdbc:oracle:thin:@localhost:1521:XE");
    	setUsername("hr");
    	setPassword("happy");
    }
}
