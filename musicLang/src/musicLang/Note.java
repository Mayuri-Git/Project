package musicLang;

public class Note {
	private Duration duration;
    private Pitch pitch;
	
    public Note(Pitch pitch, Duration duration) {
        this.duration = duration;
        this.pitch = pitch;
    }

	public void setDuration(Duration dur) {
		this.duration = dur;
	}

	public void setPitch(Pitch pitch) {
		this.pitch = pitch;
	}

	public Duration getDuration() {
		return duration;
	}

	public Pitch getPitch() {
		return pitch;
	}

	public int getNoteNumber() {
		// TODO Auto-generated method stub
		return 0;
	}

	

}
