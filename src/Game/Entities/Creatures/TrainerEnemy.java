
package Game.Entities.Creatures;

import Game.Entities.DisplayInfo;
import Game.Entities.EntityBase;
import Game.Entities.EntityId;
import Game.Inventories.Inventory;
import Game.Items.Item;
import Main.Handler;
import Resources.Animation;
import Resources.Images;

import java.awt.*;
import java.util.Random;

import com.sun.glass.events.KeyEvent;

/**
 * Created by Elemental on 2/7/2017.
 */
public class TrainerEnemy extends CreatureBase {

	private Animation animDown, animUp, animLeft, animRight;

	private Boolean attacking = false;

	private int animWalkingSpeed = 150;
	private Inventory Trainerinventory;
	private Rectangle TrainerCam;

	private int healthcounter = 0;

	private Random randint;
	private int moveCount = 0;
	private int direction;
	private DisplayInfo di;

	public TrainerEnemy(Handler handler, float x, float y, EntityId id) {
		super(handler, x, y, CreatureBase.DEFAULT_CREATURE_WIDTH, CreatureBase.DEFAULT_CREATURE_HEIGHT, id);
		this.id = id;
		bounds.x = 8 * 2;
		bounds.y = 18 * 2;
		bounds.width = 16 * 2;
		bounds.height = 14 * 2;
		speed = 1.5f;
		health = 10;

		TrainerCam = new Rectangle();

		randint = new Random();
		direction = randint.nextInt(4) + 1;

		animDown = new Animation(animWalkingSpeed, Images.Trainer_front);
		animLeft = new Animation(animWalkingSpeed, Images.Trainer_left);
		animRight = new Animation(animWalkingSpeed, Images.Trainer_right);
		animUp = new Animation(animWalkingSpeed, Images.Trainer_back);

		Trainerinventory = new Inventory(handler);
		di = new DisplayInfo(this, handler);

	}

	@Override
	public void tick() {

		animDown.tick();
		animUp.tick();
		animRight.tick();
		animLeft.tick();

		moveCount++;
		if (moveCount >= 60) {
			moveCount = 0;
			direction = randint.nextInt(4) + 1;
		}
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

		Trainerinventory.tick();
	}

	private void checkIfMove() {
		for (EntityBase p : handler.getWorld().getEntityManager().getEntities()) {
			if (p.getId() == EntityId.player || (p.getId() == EntityId.companion && p.isVisible())) {
				xMove = 0;
				yMove = 0;

				TrainerCam.x = (int) (x - handler.getGameCamera().getxOffset() - (64 * 3));
				TrainerCam.y = (int) (y - handler.getGameCamera().getyOffset() - (64 * 3));
				TrainerCam.width = 64 * 7;
				TrainerCam.height = 64 * 7;

				if (TrainerCam.contains(p.getX() - handler.getGameCamera().getxOffset(),
						p.getY() - handler.getGameCamera().getyOffset())
						|| TrainerCam.contains(p.getX() - handler.getGameCamera().getxOffset() + p.getWidth(),
								p.getY() - handler.getGameCamera().getyOffset() + p.getHeight())) {

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
						if (e.getCollisionBounds(0, 0).intersects(ar) && e.equals(p)) {

							checkAttacks();
							return;
						}
					}

					if (x >= p.getX() - 8 && x <= p.getX() + 8) {// nada

						xMove = 0;
					} else if (x < p.getX()) {// move right

						xMove = speed;

					} else if (x > p.getX()) {// move left

						xMove = -speed;
					}

					if (y >= p.getY() - 8 && y <= p.getY() + 8) {// nada
						yMove = 0;
					} else if (y < p.getY()) {// move down
						yMove = speed;

					} else if (y > p.getY()) {// move up
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

	@Override
	public void render(Graphics g) {
		di.render(g, (int) x, (int) y);

		g.drawImage(
				getCurrentAnimationFrame(animDown, animUp, animLeft, animRight, Images.Trainer_front,
						Images.Trainer_back, Images.Trainer_left, Images.Trainer_right),
				(int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()),
				width + 20, height + 20, null);

	}

	@Override
	public void die() {
		for (EntityBase b : handler.getWorld().getEntityManager().getEntities()) {

			if (b.getId() == EntityId.humanoid) {
				b.setVisible(true);
				b.setY(handler.getWorld().getEntityManager().getPlayer().getY());
				b.setX(handler.getWorld().getEntityManager().getPlayer().getX() - 70);

			}

		}

	}
}
