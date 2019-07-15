package by.pvt;

import javax.servlet.http.*;
import java.io.IOException;

public class HelloTomcat extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest httpServletRequest
            , HttpServletResponse httpServletResponse){
        try {
            httpServletResponse.getWriter().print("Hello from Tomcat");
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}