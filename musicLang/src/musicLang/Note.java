package musicLang;

/**
 * Note represents a note played by an instrument. 
 */
public class Note {
    
    private final double duration;
    private final Pitch pitch;
    private MusicInstrument instrument = null;
    
    private void checkRep() {
        assert duration >= 0;
        assert pitch != null;
        assert instrument != null;
    }
    
    /**
     * Make a Note played by instrument for duration beats.
     * @param duration duration in beats, must be >= 0
     * @param pitch pitch to play
     * @param instrument instrument to use
     */
    public Note(double duration, Pitch pitch, MusicInstrument instrument) {
        this.duration = duration;
        this.pitch = pitch;
        this.instrument = instrument;
        checkRep();
    }
    
    public Note(double duration, Pitch pitch) {
        this.duration = duration;
        this.pitch = pitch;
        checkRep();
    }
    
    /**
     * @return pitch of this note
     */
    public Pitch pitch() {
        return pitch;
    }

    /**
     * @return instrument that should play this note
     */
    public MusicInstrument instrument() {
        return instrument;
    }
    
    /**
     * @return duration of this note
     */
    public double duration() {
        return duration;
    }
    
    /**
     * Play this note.
     */
    public void play(MidiSequencePlayer player, double atBeat) {
        player.addNote(instrument, pitch, atBeat, duration);
    }

    @Override
    public int hashCode() {
        long durationBits = Double.doubleToLongBits(duration);
        return (int) (durationBits ^ (durationBits >>> 32))
                + instrument.hashCode()
                + pitch.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        
        final Note other = (Note) obj;
        return duration == other.duration
                && instrument.equals(other.instrument)
                && pitch.equals(other.pitch);
    }

    @Override
    public String toString() {
        return pitch.toString() + duration;
    }
}
