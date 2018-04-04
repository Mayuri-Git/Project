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

			mChannels[0].programChange(0);	// program change parameter changes instrument


			mChannels[0].noteOn(60, 100);//On channel 0, play note number 60 with velocity 100
			try { Thread.sleep(5000); // wait time in milliseconds to control duration
			} catch( InterruptedException e ) { }
			mChannels[0].noteOff(60);//turn of the note
			
			
			
			
			//analyzing different instruments
			
			
			Instrument[] instruments = midiSynth.getDefaultSoundbank().getInstruments();
			final MidiChannel[] channels = midiSynth.getChannels();
			
			Synthesizer synth = MidiSystem.getSynthesizer();
			synth.open();
			
			//steel drums
			int instrument = 114;
			int velocity = 100;
			int note = 60;
			
			synth.loadInstrument(instruments[instrument]);
			channels[0].programChange(instrument);
			
			System.out.println(instruments[instrument].getName());
			
			mChannels[0].noteOn(note, velocity);
			try { Thread.sleep(5000); // wait time in milliseconds to control duration
			} catch( InterruptedException e ) { }
			mChannels[0].noteOff(note);//turn of the note
			
			
			//loading all instruments
			for(Instrument instrument1 : instr) {
				System.out.println(instrument1);
			}
			
			
		} catch (MidiUnavailableException e) {}
	}

}


