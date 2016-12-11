package com.zdhy.platform.itsm.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zdhy.platform.itsm.entity.Person;

@RestController
@RequestMapping(value = { "/test" }, produces = { "application/json;charset=UTF-8" })
@Api(value = "/test", description = "test的相关操作")
public class TestController {

	@RequestMapping(value = { "/getPersonInfo" }, method = RequestMethod.POST)
	@ApiOperation(notes = "getPersonInfo", httpMethod = "POST", value = "根据用户名获取用户")
	@ApiImplicitParams({ @ApiImplicitParam(paramType = "query", name = "name", dataType = "String", value = "用户名", defaultValue = "ddd") })
	public Person getTestWord(
			@RequestParam(value = "name", required = false) String name,
			HttpServletRequest req) {
		// Person Person = personService.findPersonByName(name);
		Person person = new Person();
		person.setName(name);
		return person;
	}
}