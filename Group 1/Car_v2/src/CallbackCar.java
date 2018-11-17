
public class CallbackCar extends Car {
	
	public CallbackCar() {
		super();
		this.monitor = Monitor.getInstance();
	}
	
	public CallbackCar(Monitor monitor) {
		super();
		this.monitor = monitor;
	}

	@Override
	public void setCarID(int carID) {
		super.setCarID(carID);
		monitor.addTransaction(this, String.format("Car ID set %d", carID));
	}

	@Override
	public void setCurrentFloorNumber(int currentFloorNumber) {
		super.setCurrentFloorNumber(currentFloorNumber);
		monitor.addTransaction(this, String.format("Car %d now on floor %d", getCarID(), currentFloorNumber));
	}

	@Override
	public void setDoor(IDoor door) {
		super.setDoor(door);
		monitor.addTransaction(this, String.format(
				"Car %d now at door with status \"%s\"", getCarID(), door.getDoorStatus()));
	}

	@Override
	public void moveDown(int destinationFloorNo) {
		super.moveDown(destinationFloorNo);
		monitor.addTransaction(this, String.format(
				"Car %d moving down to floor %d", getCarID(), destinationFloorNo));
	}

	@Override
	public synchronized void  moveUp(int destinationFloorNo) {		
		super.moveUp(destinationFloorNo);
		monitor.addTransaction(this, String.format(
				"Car %d moving up to floor %d", getCarID(), destinationFloorNo));
	}

	@Override
	public void setStatus(CarStatus status) {
		super.setStatus(status);
		monitor.addTransaction(this, String.format("Car %d status: \"%s\"", getCarID(), status.name()));
	}
	
	private Monitor monitor;
}
