package musicLang.examples;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiUnavailableException;

import musicLang.Duration;
import musicLang.MusicInstrument;
import musicLang.MusicTrack;
import musicLang.Note;
import musicLang.Pitch;

public class Sample2 {
	
	
	public static void main(String args[]) throws MidiUnavailableException, InvalidMidiDataException, InterruptedException {
		
		MusicTrack track1 = new MusicTrack();
		track1.addNote(new Note(1, new Pitch('C')));
		track1.addNote(new Note(1, new Pitch('C')));
		track1.addNote(new Note(1, new Pitch('C')));
		track1.addNote(new Note(1, new Pitch('E')));
		track1.addNote(new Note(1, new Pitch('D')));
		track1.addNote(new Note(1, new Pitch('C')));
		track1.addNote(new Note(1, new Pitch('C')));
		track1.addNote(new Note(1, new Pitch('C')));
		track1.addNote(new Note(1, new Pitch('E')));
		track1.addNote(new Note(1, new Pitch('D')));
		track1.setInstrument(MusicInstrument.VIOLIN);
		track1.play();
	}
}
