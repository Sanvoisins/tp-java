import java.util.ArrayList;
import java.util.List;

public class movies {
    private String title;
    private Integer release_year;
    private Integer id_director;
    private List < Integer > actors_id = new ArrayList < Integer > ();
    private Double duration;
    private List <genres> genres = new ArrayList <genres> ();

    public movies(String title, int release_year, int id_director, List<Integer> actors_id, double duration, List<genres> genres) {
        this.title = title;
        this.release_year = release_year;
        this.id_director = id_director;
        this.actors_id = actors_id;
        this.duration = duration;
        this.genres = genres;
    }
    @Override
    public String toString() {
        return "movies{" +
                "title='" + title + '\'' +
                ", release_year=" + release_year +
                ", id_director=" + id_director +
                ", actors_id=" + actors_id +
                ", duration=" + duration +
                ", genres=" + genres +
                '}';
    }
    public String getTitle() {
        return this.title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public Integer getReleaseYear() {
        return this.release_year;
    }
    public void setReleaseYear(Integer release_year) {
        this.release_year = release_year;
    }
    public Integer getIdDirector() {
        return this.id_director;
    }
    public void setIdDirector(Integer id_director) {
        this.id_director = id_director;
    }
    public List < Integer > getActorsId() {
        return this.actors_id;
    }
    public void setIdDirector(List < Integer > actors_id) {
        this.actors_id = actors_id;
    }
    public Double getDuration() {
        return this.duration;
    }
    public void setDuration(Double duration) {
        this.duration = duration;
    }
    public List <genres> getGenres() {
        return this.genres;
    }
    public void setGenres(List <genres> genres) {
        this.genres = genres;
    }
}