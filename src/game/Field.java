package game;

import game.Cell.State;

public class Field {
	private static final int WIDTH = 70;
	private static final int HIGHT = 70;

	private final int[] x = { -1, 0, 1, -1, 1, -1, 0, 1 };
	private final int[] y = { 1, 1, 1, 0, 0, -1, -1, -1 };

	private final Cell[][] field;

	public Field() {

		field = new Cell[WIDTH][HIGHT];
		for (int i = 0; i < field.length; ++i) {
			for (int j = 0; j < field[i].length; ++j) {
				field[i][j] = new Cell();
			}
		}
		generationX();
	}

	public void checkLifeCondition() {
		int count;
		for (int i = 1; i < field.length - 1; ++i) {
			for (int j = 1; j < field[i].length - 1; ++j) {

				count = 0;
				for (int k = 0; k < 8; k++) {
					if (field[i + x[k]][j + y[k]].isAlive())
						count++;
				}
				if (!field[i][j].isAlive() && count == 3)
					field[i][j].setNextState(State.ALIVE);
				else if (field[i][j].isAlive() && count < 2)
					field[i][j].setNextState(State.DEAD);
				else if (field[i][j].isAlive() && (count == 2 || count == 3))
					field[i][j].setNextState(State.ALIVE);
				else if (field[i][j].isAlive() && count > 3)
					field[i][j].setNextState(State.DEAD);

			}
		}

	}

	// hat hier nichts zu suchen
	public void buildField() {
		System.out.println("==================================================");
		for (final Cell[] element : field) {
			for (final Cell element2 : element) {
				if (element2.isAlive())
					System.out.print("*");
				else
					System.out.print(" ");
			}
			System.out.println("");
		}
		System.out.println("====================================================");

	}

	public void update() {
		checkLifeCondition();

		for (int i = 1; i < field.length - 1; ++i)
			for (int j = 1; j < field[i].length - 1; ++j)
				field[i][j].setState(field[i][j].getNextState());
	}

	public Cell[][] getField() {
		return field;
	}

	public void r_Pentonimo() {
		field[22][23].switchState();
		field[22][24].switchState();
		field[23][22].switchState();
		field[23][23].switchState();
		field[24][23].switchState();

	}

	public void generationX() {
		// Das Muster erzeugt innerhalb von 54 Generationen eine leere Welt
		// https://de.wikipedia.org/wiki/Conways_Spiel_des_Lebens#/media/File:Game_of_life_U.gif

		field[50][49].switchState();
		field[50][50].switchState();
		field[50][51].switchState();
		field[51][49].switchState();
		field[52][49].switchState();
		field[51][51].switchState();
		field[52][51].switchState();

		field[56][49].switchState();
		field[56][50].switchState();
		field[56][51].switchState();
		field[55][49].switchState();
		field[54][49].switchState();
		field[55][51].switchState();
		field[54][51].switchState();

	}

}