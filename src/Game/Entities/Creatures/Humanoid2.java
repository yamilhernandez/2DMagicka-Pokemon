package Game.Entities.Creatures;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.sun.glass.events.KeyEvent;

import Game.Entities.EntityId;
import Game.Entities.Statics.StaticEntity;
import Game.GameStates.GameState;
import Game.Items.Item;
import Main.Handler;
import Resources.Images;

public class Humanoid2 extends StaticEntity {

	private int counter = 0;
	private boolean selected = false;

	public Humanoid2(Handler handler, EntityId id) {
		super(handler, 0, 0, 64, 64, id);

		this.setVisible(false);

	}

	@Override
	public void tick() {

		if (visible) {

			if (health < 100) {
				health = 100;
			}
		}
	}
	// TODO Auto-generated method stub

	@Override
	public void render(Graphics g) {

		if (visible) {

			Player player = handler.getWorld().getEntityManager().getPlayer();
			int imageX = (int) (x - handler.getGameCamera().getxOffset());
			int imageY = (int) (y - handler.getGameCamera().getyOffset());

			g.drawImage(Images.prof_right[0], imageX, imageY - 20, 64, 84, null);

			selected = true;

			player.setTalking(true);
			if (handler.getKeyManager().keyJustPressed(KeyEvent.VK_E)) {
				counter++;
			}

			if (counter == 0) {

				g.drawImage(Images.bubble3[0], imageX + 40, imageY - 140, null);

			} else if (counter == 1) {
				g.drawImage(Images.bubble3[1], imageX + 40, imageY - 140, null);

			}

			else if (counter == 2) {
				if (!handler.getWorld().getEntityManager().getCompanion().isVisible()) {
					handler.getWorld().getEntityManager().getPlayer().getInventory().addItem(Item.pokeBall);
				}
				Player p = handler.getWorld().getEntityManager().getPlayer();
				Companion c = handler.getWorld().getEntityManager().getCompanion();

				p.setX(100);
				p.setY(100);
				c.setX(p.getX() + 32);
				c.setY(p.getY() + 32);
				player.setTalking(false);
				counter = 0;
				selected = false;

				handler.setWorld(GameState.world2);
				this.setActive(false);

			}

		}

	}

	// TODO Auto-generated method stub

	@Override
	public void die() {
		// TODO Auto-generated method stub

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

}