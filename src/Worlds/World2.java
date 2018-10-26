package Worlds;

import java.util.Random;

import Game.Entities.EntityId;
import Game.Entities.Creatures.Boss;
import Game.Entities.Creatures.Companion;
import Game.Entities.Creatures.Player;
import Game.Entities.Creatures.SkelyEnemy;
import Main.Handler;

public class World2 extends BaseWorld {

	private Handler handler;
	private Random rand;

	public World2(Handler handler, String path, Player player, Companion companion) {
		super(handler, path, player, companion);
		
		
		
		entityManager.addEntity(new Boss(handler, 500, 500, EntityId.enemy));

	}

}
