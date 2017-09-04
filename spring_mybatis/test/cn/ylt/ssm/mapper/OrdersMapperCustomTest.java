package cn.ylt.ssm.mapper;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.ylt.ssm.po.OrdersCustom;

public class OrdersMapperCustomTest {

	private ApplicationContext  applicationContext;
	
	@Before
	public void setUp() throws Exception {
		applicationContext=new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
	}

	@Test
	public void testFindOrdersUser() throws Exception {
		OrdersMapperCustom ordersMapperCustom=(OrdersMapperCustom) applicationContext.getBean("ordersMapperCustom");
		List<OrdersCustom> list=ordersMapperCustom.findOrdersUser();
		System.out.println(list);
	}

}
