/***************************************
 *                                     *
 *  JBoss: The OpenSource J2EE WebOS   *
 *                                     *
 *  Distributable under LGPL license.  *
 *  See terms of license at gnu.org.   *
 *                                     *
 ***************************************/

package org.jboss.example.counter;

import java.io.*;
import java.net.*;
import java.util.ResourceBundle;

import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.log4j.Logger;

/**
 *
 * @author  Stan Silvert
 */
public class CounterServlet extends HttpServlet {
    public static final Logger LOG = Logger.getLogger(CounterServlet.class);

    private String titleMessage = "Counter Servlet";

    /** Initializes the servlet.
     */
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        this.titleMessage = config.getInitParameter("titleMessage");
    }

    /** Destroys the servlet.
     */
    public void destroy() {

    }

    /** Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html");
        HttpSession session = request.getSession();

        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head>");
        out.println("<title>" + this.titleMessage + "</title>");
        out.println("</head>");

        out.println("<body>");
        out.println("<font size='16'>");
        out.println(this.titleMessage);
        out.println("</font><br><br>");

        Counter counter = getSessionObj(session);
        counter.increment();

        LOG.info("*****************");
        LOG.info("Counter = " + counter.getValue());
        LOG.info("sessionID = " + request.getSession().getId());
        LOG.info("*****************");

        out.println("Counter = " + counter.getValue());
        out.println("<br><table border=1 cellpadding=2><caption><h4>Served from</h4></caption>" );
        out.println("<tr><td>Node</td><td>" + System.getProperty("jboss.node.name") +"</td></tr>");
        out.println("<tr><td>sessionID </td><td> " + request.getSession().getId() +"</td></tr>");
        out.println("<tr><td>ServerName</td><td>" + request.getServerName() +"</td></tr>");
        out.println("</table></body>");
        out.println("</html>");
        out.close();
    }

    private Counter getSessionObj(HttpSession session) {
        Counter counter = (Counter)session.getAttribute("foo");
        if (counter == null) {
            counter = new Counter();
            session.setAttribute("foo", counter);
        }

        return counter;
    }

    /** Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }

    /** Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }

    /** Returns a short description of the servlet.
     */
    public String getServletInfo() {
        return "Counter Servlet";
    }

}
