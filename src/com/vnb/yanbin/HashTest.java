package com.vnb.yanbin;

public class HashTest {

	public static void main(String[] args) {
		
		System.out.println("HashCode:");
		System.out.println("192.168.0.1的hashCode为:" + "192.168.0.1:1111".hashCode());
		System.out.println("192.168.0.2的hashCode为:" + "192.168.0.2:1111".hashCode());
		System.out.println("192.168.0.3的hashCode为:" + "192.168.0.3:1111".hashCode());
		System.out.println("192.168.0.4的hashCode为:" + "192.168.0.4:1111".hashCode());
		System.out.println("192.168.0.5的hashCode为:" + "192.168.0.5:1111".hashCode());
		System.out.println("192.168.0.6的hashCode为:" + "192.168.0.6:1111".hashCode());
		System.out.println("192.168.0.7的hashCode为:" + "192.168.0.7:1111".hashCode());
		
		System.out.println("FNV1_32_HASH:");
		System.out.println("192.168.0.1的hashCode为:" + FNV1_32_HASH.getHash("192.168.0.1:1111"));
		System.out.println("192.168.0.2的hashCode为:" + FNV1_32_HASH.getHash("192.168.0.2:1111"));
		System.out.println("192.168.0.3的hashCode为:" + FNV1_32_HASH.getHash("192.168.0.3:1111"));
		System.out.println("192.168.0.4的hashCode为:" + FNV1_32_HASH.getHash("192.168.0.4:1111"));
		System.out.println("192.168.0.5的hashCode为:" + FNV1_32_HASH.getHash("192.168.0.5:1111"));
		System.out.println("192.168.0.6的hashCode为:" + FNV1_32_HASH.getHash("192.168.0.6:1111"));
		System.out.println("192.168.0.7的hashCode为:" + FNV1_32_HASH.getHash("192.168.0.7:1111"));
		
	}
}
