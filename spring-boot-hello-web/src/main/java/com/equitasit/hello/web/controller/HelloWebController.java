package com.equitasit.hello.web.controller;

import java.net.Inet4Address;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.equitasit.hello.web.model.RespData;
import com.equitasit.hello.web.model.ServerInfo;

@Controller
public class HelloWebController {

	@Autowired
	private ServerProperties serverProperties;

	@GetMapping("hello")
	@CrossOrigin(value = "*")
	public String hello(@RequestParam(name = "name", required = false, defaultValue = "") String name,
			HttpServletRequest request, Model model) throws Exception {

		return "hello";
	}

	@PostMapping("hello")
	@CrossOrigin(value = "*")
	public String helloPost(@RequestParam(name = "name", required = false, defaultValue = "") String name,
			HttpServletRequest request, Model model) throws Exception {

		model.addAttribute("respData", getData(name, request));

		return "hello";
	}

	public RespData getData(String name, HttpServletRequest request) throws Exception {

		RespData respData = new RespData();

		respData.setDate(new Date());

		respData.setMsg("hello " + name);

		respData.setServer(serverInfo());

		respData.setRemote(remoteInfo(request));

		return respData;
	}

	private ServerInfo remoteInfo(HttpServletRequest request) {

		ServerInfo serverInfo = new ServerInfo();

		serverInfo.setIp(request.getRemoteAddr());

		serverInfo.setPort(request.getRemotePort());

		return serverInfo;
	}

	private ServerInfo serverInfo() throws Exception {

		ServerInfo serverInfo = new ServerInfo();

		serverInfo.setIp(Inet4Address.getLocalHost().toString());

		serverInfo.setPort(serverProperties.getPort());

		return serverInfo;
	}

}
