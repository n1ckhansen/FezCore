package com.blackfez.fezcore.messagemanager.testharness;

import com.blackfez.fezcore.messagemanager.interfaces.IAsyncMessage;
import com.blackfez.fezcore.messagemanager.interfaces.IMessageScope;

public class AddMessage implements IAsyncMessage {
	
	private IMessageScope msgScope;
	private Integer[] ints;

	public AddMessage( IMessageScope scope, Integer[] addThese ) {
		msgScope = scope;
		ints = addThese;
	}

	public IMessageScope getScope() {
		return msgScope;
	}

	public Object providePayload() {
		return ints;
	}

}
