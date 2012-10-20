package sample;

import java.util.concurrent.Executor;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Button;
import org.zkoss.zul.Label;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Textbox;

public class SampleComposer extends GenericForwardComposer<Component> {

    private static final long serialVersionUID = -2075737470348143788L;

    private Executor executor;

    private Button execute;
    private Textbox input;
    private Label status;

    @Override
    public void doAfterCompose(Component comp) throws Exception {
        super.doAfterCompose(comp);

        // Get executor from somewhere (e.g. Spring)
        executor = SampleExecutorHolder.getExecutor();
    }

    public void onClick$execute() {
        desktop.enableServerPush(true);
        executor.execute(new SampleTask(input.getValue(), desktop, this));

        execute.setLabel("Running...");
        execute.setDisabled(true);
    }

    public void onFirstStepCompleted(FirstStepEvent event) {
        status.setValue("Task running: " + event.amountOfCharacters + " characters in input");
    }

    public void onSecondStepCompleted(SecondStepEvent event) {
        status.setValue("Task finished: " + event.upperCaseResult);

        execute.setLabel("Start task");
        execute.setDisabled(false);
    }

    public void onClick$dummy() {
        Messagebox.show("Background task doesn't block the application!");
    }

}
