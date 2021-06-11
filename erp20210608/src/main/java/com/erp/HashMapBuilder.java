package com.erp;

import java.util.HashMap;
import java.util.Map;

public class HashMapBuilder {
	public static Map<String,Object> hashMapBuilder(Map<String,String[]> pMap){
		 Map<String,Object> rMap = new HashMap<>();
		 Object Keys[] =pMap.keySet().toArray();
		 for(int i=0; i<pMap.size();i++) {
			 rMap.put(Keys[i].toString(), pMap.get(Keys[i])[0]);
		 }
		 return rMap;
	}
}