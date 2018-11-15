import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.FlowLayout;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;

public class MonitorUI extends JPanel {
	public MonitorUI() {
		super(new FlowLayout());
		textArea = new JTextArea(5, 20);
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane);
        lastMessageIndex = new HashMap<ICar, Integer>();
	}
	
	public synchronized void notify(Monitor monitor) {
		HashMap<ICar, ArrayList<Monitor.Transaction>> transactions =
				monitor.getTransactions();
		for (Map.Entry<ICar, ArrayList<Monitor.Transaction>> pair : transactions.entrySet()) {
			ICar car = pair.getKey();
			ArrayList<Monitor.Transaction> transaction = pair.getValue();
			
			// Append strings instead of updating the whole area based on what has been added
			if (!lastMessageIndex.containsKey(car)) {
				lastMessageIndex.put(car, 0);
			}
			int lastIndex = lastMessageIndex.get(car);
			if (lastIndex < transaction.size()) {
				for (int i = lastIndex; i < transaction.size(); ++i) {
					textArea.append(transaction.get(i).toString() + '\n');
				}
				lastMessageIndex.put(car, transaction.size());
			}
		}
	}
	
	private HashMap<ICar, Integer> lastMessageIndex;
	private JTextArea textArea;
}
