package Game.Entities.Creatures;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import com.sun.glass.events.KeyEvent;

import Game.Entities.Statics.StaticEntity;
import Main.Handler;
import Resources.Images;
import Worlds.BaseWorld;

public class Humanoid extends StaticEntity {
	private BaseWorld world;

	private int counter = 0;
	private boolean selected = false;
	private boolean alreadyTalked = false;

	public Humanoid(Handler handler, float x, float y, BaseWorld world) {
		super(handler, x, y, 64, 64);
		// TODO Auto-generated constructor stub

	}

	@Override
	public void tick() {
		if (handler.getKeyManager().keyJustPressed(KeyEvent.VK_E)) {
			selected = true;
			counter++;
		}

		if (health < 100)
			health = 100;

		// TODO Auto-generated method stub

	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub

		Graphics2D g2d = (Graphics2D) g;
		if (getBoundsBot().intersects(handler.getWorld().getEntityManager().getPlayer().getCollisionBounds(0, 0))) {

			g.drawImage(Images.humanoid_front[0], (int) (x - handler.getGameCamera().getxOffset()),
					(int) (y - handler.getGameCamera().getyOffset()), 64, 84, null);

		} else if (getBoundsLeft()
				.intersects(handler.getWorld().getEntityManager().getPlayer().getCollisionBounds(0, 0))) {

			g.drawImage(Images.humanoid_left[0], (int) (x - handler.getGameCamera().getxOffset()),
					(int) (y - handler.getGameCamera().getyOffset() - 20), 64, 84, null);
		} else if (getBoundsTop()
				.intersects(handler.getWorld().getEntityManager().getPlayer().getCollisionBounds(0, 0))) {

			g.drawImage(Images.humanoid_back[0], (int) (x - handler.getGameCamera().getxOffset()),
					(int) (y - handler.getGameCamera().getyOffset()) - 20, 64, 84, null);
		} else if (getBoundsRight()
				.intersects(handler.getWorld().getEntityManager().getPlayer().getCollisionBounds(0, 0))) {

			g.drawImage(Images.humanoid_right[0], (int) (x - handler.getGameCamera().getxOffset()),
					(int) (y - handler.getGameCamera().getyOffset() - 20), 64, 84, null);
		} else {
			g.drawImage(Images.humanoid_front[0], (int) (x - handler.getGameCamera().getxOffset()),
					(int) (y - handler.getGameCamera().getyOffset()), 64, 84, null);
		}

		if (getBoundsRight().intersects(handler.getWorld().getEntityManager().getPlayer().getCollisionBounds(0, 0))
				|| getBoundsLeft()
						.intersects(handler.getWorld().getEntityManager().getPlayer().getCollisionBounds(0, 0))
				|| getBoundsTop().intersects(handler.getWorld().getEntityManager().getPlayer().getCollisionBounds(0, 0))
				|| getBoundsBot()
						.intersects(handler.getWorld().getEntityManager().getPlayer().getCollisionBounds(0, 0))) {
			if (!handler.getWorld().getEntityManager().getPlayer().getTalking() && !alreadyTalked)
				g.drawImage(Images.exlcamationMark, (int) (x - handler.getGameCamera().getxOffset()),
						(int) (y - handler.getGameCamera().getyOffset() - 64), 64, 64, null);

			if (selected) {

				if (!alreadyTalked) {
					handler.getWorld().getEntityManager().getPlayer().setTalking(true);

					if (counter <= Images.bubble.length) {
						g.drawImage(Images.bubble[counter - 1], (int) (x - handler.getGameCamera().getxOffset()) + 40,
								(int) (y - handler.getGameCamera().getyOffset()) - 140, null);

					} else if (counter > 4) {
						handler.getWorld().getEntityManager().getPlayer().setTalking(false);
						counter = 0;
						selected = false;
						alreadyTalked = true;
					}
				}

			} else {
				counter = 0;
			}
		}

		// g2d.setColor(Color.red);
		// g2d.draw(getBoundsTop());
		// g2d.draw(getBoundsBot());
		// g2d.draw(getBoundsLeft());
		// g2d.draw(getBoundsRight());

	}

	public Rectangle getBoundsTop() {
		return new Rectangle((int) (x - handler.getGameCamera().getxOffset()),
				(int) (y - handler.getGameCamera().getyOffset() - 64), 64, 64);
	}

	public Rectangle getBoundsBot() {
		return new Rectangle((int) (x - handler.getGameCamera().getxOffset()),
				(int) (y - handler.getGameCamera().getyOffset() + 64), 64, 64);
	}

	public Rectangle getBoundsRight() {
		return new Rectangle((int) (x - handler.getGameCamera().getxOffset() + 64),
				(int) (y - handler.getGameCamera().getyOffset()), 64, 64);
	}

	public Rectangle getBoundsLeft() {
		return new Rectangle((int) (x - handler.getGameCamera().getxOffset() - 64),
				(int) (y - handler.getGameCamera().getyOffset()), 64, 64);
	}

	@Override
	public void die() {
		// TODO Auto-generated method stub

	}

}
