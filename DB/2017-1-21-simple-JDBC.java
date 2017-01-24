/** jdbc是sun公司设计的一套通用的java语言操作不同数据库的接口，一个规范。（mysql，oracle，sql server）
*
*
*
**/
//不加载类com.mysql.jdbc.PreparedStatement:若要加载oracle驱动就要换
//只加接口
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JdbcTest{
	
	public static void main(String[] args){
		//数据库连接
		Connection connection = null;
		//预编译的statement,数据库编译sql,预编译的sql放在数据库缓存,不需要重复编译，提高性能
		PreparedStatement preparedStatement = null;
		//结果集
		ResultSet resultSet = null;
		
		try{
			//加载数据库驱动
			//"com.mysql.jdbc.Driver"在mysql-connector-java-xxx.jar包中
			// ojdbcxxx.jar是oracle驱动
			Class.forName("com.mysql.jdbc.Driver");
			//通过驱动管理类获取连接
			connection = DriverManager.getConnection("","","");
			//定义sql语句,?表示占位符
			String sql = "select * from user where username = ?";
			//获取预处理的statement
			preparedStatement = connection.preparedStatement(sql);
			//设置参数
			preparedStatement.setString(1,"王五");
			//向数据库发出sql执行查询，查询出结果集
			resultSet = preparedStatement.executeQuery();
			//遍历查询结果集
			while(resultSet.next()){
				System.out.println(resultSet.getString("id")+"---"+resultSet.getString("username"));
			}		
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			//释放资源
			if(resultSet!=null){
				try{
					resultSet.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
			if(preparedStatement!=null){
				try{
					preparedStatement.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
			if(connection!=null){
				try{
					connection.close();
			}catch(SQLException e){
				e.printStackTrace();
			}		
		}
	}
}
/**
*  单纯使用jdbc问题：
*	1.数据库连接创建、释放频繁造成系统内存、时间浪费从而影响系统性能，可能会导致，内存泄漏。如果使用数据库链接池可解决此问题。
	本质上说，数据库资源的管理依赖应用系统本身就是不安全，不稳定的。c3p0、dpcp
*	2.Sql语句在代码中硬编码，造成代码不易维护，实际应用sql变化的可能较大，sql变动需要改变java代码。将sql语句配置在xml配置文件中，即使sql变化，不需要对java代码重新编译
*	3.使用preparedStatement向占有位符号传参数存在硬编码，系统不易维护。将sql语句及占位符和参数全部配置到xml里面
*	4.对结果集解析存在硬编码（查询列名），sql变化导致解析代码变化，系统不易维护，如果能将数据库记录封装成pojo对象解析比较方便。
*	
**/