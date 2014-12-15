package com;

import interf.ComposantAuthentificationRemote;

import javax.ejb.Remote;
import javax.ejb.Stateful;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

@SuppressWarnings("serial")
@Stateful
@Remote(ComposantAuthentificationRemote.class)
public class Authentication implements PhaseListener, ComposantAuthentificationRemote{

    private static final String UTILISATEUR_LOGIN_OUTCOME = "login";
       
    public void afterPhase(PhaseEvent event) {
        FacesContext context = event.getFacesContext();
       
        if (userExists(context)) {
            return;
        } else {            
            if (requestingSecureView(context)) {
                context.responseComplete();              
                context.getApplication().
                        getNavigationHandler().handleNavigation(context, null, UTILISATEUR_LOGIN_OUTCOME);
            }
        }
    }

    public void beforePhase(PhaseEvent event) {        
    }

    public PhaseId getPhaseId() {
        return PhaseId.RESTORE_VIEW;
    }
    
    // ---------------------------------------------------------       

    private boolean userExists(FacesContext context) {
        ExternalContext extContext = context.getExternalContext();
        return (extContext.getSessionMap().containsKey(GestionUtilisateur.UTILISATEUR_SESSION_KEY));
    }

    private boolean requestingSecureView(FacesContext context) {
        ExternalContext extContext = context.getExternalContext();       
        String path = extContext.getRequestPathInfo();
        return (!"/login.jsp".equals(path) && !"/CreationUtilisateur.jsp".equals(path));              
    }
}
