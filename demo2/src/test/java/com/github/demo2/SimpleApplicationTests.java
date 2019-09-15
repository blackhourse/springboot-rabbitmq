package com.github.demo2;

import com.github.demo2.simple.consumer.Consumer;
import com.github.demo2.simple.send.HelloSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SimpleApplicationTests {

	@Autowired
	private HelloSender helloSender;

	@Autowired
	private Consumer consumer;

	@Test
	public void helloSend() {
		helloSender.send();
	}

	@Test
	public void helloConsumer() {
		consumer.process("1");
	}

}
