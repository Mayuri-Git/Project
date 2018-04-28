package musicLang.examples;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiUnavailableException;

public class Sample3 {
    public static void main(String args[]) throws MidiUnavailableException, InvalidMidiDataException, InterruptedException {


        String happyBirthday = "DDEDGFDDEDAGDDBAGGFCCAFBG";

        char[] notes = happyBirthday.toCharArray();

        for (char n : notes)
        {
            MusicTrack track1 = new MusicTrack();
            track1.addNote(new Note(1, new Pitch(n), MusicInstrument.PIANO));
            track1.play();
            Thread.sleep(500);
        }


    }
}