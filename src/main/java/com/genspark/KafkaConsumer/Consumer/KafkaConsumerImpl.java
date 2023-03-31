package com.genspark.KafkaConsumer.Consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileWriter;

@Service
public class KafkaConsumerImpl implements KafkaConsumerInt{
	@KafkaListener(topics = "HrEventTopic", groupId = "Group1")
	public void listen(String hrEvent)
	{

		System.out.println("Received '" + hrEvent +"' from the HrEventTopic." );

		FileWriter out ;//= null;
		String output="HR_Activity_log.txt";
		File file=new File(output);
		try {
			out = new FileWriter(file);
			out.write("event");
			//out.write("event : ");
			out.write(hrEvent);
			System.out.println("writing in a HR_Activity_log file!!!");
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
}
