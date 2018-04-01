package com.blackfez.fezcore.messagemanager.interfaces;

public interface IMessageProcessor {
	
	public void processMessage( IMessage msg );
	
	public IMessageScope getProcessorScope();
	
	public String getProcessorName();

}
