package sample;

import org.zkoss.zk.ui.event.Event;

public class SecondStepEvent extends Event {

    private static final long serialVersionUID = 5095885632591720766L;

    public final String upperCaseResult;

    public SecondStepEvent(String upperCaseResult) {
        super("onSecondStepCompleted", null);
        this.upperCaseResult = upperCaseResult;
    }

}
