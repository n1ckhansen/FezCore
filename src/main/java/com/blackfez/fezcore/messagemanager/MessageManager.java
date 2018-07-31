package com.blackfez.fezcore.messagemanager;

import com.blackfez.fezcore.messagemanager.interfaces.IAsyncMessage;
import com.blackfez.fezcore.messagemanager.interfaces.IMessageProcessor;

public class MessageManager {
	
	private final AsyncMessageQueue _asyncQueue;
	
	public MessageManager() {
		_asyncQueue = new AsyncMessageQueue();
		Runtime.getRuntime().addShutdownHook(
				new Thread() {
					public void run() {
						try {
							_asyncQueue.shutdown();;
						} 
						catch (InterruptedException e) {
							System.out.println( "_asyncQueue failed to shutdown properly.  That sucks" );
						}
					}
				}
		);
	}

	public void addMessageProcessor( IMessageProcessor proccer ) {
		//this needs more work but I just want to do some prelim testing...
		_asyncQueue.addProcessor(proccer);
	}
	
	public void removeMessageProcessor( IMessageProcessor proccer ) {
		_asyncQueue.removeProcessor( proccer );
	}
	
	public void queueAsyncMessage( IAsyncMessage msg ) {
		_asyncQueue.queueMessage( msg );
	}

}
