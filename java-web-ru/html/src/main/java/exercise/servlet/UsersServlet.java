package exercise.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.Files;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import exercise.User;
import org.apache.commons.lang3.ArrayUtils;

public class UsersServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
                throws IOException, ServletException {

        String pathInfo = request.getPathInfo();

        if (pathInfo == null) {
            showUsers(request, response);
            return;
        }

        String[] pathParts = pathInfo.split("/");
        String id = ArrayUtils.get(pathParts, 1, "");

        showUser(request, response, id);
    }

    private List<User> getUsers() throws IOException {
        // BEGIN
        List<User> usersList;
        ObjectMapper objectMapper = new ObjectMapper();
        Path fullPath = Path.of("src/main/resources/users.json").toAbsolutePath().normalize();
        String rawJson = Files.readString(fullPath);
        usersList = objectMapper.readValue(rawJson, new TypeReference<>() {});
        return usersList;
        // END
    }

    private void showUsers(HttpServletRequest request,
                          HttpServletResponse response)
                throws IOException {

        // BEGIN
        response.setContentType("text/html;charset=UTF-8");
        StringBuilder body = new StringBuilder();
        body.append("""
                <!DOCTYPE html>
                <html lang=\\"ru\\">
                <head>
                <meta charset=\\"UTF-8\\">
                <title>Example application | Users</title>
                <link rel=\\"stylesheet\\" href=\\"mysite.css\\">
                </head>
                <body>
                <table>                
                """);

        for (User user : getUsers()) {
            body.append("<tr>");
            String fullName = user.getFirstName() + " " + user.getLastName();
            body.append("<td>" + user.getId() + "</td>");
            body.append("<td><a href=\"/users/" + user.getId() + "\">" + fullName + "</a></td>");
            body.append("</tr>");
        }
        body.append("</table></body></html>");

        PrintWriter out = response.getWriter();
        out.println(body);
        // END
    }

    private void showUser(HttpServletRequest request,
                         HttpServletResponse response,
                         String id)
                 throws IOException {

        // BEGIN
        response.setContentType("text/html;charset=UTF-8");
        User requestedUser = getUsers().stream().filter(u -> u.getId().equals(id)).findAny().orElse(null);
        if (requestedUser == null) {
            response.sendError((HttpServletResponse.SC_NOT_FOUND));
            return;
        }
        StringBuilder body = new StringBuilder();
        body.append("""
                <!DOCTYPE html>
                <html lang=\\"ru\\">
                <head>
                <meta charset=\\"UTF-8\\">
                <title>Example application | Users</title>
                <link rel=\\"stylesheet\\" href=\\"mysite.css\\">
                </head>
                <body>
                <table>
                """);
        body.append("<tr><td>").append(requestedUser.getFirstName()).append("</td>");
        body.append("<td>").append(requestedUser.getLastName()).append("</td>");
        body.append("<td>").append(requestedUser.getId()).append("</td>");
        body.append("<td>").append(requestedUser.getEmail()).append("</td></tr>");

        body.append("</table></body></html>");

        PrintWriter out = response.getWriter();
        out.println(body);
        // END
    }
}
