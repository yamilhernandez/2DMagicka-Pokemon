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

/**
 * Created by Elemental on 2/7/2017.
 */
public class Boss extends CreatureBase {

	private Animation animDown, animUp, animLeft, animRight;

	private Boolean attacking = false;

	private int animWalkingSpeed = 300;
	private Inventory Bossinventory;
	private Rectangle BossCam;

	private int healthcounter = 0;

	private Random randint;
	private int moveCount = 0;
	private int direction;
	private DisplayInfo di;

	public Boss(Handler handler, float x, float y, EntityId id) {
		super(handler, x, y, CreatureBase.DEFAULT_BOSS_WIDTH, CreatureBase.DEFAULT_BOSS_HEIGHT, id);
		this.id = id;
		bounds.x = 8 * 2;
		bounds.y = 18 * 2;
		bounds.width = 250;
		bounds.height = 250;
		speed = 1;
		health = 200;

		BossCam = new Rectangle();

		randint = new Random();
		direction = randint.nextInt(4) + 1;

		animDown = new Animation(animWalkingSpeed, Images.boss_front);
		animLeft = new Animation(animWalkingSpeed, Images.boss_left);
		animRight = new Animation(animWalkingSpeed, Images.boss_right);
		animUp = new Animation(animWalkingSpeed, Images.boss_back);

		Bossinventory = new Inventory(handler);
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

		Bossinventory.tick();

	}

	private void checkIfMove() {

		for (EntityBase p : handler.getWorld().getEntityManager().getEntities()) {
			if (p.getId() == EntityId.player || (p.getId() == EntityId.companion)) {
				xMove = 0;
				yMove = 0;

				BossCam.x = (int) (x - handler.getGameCamera().getxOffset() - (300 * 3));
				BossCam.y = (int) (y - handler.getGameCamera().getyOffset() - (300 * 3));
				BossCam.width = 300 * 7;
				BossCam.height = 300 * 7;

				if (BossCam.contains(p.getX() - handler.getGameCamera().getxOffset(),
						p.getY() - handler.getGameCamera().getyOffset())
						|| BossCam.contains(p.getX() - handler.getGameCamera().getxOffset() + p.getWidth(),
								p.getY() - handler.getGameCamera().getyOffset() + p.getHeight())) {

					Rectangle cb = getCollisionBounds(0, 0);
					Rectangle ar = new Rectangle();
					int arSize = 10;
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
				getCurrentAnimationFrame(animDown, animUp, animLeft, animRight, Images.boss_front, Images.boss_back,
						Images.boss_left, Images.boss_right),
				(int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()),
				width, height, null);
		if (isBeinghurt() && healthcounter <= 120) {
			g.setColor(Color.white);
			g.drawString("Boss Health: " + getHealth(), (int) (x - handler.getGameCamera().getxOffset()),
					(int) (y - handler.getGameCamera().getyOffset() - 20));
		}
	}

	@Override
	public void die() {
		this.setActive(false);

	}
}
