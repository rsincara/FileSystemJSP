package Servlets;

import Models.MyFile;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Date;

@WebServlet("/download")
public class DownloadServlet extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        File file = new File(req.getParameter("path"));

        resp.setContentType("application/octet-stream");
        resp.setContentLength((int) file.length());
        resp.setHeader( "Content-Disposition",
                String.format("attachment; filename=\"%s\"", file.getName()));

        OutputStream out = resp.getOutputStream();
        try (FileInputStream in = new FileInputStream(file)) {
            byte[] buffer = new byte[4096];
            int length;
            while ((length = in.read(buffer)) > 0) {
                out.write(buffer, 0, length);
            }
        }
        out.flush();
    }

    @Override
    public void destroy() {

    }
}
