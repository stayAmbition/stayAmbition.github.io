public class MybatisFirst{
	public void findUserByIdTest(){
		try{
			//mybatis配置文件
			String resource = "SqlMapConfig.xml";
			//得到配置文件流
			InputStream inputStream = Resource.getResourceAsStream (resource);
			//创建会话工厂
			SqlSessionFactory sqlSessionFactory  = new SqlSessionFactoryBuilder().build(instream);
			//通过工厂得到sqlSession
			SqlSession sqlSession = sqlSessionFactory.openSession();
			//通过sqlSession操作数据库
			//第一个参数，statementId，namespace+statement id
			//第二个参数，指定和映射文件匹配的parameterType的类型的参数
			User user =sqlSession.selectOne("test.findUserById",1);
			System.out.println(user);
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			//释放资源
			if（sqlSession!=null）{
				sqlSession.close();
			}
		}
		
		
	}
	
}