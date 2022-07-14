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


public class UpdateUserServlet extends HttpServlet {

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
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");

        final String id = req.getParameter("id");
        final String album = req.getParameter("album");
        final String title = req.getParameter("title");
        final String artist = req.getParameter("artist");
        final String year = req.getParameter("year");

        final Music music = musicMap.get(Integer.parseInt(id));
        music.setTitle(title);
        music.setAlbum(album);
        music.setArtist(artist);
        music.setYear(year);

        resp.sendRedirect(req.getContextPath() + "/");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        final String id = req.getParameter("id");

        if (Utils.idIsInvalid(id, musicMap)) {
            resp.sendRedirect(req.getContextPath() + "/");
            return;
        }

        final Music music = musicMap.get(Integer.parseInt(id));
        req.setAttribute("music", music);

        req.getRequestDispatcher("/WEB-INF/view/update.jsp")
                .forward(req, resp);
    }
}
