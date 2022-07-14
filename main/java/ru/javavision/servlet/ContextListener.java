package ru.javavision.servlet;

import ru.javavision.model.Music;
import ru.javavision.util.Utils;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@WebListener
public class ContextListener implements ServletContextListener {

    private Map<Integer, Music> musicMap;

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {

        final ServletContext servletContext =
                servletContextEvent.getServletContext();

        musicMap = new ConcurrentHashMap<>();

        servletContext.setAttribute("musicMap", musicMap);

        final Music music = Utils.createStubUser(1, "Africa", "Toto IV","Toto","1982");
        this.musicMap.put(music.getId(), music);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        //Close recourse.
        musicMap = null;
    }
}