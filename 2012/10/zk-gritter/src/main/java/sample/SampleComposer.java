package sample;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;

import fi.jawsy.jawwa.zk.gritter.Gritter;
import fi.jawsy.jawwa.zk.gritter.Gritter.NotificationBuilder;

public class SampleComposer extends SelectorComposer<Component> {

    private static final long serialVersionUID = -1201615012297469103L;

    private static final String LOREM_IPSUM = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. In consequat tortor sed tellus luctus ultricies. Mauris convallis aliquam semper. Proin egestas sapien bibendum dolor pharetra id faucibus sem feugiat. Sed auctor vehicula venenatis. Etiam ac molestie velit. Integer id leo erat, ac tristique risus. Nunc tristique, orci at mollis semper, orci massa vehicula mauris, et consectetur nunc libero non ipsum. ";

    private NotificationBuilder notification() {
        return Gritter.notification().withTitle("ZK Gritter demo").withText(LOREM_IPSUM);
    }

    @Listen("onClick = #regular")
    public void regular() {
        notification().show();
    }

    @Listen("onClick = #sticky")
    public void sticky() {
        notification().withSticky(true).show();
    }

    @Listen("onClick = #timeout")
    public void timeout() {
        notification().withTime(500).show();
    }

    @Listen("onClick = #sclass")
    public void sclass() {
        notification().withSclass("gritter-red").show();
    }

    @Listen("onClick = #image")
    public void image() {
        notification().withImage("/warning.png").show();
    }

    @Listen("onClick = #clear")
    public void clear() {
        Gritter.removeAll();
    }

}
