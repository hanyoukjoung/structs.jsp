package kr.or.ddit.utiles;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class JSONDataConvertView {
	public void object2JSONConvert(Object target,
									HttpServletResponse response) throws Exception{

		ObjectMapper mapper = new ObjectMapper();
		String jsonData = mapper.writeValueAsString(target);
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("applicaton/json; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		out.println(jsonData);
	}

}
