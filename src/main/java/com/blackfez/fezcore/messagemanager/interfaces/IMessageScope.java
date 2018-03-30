package com.blackfez.fezcore.messagemanager.interfaces;

public interface IMessageScope {
	
	public Boolean isInScope( IMessageScope scope );
	
	public IMessageScope getScope();

}
