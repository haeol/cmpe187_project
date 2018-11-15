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
	
	public void addCar(Car car) {
		if (!transactions.containsKey(car)) {
			transactions.put(car, new ArrayList<Transaction>());
		}
	}
	
	public void addTransaction(Car car, String message) {
		if (transactions.containsKey(car)) {
			transactions.get(car).add(new Transaction(message));
		}
		updateUI();
	}
	
	public void updateUI() {
		// TODO: update the UI with the latest transactions
	}
	
	private HashMap<Car, ArrayList<Transaction>> transactions;
	private static final DateFormat TimestampFormat =
			new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
}
