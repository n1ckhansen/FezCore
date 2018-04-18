package com.blackfez.fezcore.configurationmanager.interfaces;

public interface IConfigurationManager {
	
	public IConfigurationBlock getConfigurationBlock( Class<?> type ) throws ClassNotFoundException;

	public void addConfigurationBlock( IConfigurationBlock block );
	
}
