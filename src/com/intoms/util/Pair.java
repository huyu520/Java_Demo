/**
 * @author ivan(ivan@intoms.com)
 * 创建时间:2009-7-16 下午09:34:46
 */
package com.intoms.util;

import java.io.Serializable;

/**
 *
 */
public class Pair <K,V> implements Serializable {
	private static final long serialVersionUID = 4405599508002758431L;

	private K key;
	private V value;
	
	public Pair( K k, V v ) {
		this.key = k;
		this.value = v;
	}
	
	public K getKey() {
		return key;
	}
	public void setKey(K key) {
		this.key = key;
	}
	public V getValue() {
		return value;
	}
	public void setValue(V value) {
		this.value = value;
	}
	
	public static <FT, ST> Pair<FT, ST> makePair(FT f, ST s)
	{
		return new Pair<FT, ST>(f, s);
	}
}
