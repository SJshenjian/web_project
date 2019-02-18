package online.shenjian.xuefeng.util.download.api.impl;

import online.shenjian.xuefeng.util.download.api.Connection;
import online.shenjian.xuefeng.util.download.api.ConnectionException;
import online.shenjian.xuefeng.util.download.api.ConnectionManager;


public class ConnectionManagerImpl implements ConnectionManager {

	@Override
	public Connection open(String url) throws ConnectionException {
		
		return new ConnectionImpl(url);
	}

}
