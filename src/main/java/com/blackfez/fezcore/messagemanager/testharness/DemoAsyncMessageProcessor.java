package com.blackfez.fezcore.messagemanager.testharness;

import com.blackfez.fezcore.messagemanager.interfaces.IMessage;
import com.blackfez.fezcore.messagemanager.interfaces.IMessageProcessor;
import com.blackfez.fezcore.messagemanager.interfaces.IMessageScope;

public class DemoAsyncMessageProcessor implements IMessageProcessor {
	
	private IMessageScope processorScope;
	private String processorName;
	
	public DemoAsyncMessageProcessor( String name, IMessageScope scope ) {
		processorScope = scope;
		processorName = name;
	}

	public void processMessage(IMessage msg) {
		if( msg.getScope().isInScope( processorScope) ) {
			if( msg instanceof EchoMessage ) {
				EchoMessage m = (EchoMessage) msg;
				System.out.println( getProcessorName() + " is processing EchoMessage with message " + m.providePayload() );
			}
			else if( msg instanceof AddMessage ) {
				AddMessage m = (AddMessage) msg;
				System.out.println( getProcessorName() + " is processing AddMessage with message " + m.providePayload() );
			}
			else {
				System.out.println( "DemoAsyncMessageProcessor '" + getProcessorName() + "' lacks a handler for messages of type '" + msg.getClass() + "'" );
			}
		}
	}
	
	public String getProcessorName() {
		return processorName;
	}

	public IMessageScope getProcessorScope() {
		return processorScope;
	}

}
