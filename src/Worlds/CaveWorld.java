package Worlds;

import Game.Entities.EntityId;
import Game.Entities.Creatures.Player;
import Game.Entities.Creatures.TrainerEnemy;
import Game.Entities.Statics.Tree;
import Main.Handler;

/**
 * Created by Elemental on 2/10/2017.
 */
public class CaveWorld extends BaseWorld {
	private Handler handler;
	private Player player;

	public CaveWorld(Handler handler, String path, Player player) {
		super(handler, path, player);
		this.handler = handler;
		this.player = player;

		entityManager.addEntity(new TrainerEnemy(handler, 1250, 500, EntityId.enemy));

	}

}