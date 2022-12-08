package com.equitasitinc.demo.controller;

import java.net.Inet4Address;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class HelloController {

	@Autowired
	private ServerProperties serverProperties;

	@GetMapping("hello")
	public Map<String, Object> hello(@RequestParam(name = "name", required = false, defaultValue = "") String name,
			HttpServletRequest request) throws Exception {

		Map<String, Object> respMap = new HashMap<>();

		respMap.put("msg", "hello " + name);

		respMap.put("date", Calendar.getInstance().getTime());

		respMap.put("server", serverInfo());

		respMap.put("remote", remoteInfo(request));

		return respMap;
	}

	private Map<String, Object> remoteInfo(HttpServletRequest request) {
		Map<String, Object> remoteMap = new HashMap<>();
		remoteMap.put("IP", request.getRemoteAddr());
		remoteMap.put("port", request.getRemotePort());
		return remoteMap;
	}

	private Map<String, Object> serverInfo() throws Exception {
		Map<String, Object> remoteMap = new HashMap<>();
		remoteMap.put("IP", Inet4Address.getLocalHost());
		remoteMap.put("port", serverProperties.getPort());
		return remoteMap;
	}
}
