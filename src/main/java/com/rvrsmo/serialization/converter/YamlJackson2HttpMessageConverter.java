package com.rvrsmo.serialization.converter;

import org.springframework.http.MediaType;
import org.springframework.http.converter.json.AbstractJackson2HttpMessageConverter;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;


public class YamlJackson2HttpMessageConverter extends AbstractJackson2HttpMessageConverter {

	protected YamlJackson2HttpMessageConverter(ObjectMapper objectMapper) {
		/*
		 * super(new YAMLMapper() .setSerializationInclusion(
		 * JsonInclude.Include.NON_NULL),
		 * MediaType.parseMediaTypes("application/x-yaml"));
		 */
		super(objectMapper);
		// TODO Auto-generated constructor stub
	}
	
	
}
