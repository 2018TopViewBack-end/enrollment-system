package org.topview.dao;

import java.io.Serializable;
import java.util.List;

/**
 * Mapper父接口
 *
 * @param <T>
 * @param <PK>
 * @author Medwin。
 */
public interface BaseMapper<T, PK extends Serializable> {

    T selectByPrimaryKey(PK pk);  //根据主键选择对象

    T selectByExample(T example);//根据example选择对象

    int deleteByPrimaryKey(PK pk);//根据主键删除对象

    int insert(T object);

    int updateByPrimaryKey(T object); //根据主键更新

    List<T> listAll();

    int updateByExample(T example);

    int deleteByExample(T example);//根据example删除对象
}
