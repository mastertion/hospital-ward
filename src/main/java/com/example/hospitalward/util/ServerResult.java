package com.example.hospitalward.util;

import java.util.HashMap;
import java.util.Map;

/**
 * 返回数据
 */
public class ServerResult extends HashMap<String, Object> {
	private static final long serialVersionUID = 1L;
	
	public ServerResult() {
		put("code", 200);
	}
	
	public static ServerResult error() {
		return error(500, "未知异常，请联系管理员");
	}
	
	public static ServerResult error(String msg) {
		return error(500, msg);
	}
	
	public static ServerResult error(int code, String msg) {
		ServerResult ServerResult = new ServerResult();
		ServerResult.put("code", code);
		ServerResult.put("msg", msg);
		return ServerResult;
	}

	public static ServerResult ok(String msg) {
		ServerResult r = new ServerResult();
		r.put("msg", msg);
		return r;
	}
	
	public static ServerResult ok(Map<String, Object> map) {
		ServerResult r = new ServerResult();
		r.putAll(map);
		return r;
	}
	
	public static ServerResult ok() {
		return new ServerResult();
	}

	public ServerResult put(String key, Object value) {
		super.put(key, value);
		return this;
	}
}
