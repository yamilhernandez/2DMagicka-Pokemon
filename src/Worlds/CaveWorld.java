package Worlds;

import Game.Entities.EntityId;
import Game.Entities.Creatures.Companion;
import Game.Entities.Creatures.Humanoid2;
import Game.Entities.Creatures.Player;
import Game.Entities.Creatures.SkelyEnemy;
import Game.Entities.Creatures.TrainerEnemy;
import Game.Entities.Statics.Chest;
import Game.Items.Item;
import Main.Handler;

/**
 * Created by Elemental on 2/10/2017.
 */
public class CaveWorld extends BaseWorld {

	public CaveWorld(Handler handler, String path, Player player, Companion companion) {
		super(handler, path, player, companion);

		entityManager.addEntity(new TrainerEnemy(handler, 1250, 500, EntityId.trainer));
		entityManager.addEntity(new Humanoid2(handler, EntityId.humanoid));
		entityManager.addEntity(new Chest(handler, 1050, 900, EntityId.chest));
		entityManager.addEntity(new Chest(handler, 700, 700, EntityId.chest));
		entityManager.getPlayer().setX(spawnX);
		entityManager.getPlayer().setY(spawnY);
		itemManager.addItem(Item.goldCoin.createNew(1000, 700, 1));
		itemManager.addItem(Item.dmgPotion.createNew(600, 890, 1));
	}

}