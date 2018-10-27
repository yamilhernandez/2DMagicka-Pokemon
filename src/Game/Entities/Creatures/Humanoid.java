package Game.Entities.Creatures;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import com.sun.glass.events.KeyEvent;

import Game.Entities.EntityId;
import Game.Entities.Statics.Door;
import Game.Entities.Statics.StaticEntity;
import Game.Items.Item;
import Main.Handler;
import Resources.Images;
import Worlds.BaseWorld;

public class Humanoid extends StaticEntity {
	

	private int counter = 0;
	private boolean selected = false;
	private boolean alreadyTalked = false;
	private boolean levelComplete = false;
	private boolean missionStarted = false, firstObejctive = false, secondObjective = false;

	private Door door;

	public Humanoid(Handler handler, float x, float y, BaseWorld world, Door door, EntityId id) {
		super(handler, x, y, 64, 64, id);
		this.id = id;
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

	public void render(Graphics g) {

		if (missionStarted && !levelComplete) {

			int playerX = (int) (handler.getWorld().getEntityManager().getPlayer().getX()
					- handler.getGameCamera().getxOffset());
			int playerY = (int) (handler.getWorld().getEntityManager().getPlayer().getY()
					- handler.getGameCamera().getyOffset());

			for (Item i : handler.getWorld().getEntityManager().getPlayer().getInventory().getInventoryItems()) {
				g.setColor(Color.yellow);
				if (i.getId() == Item.goldCoin.getId()) {

					String c = "";

					if (i.getCount() < 3) {
						c = "COINS: " + i.getCount();

					} else {
						c = "COINS:COMPLETE";
						this.firstObejctive = true;

					}

					g.drawString(c, playerX, playerY - 30);

				}
				if (i.getId() == Item.skullKey.getId()) {
					String c = "";
					if (i.getCount() < 1) {

						c = "SKULL-KEY: " + i.getCount();

					} else {
						c = "SKULL-KEY:COMPLETE";
						this.secondObjective = true;

					}
					g.drawString(c, playerX, playerY - 60);

				}
			}

		}

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
							missionStarted = true;
						}
					} else if (alreadyTalked) {

						if (this.firstObejctive && this.secondObjective) {

							if (counter < Images.bubble2.length) {
								g.drawImage(Images.bubble2[counter - 1], imageX + 40, imageY - 140, null);

								handler.getWorld().getEntityManager().getPlayer().setTalking(true);
							} else {
								handler.getWorld().getEntityManager().getPlayer().getInventory()
										.deleteItem(Item.skullKey);
								for (int i = 0; i < 3; i++)
									handler.getWorld().getEntityManager().getPlayer().getInventory()
											.addItem(Item.dmgPotion);

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
