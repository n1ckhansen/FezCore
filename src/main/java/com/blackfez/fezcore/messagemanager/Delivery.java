package com.blackfez.fezcore.messagemanager;

import com.blackfez.fezcore.messagemanager.interfaces.IMessage;
import com.blackfez.fezcore.messagemanager.interfaces.IMessageProcessor;

public class Delivery implements Runnable {
	
	private IMessage message;
	private IMessageProcessor processor;
	
	public Delivery( IMessageProcessor proc, IMessage msg ) {
		setMessage( msg );
		setProcessor( proc );
	}
	
	public IMessage getMessage() {
		return message;
	}
	
	public IMessageProcessor getProcessor() {
		return processor;
	}

	public void run() {
		getProcessor().processMessage( getMessage() );
	}
	
	private void setMessage( IMessage msg ) {
		message = msg;
	}
	
	private void setProcessor( IMessageProcessor proc ) {
		processor = proc;
	}

}
