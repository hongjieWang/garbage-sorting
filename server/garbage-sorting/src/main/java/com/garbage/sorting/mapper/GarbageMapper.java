package com.garbage.sorting.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.garbage.sorting.domain.Garbage;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author wanghongjie
 */
public interface GarbageMapper extends BaseMapper<Garbage> {
    @Select("SELECT * FROM garbage  ORDER BY  RAND() LIMIT 10")
    List<Garbage> genExam();
}
