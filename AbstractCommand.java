public abstract class AbstractCommand implements Command {
	@Override
	public void apply(MovieDatabase db, String args) throws DatabaseException {
		String[] arga = parse(args);
		queryDatabase(db, arga);
	}

	private String[] parse(String args) throws CommandParseException {
		if (args.isEmpty()) {
			return new String[] {};
		} else {
			String[] preparse = args.split("%");
			String[] parse = new String[preparse.length / 2];
			for (int i = 0; i < preparse.length; i++){
				if (i % 2 != 0)
				parse[i / 2] = preparse[i];
			}
			return parse;
		}
	}

	protected abstract void queryDatabase(MovieDatabase db, String[] arga) throws DatabaseException;
}
