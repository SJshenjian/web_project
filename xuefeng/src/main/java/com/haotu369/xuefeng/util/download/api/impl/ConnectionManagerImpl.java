package com.haotu369.xuefeng.util.download.api.impl;

import com.haotu369.xuefeng.util.download.api.Connection;
import com.haotu369.xuefeng.util.download.api.ConnectionException;
import com.haotu369.xuefeng.util.download.api.ConnectionManager;


public class ConnectionManagerImpl implements ConnectionManager {

	@Override
	public Connection open(String url) throws ConnectionException {
		
		return new ConnectionImpl(url);
	}

}
