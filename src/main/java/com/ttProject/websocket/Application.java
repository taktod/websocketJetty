package com.ttProject.websocket;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * スコープ用
 * @author taktod
 */
public class Application {
	private static Map<String, Application> applications = new ConcurrentHashMap<String, Application>(); 
	private Set<Client> clientSet = new CopyOnWriteArraySet<Client>();
	private final String path;
	public static Application getInstance(String path) {
		Application app = applications.get(path);
		if(app == null) {
			app = new Application(path);
			applications.put(path, app);
		}
		return app;
	}
	private Application(String path) {
		this.path = path;
	}
	public void addClient(Client client) {
		clientSet.add(client);
	}
	public void removeClient(Client client) {
		clientSet.remove(client);
	}
	public Set<Client> getClientSet() {
		return clientSet;
	}
	public String getPath() {
		return path;
	}
}
