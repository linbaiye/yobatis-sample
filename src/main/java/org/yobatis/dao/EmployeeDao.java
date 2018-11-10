package org.yobatis.dao;

import java.util.List;
import org.yobatis.entity.Employee;
import org.yobatis.entity.base.BaseEmployee;
import org.yobatis.entity.criteria.EmployeeCriteria;

public interface EmployeeDao {
    int insert(BaseEmployee record);

    Employee selectOne(Long pk);

    Employee selectOne(EmployeeCriteria criteria);

    List<Employee> selectList(EmployeeCriteria criteria);

    int count(EmployeeCriteria criteria);

    int update(BaseEmployee record);

    int update(BaseEmployee record, EmployeeCriteria criteria);

    int delete(Long pk);

    int delete(EmployeeCriteria criteria);
}