package me.duckdoom5.RpgServer;

public class RpgServerData {
	private String ip;
	private int port;
	
	public RpgServerData(String ip, int port){
		this.ip = ip;
		this.port = port;
	}
	
	public int getPort(){
		return port;
	}
	
	public String getIp(){
		return ip;
	}
	
	public void requestData(){
		
	}
}
