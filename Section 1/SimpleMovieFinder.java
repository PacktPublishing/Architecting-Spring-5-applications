public class SimpleMovieFinder {

    private MovieFinder movieFinder;
   
    public SimpleMovieFinder(MovieFinder movieFinder) {
        this.setMovieFinder(movieFinder);
    }

	public MovieFinder getMovieFinder() {
		return movieFinder;
	}

	public void setMovieFinder(MovieFinder movieFinder) {
		this.movieFinder = movieFinder;
	}
}
