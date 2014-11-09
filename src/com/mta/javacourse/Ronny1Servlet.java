package com.mta.javacourse;
import java.io.IOException;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class Ronny1Servlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/html");
		int num1,num2,num3,num4=0;
		num1=3;
		num2=4;
		num3=7;
		num4=(num1+num2)*num3;
		String resultstr = new String ("<h1>the result of"+"("+num1 +"+" +num2 +")" +"*" +num3 +"=" +num4+"</h1>");
		
		resp.getWriter().println(resultstr);
	}
}
