import java.util.*;
import java.util.stream.Collectors;

public class main {
    public static void main(String[] args) {

        System.out.println("TP JAVA - Antoine SANVOISIN");
        List<people> directors = fillDirectors();
        List<people> actors = fillActors();
        List<movies> movies = fillMovies();
        // Question 3
        try{
            searchMovieByTitle(movies, directors, actors);
        }
        catch (Exception exception) {
            System.out.println(ANSI_RED_BACKGROUND + exception.getMessage() + ANSI_RESET);
        }

        // Question 4
        try{
            searchDirectorByName(directors);
        }
        catch (Exception exception) {
            System.out.println(ANSI_RED_BACKGROUND + exception.getMessage() + ANSI_RESET);
        }

        // Question 5
        try{
            searchMovieByReleaseYear(movies);
        }
        catch (Exception exception) {
            System.out.println(ANSI_RED_BACKGROUND + exception.getMessage() + ANSI_RESET);
        }
        // Question 6
        try{
            searchActorFilmography(actors, movies);
        }
        catch (Exception exception) {
            System.out.println(ANSI_RED_BACKGROUND + exception.getMessage() + ANSI_RESET);
        }
    }
    public static void searchMovieByTitle(List<movies> movies, List<people> directors, List<people> actors) throws NoSuchElementException {
        Scanner reader = new Scanner(System.in);
        System.out.println("Enter a movie title : ");
        String searched_title = reader.nextLine();
        List<movies> searched_movie = movies.stream()
                .filter(movie -> movie.getTitle().equals(searched_title))
                .collect(Collectors.toList());
        if (searched_movie.isEmpty()) {
            throw new NoSuchElementException("Movie is not present in the database");
        }
        System.out.println(ANSI_GREEN_BACKGROUND + searched_movie.toString() + ANSI_RESET);

        System.out.println("\n" + ANSI_GREEN_BACKGROUND + "ACTORS" + ANSI_RESET);
        getActorsFromMovie(searched_movie.get(0), actors);

        System.out.println("\n" + ANSI_GREEN_BACKGROUND + "DIRECTOR" + ANSI_RESET);
        getDirectorFromMovie(searched_movie.get(0), directors);
    }
    public static void searchDirectorByName(List<people> directors) throws NoSuchElementException {
        Scanner reader = new Scanner(System.in);
        System.out.println("Enter a director first name : ");
        String searched_first_name = reader.nextLine();
        System.out.println("Enter a director last name : ");
        String searched_last_name = reader.nextLine();
        List<people> searched_director = directors.stream()
                .filter(director -> director.getFirst_name().equals(searched_first_name))
                .filter(director -> director.getLast_name().equals(searched_last_name))
                .collect(Collectors.toList());
        if (searched_director.isEmpty()) {
            throw new NoSuchElementException("Director is not present in the database");
        }
        System.out.println(ANSI_GREEN_BACKGROUND + searched_director.toString() + ANSI_RESET);
    }
    public static void searchMovieByReleaseYear(List<movies> movies) throws NoSuchElementException {
        Scanner reader = new Scanner(System.in);
        System.out.println("Enter a movie release year : ");
        int searched_year = reader.nextInt();
        List<movies> searched_movie = movies.stream()
                .filter(movie -> movie.getReleaseYear() == searched_year)
                .collect(Collectors.toList());
        if (searched_movie.isEmpty()) {
            throw new NoSuchElementException("No such movie in the database which was released in " + searched_year);
        }
        searched_movie.stream()
                .forEach(movie -> System.out.println("\n" + ANSI_GREEN_BACKGROUND + movie.toString() + ANSI_RESET));

    }
    public static void searchActorFilmography(List<people> actors, List<movies> movies) {
        Scanner reader = new Scanner(System.in);
        System.out.println("Enter an actor first name : ");
        String searched_first_name = reader.nextLine();
        System.out.println("Enter an actor last name : ");
        String searched_last_name = reader.nextLine();
        List<people> searched_actor = actors.stream()
                .filter(director -> director.getFirst_name().equals(searched_first_name))
                .filter(director -> director.getLast_name().equals(searched_last_name))
                .collect(Collectors.toList());
        if (searched_actor.isEmpty()) {
            throw new NoSuchElementException("Actor is not present in the database");
        } else {
            people actor = searched_actor.get(0);
            movies.stream()
                    .filter(movie -> movie.getActorsId().contains(actor.getId()))
                    .forEach(movie -> System.out.println(movie.toString()));
        }
    }
    public static void getActorsFromMovie(movies movie, List<people> actors) {
        List<people> movie_actors = new ArrayList<people>();

        for(Integer actor_id : movie.getActorsId()) {
            List<people> found_actors = actors.stream()
                    .filter(actor -> actor.getId().equals(actor_id))
                    .collect(Collectors.toList());
            movie_actors.add(found_actors.get(0));
        }
        movie_actors.stream()
                .forEach(actor -> System.out.println("\n" + ANSI_GREEN_BACKGROUND + actor.toString() + ANSI_RESET));
    }
    public static void getDirectorFromMovie(movies movie, List<people> directors) {
        directors.stream()
                .filter(director -> director.getId().equals(movie.getIdDirector()))
                .forEach(director -> System.out.println("\n" + ANSI_GREEN_BACKGROUND + director.toString() + ANSI_RESET));
    }
    public static List<people> fillDirectors() {
        return Arrays.asList(
                new people(1, "Denis", "VILLENEUVE", jobs.DIRECTOR, new birthDate(3, 10, 1967), "canadian"),
                new people(2, "James", "CAMERON", jobs.DIRECTOR, new birthDate(16, 8, 1954), "american"),
                new people(3, "Steven", "SPIELBERG", jobs.DIRECTOR, new birthDate(18, 12, 1946), "american")
        );
    }
    public static List<people> fillActors() {
        return Arrays.asList(
                new people(1, "Leonardo", "DICAPRIO", jobs.ACTOR, new birthDate(11, 11, 1974), "american"),
                new people(2, "Kate", "WINSLET", jobs.ACTOR, new birthDate(5, 10, 1975), "american"),
                new people(3, "Timothée", "CHALAMET", jobs.ACTOR, new birthDate(27, 12, 1995), "french"),
                new people(4, "Zendaya", "COLEMAN", jobs.ACTOR, new birthDate(1, 9, 1996), "american"),
                new people(5, "Henry", "THOMAS", jobs.ACTOR, new birthDate(9, 9, 1971), "american"),
                new people(6, "Thomas", "HOWELL", jobs.ACTOR, new birthDate(7, 12, 1966), "american")
        );
    }
    public static List<movies> fillMovies() {
        return Arrays.asList(
                new movies("Titanic", 1997, 2, Arrays.asList(1, 2), 194, Arrays.asList(genres.DRAME)),
                new movies("Dune", 2021, 1, Arrays.asList(3, 4), 155, Arrays.asList(genres.SCIENCE_FICTION, genres.ACTION)),
                new movies("E.T", 1982, 3, Arrays.asList(5, 6), 115, Arrays.asList(genres.SCIENCE_FICTION))
        );
    }

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
}
