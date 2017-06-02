package com.molyo.intergrationjannie.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.jdbc.SQL;

import java.util.List;

/**
 * Created by hongchong on 2017-05-26.
 */
public interface SuperDao<T> {

    public abstract T create(T var1);


    public abstract void update(T var1);

    public abstract void delete(T var1);


    public abstract List<T> getAll();

    @Select("select * from ${t.tableName} where id = #{id}" limit )
    public abstract T selectByPrimaryKey(@Param("id") long id, @Param("t")T t);

//    @Insert("insert into T values(#{name})")
//    public void insert(T var1);


//    public int getCount(QM var1);
//    void updateCell(M var1, String var2);
//    public void deletes(List<String> var1);
//    M getByUuid(String var1);
//    public List<T> getAll(int var1, int var2);
//    List<T> getByCondition(QM var1);
//    List<T> getByCondition(QM var1, int var2, int var3);
//    List<String> getUuidsByCondition(QM var1, int var2, int var3);
//    void setDataDeleteFlag(String var1, int var2);
}
