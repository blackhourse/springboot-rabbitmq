package com.github.demo2;

import com.github.demo2.simple.consumer.Consumer;
import com.github.demo2.work.HelloSender2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WorkApplicationTests {

	@Autowired
	private HelloSender2 helloSender;

	@Autowired
	private Consumer consumer;

	@Test
	public void oneToMany() throws Exception {
		for (int i=0;i<100;i++){
			helloSender.send(i);
			Thread.sleep(300);
		}
	}





}
