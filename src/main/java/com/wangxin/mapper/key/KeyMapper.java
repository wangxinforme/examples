package com.wangxin.mapper.key;

import java.util.List;

import com.wangxin.common.db.table.Key;

public interface KeyMapper {

    /**
     * @return 返回key集合
     */
    public List<Key> getTableValues(List<Key> keys);

    /**
     * @return 返回key集合(只存储表名)
     */
    public List<Key> getTables();

}
