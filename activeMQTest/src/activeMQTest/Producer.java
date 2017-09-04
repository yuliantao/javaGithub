package activeMQTest;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.InvalidSelectorException;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.management.MBeanServerConnection;
import javax.management.MBeanServerInvocationHandler;
import javax.management.MalformedObjectNameException;
import javax.management.ObjectName;
import javax.management.openmbean.OpenDataException;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.broker.jmx.BrokerViewMBean;
import org.apache.activemq.broker.jmx.QueueViewMBean;
import org.apache.activemq.broker.jmx.TopicViewMBean;
import org.apache.activemq.util.URISupport.CompositeData;

public class Producer {

	public static void main(String[] args) throws MalformedObjectNameException, IOException, OpenDataException, InvalidSelectorException {
		// TODO Auto-generated method stub
		//ptp();
		//Topic();
		getQueueMap();
	}

	private static void ptp() {
		String user = ActiveMQConnection.DEFAULT_USER;
		String password = ActiveMQConnection.DEFAULT_PASSWORD;
		String url = "failover://tcp://localhost:61616";
		String subject = "test.queue";
		ConnectionFactory contectionFactory = new ActiveMQConnectionFactory(user, password, url);
		try {
			Connection connection = contectionFactory.createConnection();
			connection.start();
			Session session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);
			Destination destination = session.createQueue(subject);
			MessageProducer producer = session.createProducer(destination);
			producer.setTimeToLive(60000); //有效期1小时 （1000毫秒 * 60秒 * 60分）,默认是永远不过期
			//producer.setTimeToLive(3600000); //有效期1小时 （1000毫秒 * 60秒 * 60分）,默认是永远不过期
			//producer.setPriority(9);//消息的优先级。0-4为正常的优先级，5-9为高优先级。可以通过下面方式设置：
			//Producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);//消息的发送模式：persistent或nonpersistent,默认是第一种
			for (int i = 0; i <= 20; i++) {
				MapMessage message = session.createMapMessage();
				Date date = new Date();
				message.setLong("count", date.getTime());
				message.setInt("intValue",22);
				producer.send(message);
				System.out.println("--发送消息：" + date);
			}			
			session.commit();
			session.close();
			connection.close();
		} catch (JMSException e) {
			e.printStackTrace();
		} 
	}

	private static void Topic() {
		String user = ActiveMQConnection.DEFAULT_USER;
        String password = ActiveMQConnection.DEFAULT_PASSWORD;
        String url = "tcp://localhost:61616";
        String subject = "mq.topic";
        ActiveMQConnectionFactory amcf = new ActiveMQConnectionFactory(user, password, url);
        try {
            Connection conn = amcf.createConnection();
            conn.start();
            Session session = conn.createSession(Boolean.TRUE,Session.AUTO_ACKNOWLEDGE);            
            Destination d = session.createTopic(subject);
            MessageProducer producer = session.createProducer(d);
            producer.setTimeToLive(60000); 
			//producer.setTimeToLive(3600000); //有效期1小时 （1000毫秒 * 60秒 * 60分）,默认是永远不过期
			//producer.setPriority(9);//消息的优先级。0-4为正常的优先级，5-9为高优先级。可以通过下面方式设置：
			//Producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);//消息的发送模式：persistent或nonpersistent,默认是第一种
            for (int i = 0; i <= 20; i++){
                MapMessage message = session.createMapMessage();
                Date date = new Date();
                message.setLong("count",date.getTime());
                message.setInt("intValue", 100);
                producer.send(message);
                System.out.println("--发送消息：" + date);
            }          
            session.commit();
            session.close();
            conn.close();
        }catch(Exception e) {
            e.printStackTrace();
        }
	}

	private static void getQueueMap() throws IOException, MalformedObjectNameException, OpenDataException, InvalidSelectorException {
		
//	    String reportQueueName ="zc-queue-actual";//生成核对报告队列名
//	    String connectorPort = "1093";
//	    String connectorPath = "/jmxrmi";
//	    String jmxDomain = "org.apache.activemq";
//		
//	    HashMap<String,Long> queueMap=new HashMap<String, Long>();
//        BrokerViewMBean mBean=null;
//        MBeanServerConnection connection=null;
//        try{
//            JMXServiceURL url = new JMXServiceURL("service:jmx:rmi:///jndi/rmi://localhost:" + connectorPort + connectorPath);
//            JMXConnector connector = JMXConnectorFactory.connect(url);
//            connector.connect();
//            connection = connector.getMBeanServerConnection();
//            ObjectName name = new ObjectName(jmxDomain + ":brokerName=localhost,type=Broker");
//            mBean = MBeanServerInvocationHandler.newProxyInstance(connection, name, BrokerViewMBean.class, true);
//        }catch (IOException e){
//            
//        }catch (MalformedObjectNameException e){
//            
//        }
//
//        if(mBean!=null){
//            for (ObjectName queueName : mBean.getQueues()) {
//                QueueViewMBean queueMBean = MBeanServerInvocationHandler.newProxyInstance(connection, queueName, QueueViewMBean.class, true);
//                queueMap.put(queueMBean.getName(),queueMBean.getQueueSize());
//                //System.out.println("Queue Name --- " + queueMBean.getName());// 消息队列名称
//                //System.out.println("Queue Size --- " + queueMBean.getQueueSize());// 队列中剩余的消息数
//                //System.out.println("Number of Consumers --- " + queueMBean.getConsumerCount());// 消费者数
//                //System.out.println("Number of Dequeue ---" + queueMBean.getDequeueCount());// 出队数
//            }
//        }
//
//        return queueMap;
		
		
	    //jmx服务地址，注意端口
	    String jmxserviceURL="service:jmx:rmi:///jndi/rmi://localhost:1099/jmxrmi";
	    //brokerName和type首字母要小些，brokerName=broker要与上面配置文件一致，斜体下划线部分
	    String objectName="org.apache.activemq:brokerName=localhost,type=Broker";
		
		JMXServiceURL url = new JMXServiceURL(jmxserviceURL);
        JMXConnector connector = JMXConnectorFactory.connect(url, null);
        connector.connect();
        MBeanServerConnection connection = connector.getMBeanServerConnection();

        ObjectName name = new ObjectName(objectName);
        BrokerViewMBean mBean =  (BrokerViewMBean)MBeanServerInvocationHandler.newProxyInstance(connection,
               name, BrokerViewMBean.class, true);
        // System.out.println(mBean.getBrokerName());
        
        for(ObjectName queueName : mBean.getQueues()) {
            QueueViewMBean queueMBean =   (QueueViewMBean)MBeanServerInvocationHandler.newProxyInstance(connection, queueName, QueueViewMBean.class, true);
            System.out.println("\n------------------------------\n");

            // 消息队列名称
            System.out.println("States for queue --- " + queueMBean.getName());

            // 队列中剩余的消息数
            System.out.println("Size --- " + queueMBean.getQueueSize());

            // 消费者数
            System.out.println("Number of consumers --- " + queueMBean.getConsumerCount());
            
            
            // 出队数
            System.out.println("Number of dequeue ---" + queueMBean.getDequeueCount() );
        }
		
        for(ObjectName topicName : mBean.getTopics()) {
            TopicViewMBean topicMBean =   (TopicViewMBean)MBeanServerInvocationHandler.newProxyInstance(connection, topicName, TopicViewMBean.class, true);
            System.out.println("\n------------------------------\n");

            
            // 消息队列名称
            System.out.println("States for topic --- " + topicMBean.getName());
            
            System.out.println("开始监视" );
            // 队列中剩余的消息数
            System.out.println("Size --- " + topicMBean.getQueueSize());
           

            ObjectName[] obj= topicMBean.getSubscriptions();
            javax.management.openmbean.CompositeData[] date= topicMBean.browse();
            List<?>  list=topicMBean.browseMessages();
            ObjectName[] obj2=topicMBean.getSubscriptions();
            
            
            
            // 消费者数
            System.out.println("Number of consumers --- " + topicMBean.getConsumerCount());
            
            
            // 出队数
            System.out.println("Number of dequeue ---" + topicMBean.getDequeueCount() );
        }
        
	}

}
