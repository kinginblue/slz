package cn.shana.slz.mapper.base;

import java.util.List;

public interface BaseMapper<T> {
    void insert(T t);
    void delete(long id);
    void update(T t);
    void query(long id);
    List<T> getAll();
}
