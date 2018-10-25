package Worlds;

import Game.Entities.EntityId;
import Game.Entities.Creatures.Companion;
import Game.Entities.Creatures.Player;
import Game.Entities.Creatures.TrainerEnemy;
import Main.Handler;

/**
 * Created by Elemental on 2/10/2017.
 */
public class CaveWorld extends BaseWorld {

	public CaveWorld(Handler handler, String path, Player player, Companion companion) {
		super(handler, path, player, companion);

		entityManager.addEntity(new TrainerEnemy(handler, 1250, 500, EntityId.enemy));

	}

}