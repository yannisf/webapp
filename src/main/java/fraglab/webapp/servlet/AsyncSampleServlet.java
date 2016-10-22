package fraglab.webapp.servlet;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

@WebServlet(name = "AsyncSampleServlet", urlPatterns = {"/async"}, asyncSupported = true)
public class AsyncSampleServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AsyncContext asyncContext = request.startAsync();

        long randomMs = ThreadLocalRandom.current().nextLong(100, 1000);
        try {
            System.out.println("Working (sleeping) for " + randomMs + " ms");
            Thread.currentThread().sleep(randomMs);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        response.getWriter().println("Async responded in " + randomMs + " ms");
        asyncContext.complete();
    }

}
