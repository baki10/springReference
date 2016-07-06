package com.bakigoal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/angularPage")
public class AngularController {

	@RequestMapping(method = RequestMethod.GET)
	public String main() {
		return "angularMainPage";
	}

	@RequestMapping(value = "/angular1", method = RequestMethod.GET)
	public String basics() {
		return "angularBasic";
	}

	@RequestMapping(value = "/angular2", method = RequestMethod.GET)
	public String toDo() {
		return "angularToDo";
	}

	@RequestMapping(value = "/angular3", method = RequestMethod.GET)
	public String search() {
		return "angularSearch";
	}

	@RequestMapping(value = "/angular4", method = RequestMethod.GET)
	public String sort() {
		return "angularSort";
	}

	@RequestMapping(value = "/angular5", method = RequestMethod.GET)
	public String time() {
		return "angularTime";
	}

	@RequestMapping(value = "/angular6", method = RequestMethod.GET)
	public String http() {
		return "angularHttp";
	}

	@RequestMapping(value = "/angular7", method = RequestMethod.GET)
	public String rest() {
		return "angularREST";
	}

	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public @ResponseBody
	String welcome() {
		return "{\"message\":\"This Welcome Text is from spring controller\"}";
	}

}