package Servlets;

import Models.MyFile;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Date;

@WebServlet("/files")
public class MainServlet extends HttpServlet {

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
        //метот дуГет из супера только вызывает ошибку
        File folder = new File(req.getParameter("path"));
        ArrayList<MyFile> directories = new ArrayList<>();
        ArrayList<MyFile> binaryFiles = new ArrayList<>();

        for (File currentFile : folder.listFiles()) {
            if (currentFile.isDirectory()) {
                directories.add(new MyFile(currentFile));
            } else {
                binaryFiles.add(new MyFile(currentFile));
            }
        }

        String path = req.getParameter("path");
        String[] backPathArr = path.split("\\\\");
        String backPath = "";
        if(path.equals("C:\\")){
            backPath = path;
        }
        else{
            for (int i = 0; i < backPathArr.length-1; i++) {
                backPath+=backPathArr[i] + "\\";
            }
        }

        req.setAttribute("path", path);
        req.setAttribute("backPath", backPath);
        req.setAttribute("generatedTime", new Date());
        req.setAttribute("directories", directories);
        req.setAttribute("binaryFiles", binaryFiles);
        getServletContext().getRequestDispatcher("/files.jsp").forward(req,resp);
    }

    @Override
    public void destroy() {

    }
}
