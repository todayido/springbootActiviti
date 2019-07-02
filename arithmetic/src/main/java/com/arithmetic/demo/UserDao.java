package com.arithmetic.demo;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface UserDao {

    @Select("select * from t_user")
    public List<User> AllUser();

    @Update("<script> " + "update t_user" +
            "<set>"+  "<if test='uname!=null'>uname=#{uname},</if>"+
            "<if test='upassword!=null'>upassword=#{upassword},</if>"+
            "</set>"+ "where uid=#{uid}"+
            " </script> ")
    public int Update(User user);
}
