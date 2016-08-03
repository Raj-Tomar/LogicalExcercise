package com.raj.cmd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class RuntimeExec {
	public StreamWrapper getStreamWrapper(InputStream is, String type){
		return new StreamWrapper(is, type);
	}
	private class StreamWrapper extends Thread {
		InputStream is = null;
		String message = null;

		@SuppressWarnings("unused")
		public String getMessage() {
			return message;
		}

		StreamWrapper(InputStream is, String type) {
			this.is = is;
		}

		public void run() {
			try {
				BufferedReader br = new BufferedReader(new InputStreamReader(is));
				StringBuffer buffer = new StringBuffer();
				String line = null;
				while ( (line = br.readLine()) != null) {
					buffer.append(line);//.append("\n");
				}
				message = buffer.toString();
			} catch (IOException ioe) {
				ioe.printStackTrace();  
			}
		}
	}
	// this is where the action is
	public static void main(String[] args) {
		Runtime rt = Runtime.getRuntime();
		RuntimeExec rte = new RuntimeExec();
		StreamWrapper error, output;

		try {
			Process proc = rt.exec("ping localhost");
			error = rte.getStreamWrapper(proc.getErrorStream(), "ERROR");
			output = rte.getStreamWrapper(proc.getInputStream(), "OUTPUT");
			error.start();
			output.start();
			error.join(3000);
			output.join(3000);
			proc.waitFor();
			System.out.println("Output: "+output.message+"\nError: "+error.message);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}