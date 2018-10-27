package Main;

import java.util.ArrayList;

import Inputs.KeyManager;
import Resources.GameCamera;
import Inputs.MouseManager;
import Worlds.BaseWorld;

/**
 * Created by Elemental on 1/1/2017.
 */
public class Handler {

	private Game game;
	private BaseWorld world;
	private ArrayList<BaseWorld> cWorld = new ArrayList<BaseWorld>();

	public Handler(Game game) {
		this.game = game;
	}

	public void addWorld(BaseWorld i) {
		cWorld.add(i);

	}

	public GameCamera getGameCamera() {
		return game.getGameCamera();
	}

	public ArrayList<BaseWorld> getcWorld() {
		return cWorld;
	}

	public KeyManager getKeyManager() {
		return game.getKeyManager();
	}

	public MouseManager getMouseManager() {
		return game.getMouseManager();
	}

	public int getWidth() {
		return game.getWidth();
	}

	public int getHeight() {
		return game.getHeight();
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public BaseWorld getWorld() {
		return world;
	}

	public void setWorld(BaseWorld world) {
		this.world = world;
	}

}
