package com.mta.javacourse;
import java.io.IOException;

import javax.servlet.http.*;

@SuppressWarnings("serial")
public class Ronny1Servlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/html");
		int Radius=50;
		double Area,angleB=30,Hypotenuse=50,Opposite=0,Pow=0;
		Area= Math.pow(Radius, 2)*Math.PI;
		String line1 =new String("calculation 1:Area of circle with radius is:"+Area+"square-cm.");
		angleB=(30*Math.PI)/180;
		Opposite=Math.sin(angleB)*Hypotenuse;
		String line2 =new String("calculation 2:Length of Opposite where angle B is 30 degrees and Hypotenuse length is 50 cm is:"+Opposite+"cm.");
		Pow=Math.pow(20,13);
		String line3 =new String("calculation 3: Power of 20 with exp of 13 is"+Pow);
		String resultStr=new String (line1+"<br>"+line2+"<br>"+line3);
		resp.getWriter().println(resultStr);
	}
}
