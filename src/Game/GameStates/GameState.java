package Game.GameStates;

import Game.Entities.EntityId;
import Game.Entities.Creatures.Companion;
import Game.Entities.Creatures.Player;
import Main.Handler;
import Worlds.BaseWorld;
import Worlds.CaveWorld;
import Worlds.World1;
import Worlds.World2;

import java.awt.*;

/**
 * Created by Elemental on 12/10/2016.
 */
public class GameState extends State {

	public static BaseWorld world1;
	public static BaseWorld world2;
	public static BaseWorld caveWorld;

	public GameState(Handler handler) {
		super(handler);
		Player player = new Player(handler, 100, 100, EntityId.player);
		Companion companion = new Companion(handler, EntityId.companion);
		companion.setVisible(false);

		world1 = new World1(this.handler, "res/Maps/map1.map", player, companion);

		world2 = new World2(this.handler, "res/Maps/map2.map", player, companion);
		this.handler.setWorld(world2);
		this.handler.getWorld().getEntityManager().setPlayer(player);
		this.handler.getWorld().getEntityManager().setCompanion(companion);

	}

	@Override
	public void tick() {
		handler.getWorld().tick();

	}

	@Override
	public void render(Graphics g) {
		handler.getWorld().render(g);

	}

}
