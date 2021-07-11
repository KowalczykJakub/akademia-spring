package akademiaspringweek6.service;

import akademiaspringweek6.model.Film;

import java.util.List;

public interface FilmService {

    List<Film> getAllFilms();

    boolean addFilm(Film film);

}
