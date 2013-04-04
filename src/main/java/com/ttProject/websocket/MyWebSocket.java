package com.ttProject.websocket;

import javax.servlet.http.HttpServletRequest;

import org.eclipse.jetty.websocket.WebSocket;
import org.eclipse.jetty.websocket.WebSocketServlet;

public class MyWebSocket extends WebSocketServlet {
	private static final long serialVersionUID = -4388727682700575642L;

	public WebSocket doWebSocketConnect(
			HttpServletRequest request, String protocol) {
		Application app = Application.getInstance(request.getRequestURI());
		return new Client(app);
	}
}
