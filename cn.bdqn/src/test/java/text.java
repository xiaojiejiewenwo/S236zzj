import Mapper.EmployeeMapper;
import entity.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class text {
   @Test
    public void te()throws Exception{
        // 1、读取mybatis主配置文件
        InputStream is= Resources.getResourceAsStream("mybatis.config.xml");
        // 2、根据配置文件创建SqlSessionFactory
        SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(is);
        // 3、用SqlSessionFactory工厂去创建SqlSession
        SqlSession session=factory.openSession(true);
        // 4.通过Sqlsession提供的方法查询数据
       List<Employee> list=session.selectList("Mapper.EmployeeMapper.selectAll");
       if(list !=null && list.size()>0){
           for (Employee e : list) {
            System.out.print(e);
           }
       }
        session.close();
    }
    @Test
    public void list()throws Exception{
        // 1、读取mybatis主配置文件
        InputStream is= Resources.getResourceAsStream("mybatis.config.xml");
        // 2、根据配置文件创建SqlSessionFactory
        SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(is);
        // 3、用SqlSessionFactory工厂去创建SqlSession
        SqlSession session=factory.openSession(true);
        // 4.通过Sqlsession提供的方法查询数据
        EmployeeMapper employeeMapper=session.getMapper(EmployeeMapper.class);
        List<Employee> list=employeeMapper.list();
        if(list !=null && list.size()>0){
            for (Employee e : list) {
                System.out.println(e);
            }
        }
        session.close();
    }
    @Test
    public void Byid()throws Exception{
        // 1、读取mybatis主配置文件
        InputStream is= Resources.getResourceAsStream("mybatis.config.xml");
        // 2、根据配置文件创建SqlSessionFactory
        SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(is);
        // 3、用SqlSessionFactory工厂去创建SqlSession
        SqlSession session=factory.openSession(true);
        EmployeeMapper employeeMapper=session.getMapper(EmployeeMapper.class);
        // 4.通过Sqlsession提供的方法查询数据
        Employee employee=employeeMapper.Byid(1);
                System.out.print(employee);
        }
    @Test
    public void add()throws Exception{
        // 1、读取mybatis主配置文件
        InputStream is= Resources.getResourceAsStream("mybatis.config.xml");
        // 2、根据配置文件创建SqlSessionFactory
        SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(is);
        // 3、用SqlSessionFactory工厂去创建SqlSession
        SqlSession session=factory.openSession(true);
        Employee em=new Employee();
        em.setEmpName("嘟嘟");
        em.setSex("女");
        em.setEmail("qq@.com");
        em.setBirthday(new Date());
        em.setAddress("河南");
        EmployeeMapper employeeMapper=session.getMapper(EmployeeMapper.class);
        // 4.通过Sqlsession提供的方法查询数据
            employeeMapper.add(em);
        System.out.print(em.getId());
    }
    @Test
    public void del()throws Exception{
        // 1、读取mybatis主配置文件
        InputStream is= Resources.getResourceAsStream("mybatis.config.xml");
        // 2、根据配置文件创建SqlSessionFactory
        SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(is);
        // 3、用SqlSessionFactory工厂去创建SqlSession
        SqlSession session=factory.openSession(true);
        EmployeeMapper employeeMapper=session.getMapper(EmployeeMapper.class);
        // 4.通过Sqlsession提供的方法查询数据
        employeeMapper.del(3);
    }
    @Test
    public void Byname()throws Exception{
        // 1、读取mybatis主配置文件
        InputStream is= Resources.getResourceAsStream("mybatis.config.xml");
        // 2、根据配置文件创建SqlSessionFactory
        SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(is);
        // 3、用SqlSessionFactory工厂去创建SqlSession
        SqlSession session=factory.openSession(true);
        EmployeeMapper employeeMapper=session.getMapper(EmployeeMapper.class);
        // 4.通过Sqlsession提供的方法查询数据
       List<Employee> l=employeeMapper.byname("张");
       if(l!=null && l.size()>0){
           for (Employee e: l) {
               System.out.println(e);
           }
       }
    }
    @Test
    public void up()throws Exception{
        // 1、读取mybatis主配置文件
        InputStream is= Resources.getResourceAsStream("mybatis.config.xml");
        // 2、根据配置文件创建SqlSessionFactory
        SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(is);
        // 3、用SqlSessionFactory工厂去创建SqlSession
        SqlSession session=factory.openSession(true);
        Employee em=new Employee();
        em.setEmpName("丽丽");
        em.setSex("女");
        em.setEmail("qq@.com");
        em.setBirthday(new Date());
        em.setAddress("河南");
        em.setId(4);
        EmployeeMapper employeeMapper=session.getMapper(EmployeeMapper.class);
        // 4.通过Sqlsession提供的方法查询数据
        employeeMapper.up(em);
    }
}
