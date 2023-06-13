package Main;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import javax.swing.JOptionPane;

import models.PaqueteEnvio;

public class Cliente2 {
    public static ActualizacionProductos ap = new ActualizacionProductos();
    public static String old_price = "0";
    public static void main(String[] args) {
        
        ap.setVisible(true);
        listen(); // escuchamos las conexiones de la consola

        //Client.updateLog("HEopklñ8IL");
    }

    public static void updateData(String product_name) {
        ap.product_name_lbl.setText(product_name);
    }

    public static void updateLog(String mensaje) {
        // comunicamos con el servidor de replica para que actualice el log 
        try {
            // ip del servidor
            String SERVER_IP = "127.0.0.1";
            Socket socket = new Socket( SERVER_IP, 9998);

            PaqueteEnvio paquete = new PaqueteEnvio("AAAAAAAA", "AAAAAAAAAAAAA", mensaje);
            ObjectOutputStream flujoSalida = new ObjectOutputStream(socket.getOutputStream());

            flujoSalida.writeObject(paquete);
            flujoSalida.close();

            socket.close();

        } catch (UnknownHostException e) {
                e.printStackTrace();
        } catch (IOException e) {
                e.printStackTrace();
        //	System.out.println(e.getMessage());
        }
    }

    public static void listen() {
        // opermanecemos a la escucha de solicitudes de cambio 
        try (ServerSocket servidorCliente = new ServerSocket(9999)){	

            Socket cliente;
            PaqueteEnvio paqueteRecibido;

            while(true) {
                
                cliente = servidorCliente.accept();
                ObjectInputStream flujoEntrada = new ObjectInputStream(cliente.getInputStream());
                paqueteRecibido  = (PaqueteEnvio) flujoEntrada.readObject();

                System.out.println(paqueteRecibido.getMensaje());
                
                ap.setImage(paqueteRecibido.getIp());
                ap.product_name_lbl.setText(paqueteRecibido.getJson().get("name"));
                ap.precio_anterior_lbl.setText(paqueteRecibido.getJson().get("oldPrice"));
                ap.precio_nuevo_lbl.setText(paqueteRecibido.getJson().get("price"));
                //JOptionPane.showMessageDialog(null, paqueteRecibido.getMensaje(), "Mensaje recibido", JOptionPane.INFORMATION_MESSAGE);
                //JOptionPane.showMessageDialog(null, paqueteRecibido.getJson().get("name"), "json", JOptionPane.INFORMATION_MESSAGE);
                updateLog(paqueteRecibido.getMensaje());

                //campoChat.append("\n" + paqueteRecibido.getNick() +":  " +  paqueteRecibido.getMensaje());
                //servidorCliente.close();
            }	
        }catch(Exception e){
                System.out.println(e);
        }
    }
}
