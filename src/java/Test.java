
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author c0687631
 */
@WebServlet("/hello")
public class Test extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    {
        try(PrintWriter out = response.getWriter()){
            String name = request.getParameter("name");
            if(name == null) name = "World";
            out.println("Hello " + name + "!");
            
            HttpSession session = request.getSession();
            
            if (session != null) {
                String prevName = (String) session.getAttribute("prevName");
                out.println("Weren't you "+ prevName +" before?");
                request.getSession().setAttribute("prevName", name);
            }
            
        } catch (IOException ex) {
            System.err.println("Something went Wrong: "+ex.getMessage());
        }
        
    }
}
