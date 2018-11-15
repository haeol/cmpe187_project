
public class CallbackCar extends Car {
		
	public CallbackCar(Monitor monitor) {
		super();
		this.monitor = monitor;
	}

	public void setCarID(int carID) {
		super.setCarID(carID);
		monitor.addTransaction(this, String.format("Car ID set %d", carID));
	}

	public void setCarController(ICarController carController) {
		super.setCarController(carController);
		// TODO: add transaction for each setter
	}

	public void setCurrentFloorNumber(int currentFloorNumber) {
		super.setCurrentFloorNumber(currentFloorNumber);
	}

	public void setDoor(IDoor door) {
		super.setDoor(door);
	}

	public void setCarName(String carName) {
		super.setCarName(carName);
	}

	public void setUserPanel(IUserPanel userPanel) {
		super.setUserPanel(userPanel);
	}

	@Override
	public void setUserPanelQueue(IUserPanelQueue userPanelQueue) {
		super.setUserPanelQueue(userPanelQueue);
	}

	@Override
	public void moveDown(int destinationFloorNo) {
		super.moveDown(destinationFloorNo);
		// not sure if need add transaction here
	}

	@Override
	public synchronized void  moveUp(int destinationFloorNo) {		
		super.moveUp(destinationFloorNo);
	}

	@Override
	public void setStatus(CarStatus status) {
		super.setStatus(status);
	}

	@Override
	public void setDoorPanel(IDoorPanel doorPanel) {
		super.setDoorPanel(doorPanel);
	}
	
	private Monitor monitor;
}
