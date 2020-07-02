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
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author Ramez
 */
public class ProjectPracticalClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         String entername;
    String name;
   
     String message;
        try{
             Socket socket = new Socket ("localhost" , 9393);
         DataInputStream dis = new DataInputStream (socket.getInputStream());
      DataOutputStream dos = new DataOutputStream (socket.getOutputStream());
     
       
         Scanner inp = new Scanner (System.in);
         entername = dis.readUTF();
        System.out.println(entername);
         name = inp.nextLine ();
        dos.writeUTF(name);
        MyThread2 x = new MyThread2 (socket);
        x.start();
        while(true){
          
         message= JOptionPane.showInputDialog(name); ;
         if (message.contains("exit"))
         {
         dos.writeUTF(message);
         socket.close();
         return ;
         }
          if (message.contains("rename"))
         { 
           name = message.replaceFirst("rename","      ");
          name = name.trim();
         }
          dos.writeUTF(message);
        }
    
    
    }
       
        
        catch (IOException ex){
        
        System.out.println("error");
        }
    }
}
