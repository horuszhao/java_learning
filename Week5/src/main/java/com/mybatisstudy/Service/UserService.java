package com.mybatisstudy.Service;

import com.mybatisstudy.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.Reader;
import java.util.List;

public class UserService {


    public User getUser(int id) {
        try {
            String resource = "mybatis-config.xml";

            Reader reader = Resources.getResourceAsReader(resource);

            SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
            SqlSession session = sessionFactory.openSession();

            String statement = "com.mybatisstudy.mapping.userMapper.getUser";
            User user = session.selectOne(statement, id);

            session.commit();

            return user;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     *  1）通过Mybatis批量插入N条数据到数据库
     * @param users
     * @return
     */
    public int batchInsert(List<User> users) {
        try {
            String resource = "mybatis-config.xml";

            Reader reader = Resources.getResourceAsReader(resource);

            SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
            SqlSession session = sessionFactory.openSession(ExecutorType.BATCH);

            String statement = "com.mybatisstudy.mapping.userMapper.batchInsert";
            int result = session.insert(statement, users);

            session.commit();
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }
}
