class Genre implements Comparable<Genre> {
	
	String name;
	MyLinkedList<String> movieList;
	
	public Genre(String name) {
		this.name = name;
		movieList = new MyLinkedList<String>();
	}
	
	public boolean insert(String title){
		return movieList.add(title);
	}
	
	public boolean delete(String title){
		return movieList.remove(title);
	}

	@Override
	public int compareTo(Genre other) {
		return name.compareTo(other.name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Genre other = (Genre) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public String toString() {
		String str = "";
		str += "(";
		str += name;
		for (String movie : movieList){
			str += ", " + movie;
		}
		str += ")";
		return str; 
	}
}
