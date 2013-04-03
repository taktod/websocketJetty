package com.ttProject.websocket;

import javax.servlet.http.HttpServletRequest;

import org.eclipse.jetty.websocket.WebSocketServlet;

public class WebSocket extends WebSocketServlet {
	private static final long serialVersionUID = -4388727682700575642L;

	public org.eclipse.jetty.websocket.WebSocket doWebSocketConnect(
			HttpServletRequest request, String protocol) {
		System.out.println(request.getPathInfo());
		Application app = Application.getInstance(request.getPathInfo());
		return new Client(app);
	}
}
