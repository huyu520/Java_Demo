/**
 * 
 */
package com.intoms.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *  CopyRight by 2016 Mfish
 *  All Right Reserved
 *	
 *  @author hy
 *	Create on 2017年2月6日下午6:05:37
 */
public class MapTeest {
	public static void main(String[] args)  
    {  
        Map<String, Integer> map = new HashMap<String, Integer>();  
        map.put("Total Memory", 2);  
        map.put("Max Memory", 1);  
        map.put("Free Memory", 1);  
        map.put("Actual Free", 3);  
          
        List<Map.Entry<String, Integer>> infoIds = new ArrayList<Map.Entry<String, Integer>>(map.entrySet());  
          
        //排序方法  
        Collections.sort(infoIds, new Comparator<Map.Entry<String, Integer>>() {     
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {        
                //return (o2.getValue() - o1.getValue());   
                return (o1.getKey()).toString().compareTo(o2.getKey());  
            }  
        });   
          System.out.println(map);
        //排序后  
        for (int i = 0; i < infoIds.size(); i++) {  
            String id = infoIds.get(i).toString();  
            System.out.println(id);  
        }  
          
        //排序后  
        for(Map.Entry<String, Integer> m : infoIds){  
            System.out.println(m.getKey()+":"+ m.getValue());  
        }  
          
    }  
}
