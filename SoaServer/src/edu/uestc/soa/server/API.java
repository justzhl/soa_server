package edu.uestc.soa.server;
import java.util.ArrayList;
import java.util.List;

import org.apache.axis2.context.MessageContext;
import org.apache.axis2.context.ServiceGroupContext;



import edu.uestc.soa.dao.students.GetHistoryEntity;
import edu.uestc.soa.dao.students.GetHistoryMapper;
import edu.uestc.soa.impl.students.GetHistoryImpl;


public class API {
	private GetHistoryMapper mapper;
	public List<GetHistoryEntity> GetHistoryInterval(long id,int week_start,int week_end){
		MessageContext mc = MessageContext.getCurrentMessageContext();
		ServiceGroupContext sgc = mc.getServiceGroupContext();
		String pwd = (String)sgc.getProperty("userinfo");
		System.out.println(pwd == null ? "null" : pwd);
		if(pwd == null || pwd.equals("123451")){
			List<GetHistoryEntity> temp = new ArrayList<GetHistoryEntity>();
			GetHistoryEntity gg = new GetHistoryEntity();
			gg.setId(0);
			gg.setCourse_name("no login");
			gg.setResult("no login");
			gg.setStudent_name("no login");
			gg.setTeacher_name("no login");
			temp.add(gg);
			return temp;
		}
		mapper = new GetHistoryImpl();
		List<GetHistoryEntity> result =  mapper.getInterVal(id, week_start, week_end);
		System.out.println("result contains:"+result.size());
		return result;
	}
	
	public boolean Login(String username,String passwd){
		if("chunchun".equals(username)&& "12345".equals(passwd)){
			MessageContext mc = MessageContext.getCurrentMessageContext();
			ServiceGroupContext sgc = mc.getServiceGroupContext();
			sgc.setProperty("userinfo", username);
			return true;
		}
		return false;
	}
}
