package Game.Entities.Creatures;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

import Game.Entities.EntityBase;
import Game.Entities.EntityId;
import Game.Inventories.Inventory;
import Main.Handler;
import Resources.Animation;
import Resources.Images;

/**
 * Created by Elemental on 2/7/2017.
 */
public class Companion extends CreatureBase {
	private Animation animDown, animUp, animLeft, animRight;

	private int animWalkingSpeed = 150;
	private Inventory CompanionInventory;
	private Rectangle CompanionCam;
	private int healthcounter = 0;
	private Random randint;

	private int direction;
	private boolean enemyAttack;

	public Companion(Handler handler, EntityId id) {
		super(handler, 0, 0, CreatureBase.DEFAULT_CREATURE_WIDTH, CreatureBase.DEFAULT_CREATURE_HEIGHT, id);
		this.id = id;
		bounds.x = 8 * 2;
		bounds.y = 18 * 2;
		bounds.width = 16 * 2;
		bounds.height = 14 * 2;
		speed = 3;
		health = 50;
		CompanionCam = new Rectangle();
		randint = new Random();
		direction = randint.nextInt(4) + 1;
		animDown = new Animation(animWalkingSpeed, Images.Pika_front);
		animLeft = new Animation(animWalkingSpeed, Images.Pika_left);
		animRight = new Animation(animWalkingSpeed, Images.Pika_right);
		animUp = new Animation(animWalkingSpeed, Images.Pika_back);
		CompanionInventory = new Inventory(handler);

	}

	@Override
	public void tick() {

		if (visible) {
			animDown.tick();
			animUp.tick();
			animRight.tick();
			animLeft.tick();
			// moveCount ++;
			// if(moveCount>=60){
			// moveCount=0;
			// direction = randint.nextInt(4) + 1;
			// }ww
			checkIfMove();
			move();
			if (isBeinghurt()) {
				healthcounter++;
				if (healthcounter >= 120) {
					setBeinghurt(false);
					System.out.print(isBeinghurt());
				}
			}
			if (healthcounter >= 120 && !isBeinghurt()) {
				healthcounter = 0;
			}
			CompanionInventory.tick();
		}
		for (EntityBase i : handler.getWorld().getEntityManager().getEntities()) {

			if (i.getId() == EntityId.enemy || i.getId() == EntityId.trainer) {
				if ((Math.abs(i.getX() - this.getX()) < 100) && i.isActive()) {

					this.enemyAttack = true;
				} else {
					this.enemyAttack = false;
				}

			}

		}
	}

	private void checkIfMove() {
		xMove = 0;
		yMove = 0;
		CompanionCam.x = (int) (x - handler.getGameCamera().getxOffset() - (64 * 3));
		CompanionCam.y = (int) (y - handler.getGameCamera().getyOffset() - (64 * 3));
		CompanionCam.width = 64 * 7;
		CompanionCam.height = 64 * 7;

		// follow
		if (!enemyAttack) {
			if (CompanionCam.contains(
					handler.getWorld().getEntityManager().getPlayer().getX() - handler.getGameCamera().getxOffset(),
					handler.getWorld().getEntityManager().getPlayer().getY() - handler.getGameCamera().getyOffset())
					|| CompanionCam.contains(
							handler.getWorld().getEntityManager().getPlayer().getX() + 2
									- handler.getGameCamera().getxOffset()
									+ handler.getWorld().getEntityManager().getPlayer().getWidth(),
							handler.getWorld().getEntityManager().getPlayer().getY() + 2
									- handler.getGameCamera().getyOffset()
									+ handler.getWorld().getEntityManager().getPlayer().getHeight())) {
				Rectangle cb = getCollisionBounds(0, 0);
				Rectangle ar = new Rectangle();
				int arSize = 40;
				ar.width = arSize;
				ar.height = arSize;
				if (lu) {
					ar.x = cb.x + cb.width / 2 - arSize / 2;
					ar.y = cb.y - arSize;
				} else if (ld) {
					ar.x = cb.x + cb.width / 2 - arSize / 2;
					ar.y = cb.y + cb.height;
				} else if (ll) {
					ar.x = cb.x - arSize;
					ar.y = cb.y + cb.height / 2 - arSize / 2;
				} else if (lr) {
					ar.x = cb.x + cb.width;
					ar.y = cb.y + cb.height / 2 - arSize / 2;
				}
				// !!

				for (EntityBase e : handler.getWorld().getEntityManager().getEntities()) {
					if (e.equals(this))
						continue;
					if (e.getCollisionBounds(0, 0).intersects(ar)
							&& e.equals(handler.getWorld().getEntityManager().getPlayer())) {

						return;
					}
				}
				if (x >= handler.getWorld().getEntityManager().getPlayer().getX() - 8
						&& x <= handler.getWorld().getEntityManager().getPlayer().getX() + 8) {// nada
					xMove = 0;

				} else if (x < handler.getWorld().getEntityManager().getPlayer().getX()) {// move right
					xMove = speed;
				} else if (x > handler.getWorld().getEntityManager().getPlayer().getX()) {// move left
					xMove = -speed;

				}
				if (y >= handler.getWorld().getEntityManager().getPlayer().getY() - 8
						&& y <= handler.getWorld().getEntityManager().getPlayer().getY() + 8) {// nada
					yMove = 0;

				} else if (y < handler.getWorld().getEntityManager().getPlayer().getY()) {// move down
					yMove = speed;
				} else if (y > handler.getWorld().getEntityManager().getPlayer().getY()) {// move up
					yMove = -speed;
				}
			} else {
				switch (direction) {
				case 1:// up
					yMove = -speed;
					break;
				case 2:// down
					yMove = speed;
					break;
				case 3:// left
					xMove = -speed;
					break;
				case 4:// right
					xMove = speed;
					break;
				}
			}
		}
		if (enemyAttack) {

			for (EntityBase i : handler.getWorld().getEntityManager().getEntities()) {

				if (i.getId() == EntityId.enemy || i.getId() == EntityId.trainer) {
					if (CompanionCam.contains(i.getX() - handler.getGameCamera().getxOffset(),
							i.getY() - handler.getGameCamera().getyOffset())
							|| CompanionCam.contains(i.getX() - handler.getGameCamera().getxOffset() + i.getWidth(),
									handler.getWorld().getEntityManager().getPlayer().getY()
											- handler.getGameCamera().getyOffset() + i.getHeight())) {

						Rectangle cb = getCollisionBounds(0, 0);
						Rectangle ar = new Rectangle();
						int arSize = 13;
						ar.width = arSize;
						ar.height = arSize;

						if (lu) {
							ar.x = cb.x + cb.width / 2 - arSize / 2;
							ar.y = cb.y - arSize;
						} else if (ld) {
							ar.x = cb.x + cb.width / 2 - arSize / 2;
							ar.y = cb.y + cb.height;
						} else if (ll) {
							ar.x = cb.x - arSize;
							ar.y = cb.y + cb.height / 2 - arSize / 2;
						} else if (lr) {
							ar.x = cb.x + cb.width;
							ar.y = cb.y + cb.height / 2 - arSize / 2;
						}

						for (EntityBase e : handler.getWorld().getEntityManager().getEntities()) {
							if (e.equals(this))
								continue;
							if (e.getCollisionBounds(0, 0).intersects(ar) && e.equals(i)) {

								checkAttacks();
								return;
							}
						}

						if (x >= i.getX() - 8 && x <= i.getX() + 8) {// nada

							xMove = 0;
						} else if (x < i.getX()) {// move right

							xMove = speed;

						} else if (x > i.getX()) {// move left

							xMove = -speed;
						}

						if (y >= i.getY() - 8 && y <= i.getY() + 8) {// nada
							yMove = 0;
						} else if (y < i.getY()) {// move down
							yMove = speed;

						} else if (y > i.getY()) {// move up
							yMove = -speed;
						}

					} else {

						switch (direction) {
						case 1:// up
							yMove = -speed;
							break;
						case 2:// down
							yMove = speed;
							break;
						case 3:// left
							xMove = -speed;
							break;
						case 4:// right
							xMove = speed;
							break;

						}
					}

				}
			}

		}

	}

	@Override
	public void render(Graphics g) {
		if (visible) {
			g.drawImage(
					getCurrentAnimationFrame(animDown, animUp, animLeft, animRight, Images.Pika_front, Images.Pika_back,
							Images.Pika_left, Images.Pika_right),
					(int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()),
					width, height, null);
			if (isBeinghurt() && healthcounter <= 120) {
				g.setColor(Color.white);
				g.drawString("Companion Health: " + getHealth(), (int) (x - handler.getGameCamera().getxOffset()),
						(int) (y - handler.getGameCamera().getyOffset() - 20));
			}
		}
	}

	@Override
	public void die() {

		this.setVisible(false);
		this.setHealth(40);

	}
}