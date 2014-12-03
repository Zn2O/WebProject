package interf;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;

public interface ComposantAuthentificationRemote {
	public void afterPhase(PhaseEvent event);
	public void beforePhase(PhaseEvent event);
    public PhaseId getPhaseId();
}
