package ru.javavision.servlet;


import ru.javavision.model.Music;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class GetIndexPageServlet extends HttpServlet {

    private Map<Integer, Music> musicMap;

    @Override
    public void init() throws ServletException {

        final Object musicMap = getServletContext().getAttribute("musicMap");

        if (musicMap == null || !(musicMap instanceof ConcurrentHashMap)) {

            throw new IllegalStateException("You're repo does not initialize!");
        } else {

            this.musicMap = (ConcurrentHashMap<Integer, Music>) musicMap;
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        //сортировка массива
        req.setAttribute("musicData", musicMap.values());
        req.getRequestDispatcher("/WEB-INF/view/index.jsp").forward(req, resp);
    }
}
