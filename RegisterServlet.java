package kz.edu;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        List<String> empty = new ArrayList<>();
        if (isEmpty(name)) empty.add("Аты");
        if (isEmpty(email)) empty.add("Email");
        if (isEmpty(password)) empty.add("Пароль");

        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html><html lang=\"kk\"><head><meta charset=\"UTF-8\">");
            out.println("<title>Тіркелу нәтижесі</title>");
            out.println("<link rel=\"stylesheet\" href=\"style.css\"></head><body>");
            out.println("<div class=\"card\">");

            if (empty.isEmpty()) {
                out.println("<h2 class=\"ok\">Сәтті тіркелдіңіз, " + escape(name.trim()) + "!</h2>");
            } else {
                out.println("<h2 class=\"err\">Қате!</h2>");
                for (String field : empty) {
                    out.println("<p class=\"err\">\"" + field + "\" өрісі бос. Оны толтырыңыз.</p>");
                }
            }

            out.println("<a href=\"index.html\">&larr; Артқа</a>");
            out.println("</div></body></html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("index.html");
    }

    private boolean isEmpty(String s) {
        return s == null || s.trim().isEmpty();
    }

    // HTML-ге қауіпті таңбаларды экрандау (XSS-тан қорғау)
    private String escape(String s) {
        return s.replace("&", "&amp;").replace("<", "&lt;")
                .replace(">", "&gt;").replace("\"", "&quot;");
    }
}
