/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectpracticalclient;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;


/**
 *
 * @author Ramez
 */
public class MyThread2 extends Thread{
    Socket socket ;
    public MyThread2 (Socket socket){this.socket = socket;}

   
   
    String readmessage;
        @Override
    public void run (){
     try {
            
            DataInputStream dis = new DataInputStream (socket.getInputStream());
      DataOutputStream dos = new DataOutputStream (socket.getOutputStream());
     
       
   
      
         
     
     while (true){
     readmessage = dis.readUTF();
      
         if (readmessage.startsWith("red"))
         {readmessage = readmessage.replaceFirst("red", "        ");
         readmessage = readmessage.trim();
         System.err.println(readmessage);
         }
         else if  (readmessage.startsWith("exit"))
         {
         readmessage = readmessage.replaceFirst("exit", "    ");
         readmessage = readmessage.trim();
         
         System.out.println("\"" + readmessage + "\"" + " Left The Chat Room");
         
         }
    else
     System.out.println(readmessage);
          }
     }
        catch (IOException ex){System.out.println("Disconnected");}
    }
    
    
}
