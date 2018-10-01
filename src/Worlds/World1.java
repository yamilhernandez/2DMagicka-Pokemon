package Worlds;

import java.util.Random;

import Game.Entities.Creatures.Player;
import Game.Entities.Creatures.SkelyEnemy;
import Game.Entities.Statics.Door;
import Game.Entities.Statics.Rock;
import Game.Entities.Statics.Tree;
import Game.GameStates.GameState;
import Game.Items.Item;
import Main.Handler;

/**
 * Created by Elemental on 1/2/2017.
 */
public class World1 extends BaseWorld {

	private Handler handler;
	private Random rand;

//    private BaseWorld caveWorld;

	public World1(Handler handler, String path, Player player) {
		super(handler, path, player);
		this.handler = handler;

//        caveWorld = new CaveWorld(handler,"res/Maps/caveMap.map",player);
		rand = new Random();
		entityManager.addEntity(new Tree(handler, 100, 250));
		entityManager.addEntity(new Rock(handler, 100, 450));
		entityManager.addEntity(new Tree(handler, 533, 276));
		entityManager.addEntity(new Rock(handler, 684, 1370));
		entityManager.addEntity(new Tree(handler, 765, 888));
		entityManager.addEntity(new Rock(handler, 88, 1345));
		entityManager.addEntity(new Tree(handler, 77, 700));
		entityManager.addEntity(new Rock(handler, 700, 83));
		entityManager.addEntity(new Door(handler, 100, 0, GameState.caveWorld));
		entityManager.addEntity(new SkelyEnemy(handler, 1250, 500));

		entityManager.getPlayer().setX(spawnX);
		entityManager.getPlayer().setY(spawnY);

		itemManager.addItem(Item.goldCoin.createNew(rand.nextInt(this.getWidth() * 64 - 64),
				rand.nextInt(this.getHeight() * 64 - 64), 1));

	}

}