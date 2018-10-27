package Game.Entities;

import java.awt.Color;
import java.awt.Graphics;

import Main.Handler;

public class DisplayInfo {

	private EntityBase e;

	private Handler handler;

	public DisplayInfo(EntityBase e, Handler handler) {
		this.e = e;

		this.handler = handler;
	}

	public void render(Graphics g, int x, int y) {

		if (e.getId() == EntityId.player) {

			if (e.getHealth() > e.getHealth() / 2) {
				g.setColor(Color.GREEN);
				g.fillRect((int) (x - handler.getGameCamera().getxOffset()),
						(int) (y - handler.getGameCamera().getyOffset() - 20), e.getHealth(), 10);

			} else if (e.getHealth() >= 15 && e.getHealth() <= e.getHeight() / 2) {
				g.setColor(Color.YELLOW);
				g.fillRect((int) (x - handler.getGameCamera().getxOffset()),
						(int) (y - handler.getGameCamera().getyOffset() - 20), e.getHealth(), 10);

			} else if (this.e.getHealth() < 15) {
				g.setColor(Color.RED);
				g.fillRect((int) (x - handler.getGameCamera().getxOffset()),
						(int) (y - handler.getGameCamera().getyOffset() - 20), e.getHealth(), 10);

			}
		} else {
			g.setColor(Color.red);
			g.fillRect((int) (x - handler.getGameCamera().getxOffset()),
					(int) (y - handler.getGameCamera().getyOffset() - 20), e.getHealth(), 10);

		}

	}

	public void missionLog() {

	}
}
