package hu.food.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import java.util.Map;

public class GeneratedJsfIdListener implements PhaseListener {

    @Override
    public void beforePhase(PhaseEvent event) {
        if (!ContextUtil.isProductionStage()) {
            FacesContext fc = FacesContext.getCurrentInstance();
            ExternalContext ec = fc.getExternalContext();
            Map<String, String> parameterMap = ec.getRequestParameterMap();
            if (parameterMap != null) {
                String jIdString = "j_id";
                for (String key : parameterMap.keySet()) {
                    boolean keyContainsNonFixId = key.toLowerCase().contains(jIdString);
                    if (keyContainsNonFixId) {
                        String keyContainsNonFixIdWarnMsg = "Non fix id found in key: " + key;
                        fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, keyContainsNonFixIdWarnMsg, null));
                    }
                    String keyValue = parameterMap.get(key);
                    if (keyValue != null) {
                        boolean keyValueContainsNonFixId = keyValue.toLowerCase().contains(jIdString);
                        if (keyValueContainsNonFixId) {
                            String keyValueContainsNonFixIdWarnMsg = "Non fix id found in value: " + keyValue + " with key: " + key;
                            fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, keyValueContainsNonFixIdWarnMsg, null));
                        }
                    }
                }
            }
        }
    }

    @Override
    public void afterPhase(PhaseEvent event) {

    }

    @Override public PhaseId getPhaseId() {
        return PhaseId.APPLY_REQUEST_VALUES;
    }
}
