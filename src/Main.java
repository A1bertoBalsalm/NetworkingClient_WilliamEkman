import java.io.*;

import java.net.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Socket client = null;

        int portnumber = 3333;

        if(args.length >= 1){
            portnumber = Integer.parseInt(args[0]);

        }

        for (int i=0; i <10; i++){
            try{
                // Create a client socket
                client = new Socket(InetAddress.getLocalHost(),portnumber);
                System.out.println("Client socket is created "+client);

                // Create output
                OutputStream clientOut = client.getOutputStream();
                PrintWriter pw = new PrintWriter(clientOut, true);

                // Create Input

                InputStream clientIn = client.getInputStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(clientIn));

                // Create standard input
                BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));

                System.out.println("Enter your name. Type Bye to exit.");

                // Read data from standerd input and write it

                var msg = stdIn.readLine().trim();
                pw.println(msg);

                // Read data from client socket
                System.out.println("Message retunred from the server = "+br.readLine());

                pw.close();
                br.close();
                client.close();

                // Stop
                if(msg.equalsIgnoreCase("Bye")){
                    break;
                }


            } catch (IOException ie){
                System.out.println("Error: "+ie);
            }

        }







    }
}