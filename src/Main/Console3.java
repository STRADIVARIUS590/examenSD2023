package Main;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import models.PaqueteEnvio;

public class Console3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		notify("HíklnkñlñdqqweqweqwedasdasdasdqeqweqeqweOpopLA");
	}
	
	public static void notify(String mensaje) {
		try {
						
			// ip del servidor
			String SERVER_IP = "localhost";
			
			Socket socket = new Socket( SERVER_IP, 9999);
		
			PaqueteEnvio paquete = new PaqueteEnvio("AAA", "QQQ", mensaje);
			
			ObjectOutputStream flujoSalida = new ObjectOutputStream(socket.getOutputStream());
			flujoSalida.writeObject(paquete);
			
			
			flujoSalida.close();
		 
			//socket.close();
				
			//	campo1.setText("");
				

			} catch (UnknownHostException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			//	System.out.println(e.getMessage());
			}
	}

}
