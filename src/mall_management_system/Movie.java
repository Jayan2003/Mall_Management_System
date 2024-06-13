package mall_management_system;
import java.time.LocalDate;//to use LocalDate datatype

public class Movie {
    private String movie_name;
    private String movie_genre;
    private LocalDate release_date;
    private String running_time;
    private int hallnumber;
    
   
    public String getMovie_name() {
        return movie_name;
    }
    
    public void setMovie_name(String movie_name) {
        this.movie_name = movie_name;
    }

    public LocalDate getRelease_date() {
        return release_date;
    }

    public void setRelease_date(LocalDate release_date) {
        this.release_date = release_date;
    }

    public String getRunning_time() {
        return running_time;
    }

    public void setRunning_time(String running_time) {
        this.running_time = running_time;
    }

    public int getHallnumber() {
        return hallnumber;
    }

    public void setHallnumber(int hallnumber) {
        this.hallnumber = hallnumber;
    }

    public String getMovie_genre() {
        return movie_genre;
    }

    public void setMovie_genre(String movie_genre) {
        this.movie_genre = movie_genre;
    }
    

    //Default constructor
    public Movie() {
        this.movie_name = "Avatar";
        this.movie_genre = "Science Fiction";
        this.release_date = LocalDate.of(2009,12,16);
        this.running_time = "150 min";
        this.hallnumber=10;
    }
    
    //Argument-based Constructor
    public Movie(String movie_name, String movie_genre, LocalDate release_date, String running_time, int hallnumber) {
        this.movie_name = movie_name;
        this.movie_genre = movie_genre;
        this.release_date = release_date;
        this.running_time = running_time;
        this.hallnumber=hallnumber;
    }
    //Copy Constructor
    public Movie(Movie m) {
        this.movie_name = m.movie_name;
        this.movie_genre =m.movie_genre;
        this.release_date = m.release_date;
        this.running_time =m.running_time;
        this.hallnumber=m.hallnumber;
    }
    public String toString(){
        return  "Movie name is "+movie_name+"\nMovie genre is "+movie_genre+"\nRelease Date is "+release_date+"\nRunning Time is "+running_time+"\nHall Number is "+hallnumber;
    }
    
}

