package servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/authorization")
public class Authorization extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //super.doPost(request, response);
        //MyClass myClass = new MyClass();

        if (request.getParameter("button1") != null) {
            //myClass.method1();
            String varTextA = "Hello! It is Get My Track! Upload your txt file with coordinates:";
            request.setAttribute("textA", varTextA);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/authorization.jsp");
            dispatcher.forward(request, response);
        } else if (request.getParameter("button2") != null) {
            //myClass.method2();
        } else if (request.getParameter("button3") != null) {
            //myClass.method3();
        } else {
            // ???
        }
    }



    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/authorization.jsp").forward(request, response);
    }
}
