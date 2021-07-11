package akademiaspringweek6;

import akademiaspringweek6.model.Film;
import akademiaspringweek6.service.EmailSenderService;
import akademiaspringweek6.service.FilmService;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
public class FilmAspect {

    @Autowired
    private EmailSenderService emailSenderService;

    @Autowired
    private FilmService filmService;


    @After("@annotation(FilmAspectAnnotate)")
    private void afterAddingFilm() {

        List<Film> list = filmService.getAllFilms();

        StringBuilder sb = new StringBuilder();

        for (Film film : list) {

            sb.append(film.toString());

        }

        emailSenderService.sendSimpleMail("akademiaspring.week6@gmail.com",
                sb.toString(),
                "List of Films");

    }

}
