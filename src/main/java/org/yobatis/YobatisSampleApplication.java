package org.yobatis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.yobatis.dao.EmployeeDao;
import org.yobatis.entity.Employee;
import org.yobatis.entity.criteria.EmployeeCriteria;

import javax.annotation.Resource;
import java.util.List;

// create table employee(id bigint primary key auto_increment, name char(20), phone char(12));
@SpringBootApplication
public class YobatisSampleApplication {

	@Resource
	private EmployeeDao employeeDao;

	public void testSelect() {
	    // select id, name, phone from employee where id is not null limit 10 offset 1 order by name asc, phone desc for update
	    List<Employee> list = employeeDao.selectList(EmployeeCriteria.idIsNotNull()
		.setLimit(10L) // 最多10条记录
		.setOffset(1L) // offset为1
		.ascOrderBy("name") // 通过name字段做asc排序, 参数为数据库中的字段名
		.descOrderBy("phone") // 若name相同则通过phone desc排序, 参数为数据库中的字段名
		.setForUpdate(true) // 设置for update, 小心使用
		);
		for (Employee employee : list) {
			System.out.println(employee.toString());
		}
	}

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(YobatisSampleApplication.class, args);
		YobatisSampleApplication application = context.getBean(YobatisSampleApplication.class);
		application.testSelect();
	}
}
