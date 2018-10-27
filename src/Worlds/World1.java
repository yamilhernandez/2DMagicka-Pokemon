package Worlds;

import java.util.Random;

import Game.Entities.EntityId;
import Game.Entities.Creatures.Companion;
import Game.Entities.Creatures.Humanoid;
import Game.Entities.Creatures.Player;
import Game.Entities.Creatures.SkelyEnemy;
import Game.Entities.Statics.Chest;
import Game.Entities.Statics.Door;
import Game.Entities.Statics.Rock;
import Game.Entities.Statics.Tree;
import Game.Items.Item;
import Main.Handler;

/**
 * Created by Elemental on 1/2/2017.
 */
public class World1 extends BaseWorld {

	public static BaseWorld caveWorld;

	private Random rand;
	private Door door;

	// private BaseWorld caveWorld;

	public World1(Handler handler, String path, Player player, Companion companion) {
		super(handler, path, player, companion);

		caveWorld = new CaveWorld(handler, "res/Maps/caveMap.map", player, companion);
		handler.addWorld(this.caveWorld);
		rand = new Random();

		entityManager.addEntity(new Tree(handler, 100, 250, EntityId.tree));
		entityManager.addEntity(new Rock(handler, 100, 450, EntityId.rock));
		entityManager.addEntity(new Tree(handler, 533, 276, EntityId.tree));
		entityManager.addEntity(new Rock(handler, 684, 1370, EntityId.rock));
		entityManager.addEntity(new Tree(handler, 765, 888, EntityId.tree));
		entityManager.addEntity(new Rock(handler, 88, 1345, EntityId.rock));
		entityManager.addEntity(new Tree(handler, 77, 700, EntityId.tree));
		entityManager.addEntity(new Rock(handler, 700, 83, EntityId.rock));

		entityManager.addEntity(door = new Door(handler, 100, 0, caveWorld, EntityId.door));
		entityManager.addEntity(new Humanoid(handler, 256, 256, caveWorld, door, EntityId.humanoid));
		entityManager.addEntity(new SkelyEnemy(handler, 1250, 500, EntityId.enemy));
		entityManager.addEntity(new Chest(handler, 600, 1000, EntityId.chest));
		entityManager.addEntity(new Chest(handler, 300, 700, EntityId.chest));
		entityManager.getPlayer().setX(spawnX);
		entityManager.getPlayer().setY(spawnY);
		itemManager.addItem(Item.goldCoin.createNew(300, 400, 1));
		itemManager.addItem(Item.dmgPotion.createNew(600, 235, 1));

	}

}