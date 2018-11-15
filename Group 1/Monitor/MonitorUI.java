import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.FlowLayout;

public class MonitorUI extends JPanel {
	public MonitorUI() {
		super(new FlowLayout());
		textArea = new JTextArea(5, 20);
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane);
	}
	
	private JTextArea textArea;
}
