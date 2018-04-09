package com.blackfez.fezcore.configurationmanager;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.blackfez.fezcore.configurationmanager.interfaces.IConfigurationBlock;
import com.blackfez.fezcore.configurationmanager.interfaces.IConfigurationManager;
import com.blackfez.fezcore.utilities.IO.ObjectSerializerIO;;

public class ConfigurationManager implements IConfigurationManager {
	
	private Map<Class<?>,IConfigurationBlock> configBlocks;
	private File CONFIG_FILE;
	
	public ConfigurationManager( String configFile ) throws IOException, ClassNotFoundException {
		CONFIG_FILE = new File( configFile );
		loadConfiguration();
	}

	public IConfigurationBlock getConfigurationBlock( Class<?> type ) throws ClassNotFoundException {
		if( configBlocks.containsKey( type ) )
		    return configBlocks.get( type );
		throw new ClassNotFoundException();
	}

	@SuppressWarnings("unchecked")
	public void loadConfiguration() throws IOException, ClassNotFoundException {
		if( !CONFIG_FILE.exists() ) {
			configBlocks = new HashMap<Class<?>,IConfigurationBlock>();
			saveConfiguration();
		}
		else {
			Object payload = ObjectSerializerIO.LoadObject( CONFIG_FILE );
			this.configBlocks = (HashMap<Class<?>,IConfigurationBlock>) payload;
		}
	}

	public void saveConfiguration() throws IOException {
		ObjectSerializerIO.WriteObject( CONFIG_FILE, configBlocks );
	}

	public void setConfigurationBlock(IConfigurationBlock block) {
		configBlocks.put( block.getClass(), block );
		try {
			saveConfiguration();
		} 
		catch (IOException e) {
			System.out.println( "NON-FATAL ERROR: Unable to save configBlocks.  Config will not persist." );
			e.printStackTrace();
			System.out.println( "Continuing onward..." );
		}
	}

}
