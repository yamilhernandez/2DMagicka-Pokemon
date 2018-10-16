package Game.Entities.Statics;

import Resources.Images;
import Main.Handler;

import java.awt.*;

import Game.Entities.EntityId;

/**
 * Created by Elemental on 1/2/2017.
 */
public class SmokeParticle extends StaticEntity {

	public SmokeParticle(Handler handler, float x, float y, EntityId id) {
		super(handler, x, y, 22, 22, id);
		this.id = id;
		health = 100;
	}

	@Override
	public void tick() {
		System.out.println(getHealth());
		health--;
		if (health <= 0) {
			die();
		}
	}

	@Override
	public void render(Graphics g) {

		g.drawImage(Images.particleSmoke[0], (int) (x - handler.getGameCamera().getxOffset()),
				(int) (y - handler.getGameCamera().getyOffset()), width, height, null);

	}

	@Override
	public void die() {
		this.setActive(false);
	}

}
