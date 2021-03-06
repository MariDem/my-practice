package by.marina.servlet;

import by.marina.service.DataService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Logger;

@WebServlet("/data")
public class DataServlet extends HttpServlet {

    private final static Logger LOG = Logger.getLogger(DataServlet.class.getName());
    private final DataService dataService;

    public DataServlet() {
        dataService = new DataService();
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("application/json");
        PrintWriter writer = resp.getWriter();
        writer.println(dataService.getAllEntitiesForResponse());
        writer.close();
    }


//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
//        String body = req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
//        dataService.addEntity(body);
//    }


  }
