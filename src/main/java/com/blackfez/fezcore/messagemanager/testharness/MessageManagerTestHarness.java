package com.blackfez.fezcore.messagemanager.testharness;

import com.blackfez.fezcore.messagemanager.MessageManager;

public class MessageManagerTestHarness {

	public static void main(String[] args) {
		MessageManager mm = new MessageManager();
		mm.addMessageProcessor( new DemoAsyncMessageProcessor("EchoScopedProccer", new HexScope( HexScope.ECHO )));
		mm.addMessageProcessor( new DemoAsyncMessageProcessor("AddScopedProccer", new HexScope( HexScope.ADD )));
		mm.addMessageProcessor( new DemoAsyncMessageProcessor("EverythingProccer", new HexScope( HexScope.ALL ) ) );
		mm.queueAsyncMessage( new EchoMessage( new HexScope( HexScope.ECHO ), "My first message" ) );
		mm.queueAsyncMessage( new AddMessage( new HexScope( HexScope.ADD ), new Integer[] { 1, 2, 4}  ) );
		System.exit( 0 );
	}
}
