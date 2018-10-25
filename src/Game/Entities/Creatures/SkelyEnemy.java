package Game.Entities.Creatures;

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
public class SkelyEnemy extends CreatureBase {

	private Animation animDown, animUp, animLeft, animRight;

	private Boolean attacking = false;

	private int animWalkingSpeed = 150;
	private Inventory Skelyinventory;
	private Rectangle SkelyCam;

	private int healthcounter = 0;

	private Random randint;
	private int moveCount = 0;
	private int direction;

	public SkelyEnemy(Handler handler, float x, float y, EntityId id) {
		super(handler, x, y, CreatureBase.DEFAULT_CREATURE_WIDTH, CreatureBase.DEFAULT_CREATURE_HEIGHT, id);
		this.id = id;
		bounds.x = 8 * 2;
		bounds.y = 18 * 2;
		bounds.width = 16 * 2;
		bounds.height = 14 * 2;
		speed = 1.5f;
		health = 50;

		SkelyCam = new Rectangle();

		randint = new Random();
		direction = randint.nextInt(4) + 1;

		animDown = new Animation(animWalkingSpeed, Images.SkelyEnemy_front);
		animLeft = new Animation(animWalkingSpeed, Images.SkelyEnemy_left);
		animRight = new Animation(animWalkingSpeed, Images.SkelyEnemy_right);
		animUp = new Animation(animWalkingSpeed, Images.SkelyEnemy_back);

		Skelyinventory = new Inventory(handler);

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

		Skelyinventory.tick();

	}

	private void checkIfMove() {

		for (EntityBase p : handler.getWorld().getEntityManager().getEntities()) {
			if (p.getId() == EntityId.player ||( p.getId() == EntityId.companion&&p.isVisible())) {
				xMove = 0;
				yMove = 0;

				SkelyCam.x = (int) (x - handler.getGameCamera().getxOffset() - (64 * 3));
				SkelyCam.y = (int) (y - handler.getGameCamera().getyOffset() - (64 * 3));
				SkelyCam.width = 64 * 7;
				SkelyCam.height = 64 * 7;

				if (SkelyCam.contains(p.getX() - handler.getGameCamera().getxOffset(),
						p.getY() - handler.getGameCamera().getyOffset())
						|| SkelyCam.contains(p.getX() - handler.getGameCamera().getxOffset() + p.getWidth(),
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
		g.drawImage(
				getCurrentAnimationFrame(animDown, animUp, animLeft, animRight, Images.SkelyEnemy_front,
						Images.SkelyEnemy_back, Images.SkelyEnemy_left, Images.SkelyEnemy_right),
				(int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()),
				width, height, null);
		if (isBeinghurt() && healthcounter <= 120) {
			g.setColor(Color.white);
			g.drawString("SkelyHealth: " + getHealth(), (int) (x - handler.getGameCamera().getxOffset()),
					(int) (y - handler.getGameCamera().getyOffset() - 20));
		}
	}

	@Override
	public void die() {
		handler.getWorld().getItemManager().addItem(Item.skullKey.createNew((int) x + bounds.x, (int) y + bounds.y, 1));
		this.setActive(false);

	}
}
