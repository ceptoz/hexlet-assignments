package exercise.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.List;
import java.util.stream.Collectors;
import static exercise.Data.getCompanies;

public class CompaniesServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
                throws IOException, ServletException {

        // BEGIN
        List<String> companies = getCompanies();
        PrintWriter out = response.getWriter();
        boolean companyIsPresent = false;
        int counter = 1;

        String searchResult = request.getParameter("search");

        if (searchResult == null || searchResult.equals("")) {
            for (String company : companies) {
                out.println(company);
                counter++;
            }
        } else {
            for (String company : companies) {
                if (company.contains(searchResult)) {
                    out.println(company);
                    companyIsPresent = true;
                }
            }
            if (!companyIsPresent) {
                out.println("Companies not found");
            }
        }
        // END
    }
}
