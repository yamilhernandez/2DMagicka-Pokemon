package Game.Entities.Statics;

import Game.Entities.EntityId;
import Game.Items.Item;
import Game.Tiles.Tile;
import Resources.Images;
import Main.Handler;

import javax.sound.sampled.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Random;

/**
 * Created by Elemental on 1/1/2017.
 */
public class Chest extends StaticEntity {
	private File audioFile;
	private AudioInputStream audioStream;
	private AudioFormat format;
	private DataLine.Info info;
	private Clip audioClip;
	private Random rand = new Random();

	public Chest(Handler handler, float x, float y, EntityId id) {
		super(handler, x, y, Tile.TILEHEIGHT * 2, Tile.TILEWIDTH, id);
		this.id = id;
		bounds.x = -50;
		bounds.y = -30;
		bounds.width = 70;
		bounds.height = 70;
		health = 2;

		try {
			audioFile = new File("res/music/chestSound.wav");
			audioStream = AudioSystem.getAudioInputStream(audioFile);
			format = audioStream.getFormat();
			info = new DataLine.Info(Clip.class, format);
			audioClip = (Clip) AudioSystem.getLine(info);
			audioClip.open(audioStream);
			audioClip.setMicrosecondPosition(2000);

		} catch (UnsupportedAudioFileException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void tick() {
		if (isBeinghurt()) {
			audioClip.start();
		}
//        if(!isBeinghurt() && !handler.getKeyManager().attbut){
//            audioClip.stop();
//        }
//        if(!isActive()){
//            audioClip.stop();
//
//        }

	}

	@Override
	public void render(Graphics g) {
		renderLife(g);
		g.drawImage(Images.chest, (int) (x - handler.getGameCamera().getxOffset()) - 64,
				(int) (y - handler.getGameCamera().getyOffset()) - 64, 90, 90, null);

	}

	@Override
	public void die() {
		handler.getWorld().getItemManager()
				.addItem(Item.goldCoin.createNew((int) x + bounds.x, (int) y + bounds.y, rand.nextInt(5)));

	}

	public void renderLife(Graphics g) {
		if (beinghurt && count <= 8) {
			if (count == 1) {
				count = 0;
				beinghurt = false;
			}

			g.drawImage(Images.numbers[getHealth()], (int) (x - handler.getGameCamera().getxOffset() + bounds.x),
					(int) (y - handler.getGameCamera().getyOffset() - getHeight() + (bounds.height + 32)), width,
					height, null);
			count++;

		}
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

}
