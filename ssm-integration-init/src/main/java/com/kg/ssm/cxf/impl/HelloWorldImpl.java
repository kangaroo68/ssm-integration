package com.kg.ssm.cxf.impl;

import com.kg.ssm.cxf.HelloWorld;
import org.springframework.stereotype.Component;

import javax.jws.WebService;

@Component("helloWorld")
@WebService
public class HelloWorldImpl implements HelloWorld {

	@Override
    public String say(String str) {
		return "Hello"+str;
	}

}
