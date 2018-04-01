package com.blackfez.fezcore.messagemanager.interfaces;

public interface IMessageQueue {
	
	public void addProcessor( IMessageProcessor processor );
	
	public void queueMessage( IMessage msg );
	
	public void removeProcessor( IMessageProcessor processor );

	public void shutdown() throws InterruptedException;

}
