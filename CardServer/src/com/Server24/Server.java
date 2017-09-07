package com.Server24;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
	static ArrayList<String>  addr=new ArrayList<String> ();
	public static void run(int port) {
		try (ServerSocket sc = new ServerSocket(port)) {
			while (true) {
				System.out.println("waiting…………");
				Socket s = sc.accept();
				System.out.println("one connect…………");
				new Thread(new Task(s)).start();
				/*if(addr.size()<4){
					String temp = sc.getInetAddress().toString();
					for(int i = 0; i < addr.size(); i ++){
						int k=0;
						if(temp.equals(addr.get(i))){
							k ++;
						}
						if(k == 0){
							addr.add(temp);
						}
					}
				}
				if(addr.size() == 4){
					new Thread(new Task(s)).start();
				}四人同时在线*/
				}
			} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

class Task implements Runnable {
	Distribute ds = null;
	int index1 = 0;
	private Socket s;

	public Task(Socket s) {
		this.s = s;
	}

	public void run() {
		ds = new Distribute();
		index1 = ds.getRandom(12);
		while (!ds.boo1[index1]) {
			index1 = ds.getRandom(12);
		}
		try {
			ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
			oos.writeObject(ds.play1.get(index1));
			oos.writeObject(ds.play2.get(index1));
		    oos.writeObject(ds.play3.get(index1));
			oos.writeObject(ds.play4.get(index1)); 
			ds.boo1[index1] = false;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				s.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}

