/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.net.*;
import java.io.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;


/**
 *
 * @author Daniel
 */
public class ClientSocket {
     public static void main(String[] args){
        try {
            System.out.print("[ Conectando con Servidor TCP    ..................  ");
            Socket socket = new Socket("127.0.0.1", 3300);
            System.out.println("[OK] ]");
            
            BufferedWriter escritor = new BufferedWriter(
                    new OutputStreamWriter(socket.getOutputStream()));
            escritor.write("multiplicacion,50,45");
            escritor.newLine();
            escritor.flush();
            
            BufferedReader lector = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            System.out.println(lector.readLine());
            lector.close();
            escritor.close();
            /*InputStream is = sock.getInputStream(); // Canal de entrada de dados
            OutputStream os = sock.getOutputStream(); // Canal de salida de dados
            String msg = "Hola con Sockets!";
            byte[] buf = msg.getBytes(); // obteniendo la representación del byte del mensaje

            System.out.print("[ Enviando mensaje    ..............................  ");
            os.write(buf);
            System.out.println("[OK] ]");*/
        }catch(Exception e){System.out.println(e);}    
        System.out.println("[ Fin ]");
    }
    
}
