package com.shujiu.test.dao;

import com.shujiu.test.dto.Person;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author shujiu.cl
 * @since 2021/11/2
 */
@Mapper
public interface PersonDAO {

    /**
     * 新增
     */
    Long insert(Person person);

    /**
     * ID查询
     */
    Person get(Long id);
}
