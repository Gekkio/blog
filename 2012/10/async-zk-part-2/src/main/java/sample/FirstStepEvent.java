package sample;

import org.zkoss.zk.ui.event.Event;

public class FirstStepEvent extends Event {

    private static final long serialVersionUID = -4093215605557566198L;

    public final int amountOfCharacters;

    public FirstStepEvent(int amountOfCharacters) {
        super("onFirstStepCompleted", null);
        this.amountOfCharacters = amountOfCharacters;
    }

}
