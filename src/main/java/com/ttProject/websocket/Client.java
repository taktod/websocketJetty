package com.ttProject.websocket;

import java.io.IOException;

import org.eclipse.jetty.websocket.WebSocket.OnTextMessage;

/**
 * それぞれのクライアントオブジェクト
 * @author taktod
 */
public class Client implements OnTextMessage {
	private Connection conn;
	private final Application app;
	public Client(Application app) {
		this.app = app;
	}
	/**
	 * 切断時イベント
	 */
	public void onClose(int status, String protocol) {
		this.app.removeClient(this);
	}
	/**
	 * 接続時イベント
	 */
	public void onOpen(Connection conn) {
		this.conn = conn;
		this.app.addClient(this);
	}
	/**
	 * メッセージ受信イベント
	 */
	public void onMessage(String message) {
		// メッセージを他のユーザーに飛ばす。
		for(Client client : this.app.getClientSet()) {
			try {
				client.sendMessage(message);
			}
			catch (Exception e) {
				;
			}
		}
	}
	/**
	 * メッセージを送る
	 * @param message
	 * @throws IOException
	 */
	public void sendMessage(String message) throws IOException {
		conn.sendMessage(message);
	}
}
