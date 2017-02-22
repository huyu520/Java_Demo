/**
 * 
 */
package com.intoms.string;

/**
 *  CopyRight by 2016 Mfish
 *  All Right Reserved
 *	
 *  @author hy
 *	Create on 2016年12月6日下午3:23:58
 */
public class TextUtil {
	/**
	 * 将字符串转化成wml格式
	 * @param args
	 */
	public static String StringToWml(String str){
		if(str == null){
			return "";
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i < str.length() ; i ++ ){
			char ch = str.charAt(i);
			switch (ch) {
			case '&':
				sb.append("&amp;");
				break;
			case '<':
				sb.append("&lt;");
				break;
			case '>':
				sb.append("&gt;");
				break;
			case '\t':
				sb.append(" ");
				break;
			case '"':
				sb.append("&quot;");
				break;
			case '\n':
				sb.append("<br/>;");
				break;
			case '\u0024':
				sb.append("$");
				break;
			default:
				if(ch >= '\u0000' && ch <= '\u001F') {
					continue;
				}
				sb.append(ch);
				break;
			}
		}
		return sb.toString() ;
	}
	public static void main(String[] args) {
	}
}
