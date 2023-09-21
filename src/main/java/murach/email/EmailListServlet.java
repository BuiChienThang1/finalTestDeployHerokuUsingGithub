package murach.email;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import static java.util.Objects.isNull;
import murach.business.User;
import murach.data.UserDB;

@WebServlet("/survey")
public class EmailListServlet extends HttpServlet {
        
    @Override
    protected void doPost(HttpServletRequest request, 
                          HttpServletResponse response) 
                          throws ServletException, IOException {

        String url = "/index.html";

        // get current action
        String action = request.getParameter("action");
        if (action == null) {
            action = "join";  // the "thanks" page
        }

        // perform action and set URL to appropriate page
        if (action.equals("join")) {
            url = "/index.html";   // the "thanks" page
        }
        else if (action.equals("Submit")) {                
            // get parameters from the request
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String email = request.getParameter("email");
            String birthDate = request.getParameter("birthDate"); 
            String hear = request.getParameter("heardFrom");
            
            String contactBy;

            boolean isContact = isNull(request.getParameter("heardFrom")) 
                    && isNull(request.getParameter("wantsUpdates"));
            if(isContact == true){
                contactBy = "haha";

               
            }
            else{
                contactBy = request.getParameter("contactVia");
            }

            // store data in User object and save User object in database
            User user = new User(firstName, lastName, email, birthDate, hear, contactBy);
            UserDB.insert(user);
            
            // set User object in request object and set URL
            request.setAttribute("user", user);
            url = "/thanks.jsp";   // the "thanks" page
        }
        
        // forward request and response objects to specified URL
        getServletContext()
            .getRequestDispatcher(url)
            .forward(request, response);
    }    
    
    @Override
    protected void doGet(HttpServletRequest request, 
                          HttpServletResponse response) 
                          throws ServletException, IOException {
        doPost(request, response);
    }    
}