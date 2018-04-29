package musicLang;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.sound.midi.Instrument;
import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.MidiMessage;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Synthesizer;
import javax.sound.midi.Track;

import musicLang.MusicInstrument;

public class MusicTrack {
	final double warmup = 0.125;
	public ArrayList<Pitch> pitches = new ArrayList<Pitch>();
	public ArrayList<Double> durations = new ArrayList<Double>();
	public ArrayList<Note> notes = new ArrayList<Note>();
	
	private Sequence sequence;
	
	public MusicTrack() throws MidiUnavailableException, InvalidMidiDataException {

	}
	
	public void addNote(Note n) {
		this.notes.add(n);
	}

	public ArrayList<Pitch> getPitches() {
		return pitches;
	}

	public ArrayList<Double> getDurations() {
		return durations;
	}

	public void setPitches(Pitch p) {
		this.pitches.add(p);
	}

	public void setDurations(double d) {
		this.durations.add(d);
	}
	
	
	public void play() throws MidiUnavailableException, InvalidMidiDataException, InterruptedException {
		// TODO Auto-generated method stub



		for(Note note:notes) {
			final MidiSequencePlayer player = new MidiSequencePlayer(120,64);
			player.addNote(note.instrument(), note.pitch(), warmup, note.duration());
			Thread.sleep(500);
			player.play();
		}


	}

}
