package com.redis.Resis;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface MysqlUtils {
    @Select("select id, value from t_test")
    List<Map<String, String>> getData();

    @Insert("insert into t_test(value) values (#{value})")
    void insertData(String value);

    @Select("select id, value from t_test where value like '%' || 'value' || '%'")
    List<Map<String, String>> selectOne(@Param("value")String value);

    @Select("SELECT COLUMN_NAME NAME, DATA_TYPE TYPE, COLUMN_COMMENT COMMENT, IS_NULLABLE, COLUMN_TYPE, COLUMN_KEY, COLUMN_DEFAULT " +
            "FROM INFORMATION_SCHEMA.COLUMNS c "+
            "WHERE table_name = #{name} AND table_schema='attendance'")
    List<Map<String, String>>  getTableInfo(String name);


    @Select("SELECT table_name FROM information_schema.TABLES WHERE table_schema='attendance' AND ( table_name LIKE 'dm_%' OR table_name LIKE 'door_%' OR table_name LIKE 'sys_%' OR table_name LIKE 'user_%')")
    List<String>  getTableNames();
}
