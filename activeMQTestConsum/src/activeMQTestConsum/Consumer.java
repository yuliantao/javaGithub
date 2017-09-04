package activeMQTestConsum;

import java.util.Date;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Session;
import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

public class Consumer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//ptp();
		Topic();
	}

	private static void ptp() {
		String user = ActiveMQConnection.DEFAULT_USER;
		String password = ActiveMQConnection.DEFAULT_PASSWORD;
		String url = "failover://tcp://localhost:61616";
		String subject = "test.queue";
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(user, password, url);
		Connection connection;
		try {
			connection = connectionFactory.createConnection();
			connection.start();
			final Session session = connection.createSession(Boolean.FALSE, Session.AUTO_ACKNOWLEDGE);//������Ϣ���պ�Ļظ�ģʽ
			Destination destination = session.createQueue(subject);
			MessageConsumer message = session.createConsumer(destination);
			//�����첽������Ϣ
			message.setMessageListener(new MessageListener() {
				public void onMessage(Message msg) {
					MapMessage message = (MapMessage) msg;
					try {
						int intValue=message.getInt("intValue");
						long longValue=message.getLong("count");
						System.out.println("--�յ���Ϣ��" + new Date()+" intValue="+intValue+" longValue="+longValue);
						//session.commit();
					} catch (JMSException e) {
						e.printStackTrace();
					}
				}
			});		
			//session.close();			
			//connection.close();			
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}
	
	private static void Topic() {		 
		String user = ActiveMQConnection.DEFAULT_USER;
        String password = ActiveMQConnection.DEFAULT_PASSWORD;
        String url = "tcp://localhost:61616";
        String subject = "mq.topic";
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory(user, password, url);
        Connection connection;
        try {
            connection= factory.createConnection();    
            connection.setClientID("cj1");//���ö������ǳ־û�
            connection.start();
            final Session session =connection.createSession(Boolean.FALSE, Session.AUTO_ACKNOWLEDGE);
            javax.jms.Topic topic = session.createTopic(subject);
            //MessageConsumer consumer = session.createConsumer(topic); ////��ͨ���ķ�ʽ    
            MessageConsumer consumer = session.createDurableSubscriber(topic,"cj1");//�־ö��ķ�ʽ  
            consumer.setMessageListener(new MessageListener() {
                public void onMessage(Message msg){
                    MapMessage message = (MapMessage) msg;
                    try {
						int intValue=message.getInt("intValue");
						long longValue=message.getLong("count");
						System.out.println("--�յ���Ϣ��" + new Date()+" intValue="+intValue+" longValue="+longValue);
                        //session.commit();
                    }catch(JMSException e) {
                        e.printStackTrace();
                    }
                }
            });
        }catch(JMSException e) {
            e.printStackTrace();
        }
	}
	
}
