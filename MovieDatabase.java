public class MovieDatabase {
	
	MyLinkedList<Genre> genreList;
	
	public MovieDatabase() {
		genreList = new MyLinkedList<Genre>();
	}

	public void insert(String genre, String title) {
		for (Genre genreElement : genreList){
			if (genreElement.name.equals(genre)){
				genreElement.insert(title);
				return;
			}
		}
		Genre newGenre = new Genre(genre);
		newGenre.insert(title);
		genreList.add(newGenre);
		return;
	}

	public void delete(String genre, String title) {
		for (Genre genreElement : genreList){
			if (genreElement.name.equals(genre)){
				genreElement.delete(title);
				if (genreElement.movieList.size() == 0){
					genreElement.delete(genre);
				}
				return;
			}
		}
	}

	public MyLinkedList<QueryResult> search(String term) {
		MyLinkedList<QueryResult> results = new MyLinkedList<QueryResult>();
		for (Genre genre : genreList){
			for (String movie : genre.movieList){
				if (movie.contains(term)){
					results.add(new QueryResult(genre.name, movie));
				}
			}
		}
		return results;
	}
}
