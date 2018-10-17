package HomeWork;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Student")
public class CalcServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String weight = request.getParameter("weight");
        String growth = request.getParameter("growth");
        name = name == null ? "Unknown" : name;

        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        Double weightD=(Double.parseDouble(weight));
        Double growthD=(Double.parseDouble(growth))/100;
        if (growthD != 0) {
            Double indexweight = weightD / (growthD* growthD);


            writer.println("<b>" + name + " Ваш индекс массы : " + indexweight + " <b></b>");
            if (indexweight < 16)
                writer.println("Выраженный дефицит массы тела");
            else if (indexweight < 18.5 && indexweight > 16)
                writer.println("Недостаточная (дефицит) масса тела");
            else if (indexweight < 24.99 && indexweight > 18.5)
                writer.println("Норма");
            else if (indexweight < 29.99 && indexweight > 25)
                writer.println("Избыточная масса тела (предожирение)");
            else if (indexweight < 34.99 && indexweight > 30)
                writer.println("Ожирение");
            else if (indexweight < 39.99 && indexweight > 35)
                writer.println("Ожирение резкое");
            else if (indexweight > 40)
                writer.println("Очень резкое ожирение");
        }
        else  writer.println("Введите все данные");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        writer.println("<html><head><link rel='stylesheet' href='/resources/css/style.css'/></head>");
        writer.println("<body>");
        writer.println("<b>Программа определения индекса массы тела</b></br>");
        writer.println("<form method='post'>" +
                "<label> Имя: <input name='name'/>" +
                "</label>" +
                "<label> Вес: <input name='weight'/>" +
                "</label>" +
                "<label> Рост: <input name='growth'/>" +
                "</label>" +
                "<input type='submit'/>");
        writer.println("</body></html>");
    }
}
