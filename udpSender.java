
import java.net.*;
import java.util.Scanner;

public class udpSender {

	public static void main(String[] args) 
   {
	      // Check the arguments
	      /*if( args.length != 3 )
	      {
	         System.out.println( "usage: java UDPSender host port" ) ;
	         return ;
	      }*/
	      DatagramSocket socket = null ;
	      try
	      {
	         // Convert the arguments first, to ensure that they are valid
	         final InetAddress host = InetAddress.getByName( args[0] ) ;
	         final int port         = Integer.parseInt( args[1] ) ;
	         final int numSend      = Integer.parseInt( args[2] );
	         socket = new DatagramSocket() ;
     
	         Scanner in;
	         in = new Scanner (System.in);
	         String message = null;
	         while (true)
	         {
	        		 System.out.println("Enter text to be sent, ENTER to quit ");
	        		 message = in.nextLine();
	        		 if (message.length()==0) break;
	        		 byte [] data = message.getBytes() ;

	        		 for (int i = 0; i < numSend; i++) {
						 DatagramPacket packet = new DatagramPacket( data, data.length, host, port ) ;
						 socket.send( packet ) ;
						 socket.receive( packet );
						 System.out.println( packet.getAddress() + " " + packet.getPort() + ": " + new String(packet.getData()).trim() ) ;
					 }
	         }
	         System.out.println ("Closing down");
	      }
	      catch( Exception e )
	      {
	         System.out.println( e ) ;
	      }
	      finally
	      {
	         if( socket != null )
	            socket.close() ;
      }
   }
}