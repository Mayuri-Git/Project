package musicLang;

/**
 * Pitch class represents the frequency of a musical note.
 * These frequencies are represented by letters: A-G.
 * @author Mayuri Wadkar, Parth Vyas
 * 
 */
public class Pitch {

    private final int value;

    private static final int[] SCALE = {
        9,  // A
        11, // B
        0,  // C
        2,  // D
        4,  // E
        5,  // F
        7,  // G
    };

    private static final String[] VALUE_TO_STRING = {
            "C", "^C", "D", "^D", "E", "F", "^F", "G", "^G", "A", "^A", "B"
    };

    public static final Pitch MIDDLE_C = new Pitch('C');	//middle C
    
    public static final int OCTAVE = 12;	//Number of pitches in an octave
    
    private Pitch(int value) {
        this.value = value;
    }

    /**
     * Make a pitch in the middle octave of the piano keyboard.
     * @param pitchChar letter in {'A',...,'G'}
     */
    public Pitch(char pitchChar) {
        try {
            value = SCALE[pitchChar-'A'];
        } catch (ArrayIndexOutOfBoundsException aioobe) {
            throw new IllegalArgumentException(pitchChar + " must be in the range A-G");
        }
    }

    /**
     * @return pitch made by transposing this pitch by semitonesUp semitones;
     *         for example, middle C transposed by 12 semitones is high C, and
     *         E transposed by -1 semitones is E flat
     */
    public Pitch transpose(int semitonesUp) {
        return new Pitch(value + semitonesUp);
    }

    /**
     * @return number of semitones between this and that; i.e., n such that
     *         that.transpose(n).equals(this)
     */
    public int difference(Pitch that) {
        return this.value - that.value;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (obj.getClass() != this.getClass()) return false;
        
        Pitch that = (Pitch) obj;
        return this.value == that.value;
    }

    @Override
    public int hashCode() {
        return value;
    }

    /**
     * @return this pitch in abc music notation
     * @see http://www.walshaw.plus.com/abc/examples/
     */
    @Override
    public String toString() {
        String suffix = "";
        int v = value;

        while (v < 0) {
            suffix += ",";
            v += 12;
        }

        while (v >= 12) {
            suffix += "'";
            v -= 12;
        }

        return VALUE_TO_STRING[v] + suffix;
    }
}
