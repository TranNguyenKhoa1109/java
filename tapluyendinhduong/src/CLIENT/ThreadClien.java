
package CLIENT;

import java.io.DataInputStream;
import java.io.IOException;

public class ThreadClien extends Thread{
  private boolean run;
	private DataInputStream dis;
	private client client;

	public ThreadClien(client client,DataInputStream dis){
		run=true;
		this.client=client;
		this.dis=dis;

		this.start();
	}
	public void run(){
		String msg1,msg2;
		while(run){
			try {
				msg1=dis.readUTF();
				msg2=dis.readUTF();
				client.getMSG(msg1,msg2);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		try {
			dis.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void stopThread(){
		this.run=false;
	}  
}
