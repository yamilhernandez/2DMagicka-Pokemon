package Worlds;

import java.util.Random;

import Game.Entities.Creatures.Companion;
import Game.Entities.Creatures.Player;
import Main.Handler;

public class World2 extends BaseWorld {

	private Handler handler;
	private Random rand;

	public World2(Handler handler, String path, Player player, Companion companion) {
		super(handler, path, player, companion);

	}

}
