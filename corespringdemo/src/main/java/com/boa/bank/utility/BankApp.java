package com.boa.bank.utility;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.boa.bank.models.Account;
import com.boa.bank.models.Customer;

public class BankApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
/*
		//Customer Object
		Resource resource=new ClassPathResource("spring-core.xml");
        BeanFactory beanFactory=new XmlBeanFactory(resource);
        //IOC
        Customer customer=(Customer) beanFactory.getBean("customer");
        System.out.println(customer);
        
        //account object
        Account account=(Account) beanFactory.getBean("account");
        System.out.println(account);
	*/
		
		//Application Context
		
		ApplicationContext ctx=new ClassPathXmlApplicationContext(
                "spring-application-context.xml");
		
		 Customer customer=(Customer) ctx.getBean("customer");
		  System.out.println(customer);
	}

}
