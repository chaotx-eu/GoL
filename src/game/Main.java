package game;

public class Main {

	public static void main(final String[] args) {

		final Field f = new Field();
		f.r_Pentonimo();

		final Thread t = new Thread(() -> {

			while (true) {

				try {
					Thread.sleep(100);
				} catch (final InterruptedException e) {
					e.getMessage();
					e.printStackTrace();
				}

				f.buildField();
				f.checkLifeCondition();
				f.update();

			}

		});

		t.start();
	}

}
