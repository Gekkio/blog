package sample;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.zkoss.zk.ui.WebApp;
import org.zkoss.zk.ui.util.WebAppCleanup;
import org.zkoss.zk.ui.util.WebAppInit;

public class SampleExecutorHolder implements WebAppInit, WebAppCleanup {

    private static volatile ExecutorService executor;

    public static ExecutorService getExecutor() {
        return executor;
    }

    @Override
    public void cleanup(WebApp wapp) throws Exception {
        if (executor != null) {
            executor.shutdown();
            System.out.println("ExecutorService shut down");
        }
    }

    @Override
    public void init(WebApp wapp) throws Exception {
        executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        System.out.println("Initialized an ExecutorService");
    }

}
