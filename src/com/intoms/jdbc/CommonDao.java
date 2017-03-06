//package com.intoms.jdbc;
//
//import java.lang.reflect.Field;
//import java.sql.ResultSet;
//import java.util.Vector;
//
//public class CommonDao {
//	
//	/**插入
//	 * @throws IllegalAccessException 
//	 * @throws IllegalArgumentException **/
//	public void insert(Object obj) throws IllegalArgumentException, IllegalAccessException{
//		Class<? extends Object> clazz = obj.getClass() ;
//		String tableName = clazz.getName() ;
//		
//		String sql = "insert into " + tableName +"(" ;
//		Field[] fields = clazz.getDeclaredFields() ;
//		for(Field f1 : fields){
//			sql =sql +  f1.getName() + ",";
//		}
//		sql = sql.substring(0, sql.length() - 1);
//		sql += ") values (";
//		for(Field f2 : fields){
//			if(f2.getType().toString().equals("class.java.lang.String")){
//				sql = sql + "'"+f2.get(obj) + "',";
//			}else{
//				sql = sql + f2.get(obj) + ",";
//			}
//		}
//		sql = sql.substring(0, sql.length() - 1);
//		sql += ")" ;
////		DemoTest.executeUpdate(sql);
//	}
//	
//	/**删除
//	 * @throws IllegalAccessException 
//	 * @throws IllegalArgumentException **/
//	public void delete(Object obj) throws IllegalArgumentException, IllegalAccessException{
//		Class clazz = obj.getClass() ;
//		String sql = "delete from Login where";
//		Field[] fields = clazz.getDeclaredFields() ;
//		for(Field field : fields){
//			sql = sql + field.getName() + "='" + field.get(obj) + "'and" ; 
//		}
//		sql = sql.substring(0, sql.length() - 4) ;
//		DemoTest.executeUpdate(sql) ;
//	}
//	

//	/**查找**/
//	public User find(String userName){
//		String sql = "select * from Login where eName='" + userName+"'";
//		ResultSet resultSet = DemoTest.executeQuery(sql);
//		UserPo userPo = null ;
//		while(resultSet.next()){
//			
//		}
//		
//		return null ;
//	}
//	
//	/**更新**/
//	public void update(Object obj){
//		
//	}
//	
//	/**查找所有**/
//	public Vector<User> findAll(){
//		return null ;
//	}
//}
