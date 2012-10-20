package sample;

import java.util.Locale;

import org.zkoss.zk.ui.Desktop;
import org.zkoss.zk.ui.DesktopUnavailableException;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;

public class SampleTask implements Runnable {

    private final String input;
    private final Desktop desktop;
    private final EventListener<Event> eventListener;

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public SampleTask(String input, Desktop desktop, EventListener eventListener) {
        this.input = input;
        this.desktop = desktop;
        this.eventListener = eventListener;
    }

    @Override
    public void run() {
        try {
            // Step 1
            Thread.sleep(10000);
            Executions.schedule(desktop, eventListener, new FirstStepEvent(input.length()));

            // Step 2
            Thread.sleep(10000);
            Executions.schedule(desktop, eventListener, new SecondStepEvent(input.toUpperCase(Locale.ENGLISH)));
        } catch (DesktopUnavailableException e) {
            System.err.println("Desktop is no longer available: " + desktop);
        } catch (InterruptedException e) {
        }
    }

}
