package edu.uestc.soa.impl.students;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;

import edu.uestc.soa.dao.students.GetHistoryEntity;
import edu.uestc.soa.dao.students.GetHistoryMapper;
import edu.uestc.soa.utils.SqlConnection;

public class GetHistoryImpl implements GetHistoryMapper {
	private SqlSessionFactory sqlSessionFactory;

	public SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}

	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	@Override
	public GetHistoryEntity getOne(long id, int week) {
		return null;
	}

	@Override
	public List<GetHistoryEntity> getInterVal(long id, int week_start,
			int week_end) {
		List<GetHistoryEntity> result = null;
		sqlSessionFactory = SqlConnection.getFactory();
		GetHistoryMapper mapper = sqlSessionFactory.openSession().getMapper(GetHistoryMapper.class);
		result=mapper.getInterVal(id, week_start, week_end);
		return result;
	}

}
