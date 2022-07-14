package ru.javavision.util;

import ru.javavision.model.Music;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public class Utils {

    public static boolean idIsNumber(HttpServletRequest request) {
        final String id = request.getParameter("id");
        return id != null &&
                (id.length() > 0) &&
                id.matches("[+]?\\d+");
    }

    public static boolean requestIsValid(HttpServletRequest request) {
        final String title = request.getParameter("title");
        final String year = request.getParameter("year");
        final String artist = request.getParameter("artist");
        final String album = request.getParameter("album");

        return title != null && title.length() > 0 &&
                year != null && year.length() > 0 &&
                artist != null && artist.length() > 0 &&
                album != null && album.length() > 0;
    }

    public static Music createStubUser(final int id, final String title, final String album,
                                       final String artist, final String year) {
        Music music = new Music();
        music.setId(id);

        music.setTitle(title);
        music.setAlbum(album);
        music.setYear(year);
        music.setArtist(artist);

        return music;
    }

    public static boolean idIsInvalid(final String id, Map<Integer, Music> repo) {
        return !(id != null &&
                id.matches("[+]?\\d+") &&
                repo.get(Integer.parseInt(id)) != null);
    }
}
