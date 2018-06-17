
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/FirstServlettest" , name = "FirstServlet")
public class FirstServlet extends HttpServlet {
    String str = "Emae";

    public FirstServlet() {
        super();
    }
// сервлет в первую очередь это контроллер приложения!
// Он должен использоваться только для контроля реализации бизнес-логики приложения и обязан быть
// отделен как от непосредственного формирования текста ответа на запрос.

    public void init() throws ServletException {    }

    private void doRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        response.getWriter().print("This is " + this.getClass().getName() + ", using the " );

        String My_timeJsp = request.getParameter("my_time");
        Long delta = System.currentTimeMillis() - Long.parseLong(My_timeJsp) ;
        request.setAttribute("res1", (float)(delta/1_000 ));

        String adminServleta = this.getServletContext().getInitParameter("admin_param_from_web_xml");
        request.setAttribute("admServleta", adminServleta);

        String servletMetadata = "getServerInfo()= " + this.getServletContext().getServerInfo() + "" +
                "===== getServletContext().getContextPath()= " + this.getServletContext().getContextPath() +
                "===== getServletContext().getRealPath= " + this.getServletContext().getRealPath("index.jsp") +
                "===== getServletContextName()= " + this.getServletContext().getServletContextName();

        request.setAttribute("servletMetadata", servletMetadata);
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doRequest(request,response);
        response.getWriter().print(" GET method!!!!!");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doRequest(request,response);
        response.getWriter().print(" POST method");
    }

    public void destroy() {
        super.destroy(); // Just puts "destroy" string in log
    }

}