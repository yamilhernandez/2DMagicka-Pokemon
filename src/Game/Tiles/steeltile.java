package Game.Tiles;

import Resources.Images;

public class steeltile extends Tile {

	public steeltile(int id) {
		super(Images.steeltile, id);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isSolid() {
		return true;
	}

}
