package musicLang;

public class Sample1 {

	public static void main(String[] args) {
		
		Note a = new Note(Pitch.A,Duration.w);
		Note b = new Note(Pitch.G,Duration.q);
		
		Track myTrack = new Track("myTrack");
		
		myTrack.appendNote(a);
		myTrack.appendNote(b);
		
		myTrack.setInstrument(Instrument.HARMONICA);
		
		myTrack.play();
	}

}


