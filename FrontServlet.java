
package etu1785.framework.servlet;
import java.io.*;
import java.io.PrintWriter;
import jakarta.servlet.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import util.*;
import etu1785.framework.*;
import java.util.HashMap;


public class FrontServlet extends HttpServlet {
   HashMap<String,Mapping>  MappingUrls= new HashMap<String,Mapping>();


   public void init() throws ServletException {
@Override
        try {

            this.util = new Util();
            this.MappingUrls = new HashMap<>();
            List<Class<?>> allClass = util.getClassePackage("model");
            Mapping mapp;
            Method[] allMethods;
            for(Class<?> c : allClass) {
                allMethods = c.getMethods();
        
                for(Method m : allMethods) {
                    if(m.isAnnotationPresent(MethodAnnotation.class)) {
                        mapp = new Mapping();
                        mapp.setClassName(c.getSimpleName());
                        mapp.setMethod(m.getName());

                        MappingUrls.put(m.getAnnotation(MethodAnnotation.class).url(), mapping);

                    }
                }
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
   public void processRequest(HttpServletRequest request,HttpServletResponse res)
         throws ServletException, IOException {
            res.setContentType("text/html;charset=UTF-8");
            try(PrintWriter out= res.getWriter()){

                  // // Envoyer la réponse avec les données extraites de l'XML
                  // out.println("<!DOCTYPE html>");
                  // out.println("<html>");
                  // out.println("<head>");
                  // out.println("<title>Servlet Sprint1</title>");
                  // out.println("</head>");
                  // out.println("<body>");
                  // out.println("<h1>URL : " + request.getContextPath() + "</h1>");
                  // out.println("</body>");
                  // out.println("</html>");
                  
                  Util util=new Util();
                  String url=request.getRequestURI();
                  String demande=util.getMethode(url);
                  out.println("url:"+ demande);
            }

         }
@Override
public void doGet(HttpServletRequest request , HttpServletResponse res)
   throws ServletException,IOException {
      processRequest(request, res);
   }
@Override
public void doPost(HttpServletRequest request , HttpServletResponse res)
   throws ServletException,IOException {
      processRequest(request, res);
   }
}
