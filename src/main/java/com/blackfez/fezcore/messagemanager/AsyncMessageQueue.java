package com.blackfez.fezcore.messagemanager;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import com.blackfez.fezcore.messagemanager.interfaces.IMessage;
import com.blackfez.fezcore.messagemanager.interfaces.IMessageProcessor;
import com.blackfez.fezcore.messagemanager.interfaces.IMessageQueue;
import com.blackfez.fezcore.utilities.threading.BoundedCachedThreadPool;

public class AsyncMessageQueue implements IMessageQueue {

	private final transient Set<IMessageProcessor> processors;
	private final transient BoundedCachedThreadPool pool;
	
	public AsyncMessageQueue() {
		processors = new HashSet<IMessageProcessor>();
		pool = new BoundedCachedThreadPool();
		pool.setThreads( 5 );
	}
	
	public void addProcessor( IMessageProcessor processor ) {
		synchronized( processors ) {
			processors.add( processor );
		}
	}
	
	public void removeProcessor( IMessageProcessor processor ) {
		synchronized( processors ) {
			processors.remove( processor );
		}
	}
	
	public void queueMessage( IMessage message ) {
		synchronized( processors ) {
			for( IMessageProcessor proc : processors ) {
				pool.execute( new Delivery( proc, message ));
			}
		}
	}
	
	public void shutdown() throws InterruptedException {
		pool.awaitTermination( 30, TimeUnit.SECONDS );
	}

	
}
