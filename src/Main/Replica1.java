package Main;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JFrame;

import models.PaqueteEnvio;

public class Replica1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		listen(); // escuchamos las conexiones del cliente 
		
		
	}

	public static  void updateLog(String mensaje) {
		String filePath = "log.txt";
		
		File file = new File(filePath);
		FileWriter fr = null;
		try {
			// Below constructor argument decides whether to append or override
			fr = new FileWriter(file, true);
			fr.write(mensaje + "\n");

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void listen() {

		
		try {
			ServerSocket servidor = new ServerSocket(9998);
			
				
			String ip, mensaje, nick;
			PaqueteEnvio paqueteRecibido;
			
			while(true){
				//System.out.println("we");
				Socket miSocket = servidor.accept();
				ObjectInputStream paqueteDatos =  new ObjectInputStream(miSocket.getInputStream());

				paqueteRecibido = (PaqueteEnvio) paqueteDatos.readObject();
				nick = paqueteRecibido.getNick();
				ip = paqueteRecibido.getIp();
				mensaje = paqueteRecibido.getMensaje();
				
				
				System.out.println	("\nip: " + ip + "\n" + "nick: " + nick + "\n" + "mensaje: " + mensaje);
				
				
				if(mensaje != null) {
					updateLog(mensaje);
				}
				
			///	servidor.close();
	 
				miSocket.close();
		 
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Estoy a la escucha");
	}
}
