package com.blackfez.fezcore.messagemanager.testharness;

import com.blackfez.fezcore.messagemanager.interfaces.IAsyncMessage;
import com.blackfez.fezcore.messagemanager.interfaces.IMessageScope;

public class EchoMessage implements IAsyncMessage {

	private IMessageScope messageScope;
	private String echoMessage;
	
	public EchoMessage( IMessageScope scope, String message ) {
		messageScope = scope;
		echoMessage = message;
	}

	public IMessageScope getScope() {
		return messageScope;
	}

	public Object providePayload() {
		return echoMessage;
	}

}
