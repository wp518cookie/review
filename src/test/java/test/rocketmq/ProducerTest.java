package test.rocketmq;

import base.BaseJUnitTest;
import com.alibaba.rocketmq.client.consumer.DefaultMQPushConsumer;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import com.alibaba.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import com.alibaba.rocketmq.client.producer.DefaultMQProducer;
import com.alibaba.rocketmq.client.producer.SendResult;
import com.alibaba.rocketmq.common.consumer.ConsumeFromWhere;
import com.alibaba.rocketmq.common.message.Message;
import com.alibaba.rocketmq.common.message.MessageExt;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;


/**
 * Created by ping.wu on 2018/4/20.
 */
public class ProducerTest extends BaseJUnitTest {
    private final Logger logger = LoggerFactory.getLogger(ProducerTest.class);

    @Test
    public void produce() throws Exception {
        DefaultMQProducer producer = new DefaultMQProducer("ProducerGroupName");
        producer.setNamesrvAddr("106.14.115.150:9876");
        producer.start();
        try {
            Message msg = new Message("topic", "*", "hello",
                    ("Hello MetaQ").getBytes());
            SendResult sendResult = producer.send(msg);
            System.out.println(sendResult);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void consume() throws Exception {
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer(
                "ConsumerGroupName");
        consumer.setNamesrvAddr("106.14.115.150:9876");
        consumer.subscribe("topic", "*");
        consumer.subscribe("TopicTest2", "*");
        consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);

        consumer.registerMessageListener(new MessageListenerConcurrently() {
            public ConsumeConcurrentlyStatus consumeMessage(
                    List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
                System.out.println(Thread.currentThread().getName()
                        + " Receive New Messages: " + msgs);
                MessageExt msg = msgs.get(0);
                System.out.println(new String(msg.getBody()));
                if (msg.getTopic().equals("topic")) {
                    System.out.println("message consume!");
                }
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });
        consumer.start();
        System.out.println("Consumer Started.");
        TimeUnit.SECONDS.sleep(3);
    }
}
