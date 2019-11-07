package util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSourceFactory;


/*
 * 利用线程池来实现数据库连接池的工具
 * 数据库连接池工具
 */
public class DruidUtil {
	//线程池对象，类似于Map(key存储线程ID，value存储连接对象)
	private static ThreadLocal<Connection> threadPool = new ThreadLocal<Connection>();
	//数据源对象(连接池)
	private static DataSource ds;
	
	//--1.静态代码块，加载配置文件信息
	static {
		Properties ps = new Properties();   //--是一个键值对 Map<Object,Object>
		//--2.建立到配置文件流
		InputStream in = DruidUtil.class.getClassLoader().getResourceAsStream("druid.properties");
		//--3.读取配置文件的数据
		try {
			ps.load(in);    //简单读取配置文件的信息
			//--4.通过配置信息建立数据源对象DataSoure(其实就是数据库连接池对象)
			ds = DruidDataSourceFactory.createDataSource(ps);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/*
	 * 获取连接方法
	 */
	public static Connection getConnection() {
		//1.如果从线程池中那不到连接就创建一个连接对象，如果拿到了就不创建，从线程池中取连接
		if(threadPool.get()==null) {
			try {
				Connection con = ds.getConnection();
				con.setAutoCommit(false);
				threadPool.set(con);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return threadPool.get();
	}
	public static void close(Statement stmt,Connection con) {
		if(stmt!=null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(con!=null) {
			threadPool.remove();
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public static void close() {
		if(threadPool.get()!=null) {
			try {
				threadPool.get().commit();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				threadPool.get().close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			threadPool.remove();
		}
	}
}
