package com.blackfez.fezcore.utilities.threading;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class BoundedCachedThreadPool extends ThreadPoolExecutor {
	
	
	/*  By default we create a pool with a range of 1 - 4 threads.
	 *  Threads die off after 5 seconds of inactivity.
	 *  There is always one thread living
	 *  The range can be adjusted wit the setThreads method
	 */
	public BoundedCachedThreadPool() {
		super( 4, 4, 5, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>() );
	}
	
	public void setThreads( int maxThreadCount ) {
		setMaximumPoolSize( Math.max( 1, maxThreadCount ) );
		setCorePoolSize( Math.max( 1, maxThreadCount ) );
	}

}
