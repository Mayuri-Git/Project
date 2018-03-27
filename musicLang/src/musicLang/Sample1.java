package musicLang;

import javax.sound.midi.*;
import javax.sound.midi.Instrument;

public class Sample1 {

	public static void main(String[] args) {
		
		Note a = new Note(Pitch.A,Duration.w);
		Note b = new Note(Pitch.G,Duration.q);
		
		Track myTrack = new Track("myTrack");
		
		myTrack.appendNote(a);
		myTrack.appendNote(b);
		
		myTrack.setInstrument(musicLang.Instrument.HARMONICA);
		
		myTrack.play();

		try{
        /* Create a new Sythesizer and open it. Most of
         * the methods you will want to use to expand on this
         * example can be found in the Java documentation here:
         * https://docs.oracle.com/javase/7/docs/api/javax/sound/midi/Synthesizer.html
         */

			Synthesizer midiSynth = MidiSystem.getSynthesizer();
			midiSynth.open();

			//get and load default instrument and channel lists
			Instrument[] instr = midiSynth.getDefaultSoundbank().getInstruments();
			final MidiChannel[] mChannels = midiSynth.getChannels();

			mChannels[0].programChange(50);	// program change parameter changes instrument


			mChannels[0].noteOn(50, 100);//On channel 0, play note number 60 with velocity 100
			try { Thread.sleep(2000); // wait time in milliseconds to control duration
			} catch( InterruptedException e ) { }
			mChannels[0].noteOff(60);//turn of the note


		} catch (MidiUnavailableException e) {}
	}

}


