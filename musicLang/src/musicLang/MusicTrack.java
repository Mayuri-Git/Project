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
	public static final int DEFAULT_BEATS_PER_MINUTE = 120;
	public static final int DEFAULT_TICKS_PER_BEAT = 64;
	private static final int META_MARKER = 6;
	private static final int DEFAULT_VELOCITY = 100;
	private static final int META_END_OF_TRACK = 47;
	
	final double warmup = 0.125;
	
	private final Map<Instrument, Integer> channels = new HashMap<>();
//	private final Synthesizer synthesizer;
	
	public ArrayList<Note> notes = new ArrayList<Note>();
	
	private Sequence sequence;
//	private final Sequencer sequencer;
//    private final Track track;
	
	public MusicTrack() throws MidiUnavailableException, InvalidMidiDataException {
//		synthesizer = MidiSystem.getSynthesizer();
//		synthesizer.open();
//		synthesizer.loadAllInstruments(synthesizer.getDefaultSoundbank());
//		this.sequencer = MidiSystem.getSequencer();
//		Sequence sequence = new Sequence(Sequence.PPQ, DEFAULT_TICKS_PER_BEAT);
//		this.track = sequence.createTrack();
//		sequencer.setSequence(sequence);
	}
	
	public void addNote(Note n) {
		this.notes.add(n);
	}
	
	
	public void play() throws MidiUnavailableException, InvalidMidiDataException, InterruptedException {
		// TODO Auto-generated method stub


		for(Note note:notes) {
			final MidiSequencePlayer player = new MidiSequencePlayer(120,64);
			player.addNote(note.instrument(), note.pitch(), warmup, note.duration());
			player.play();
		}

	}

}
