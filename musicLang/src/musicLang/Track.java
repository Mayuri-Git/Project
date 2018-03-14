package musicLang;

import java.util.ArrayList;

public class Track {
	private Instrument instrument;
	private String title;
	private ArrayList<Note> notes = new ArrayList<Note>();
	
	Track(String title){
		this.title = title;
	}

	public void appendNote(Note note) {
		// TODO Auto-generated method stub
		this.notes.add(note);
	}

	public void setInstrument(Instrument instrument) {
		// TODO Auto-generated method stub
		this.instrument = instrument;
	}

	public void play() {
		// TODO Auto-generated method stub
		
	}
}
