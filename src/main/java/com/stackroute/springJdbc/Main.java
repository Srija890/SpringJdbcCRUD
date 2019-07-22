package com.stackroute.springJdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLOutput;

public class Main
{
   public static void main(String args[])
   {
       ApplicationContext applicationContext=new AnnotationConfigApplicationContext(ConfigurationBean.class);
       EmployeeDao employeeDao=applicationContext.getBean("employeeDao",EmployeeDao.class);
       Employee employee=new Employee();
       //employeeDao.createTable();
       employeeDao.insertData();
       employeeDao.updateDetails();
       employeeDao.readData();
      // employeeDao.deleteDetails();

   }
}