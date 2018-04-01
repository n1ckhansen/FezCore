package com.blackfez.fezcore.messagemanager.interfaces;

public interface IMessageScope {
	
	public Boolean isInScope( IMessageScope otherScope );
	
	public Object getScope();

}
