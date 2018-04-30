package musicLang;

import java.util.ArrayList;
import java.util.List;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiUnavailableException;

import musicLang.MusicInstrument;

/**
 * MusicTrack class represents a track which is comprised of sequence of notes
 * A track can be played using instrument specified.
 * @author Mayuri Wadkar, Parth Vyas
 *
 */
public class MusicTrack {
	public List<Note> notes = new ArrayList<Note>();
	public MusicInstrument instrument = null;
	public double warmup;
	
	/**
	 * MusicTrack constructor
	 * @throws MidiUnavailableException
	 * @throws InvalidMidiDataException
	 */
	public MusicTrack() throws MidiUnavailableException, InvalidMidiDataException {
		this.warmup = 1;
	}
	
	public List<Note> getNotes() {
		return notes;
	}

	public void setNotes(List<Note> notes) {
		this.notes = notes;
	}

	public MusicInstrument getInstrument() {
		return instrument;
	}

	public void setInstrument(MusicInstrument instrument) {
		this.instrument = instrument;
	}

	public double getWarmup() {
		return warmup;
	}

	public void setWarmup(double warmup) {
		this.warmup = warmup;
	}

	public void addNote(Note n) {
		this.notes.add(n);
	}

	/**
	 * The play function sequentially plays notes stored in notes array
	 * @throws MidiUnavailableException
	 * @throws InvalidMidiDataException
	 * @throws InterruptedException
	 */
	public void play() throws MidiUnavailableException, InvalidMidiDataException, InterruptedException {
		
		final MidiSequencePlayer player = new MidiSequencePlayer(120,64);
		
		for(Note note:notes) {
			player.addNote(this.instrument, note.pitch(), this.warmup, note.duration());
			this.warmup += 1;
		}
		player.play();
	}
}
