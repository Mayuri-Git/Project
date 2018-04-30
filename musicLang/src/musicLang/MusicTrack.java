package musicLang;

import java.util.ArrayList;
import java.util.List;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiUnavailableException;

import musicLang.MusicInstrument;

public class MusicTrack {
	public List<Pitch> pitches = new ArrayList<Pitch>();
	public List<Double> durations = new ArrayList<Double>();
	public List<Note> notes = new ArrayList<Note>();
	public MusicInstrument instrument = null;
	public double warmup;
	
	public MusicTrack() throws MidiUnavailableException, InvalidMidiDataException {
		this.warmup = 1;
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
		
		final MidiSequencePlayer player = new MidiSequencePlayer(120,64);
		
		for(Note note:notes) {
			player.addNote(this.instrument, note.pitch(), this.warmup, note.duration());
			this.warmup += 1;
		}
		player.play();
	}

}
