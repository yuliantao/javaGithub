package cn.ylt.mybatisStandard.mapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import cn.ylt.mybatisStandard.mapper.OrdersMapperCustom;
import cn.ylt.mybatisStandard.po.Orders;
import cn.ylt.mybatisStandard.po.OrdersCustom;
import cn.ylt.mybatisStandard.po.User;

public class OrdersMapperCustomTest {

	private SqlSessionFactory sqlSessionFactory;
	@Before
	public void setUp() throws Exception {
		//mybatis�����ļ�
		String resource="SqlMapConfig.xml";
		//�õ������ļ�����
		InputStream inputStream=Resources.getResourceAsStream(resource);
		//�����Ự����������mybatis�������ļ���Ϣ
		sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
	}

	@Test
	public void testFindOrdersUser() throws Exception {
		
		SqlSession sqlSession=sqlSessionFactory.openSession();
		//����mapper�������
		OrdersMapperCustom ordersMapperCustom=sqlSession.getMapper(OrdersMapperCustom.class);
		List<OrdersCustom> list=ordersMapperCustom.findOrdersUser();
		System.out.println(list);
		sqlSession.close();
	}
	
	@Test
	public void testfindOrdersUserwithRM() throws Exception {
		
		SqlSession sqlSession=sqlSessionFactory.openSession();
		//����mapper�������
		OrdersMapperCustom ordersMapperCustom=sqlSession.getMapper(OrdersMapperCustom.class);
		List<Orders> list=ordersMapperCustom.findOrdersUserwithRM();
		System.out.println(list);
		sqlSession.close();
	}
	
	@Test
	public void testfindOrdersUserAndDetails() throws Exception{
		SqlSession sqlSession=sqlSessionFactory.openSession();
		//����mapper�������
		OrdersMapperCustom ordersMapperCustom=sqlSession.getMapper(OrdersMapperCustom.class);
		List<Orders> list=ordersMapperCustom.findOrdersUserAndDetails();
		System.out.println(list);
		sqlSession.close();
	}
	
	@Test
	public void testfindUserAndItemsResultMap() throws Exception{
		SqlSession sqlSession=sqlSessionFactory.openSession();
		//����mapper�������
		OrdersMapperCustom ordersMapperCustom=sqlSession.getMapper(OrdersMapperCustom.class);
		List<User> list=ordersMapperCustom.findUserAndItemsResultMap();
		sqlSession.close();
	}	
	
	@Test
	public void testfindOrdersUserLazyLoading() throws Exception{
		SqlSession sqlSession=sqlSessionFactory.openSession();
		OrdersMapperCustom ordersMapperCustom=sqlSession.getMapper(OrdersMapperCustom.class);
		//��ѯ����
		List<Orders> list=ordersMapperCustom.findOrdersUserLazyLoading();
		//�����ϱߵĶ����б�
		for(Orders orders :list)
		{
			User user=orders.getUser();
			System.out.println(user);
		}
		sqlSession.close();		
	}
	
}
