package com.blackfez.fezcore.messagemanager;

import com.blackfez.fezcore.messagemanager.interfaces.IAsyncMessage;
import com.blackfez.fezcore.messagemanager.interfaces.IMessageProcessor;

public class MessageManager {
	
	private static transient MessageManager INSTANCE = null;
	private final AsyncMessageQueue _asyncQueue;
	
	private MessageManager() {
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
	
	public static MessageManager getInstance() {
		if( null != INSTANCE ) 
			return INSTANCE;
		synchronized ( MessageManager.class ) {
			if( null != INSTANCE ) 
				return INSTANCE;
			else
				INSTANCE = new MessageManager();
		}
		return INSTANCE;
	}
	
	public void addMessageProcessor( IMessageProcessor proccer ) {
		//this needs more work but I just want to do some prelim testing...
		_asyncQueue.addProcessor(proccer);
	}
	
	public void queueAsyncMessage( IAsyncMessage msg ) {
		_asyncQueue.queueMessage( msg );
	}

}
