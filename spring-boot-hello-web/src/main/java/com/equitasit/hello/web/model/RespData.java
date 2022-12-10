package com.equitasit.hello.web.model;

import java.util.Date;

public class RespData {

	private String msg;

	private Date date;

	private ServerInfo server;

	private ServerInfo remote;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public ServerInfo getServer() {
		return server;
	}

	public void setServer(ServerInfo server) {
		this.server = server;
	}

	public ServerInfo getRemote() {
		return remote;
	}

	public void setRemote(ServerInfo remote) {
		this.remote = remote;
	}
	
	

}
