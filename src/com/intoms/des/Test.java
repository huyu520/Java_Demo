/**
 * 
 */
package com.intoms.des;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 *  CopyRight by 2016 Mfish
 *  All Right Reserved
 *	
 *  @author hy
 *	Create on 2017年1月4日下午3:11:35
 */
public class Test {
	public static void main(String[] args) {
		Map<String, String> map = new HashMap<>();
		String lString = "1-19";
		String vString = "res_23510*2-res_96008*2-res_90200*1-res_235952*2-res_61054*1-res_230637*6|res_23510*2-res_96008*2-res_90200*1-res_235952*2-res_61054*1-res_230637*6|res_23510*2-res_96008*2-res_90200*1-res_235952*2-res_61054*1-res_230637*6|res_23510*2-res_96008*2-res_90200*1-res_235952*2-res_61054*1-res_230637*6|res_23510*2-res_96008*2-res_90200*1-res_235952*2-res_61054*1-res_230637*6|res_23510*2-res_96008*2-res_90200*1-res_235952*2-res_61054*1-res_230637*6|res_23510*2-res_96008*2-res_90200*1-res_235952*2-res_61054*1-res_230637*6" ;
		map.put(lString, vString);
		Map<Integer,  Map<String, Integer>> test = getParseMap(2, map);
		System.out.println(test);
	}
	public static Map<Integer, Map<String, Integer>> getParseMap(int level,Map<String,String> parseMap){
		Map<Integer,Map<String,Integer>> resultMap = null;
		if(parseMap!=null && parseMap.size() > 0 ){
			resultMap = new HashMap<Integer, Map<String,Integer>>();
			int i = 1 ;
			for(String str : parseMap.keySet() ){
				Map<String,Integer> gain = new LinkedHashMap<String, Integer>();
				String[] lvs = str.split("\\-");
				if(Integer.parseInt(lvs[0]) <= level && Integer.parseInt(lvs[1]) >= level){
					String value = parseMap.get(str) ;
					String[] infos = value.split("\\|");
					for(String key : infos){
						String[] res = key.split("\\-");
						for(String pro : res){
							String id = pro.split("\\*")[0];
							int val = Integer.parseInt(pro.split("\\*")[1]);
							gain.put(id, val);
						}
						resultMap.put(i++, gain) ;
					}
				}
			}
		}
		return resultMap;
	}
}
