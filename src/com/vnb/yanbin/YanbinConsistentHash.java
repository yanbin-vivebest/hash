package com.vnb.yanbin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class YanbinConsistentHash {
	//物理
	private List<String> realNodes = new ArrayList<String>(); 
	
	//虚拟节点
	private int virtualNum = 100;
	
	//环
	private SortedMap<Integer,String> sortedMap = new TreeMap<Integer,String>();
	
	//所有节点
	private Map<String,List<Integer>> realToVirtualMap = new HashMap<String,List<Integer>>();
	
	
	public YanbinConsistentHash() {
		super();
	}

	public YanbinConsistentHash(int virtualNum) {
		super();
		this.virtualNum = virtualNum;
	}

	//应有什么方法
	
	//加入物理节点的方法
	public void addServer(String node) {
		this.realNodes.add(node);
		
		String vnode = null;
		
		List<Integer> virtualList = new ArrayList<Integer>();
		
		this.realToVirtualMap.put(node, virtualList);
		
		int i = 0,count = 0;
		
		//虚拟节点
		while( count < this.virtualNum) {
			
			vnode = node + "&&vnode-" + (i++);
			
			int hashValue = FNV1_32_HASH.getHash(vnode);
			
			if(!sortedMap.containsKey(hashValue)) {
				virtualList.add(hashValue);
				
				//放到环上去
				sortedMap.put(hashValue, node);
				
				count++;
			}
		}
	}
	
	public String getServer(String key) {
		int hash = FNV1_32_HASH.getHash(key);
		SortedMap<Integer, String> subMap = sortedMap.tailMap(hash);
		
		if(subMap != null) {
			Integer v = subMap.firstKey();
			return subMap.get(v);
		}else {
			return sortedMap.get(sortedMap.firstKey());
		}
	}
	
	public static void main(String[] args) {
		
		YanbinConsistentHash hash = new YanbinConsistentHash(500);
		
		hash.addServer("192.168.10.0");
		hash.addServer("192.168.10.1");
		hash.addServer("192.168.10.2");
		hash.addServer("192.168.10.3");
		hash.addServer("192.168.10.4");
		
		for(int i = 0;i<10;i++) {
			System.out.println("abd" + i + "对应的服务器是:" + hash.getServer("abd" + i));
		}
		
	}
}
