package cn.shana.slz.mapper.base;

import java.util.List;

public interface BaseMapper<T> {
    void insert(T t);
    void insert(int id);
    void delete(int id);
    void update(T t);
    void query(int id);
    List<T> getAll();
}
