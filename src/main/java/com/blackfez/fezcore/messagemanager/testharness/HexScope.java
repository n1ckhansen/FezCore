package com.blackfez.fezcore.messagemanager.testharness;

import com.blackfez.fezcore.messagemanager.interfaces.IMessageScope;

public class HexScope implements IMessageScope  {
	
	public static final int ECHO = 0x1;
	public static final int ADD = 0x2;
	public static final int ALL = 0xF;
	
	private int scope;
	
	public HexScope( int hexScope ) {
		scope = hexScope;
	}

	public Boolean isInScope( IMessageScope otherScope ) {
		int result =  scope & ( (Integer) otherScope.getScope() ).intValue();
		return 0 < result;
	}

	public Object getScope() {
		return scope;
	}

}
