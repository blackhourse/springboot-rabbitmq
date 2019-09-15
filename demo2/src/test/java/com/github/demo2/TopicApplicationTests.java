package com.github.demo2;

import com.github.demo2.simple.consumer.Consumer;
import com.github.demo2.topic.MsgSender;
import com.github.demo2.topic.Receiver1;
import com.github.demo2.topic.Receiver2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TopicApplicationTests {

	@Autowired
	private MsgSender msgSender;

	@Autowired
	private Receiver1 receiver1;
	@Autowired
	private Receiver2 receiver2;

	@Test
	public void send1() throws Exception {
		msgSender.send1();
	}

	@Test
	public void send2() throws Exception {
		msgSender.send2();
	}

	@Test
	public void receiver1() throws Exception {
		receiver1.process("fff");
	}
	@Test
	public void receiver2() throws Exception {
		receiver2.process("fff");
	}
}
