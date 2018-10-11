package Game.GameStates;

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

	public GameState(Handler handler) {
		super(handler);
		Player player = new Player(handler, 100, 100);
		world1 = new World1(handler, "res/Maps/map1.map", player);

		world2 = new World2(handler, "res/Maps/map2.map", player);
		handler.setWorld(world2);
		handler.getWorld().getEntityManager().setPlayer(player);
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
