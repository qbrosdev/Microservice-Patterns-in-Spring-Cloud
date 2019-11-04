package com.example.service.domain;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.boot.jackson.JsonObjectDeserializer;

import java.io.IOException;

/**
 * Created by QBros on Zero Hour ... Hooah!
 */
public class CustomerDeserializer extends JsonObjectDeserializer<Customer> {

	@Override
	protected Customer deserializeObject(JsonParser jsonParser, DeserializationContext deserializationContext,
                                         ObjectCodec objectCodec, JsonNode jsonNode) throws IOException {
		//String title = nullSafeValue(jsonNode.get("title"), String.class);
        //for deserialize child objects
        //JsonNode userNode = jsonNode.get("user");
		//GithubUser user = objectCodec.readValue(userNode.traverse(objectCodec), GithubUser.class);
		return Customer.builder()
                .customerName(nullSafeValue(jsonNode.get("customerName"), String.class))
                .test(nullSafeValue(jsonNode.get("test"), Integer.class))
				//just for test
                .id(12)
                .build();
	}
}
