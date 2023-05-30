package models;

import java.io.Serializable;

public class PaqueteEnvio implements Serializable {

	private String nick;
	private String ip;
	private String mensaje;
	
	public PaqueteEnvio(String nick, String ip, String mensaje) {
		this.nick = nick;
		this.ip = ip;
		this.mensaje = mensaje;
	}

	public PaqueteEnvio() {
	
	}
	
	
	public void setNick(String nick) {
		this.nick = nick;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}


	
	public String getNick() {
		return this.nick;
	}
	
	public String getIp() {
		return this.ip;
	}
	
	public String getMensaje() {
		return this.mensaje;
	}
}

