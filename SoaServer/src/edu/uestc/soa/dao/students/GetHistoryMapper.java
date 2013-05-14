package edu.uestc.soa.dao.students;

import java.sql.Date;
import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

public interface GetHistoryMapper {
	
		public GetHistoryEntity getOne(long id,int week);
		
		@Select("select *  from attendance_view where week > #{1} and #{2} > week")
		@Results( value={
			@Result(column="result",property="result"),
			@Result(column="course_name",property="course_name"),
			@Result(column="teacher_id",property="teacher_id"),
			@Result(column="week",property="week"),
			@Result(column="teacher_name",property="teacher_name"),
			@Result(column="student_id",property="student_id"),
			@Result(column="student_name",property="student_name")
			})
		public List<GetHistoryEntity> getInterVal(long id,int week_start,int week_end);
}