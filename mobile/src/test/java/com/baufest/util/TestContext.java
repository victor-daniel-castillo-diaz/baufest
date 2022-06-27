package com.baufest.util;

import java.util.HashMap;

public class TestContext {
	private HashMap<String, Object> map = null;
	
	public TestContext()
	{	map = new HashMap<>();
	}

	public HashMap<String , Object> getMap()
	{	return map;
	}
	
}
