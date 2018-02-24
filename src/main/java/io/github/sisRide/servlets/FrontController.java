import interfaces.Command;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@MultipartConfig
public class FrontController extends HttpServlet {

    public void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        /*try {
            request.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(Frontal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        response.setCharacterEncoding("UTF-8");
        String ex = request.getParameter("ex");
        
        try {
            Command com = (Command) Class.forName("Controladores." + ex + "Controller").newInstance();
            com.execute(request, response);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex1) {
            Logger.getLogger(Frontal.class.getName()).log(Level.SEVERE, null, ex1);
        } catch (SQLException ex1) {
            Logger.getLogger(Frontal.class.getName()).log(Level.SEVERE, null, ex1);
        }*/
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       processRequest(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request,response);
    }

}