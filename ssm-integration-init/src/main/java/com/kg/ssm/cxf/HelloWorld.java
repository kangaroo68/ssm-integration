package com.kg.ssm.cxf;

import javax.jws.WebService;

@WebService
public interface HelloWorld {

	public String say(String str);
}
