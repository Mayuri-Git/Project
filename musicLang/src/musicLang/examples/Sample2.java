package musicLang.examples;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiUnavailableException;

import musicLang.Duration;
import musicLang.MusicInstrument;
import musicLang.MusicTrack;
import musicLang.Note;
import musicLang.Pitch;

public class Sample2 {
	
	
	public static void main(String args[]) throws MidiUnavailableException, InvalidMidiDataException {
		
		MusicTrack track1 = new MusicTrack();
		track1.addNote(new Note(1, new Pitch('C'), MusicInstrument.PIANO));
		track1.addNote(new Note(1, new Pitch('C'), MusicInstrument.PIANO));
		track1.addNote(new Note(1, new Pitch('C'), MusicInstrument.PIANO));
		track1.addNote(new Note(1, new Pitch('E'), MusicInstrument.PIANO));
		track1.addNote(new Note(1, new Pitch('D'), MusicInstrument.PIANO));
		track1.addNote(new Note(1, new Pitch('C'), MusicInstrument.FLUTE));
		track1.addNote(new Note(1, new Pitch('C'), MusicInstrument.FLUTE));
		track1.addNote(new Note(1, new Pitch('C'), MusicInstrument.FLUTE));
		track1.addNote(new Note(1, new Pitch('E'), MusicInstrument.FLUTE));
		track1.addNote(new Note(1, new Pitch('D'), MusicInstrument.FLUTE));
		track1.play();
	}
}
