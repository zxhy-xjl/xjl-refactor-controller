package com.zxhy.xjl.refactor.controller;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.zxhy.xjl.web.controller.BaseControllerTest;


/**
 * Unit test for simple App.
 */
public class FlowControllerTest extends BaseControllerTest{
	@Autowired
	private FlowController controller;
	@Override
	public Object getController() {
		return this.controller;
	}
	@Test
	public void add(){
		String uri = "/flow/add";
		String json = "{\"flowName\":\"abc\"}";
		String resp = this.mockPost(uri, json);
		System.out.println("add:" + resp);
	}
}
