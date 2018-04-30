package musicLang;

/**
 * Note class represents the smallest musical event that is comprised of pitch scale and note duration. 
 * @author Mayuri Wadkar, Parth Vyas
 * 
 */
public class Note {
    
    private final double duration;
    private final Pitch pitch;
    
    private void checkRep() {
        assert duration >= 0;
        assert pitch != null;
    }
    
    /**
     * Constructs a note to be played for duration beats.
     * @param duration duration in beats, must be >= 0
     * @param pitch pitch scale
     */
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
     * @return duration of this note
     */
    public double duration() {
        return duration;
    }
    
    @Override
    public String toString() {
        return pitch.toString() + duration;
    }
}
