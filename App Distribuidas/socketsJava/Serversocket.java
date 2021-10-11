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
/**
 *
 * @author Daniel
 */
public class Serversocket {
     public static void main(String[] args){
        
        try {
            System.out.print("[ Iniciando Servidor TCP    .........................  ");
            ServerSocket ss = new ServerSocket(3300, 5, InetAddress.getByName("127.0.0.1"));
            System.out.println("[OK] ]");
            
            System.out.print("[ Esperando solicitudes de conexion ..................  ");
            Socket socket = ss.accept(); // OperaciÃ³n de bloqueo (esperando solicitud de conexiÃ³n)
            System.out.println("[OK] ]");
           
            BufferedReader lectura = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            // Lee el mensaje del Cliente y Ejecuta para
            //Lectura del Protocolo
            String linea = lectura.readLine();
      
            int resultado =0;
        String[] elementos = linea.split(",");
        if (elementos.length != 3) {
            throw new IllegalArgumentException(
                    "Error de Lectura !");
        }
        int valor1;
        int valor2;
        String operacion = "";
        try {
             valor1 = Integer.parseInt(elementos[1]);
             valor2 = Integer.parseInt(elementos[2]);

        } catch (Exception e) {
            throw new IllegalArgumentException(
                    "Argumentos no válidos!");
        }
        switch (elementos[0].toString()) {
            case "suma":
                resultado = calcularSuma(valor1,valor2);
                operacion="suma";
                break;
            case "multiplicacion":
                resultado = calcularMul(valor1,valor2);
                operacion="multiplicacion";
                break;
           
            default:
                throw new IllegalArgumentException(
                        "No valida Operacion Trigonometrica!!");
                
        }    
            // Escribe el resultado para el Cliente
            BufferedWriter escribe = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            escribe.write("El resultado de la operacion " +operacion +" es: "+resultado);
            escribe.newLine();
            escribe.flush();
            // cierra el Flujo
            lectura.close();
            escribe.close();

        
            
            
           /* InputStream is = sock.getInputStream(); //Canal de entrada de datos
            OutputStream os = sock.getOutputStream(); //Canal de salida de datos
            byte[] buf = new byte[20]; // recibir bÃºfer

            System.out.print("[ Esperando la recepcion del mensaje  ..............  ");
            is.read(buf); // OperaciÃ³n de bloqueo (esperando la llegada de datos)
            System.out.println("[OK] ]");
            
            String msg = new String(buf); // AsignaciÃ³n de matriz(vector) de bytes recibidos a cadena
            
            System.out.println("  Mensaje recibido: "+ msg);*/
        }catch(Exception e){System.out.println(e);}    
        System.out.println("[ Fin ]");
    }
     
       public static int calcularSuma( int a, int b ) {
       return a+b;
    }
       
       public static int calcularMul( int a, int b ) {
       return a*b;
    }


     
}
    
  