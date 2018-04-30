package musicLang;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
	public List<Pitch> pitches = new ArrayList<Pitch>();
	public List<Double> durations = new ArrayList<Double>();
	public List<Note> notes = new ArrayList<Note>();
	public MusicInstrument instrument = null;
	
	private Sequence sequence;
	
	public MusicTrack() throws MidiUnavailableException, InvalidMidiDataException {

	}
	
	public void addNote(Note n) {
		this.notes.add(n);
	}

	public List<Pitch> getPitches() {
		return pitches;
	}

	public List<Double> getDurations() {
		return durations;
	}

	public void setPitches(Pitch p) {
		this.pitches.add(p);
	}

	public void setDurations(double d) {
		this.durations.add(d);
	}
	
	
	public void play() throws MidiUnavailableException, InvalidMidiDataException, InterruptedException {
		
		double warmup = 1;
		final MidiSequencePlayer player = new MidiSequencePlayer(120,64);
		
		for(Note note:notes) {
			player.addNote(this.instrument, note.pitch(), warmup, note.duration());
			//Thread.sleep(500);
			warmup += 1;
		}
		player.play();
	}

}
