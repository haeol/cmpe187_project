import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class Monitor {
	
	public class Transaction {
		public Transaction(String message) {
			this.message = message;
			this.timestamp = new Date();
		}
		
		public Transaction(String message, Date timestamp) {
			this.message = message;
			this.timestamp = timestamp;
		}
		
		public String getMessage() {
			return message;
		}
		
		public void setMessage(String m) {
			message = m;
		}
		
		public Date getTimestamp() {
			return timestamp;
		}
		
		public void setTimestamp(Date d) {
			timestamp = d;
		}
		
		@Override
		public String toString() {
			return TimestampFormat.format(timestamp) + " " + message;
		}
		
		private String message;
		private Date timestamp;
	}
	
	private Monitor() {
		transactions = new HashMap<ICar, ArrayList<Transaction>>();
	}
	
	public static Monitor getInstance() {
		if (singletonMonitor == null) {
			singletonMonitor = new Monitor();
		}
		return singletonMonitor;
	}
	
	public void addCar(ICar car) {
		if (!transactions.containsKey(car)) {
			transactions.put(car, new ArrayList<Transaction>());
		}
	}
	
	public void addTransaction(ICar car, String message) {
		if (transactions.containsKey(car)) {
			transactions.get(car).add(new Transaction(message));
		}
		updateUI();
	}
	
	public HashMap<ICar, ArrayList<Transaction>> getTransactions() {
		return transactions;
	}
	
	public void setMonitorUI(MonitorUI monitorUI) {
		this.monitorUI = monitorUI;
	}
	
	public void updateUI() {
		if (monitorUI != null) {
			monitorUI.notify(this);
		}
	}
	
	private static Monitor singletonMonitor;
	
	private HashMap<ICar, ArrayList<Transaction>> transactions;
	private static final DateFormat TimestampFormat =
			new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	private MonitorUI monitorUI;
}
