package com.intoms.hy.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestStudent {
	static List<Student> stuList = new ArrayList<Student>() ;
	/*初始化学生数据*/
	static{
		Student stu1 = new Student("huyu", "123", "hy", 177.0, 65.2);
		Student stu2 = new Student("wuxi", "456", "huni", 55.0, 65.2);
		Student stu3 = new Student("wuhao", "789", "sima", 138.0, 99.2);
		Student stu4 = new Student("hanl", "huyu0822", "wahha", 177.0, 65.2);
		Student stu5 = new Student("gson", "22", "yami", 165.0, 88.2);
		Student stu6 = new Student("timo", "huyu0822", "jiks", 177.0, 75.2);
		Student stu7 = new Student("yasuo", "22", "vn", 165.0, 88.2);
		Student stu8 = new Student("cmd", "huyu0822", "huhu", 177.0, 6885.2);
		Student stu9 = new Student("admin", "admin", "bibi", 190.0, 88.2);
		
		stuList.add(stu1);
		stuList.add(stu2);
		stuList.add(stu3);
		stuList.add(stu4);
		stuList.add(stu5);
		stuList.add(stu6);
		stuList.add(stu7);
		stuList.add(stu8);
		stuList.add(stu9);
	}
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		Student stu = null ;
		while(true){
			System.out.println("请输入账号和密码");
			System.out.println("账号：");
			String account = scan.nextLine() ;
			System.out.println("密码：");
			String pwd = scan.nextLine() ;
			Student student = new Student(account, pwd) ;
		
			try {
				stu = checkStudent(student);
			} catch (StudentNotExistException e) {
				System.out.println(e.getMessage());
				System.out.println("----------------------------");
			}
			
			while(stu !=null){
				String num = "";
				do {
					System.out.println("请输入操作的指令");
					System.out.println("1:查看个人BMI的值\t\t2:查看所有人的BMI的值\t\t3:退出");
					num = scan.nextLine() ;
					if(num.equals("1")){
						System.out.println(stu.calcuBMI());
					}
					else if(num.equals("2")){
						for(Student st2 : stuList){
							System.out.println(st2.calcuBMI());
						}
					}
					else if (num.equals("3")) {
						System.exit(0);
					}
				} while (!num.equals("3"));
				System.out.println("程序退出");
			}
			}
			}
			
	
	public static Student checkStudent(Student student) throws StudentNotExistException{
		boolean exist = stuList.contains(student);
		Student stu = null ;
		if(!exist){
			throw new StudentNotExistException("该学生不存在");
		}else{
			int index = stuList.indexOf(student);
			stu = stuList.get(index);
		}
		return stu;
	}
}
