package com.intoms.logic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;


public class LogicTest {
	public static void main(String[] args) {
//		showNineToNine();//输出九九乘法表
//		Ends();			//完数
//		wanSqrtNum();
//		JudgeNum();
//		multi();
//		judgeHuiwen();
//		judgeHuiwen1();
//		primeNumber();
//		calculate();
//		claculateValue();
		divideNum();
//		int[] array = getRandomNum(50,500,10);
//		for (int in : array) {
//			System.out.print(in + ",");
//		}
	}
	
	public static void showNineToNine(){
		System.out.println("9*9乘法表:");
		for( int i=1 ;i<=9;i++){
			for(int j=1;j<=i;j++){
				System.out.print(j+"*"+i+"="+j*i+ "\t");
			}
			System.out.println("");
		}
	}
	/**
	 * 
	 * \【程序9】  
	题目：一个数如果恰好等于它的因子之和，这个数就称为 "完数 "。例如6=1＋2＋3.编程   找出1000以内的所有完数。 
	 */
	public static void Ends(){
		List<Integer> list = new ArrayList<>();
		List<Integer> num = new ArrayList<>();
		
		int all = 0;
		
		for(int i=6 ;i<=1000;i++){
			for(int j=1 ;j<=i ;j++){
				if (i%j==0) {
					num.add(j);
				}
			}
			num.remove(num.size()-1);
			Iterator<Integer> it = num.iterator();
			while(it.hasNext()){
				all+=it.next() ;
			}
			
			if(all == i){
				list.add(all);
			}
			num.clear();
			all =0;
		}
		System.out.println(list);
	}
	
	/**
	 * 【程序13】  有问题
		题目：一个整数，它加上100后是一个完全平方数，再加上168又是一个完全平方数，请问该数是多少？  
	 */
	public static void wanSqrtNum(){
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < 10000; i++) {
			if (((int)Math.sqrt(i+100))*((int)Math.sqrt(i+100)) == i) {
				list.add(i);
			}
		}
		System.out.println(list);
	}
	/**
	 * 【程序21】  
		题目：求1+2!+3!+...+20!的和  
		1.程序分析：此程序只是把累加变成了累乘。 
	 */
	public static void multi(){
		int temp = 1; 
		int num = 0;
		for( int i =1 ; i <=20 ; i++){
			for( int j = 1 ;j <= i ;j++ ){
				temp *=j;
			}
			num +=temp;
			temp = 1 ;
		}
		System.out.println("1+2!+3!+...+20! =" + num);
	}
	/**
	 * 【程序24】  
	题目：给一个不多于5位的正整数，要求：一、求它是几位数，二、逆序打印出各位数字。  
	 */
	public static void JudgeNum(){
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入你的五位以内的正整数");
		int num = scanner.nextInt();
		System.err.println("你输入的数为"+String.valueOf(num).length() + "位数");
		
		StringBuffer sb = new StringBuffer(String.valueOf(num));
		String reString = sb.reverse().toString();
		char[] bt = reString.toCharArray();
		for(char b :bt){
			System.out.print(b +" ");
		}
	}
	
	/**
	 * 【程序25】  
		题目：一个5位数，判断它是不是回文数。即12321是回文数，个位与万位相同，十位与千位相同。
	 */
	
	public static void judgeHuiwen(){
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入你的数字");
		 int num = scanner.nextInt();
		 int a ,b,c,d,e ;
		 a = num /10000 ;
		 b = num %10000/1000;
		 c = num %1000/100;
		 d = num %100 /10 ;
		 e = num %10 ;
		 if (a == e && b == d) {
			System.out.println("该数为回文数");
		}else{
			System.out.println("该数不是回文数");
		}
	}
	
	
	/**
	 * 【程序26】  
	题目：请输入星期几的第一个字母来判断一下是星期几，如果第一个字母一样，则继续   判断第二个字母。
	
	 */
	
	public static void judgeHuiwen1(){
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入你的数字");
	int num = scanner.nextInt();
		String ste = String.valueOf(num);
		boolean flag = false ;
		if(ste.length()/2==0){
			System.out.println("该数不是回文数");
			return;
		}else{
			char[] ch = ste.toCharArray();
			int len = ch.length/2;
			for( int i=0;i<len ;i++){
				if (ch[i] == ch[2*len -i]) {
					flag = true ;
				}else{
					flag = false;
				}
			}
			
			if(flag){
				System.out.println("次数是回文数 ： "  + num);
			}else{
				System.out.println("该数不是回文数");
			}
		}
	}
	
	/**
	 * 【程序27】  
		题目：求100之内的素数 
	 */
	public static void primeNumber(){
		List<Integer> li = new ArrayList<>();
		for(int i =3 ; i<=100; i++){
			for( int j=2 ;j<i;j++){
				if(i%j==0){
					continue;
				}
			}
		}
		System.out.println(li);
	}
	/**
	 * 【程序42】  
		题目：809*??=800*??+9*??+1   其中??代表的两位数,8*??的结果为两位数，9*??的结果为3位数。求??代表的两位数，及809*??后的结果。
	 */
	
	public static void calculate(){
		for(int i=10;i<=99;i++){
			if(809*i == (800*i + 9*i + 1)){
				System.out.println("??为" + i +"809*??结果为:" + 800*i);
			}else {
				continue;
			}
		}
	}
	
	
	/***
	 */
	@SuppressWarnings("unused")
	public static String  getDay(Map<String, String> map, Character ch){
		if(map == null){
			map = new HashMap<>();
		}
		map.put("Monday", "星期一");
		map.put("Tuesday", "星期二");
		map.put("Wednesday", "星期三");
		map.put("Thursday", "星期四");
		map.put("Friday", "星期五");
		map.put("Saturday", "星期六");
		map.put("Sunday", "星期日");
		
		Set<String> set = map.keySet() ;
		for(String ss : set){
			if(!ss.startsWith(ch.toString())){
				map.remove(ss);
			}
		}
		if(map != null){
			if(map.size()>1){
				return "请继续输入";
			}else if(map.size() == 1){
				return map.get(0);
			}else{
				return "输入有误";
			}
		}
		
		return null;
	}
	
	
	/***
	 * （1）编写代码生成10个位于[50,100]区间的整数。
	 */
	public static int[] getRandomNum(int min,int max,int num){
		int length = max - min ;
		int[] array = new int[num];
		Random random = new Random();
		int randNum ;
		for(int i=0;i<10;i++){
			randNum = random.nextInt(length)+min;
			array[i] = randNum ;
		}
		return array ;
	}
	
	/**
	 * 定义一个长度为10的证书的数组，可以用于保存用户通过控制台输入的10个整数，并计算平均值，最大值，最小值
	 */
	public static void claculateValue(){
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		int[] array = new int[10];
		int i = 1;
		String num ;
		while(i<11){
			System.out.println("请输入第"+ i + "个整数");
			num = scanner.next();
			if(num.matches("\\d+")){
				array[i-1] = Integer.valueOf(num);
				i++ ;
			}else{
				System.out.println("输入不合法");
			}
		}
		
		int maxValue =array[0] ;
		int minValue = array[0];
		int sum = 0;
		
		for(int in : array){
			sum += in;
			if(maxValue <= in){
				maxValue = in ;
			}
			if(minValue >=in){
				minValue = in;
			}
		}
		
		System.out.println("平均值为："+sum*1.0/array.length);
		System.out.println("最小值为："+minValue);
		System.out.println("最大值为："+maxValue);
	}
	
	
	/**
	 * 将A1B2C3D4E5F6G7JH8I9截取出来分别分别放到int[]和String[]的数组里面
	 * 数字 48-57
	 */
	public static void divideNum(){
		String str = "A1B2C3D4E5F6G7JH8I9";
		char[] ch = str.toCharArray();
		int m=0;
		int n=0;
		for(int i=0;i<ch.length;i++){
			if(ch[i]>=48&&ch[i]<=57){
				m++;
			}else if (ch[i]>=65&&ch[i]<=90) {
				n++;
			}
		}
		int[] arr1 = new int[m];
		String[] str1 = new String[n];
		for(int i=0,j=0,k=0;i<ch.length;i++){
			if(ch[i]>=48&&ch[i]<=57){
				arr1[j] = Integer.parseInt(String.valueOf(ch[i]));
				j++;
			}else if (ch[i]>=65&&ch[i]<=90) {
				str1[k] = String.valueOf(ch[i]);
				k++;
			}
		}
		ArrayList<Object> li = new ArrayList<>();
		for(int in : arr1){
			li.add(in);
		}
		
		List<String> l2 = new ArrayList<>(Arrays.asList(str1));
		System.out.println(li);
		System.out.println(l2);
	}
		
}
