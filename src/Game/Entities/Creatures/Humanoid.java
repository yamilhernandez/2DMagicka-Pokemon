package Game.Entities.Creatures;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.sun.glass.events.KeyEvent;

import Game.Entities.Statics.Door;
import Game.Entities.Statics.StaticEntity;
import Game.Items.Item;
import Main.Handler;
import Resources.Images;
import Worlds.BaseWorld;

public class Humanoid extends StaticEntity {
	private BaseWorld world;

	private int counter = 0;
	private boolean selected = false;
	private boolean alreadyTalked = false;
	private boolean levelComplete = false;
	private Door door;

	public Humanoid(Handler handler, float x, float y, BaseWorld world, Door door) {
		super(handler, x, y, 64, 64);
		this.door = door;
		door.setVisible(false);

		// TODO Auto-generated constructor stub

	}

	@Override
	public void tick() {

		if (health < 100)
			health = 100;

		// TODO Auto-generated method stub

	}

	@Override
	public void render(Graphics g) {

		// TODO Auto-generated method stub
		int imageX = (int) (x - handler.getGameCamera().getxOffset());
		int imageY = (int) (y - handler.getGameCamera().getyOffset());
		Rectangle playerRect = handler.getWorld().getEntityManager().getPlayer().getCollisionBounds(0, 0);

		if (getBoundsBot().intersects(playerRect)) {

			g.drawImage(Images.humanoid_front[0], imageX, imageY, 64, 84, null);

		} else if (getBoundsLeft().intersects(playerRect)) {

			g.drawImage(Images.humanoid_left[0], imageX, imageY - 20, 64, 84, null);
		} else if (getBoundsTop().intersects(playerRect)) {

			g.drawImage(Images.humanoid_back[0], imageX, imageY - 20, 64, 84, null);
		} else if (getBoundsRight().intersects(playerRect)) {

			g.drawImage(Images.humanoid_right[0], imageX, imageY - 20, 64, 84, null);
		} else {
			g.drawImage(Images.humanoid_front[0], imageX, imageY, 64, 84, null);
		}

		if (getBoundsRight().intersects(playerRect) || getBoundsLeft().intersects(playerRect)
				|| getBoundsTop().intersects(playerRect) || getBoundsBot().intersects(playerRect)) {
			if (!handler.getWorld().getEntityManager().getPlayer().getTalking() && !alreadyTalked) {
				g.drawImage(Images.exlcamationMark, imageX, imageY - 64, 64, 64, null);
			}

			if (handler.getKeyManager().keyJustPressed(KeyEvent.VK_E)) {
				selected = true;
				counter++;
			}
			if (!levelComplete) {

				if (selected) {

					if (!alreadyTalked) {
						handler.getWorld().getEntityManager().getPlayer().setTalking(true);

						if (counter <= Images.bubble.length) {
							g.drawImage(Images.bubble[counter - 1], imageX + 40, imageY - 140, null);

						} else {
							handler.getWorld().getEntityManager().getPlayer().setTalking(false);
							counter = 0;
							selected = false;
							alreadyTalked = true;
						}
					} else if (alreadyTalked) {

						if (handler.getWorld().getEntityManager().getPlayer().getInventory().getInventoryItems()
								.contains(Item.skullKey)) {

							if (counter < Images.bubble2.length) {
								g.drawImage(Images.bubble2[counter - 1], imageX + 40, imageY - 140, null);

								handler.getWorld().getEntityManager().getPlayer().setTalking(true);
							} else {
								handler.getWorld().getEntityManager().getPlayer().getInventory()
										.deleteItem(Item.skullKey);
								handler.getWorld().getEntityManager().getPlayer().setTalking(false);
								door.setVisible(true);
								selected = false;
								levelComplete = true;
							}

						} else {

							if (counter == 1) {
								g.drawImage(Images.bubble[3], imageX + 40, imageY - 140, null);
								handler.getWorld().getEntityManager().getPlayer().setTalking(true);

							} else {
								handler.getWorld().getEntityManager().getPlayer().setTalking(false);
								counter = 0;
								selected = false;
							}
						}

					}

				}
			} else {
				counter = 0;
			}
		}

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
