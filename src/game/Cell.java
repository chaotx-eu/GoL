package game;

public class Cell {

	public enum State {
		ALIVE, DEAD
	}

	private State nextState;
	private State state;

	public Cell() {
		this.state = State.DEAD;
		nextState = State.DEAD;
	}

	public boolean isAlive() {

		return this.getState() == State.ALIVE ? true : false;
	}

	public State getState() {
		return this.state;
	}

	public State getNextState() {
		return this.nextState;
	}

	public void switchState() {
		if (this.getState() == State.ALIVE)
			this.state = State.DEAD;
		else
			this.state = State.ALIVE;
	}

	public void setState(final State state) {
		this.state = state;
	}

	public void setNextState(final State state) {
		nextState = state;
	}

}