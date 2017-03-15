package servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/some")
public class MyServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //super.doPost(request, response);
        //MyClass myClass = new MyClass();

        if (request.getParameter("button1") != null) {
            //myClass.method1();
            String varTextA = "Hello! It is Get My Track! Upload your txt file with coordinates:";
            request.setAttribute("textA", varTextA);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/auth.jsp");
            dispatcher.forward(request, response);
        } else if (request.getParameter("button2") != null) {
            //myClass.method2();
        } else if (request.getParameter("button3") != null) {
            //myClass.method3();
        } else {
            // ???
        }
    }



//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.setContentType("text/html");
////        PrintWriter out = response.getWriter();
////        out.println("Hello, World!");
////        out.println(" <html>");
////        out.println("<head>");
////        out.println("  <title>Get My Track!</title>");
////        out.println("</head>");
////        out.println("<body>");
////        out.println("<form enctype=\"multipart/form-data\" method=\"post\">");
////        out.println("<p><input type=\"file\" name=\"f\">");
////        out.println(" <input type=\"submit\" value=\"Отправить\"></p>");
////        out.println("</form>");
////        out.println("</body>");
////        out.println("</html>");
//        //String varTextA = "Hello! It is Get My Track! Upload your txt file with coordinates:";
//        //request.setAttribute("textA", varTextA);
////        String varTextB = "It is Get My Track!";
////        request.setAttribute("textB", varTextB);
//
//        RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
//        dispatcher.forward(request, response);
//    }
}
