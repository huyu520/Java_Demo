package com.intoms.sort;

public class SortTest {
	final int MAX = 20 ;
	int[] num = new int[MAX];
	
	{
		System.out.println("生成的数组是：");
		for (int i = 0; i < num.length; i++) {
			num[i] = (int) (Math.random()*100);
			System.out.print(num[i] + " ");
		}
	}
	
	public SortTest(){
		
	}
	
	public void selectSort(int nums[]){
		int i,j,k,m,temp ;
		 
		long start ,end ;
		
		start = System.currentTimeMillis();
		
		for(i = 0; i < MAX-1; i++) {  
            m = i;  
            for(j = i+1; j < MAX; j++){  
                if(nums[j] < nums[m]){  
                 m = j;  
                }  
            }  
            if( i != m){  
                temp=nums[i];  
                nums[i]=nums[m];  
                nums[m]=temp;  
            }  
        } 
		
		end = System.currentTimeMillis();
		
		 System.out.println("-----------------选择排序法------------------");  
	        System.out.print("排序后是:");  
	        for(i=0;i<=MAX-1;i++){  
	            System.out.print(nums[i]+" ");  
	        }  
	        System.out.println();  
	        System.out.println("排序使用时间："+(end-start)+" ns");  
	    }  
	public static void main(String[] args) {
		new SortTest();
	}
}
