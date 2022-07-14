package ru.javavision.servlet;

import ru.javavision.model.Music;
import ru.javavision.util.Utils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class DeleteUserServlet extends HttpServlet {

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

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");

        if (Utils.idIsNumber(req)) {
            musicMap.remove(Integer.valueOf(req.getParameter("id")));
        }

        resp.sendRedirect(req.getContextPath() + "/");
    }
}
