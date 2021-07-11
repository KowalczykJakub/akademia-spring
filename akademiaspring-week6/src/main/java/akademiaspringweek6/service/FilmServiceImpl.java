package akademiaspringweek6.service;

import akademiaspringweek6.FilmAspectAnnotate;
import akademiaspringweek6.model.Film;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FilmServiceImpl implements FilmService {

    private List<Film> filmList;

    public FilmServiceImpl() {

        filmList = new ArrayList<>();

        filmList.add(new Film("The Shawshank Redemption", "1994", "USA"));
        filmList.add(new Film("Forrest Gump", "1994", "USA"));
        filmList.add(new Film("The Godfather", "1972", "USA"));

    }

    @Override
    public List<Film> getAllFilms() {
        return filmList;
    }

    @Override
    @FilmAspectAnnotate
    public boolean addFilm(Film film) {

        return filmList.add(film);

    }

}
