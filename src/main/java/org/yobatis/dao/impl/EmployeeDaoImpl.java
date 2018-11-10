package org.yobatis.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Component;
import org.yobatis.dao.EmployeeDao;
import org.yobatis.entity.Employee;
import org.yobatis.entity.base.BaseEmployee;
import org.yobatis.entity.criteria.EmployeeCriteria;

@Component("employeeDao")
public class EmployeeDaoImpl implements EmployeeDao {
    private static final String NAMESPACE = "org.yobatis.dao.impl.EmployeeDaoImpl.";

    @Resource
    private SqlSessionTemplate sqlSessionTemplate;

    public int insert(BaseEmployee record) {
        return sqlSessionTemplate.insert(NAMESPACE + "insert", record);
    }

    public Employee selectOne(Long pk) {
        return sqlSessionTemplate.selectOne(NAMESPACE + "selectByPk", pk);
    }

    public Employee selectOne(EmployeeCriteria criteria) {
        return sqlSessionTemplate.selectOne(NAMESPACE + "selectByCriteria", criteria);
    }

    public List<Employee> selectList(EmployeeCriteria criteria) {
        return sqlSessionTemplate.selectList(NAMESPACE + "selectList", criteria);
    }

    public int count(EmployeeCriteria criteria) {
        return sqlSessionTemplate.selectOne(NAMESPACE + "count", criteria);
    }

    public int update(BaseEmployee record) {
        return sqlSessionTemplate.update(NAMESPACE + "updateByPk", record);
    }

    public int update(BaseEmployee record, EmployeeCriteria criteria) {
        Map<String, Object> param = new HashMap<>();
        param.put("record", record);
        param.put("criteria", criteria);
        return sqlSessionTemplate.update(NAMESPACE + "updateByCriteria", param);
    }

    public int delete(Long pk) {
        return sqlSessionTemplate.delete(NAMESPACE + "deleteByPk", pk);
    }

    public int delete(EmployeeCriteria criteria) {
        return sqlSessionTemplate.delete(NAMESPACE + "deleteByCriteria", criteria);
    }
}