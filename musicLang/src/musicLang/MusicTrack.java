package musicLang;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.sound.midi.*;

import musicLang.MusicInstrument;

public class MusicTrack {
	private static final int DEFAULT_VELOCITY = 100;
	public MusicInstrument instrument;
	public ArrayList<Note> notes = new ArrayList<Note>();
	
	public void addNote(Note n) {
		this.notes.add(n);
	}
	
	public void setInstrument(MusicInstrument i) {
		this.instrument = i;
	}
	
	public void play() throws MidiUnavailableException {
		// TODO Auto-generated method stub
	        
		Synthesizer midiSynth = MidiSystem.getSynthesizer();
		midiSynth.open();

		final MidiChannel[] mChannels = midiSynth.getChannels();
		
		MidiChannel channel = mChannels[0];
		
		channel.programChange(this.instrument.ordinal());
		
		for(Note note:notes) {
			int noteNumber  = note.getNoteNumber();
			channel.noteOn(noteNumber, DEFAULT_VELOCITY);
			try { Thread.sleep(note.getDuration()); 
			} catch( InterruptedException e ) { }
			channel.noteOff(noteNumber);
		}
				
	}

}
