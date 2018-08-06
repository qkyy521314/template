package com.baihe.common;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by qk on 2018/8/3.
 */
public interface BaseDao<T> {
    List<T> selectAll(@Param(value = "pageStart") Integer pageStart, @Param(value = "rows") Integer rows);
    T selectOneByID(Object id);
    void insert(T t);
    void delete(Object id);
    void deletes(List<Object> ids);
    void update(T t);
    Integer selectTotalCount();
}
