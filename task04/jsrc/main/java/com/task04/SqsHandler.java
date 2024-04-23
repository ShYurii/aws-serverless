package com.task04;

//import com.amazonaws.services.lambda.runtime.Context;
//import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.syndicate.deployment.annotations.lambda.LambdaHandler;
import com.syndicate.deployment.model.RetentionSetting;

import java.util.HashMap;
import java.util.Map;

//@LambdaHandler(lambdaName = "sqs_handler",
//	roleName = "sqs_handler-role",
//	isPublishVersion = true,
//	aliasName = "${lambdas_alias_name}",
//	logsExpiration = RetentionSetting.SYNDICATE_ALIASES_SPECIFIED
//)
//public class SqsHandler implements RequestHandler<Object, Map<String, Object>> {
//
//	public Map<String, Object> handleRequest(Object request, Context context) {
//		System.out.println("Hello from lambda");
//		Map<String, Object> resultMap = new HashMap<String, Object>();
//		resultMap.put("statusCode", 200);
//		resultMap.put("body", "Hello from Lambda");
//		return resultMap;
//	}
//}

import software.amazon.awssdk.services.sqs.model.Message;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.SQSEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SqsHandler implements RequestHandler<SQSEvent, Void> {

	private static final Logger LOG = LogManager.getLogger(SqsHandler.class);

	@Override
	public Void handleRequest(SQSEvent event, Context context) {
		for (SQSEvent.SQSMessage msg : event.getRecords()){
			LOG.info("New message from SQS: " + msg.getBody());
		}
		return null;
	}
}

