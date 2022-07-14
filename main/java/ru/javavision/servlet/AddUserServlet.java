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

public class AddUserServlet extends HttpServlet {

    private Map<Integer, Music> musicMap;

    private AtomicInteger id;

    @Override
    public void init() throws ServletException {

        final Object musicMap = getServletContext().getAttribute("musicMap");

        if (musicMap == null || !(musicMap instanceof ConcurrentHashMap)) {

            throw new IllegalStateException("You're repo does not initialize!");
        } else {

            this.musicMap = (ConcurrentHashMap<Integer, Music>) musicMap;
        }

        id = new AtomicInteger(2);

    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");

        if (Utils.requestIsValid(req)) {

            final String title = req.getParameter("title");
            final String year = req.getParameter("year");
            final String album = req.getParameter("album");
            final String artist = req.getParameter("artist");

            final Music music = new Music();
            final int id = this.id.getAndIncrement();
            music.setId(id);
            music.setYear(year);
            music.setTitle(title);
            music.setArtist(artist);
            music.setAlbum(album);

            musicMap.put(id, music);
        }

        resp.sendRedirect(req.getContextPath() + "/");
    }
}
