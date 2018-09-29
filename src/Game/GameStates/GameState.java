package Game.GameStates;

import Game.Entities.Creatures.Player;
import Main.Handler;
import Worlds.BaseWorld;
import Worlds.CaveWorld;
import Worlds.World1;

import java.awt.*;

/**
 * Created by Elemental on 12/10/2016.
 */
public class GameState extends State {

	public static BaseWorld caveWorld;
	public static BaseWorld world;

	public GameState(Handler handler) {
		super(handler);
		Player player = new Player(handler, 100, 100);
		world = new World1(handler, "res/Maps/map1.map", player);
		caveWorld = new CaveWorld(handler, "res/Maps/caveMap.map", player);
		handler.setWorld(world);
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
