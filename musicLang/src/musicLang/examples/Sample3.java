package musicLang;

import javax.sound.midi.Instrument;
import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiUnavailableException;

public class Sample3 {
    public static void main(String args[]) throws MidiUnavailableException, InvalidMidiDataException, InterruptedException {


        String happyBirthday = "DDEDGFDDEDAGDDBAGGFCCAFBG";

        char[] notes = happyBirthday.toCharArray();

        MusicTrack track1 = new MusicTrack();
        for (char n : notes)
        {
            track1.setDurations(20);
            track1.setPitches(new Pitch(n));

        }

        for(int i=0; i < track1.pitches.size(); i++)
        {
            track1.addNote(new Note(track1.durations.get(i), track1.pitches.get(i), MusicInstrument.PIANO));
        }
        track1.play();

    }
}