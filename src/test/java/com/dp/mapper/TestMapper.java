package com.dp.mapper;

import com.dp.entity.User;
import com.dp.util.MybatisPlusUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import java.util.List;


public class TestMapper {


        @Test
        public   void testInsert() {
            SqlSession session = MybatisPlusUtil.getSession();
            UserMapper userMapper = session.getMapper(UserMapper.class);

            User user = new User();
            user.setUId(1);
            user.setUName("cxx");
            user.setUPwd("123");
            user.setUPhone("18688220121");
            user.setBalance(20);

            userMapper.insert(user);
        }

        @Test
      public   void testSelectById() {
            SqlSession session = MybatisPlusUtil.getSession();
            UserMapper userMapper = session.getMapper(UserMapper.class);

            List<User>  list =  userMapper.getUsersList(); //mybatis
            User users= userMapper.selectById(1); //mybatis-plus

            System.out.println("list = " + list);
            System.out.println("users = " + users);
        }

        @Test
       public void testUpdateById() {
            SqlSession session = MybatisPlusUtil.getSession();
            UserMapper userMapper = session.getMapper(UserMapper.class);

            User user = new User();
            user.setUId(1);
            user.setBalance(20000);
            userMapper.updateById(user);
        }

        @Test
      public   void testDelete() {
            SqlSession session = MybatisPlusUtil.getSession();
            UserMapper userMapper = session.getMapper(UserMapper.class);

            userMapper.deleteById(1);
        }

}
