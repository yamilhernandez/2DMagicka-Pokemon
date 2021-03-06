package Resources;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created by Elemental on 12/19/2016.
 */
public class Images {

	private static final int width = 32, height = 32;
	private static final int Bwidth = 64, Bheight = 64;
	private static final int Rwidth = 56, Rheight = 93;
	private static final int Fwidth = 512, Fheight = 197;
	private static final int Pwidth = 33, Pheight = 37;
	private static final int Twidth = 50, Theight = 59;
	private static final int Awidth = 16, Aheight = 19;
	private static final int Hwidth= 17, Hheight =20;

	public static BufferedImage[] blocks;
	public static BufferedImage[] player_right;
	public static BufferedImage[] player_left;
	public static BufferedImage[] player_front;
	public static BufferedImage[] player_back;
	public static BufferedImage[] humanoid_front;
	public static BufferedImage[] humanoid_back;
	public static BufferedImage[] humanoid_left;
	public static BufferedImage[] humanoid_right;
	public static BufferedImage[] SkelyEnemy_right;
	public static BufferedImage[] SkelyEnemy_left;
	public static BufferedImage[] SkelyEnemy_front;
	public static BufferedImage[] SkelyEnemy_back;
	public static BufferedImage[] Pika_right;
	public static BufferedImage[] Pika_left;
	public static BufferedImage[] Pika_front;
	public static BufferedImage[] Pika_back;
	public static BufferedImage[] Trainer_right;
	public static BufferedImage[] Trainer_left;
	public static BufferedImage[] Trainer_front;
	public static BufferedImage[] Trainer_back;

	public static BufferedImage[] butretry;

	public static BufferedImage[] boss_right;
	public static BufferedImage[] boss_left;
	public static BufferedImage[] boss_front;
	public static BufferedImage[] boss_back;
	public static BufferedImage[] ash_right;
	public static BufferedImage[] ash_left;
	public static BufferedImage[] ash_front;
	public static BufferedImage[] ash_back;
	public static BufferedImage[] butstart;
	
	public static BufferedImage[] prof_right;
	public static BufferedImage[] prof_left;
	public static BufferedImage[] prof_front;
	public static BufferedImage[] prof_back;

	public static BufferedImage[] particleSmoke;
	public static BufferedImage[] items;
	public static BufferedImage[] numbers;
	public static BufferedImage inventory;
	public static BufferedImage title;
	public static BufferedImage door;
	public static BufferedImage gold;
	public static BufferedImage pokeBall;
	public static BufferedImage E;
	public static BufferedImage EP;
	public static BufferedImage Pause;
	public static BufferedImage winState;
	public static BufferedImage[] Resume;
	public static BufferedImage[] BTitle;
	public static BufferedImage[] Options;
	public static BufferedImage[] Runes;
	public static ImageIcon icon;
	public static BufferedImage[] FireBallLeft;
	public static BufferedImage[] FireBallRight;
	public static BufferedImage[] FireBallUp;
	public static BufferedImage[] FireBallDown;
	public static BufferedImage loading;
	public static BufferedImage spellGUI;
	public static BufferedImage key;
	public static BufferedImage chest;
	public static BufferedImage chest2;
	public static BufferedImage exlcamationMark;
	public static BufferedImage dmgPotion;
	public static BufferedImage[] bubble;
	public static BufferedImage[] bubble2;
	public static BufferedImage[] bubble3;
	 public static BufferedImage[] butback;
	 public static BufferedImage gameOver;
	 

	public static BufferedImage poketile;
	public static BufferedImage steeltile;

	public Images() {

		SpriteSheet newsheet = new SpriteSheet(Images.loadImage("/Sheets/SpriteSheet.png"));
		SpriteSheet numsheet = new SpriteSheet(Images.loadImage("/Sheets/numsheet.png"));
		SpriteSheet runesheet = new SpriteSheet(Images.loadImage("/Sheets/runes.png"));
		SpriteSheet FireBallsheet = new SpriteSheet(Images.loadImage("/Sheets/FireBall.png"));
		SpriteSheet FireBallRightsheet = new SpriteSheet(Images.loadImage("/Sheets/FireBallRight.png"));
		SpriteSheet FireBallUpsheet = new SpriteSheet(Images.loadImage("/Sheets/FireBallUp.png"));
		SpriteSheet FireBallDownsheet = new SpriteSheet(Images.loadImage("/Sheets/FireBallDown.png"));
		SpriteSheet humanoidSheet = new SpriteSheet(Images.loadImage("/Sheets/humanoid.png"));
		SpriteSheet Bubble_sheet = new SpriteSheet(Images.loadImage("/Sheets/bubble.png"));
		SpriteSheet Bubble_sheet2 = new SpriteSheet(Images.loadImage("/Sheets/bubble2.png"));
		SpriteSheet Bubble_sheet3 = new SpriteSheet(Images.loadImage("/Sheets/bubble3.png"));
		SpriteSheet pikaSheet = new SpriteSheet(Images.loadImage("/Sheets/pikaSpritefix.png"));
		SpriteSheet trainerSheet = new SpriteSheet(Images.loadImage("/Sheets/trainerSprite.png"));
		SpriteSheet bossSheet = new SpriteSheet(Images.loadImage("/Sheets/BossSprite2.png"));
		SpriteSheet ashSheet = new SpriteSheet(Images.loadImage("/Sheets/ash_sprite.png"));
		SpriteSheet profSheet = new SpriteSheet(Images.loadImage("/Sheets/FRLG-Oak.png"));

		blocks = new BufferedImage[15];
		 butback= new BufferedImage[3];

		player_left = new BufferedImage[4];
		player_right = new BufferedImage[4];
		player_front = new BufferedImage[4];
		player_back = new BufferedImage[4];
		
		prof_front = new BufferedImage[3];
		prof_back = new BufferedImage[3];
		prof_left = new BufferedImage[3];
		prof_right = new BufferedImage[3];
		

		SkelyEnemy_left = new BufferedImage[4];
		SkelyEnemy_right = new BufferedImage[4];
		SkelyEnemy_front = new BufferedImage[4];
		SkelyEnemy_back = new BufferedImage[4];
		humanoid_front = new BufferedImage[4];
		humanoid_back = new BufferedImage[4];
		humanoid_left = new BufferedImage[4];
		humanoid_right = new BufferedImage[4];
		Pika_front = new BufferedImage[4];
		Pika_back = new BufferedImage[4];
		Pika_left = new BufferedImage[4];
		Pika_right = new BufferedImage[4];
		Trainer_front = new BufferedImage[4];
		Trainer_back = new BufferedImage[4];
		Trainer_left = new BufferedImage[4];
		Trainer_right = new BufferedImage[4];
		butretry= new BufferedImage[3];

		boss_front = new BufferedImage[3];
		boss_back = new BufferedImage[3];
		boss_left = new BufferedImage[3];
		boss_right = new BufferedImage[3];
		ash_front = new BufferedImage[3];
		ash_back = new BufferedImage[3];
		ash_left = new BufferedImage[3];
		ash_right = new BufferedImage[3];

		butstart = new BufferedImage[3];
		particleSmoke = new BufferedImage[3];
		items = new BufferedImage[3];
		numbers = new BufferedImage[21];
		Resume = new BufferedImage[2];
		BTitle = new BufferedImage[2];
		Options = new BufferedImage[2];
		Runes = new BufferedImage[36];
		bubble = new BufferedImage[4];
		bubble2 = new BufferedImage[4];
		bubble3 = new BufferedImage[2];

		FireBallLeft = new BufferedImage[6];
		FireBallRight = new BufferedImage[6];
		FireBallUp = new BufferedImage[6];
		FireBallDown = new BufferedImage[6];

		try {
			steeltile = ImageIO.read(getClass().getResourceAsStream("/Blocks/steeltile.png"));
			poketile = ImageIO.read(getClass().getResourceAsStream("/Blocks/poketile.png"));
			key = ImageIO.read(getClass().getResourceAsStream("/Sheets/key.png"));
			dmgPotion = ImageIO.read(getClass().getResourceAsStream("/Sheets/damagePotion.png"));
			exlcamationMark = ImageIO.read(getClass().getResourceAsStream("/Sheets/excla.png"));
			chest = ImageIO.read(getClass().getResourceAsStream("/Sheets/chest.png"));
			chest2 = ImageIO.read(getClass().getResourceAsStream("/Sheets/chest2.png"));
			loading = ImageIO.read(getClass().getResourceAsStream("/Sheets/loading.png"));
			spellGUI = ImageIO.read(getClass().getResourceAsStream("/Sheets/SpellGUI.png"));
			inventory = ImageIO.read(getClass().getResourceAsStream("/Sheets/guit.png"));
			title = ImageIO.read(getClass().getResourceAsStream("/Sheets/newtitle2.png"));
			door = ImageIO.read(getClass().getResourceAsStream("/Sheets/Door.png"));
			gold = ImageIO.read(getClass().getResourceAsStream("/Sheets/Coin.png"));
			E = ImageIO.read(getClass().getResourceAsStream("/Buttons/E.png"));
			EP = ImageIO.read(getClass().getResourceAsStream("/Buttons/EP.png"));
			Pause = ImageIO.read(getClass().getResourceAsStream("/Buttons/Pause.png"));
			Resume[0] = ImageIO.read(getClass().getResourceAsStream("/Buttons/Resume.png"));
			Resume[1] = ImageIO.read(getClass().getResourceAsStream("/Buttons/ResumeP.png"));
			BTitle[0] = ImageIO.read(getClass().getResourceAsStream("/Buttons/BTitle.png"));
			BTitle[1] = ImageIO.read(getClass().getResourceAsStream("/Buttons/BTitleP.png"));
			Options[0] = ImageIO.read(getClass().getResourceAsStream("/Buttons/Options.png"));
			Options[1] = ImageIO.read(getClass().getResourceAsStream("/Buttons/OptionsP.png"));
			pokeBall = ImageIO.read(getClass().getResourceAsStream("/Sheets/pokeball.png"));
			butretry[0]= ImageIO.read(getClass().getResourceAsStream("/Buttons/retrybutton2.png"));//normbut
	        butretry[1]= ImageIO.read(getClass().getResourceAsStream("/Buttons/retrybuttonhover2.png"));//hoverbut
	        butback[0]= ImageIO.read(getClass().getResourceAsStream("/Buttons/backbutton.png"));//normbut
            butback[1]= ImageIO.read(getClass().getResourceAsStream("/Buttons/backbuttonhover.png"));//hoverbut
            butback[2]= ImageIO.read(getClass().getResourceAsStream("/Buttons/backbuttonclick.png"));//clickbut
            gameOver= ImageIO.read(getClass().getResourceAsStream("/Sheets/gameOverback.png"));
	        winState = ImageIO.read(getClass().getResourceAsStream("/Sheets/The-End-Thanks-for-playing-five-nights-at-freddys-38711419-900-600.jpg"));

			// icon
			icon = new ImageIcon(runesheet.crop(Rwidth * 1, Rheight * 0, Rwidth, Rheight));

			// fireball left
			FireBallLeft[0] = FireBallsheet.crop(Fwidth * 0, Fheight * 0, Fwidth, Fheight);
			FireBallLeft[1] = FireBallsheet.crop(Fwidth * 1, Fheight * 0, Fwidth, Fheight);
			FireBallLeft[2] = FireBallsheet.crop(Fwidth * 2, Fheight * 0, Fwidth, Fheight);
			FireBallLeft[3] = FireBallsheet.crop(Fwidth * 0, Fheight * 1, Fwidth, Fheight);
			FireBallLeft[4] = FireBallsheet.crop(Fwidth * 1, Fheight * 1, Fwidth, Fheight);
			FireBallLeft[5] = FireBallsheet.crop(Fwidth * 2, Fheight * 1, Fwidth, Fheight);

			// fireball right
			FireBallRight[0] = FireBallRightsheet.crop(Fwidth * 0, Fheight * 0, Fwidth, Fheight);
			FireBallRight[1] = FireBallRightsheet.crop(Fwidth * 1, Fheight * 0, Fwidth, Fheight);
			FireBallRight[2] = FireBallRightsheet.crop(Fwidth * 2, Fheight * 0, Fwidth, Fheight);
			FireBallRight[3] = FireBallRightsheet.crop(Fwidth * 0, Fheight * 1, Fwidth, Fheight);
			FireBallRight[4] = FireBallRightsheet.crop(Fwidth * 1, Fheight * 1, Fwidth, Fheight);
			FireBallRight[5] = FireBallRightsheet.crop(Fwidth * 2, Fheight * 1, Fwidth, Fheight);

			// fireball up
			FireBallUp[0] = FireBallUpsheet.crop(Fheight * 1, Fwidth * 0, Fheight, Fwidth);
			FireBallUp[1] = FireBallUpsheet.crop(Fheight * 1, Fwidth * 1, Fheight, Fwidth);
			FireBallUp[2] = FireBallUpsheet.crop(Fheight * 1, Fwidth * 2, Fheight, Fwidth);
			FireBallUp[3] = FireBallUpsheet.crop(Fheight * 0, Fwidth * 0, Fheight, Fwidth);
			FireBallUp[4] = FireBallUpsheet.crop(Fheight * 0, Fwidth * 1, Fheight, Fwidth);
			FireBallUp[5] = FireBallUpsheet.crop(Fheight * 0, Fwidth * 2, Fheight, Fwidth);

			// fireball down
			FireBallDown[0] = FireBallDownsheet.crop(Fheight * 1, Fwidth * 0, Fheight, Fwidth);
			FireBallDown[1] = FireBallDownsheet.crop(Fheight * 1, Fwidth * 1, Fheight, Fwidth);
			FireBallDown[2] = FireBallDownsheet.crop(Fheight * 1, Fwidth * 2, Fheight, Fwidth);
			FireBallDown[3] = FireBallDownsheet.crop(Fheight * 0, Fwidth * 0, Fheight, Fwidth);
			FireBallDown[4] = FireBallDownsheet.crop(Fheight * 0, Fwidth * 1, Fheight, Fwidth);
			FireBallDown[5] = FireBallDownsheet.crop(Fheight * 0, Fwidth * 2, Fheight, Fwidth);

			Runes[0] = runesheet.crop(Rwidth * 0, Rheight * 0, Rwidth, Rheight);// Runes
			Runes[1] = runesheet.crop(Rwidth * 1, Rheight * 0, Rwidth, Rheight);
			Runes[2] = runesheet.crop(Rwidth * 2, Rheight * 0, Rwidth, Rheight);
			Runes[3] = runesheet.crop(Rwidth * 3, Rheight * 0, Rwidth, Rheight);
			Runes[4] = runesheet.crop(Rwidth * 4, Rheight * 0, Rwidth, Rheight);
			Runes[5] = runesheet.crop(Rwidth * 5, Rheight * 0, Rwidth, Rheight);
			Runes[6] = runesheet.crop(Rwidth * 6, Rheight * 0, Rwidth, Rheight);
			Runes[7] = runesheet.crop(Rwidth * 7, Rheight * 0, Rwidth, Rheight);

			blocks[0] = ImageIO.read(getClass().getResourceAsStream("/Blocks/Slime.png"));

			butstart[0] = newsheet.crop(11, 422, 93, 34);// normbut
			butstart[1] = newsheet.crop(11, 456, 93, 33);// hoverbut
			butstart[2] = newsheet.crop(11, 489, 93, 32);// clickbut

			particleSmoke[0] = newsheet.crop(111, 397, 18, 38);
			particleSmoke[1] = newsheet.crop(129, 399, 20, 35);
			particleSmoke[2] = newsheet.crop(154, 400, 20, 35);

			items[0] = newsheet.crop(114, 448, 30, 24);// log

			numbers[1] = numsheet.crop(17, 15, 17, 22);
			numbers[2] = numsheet.crop(64, 16, 14, 19);
			numbers[3] = numsheet.crop(110, 16, 14, 19);
			numbers[4] = numsheet.crop(154, 17, 15, 19);
			numbers[5] = numsheet.crop(19, 61, 13, 20);
			numbers[6] = numsheet.crop(64, 61, 14, 20);
			numbers[7] = numsheet.crop(110, 62, 14, 19);
			numbers[8] = numsheet.crop(156, 61, 13, 20);
			numbers[9] = numsheet.crop(19, 107, 13, 20);
			numbers[10] = numsheet.crop(60, 107, 24, 20);
			numbers[11] = numsheet.crop(107, 107, 20, 19);
			numbers[12] = numsheet.crop(151, 107, 23, 19);
			numbers[13] = numsheet.crop(14, 152, 23, 20);
			numbers[14] = numsheet.crop(60, 152, 23, 20);
			numbers[15] = numsheet.crop(105, 153, 24, 20);
			numbers[16] = numsheet.crop(151, 153, 23, 20);
			numbers[17] = numsheet.crop(14, 198, 24, 20);
			numbers[18] = numsheet.crop(60, 198, 23, 20);
			numbers[19] = numsheet.crop(106, 198, 23, 21);
			numbers[20] = numsheet.crop(149, 198, 28, 20);

			// block images,array index is equal to block id
			blocks[1] = newsheet.crop(0, 324, Bwidth, Bheight);// grass
			blocks[2] = newsheet.crop(67, 260, Bwidth, Bheight);// dirt
			blocks[3] = newsheet.crop(67, 324, Bwidth, Bheight);// dirtrock
			blocks[4] = newsheet.crop(0, 0, Bwidth, Bheight);// uppperleft
			blocks[5] = newsheet.crop(67, 0, Bwidth, Bheight);// upperright
			blocks[6] = newsheet.crop(67, 65, Bwidth, Bheight);// lowerleft
			blocks[7] = newsheet.crop(0, 65, Bwidth, Bheight);// lowerright
			blocks[8] = newsheet.crop(0, 195, Bwidth, Bheight);// leftwall
			blocks[9] = newsheet.crop(67, 195, Bwidth, Bheight);// rightwall
			blocks[10] = newsheet.crop(0, 130, Bwidth, Bheight);// topwall
			blocks[11] = newsheet.crop(67, 130, Bwidth, Bheight);// lowerwall
			blocks[12] = newsheet.crop(0, 260, Bwidth, Bheight);// mossyrock
			blocks[13] = newsheet.crop(176, 0, Bwidth, Bheight * 2);// tree
			blocks[14] = newsheet.crop(174, 410, 78, 74);// rock

			// player anim
			player_front[0] = newsheet.crop(132, 131, width, height);
			player_front[1] = newsheet.crop(164, 131, width, height);
			player_front[2] = newsheet.crop(196, 131, width, height);
			player_front[3] = newsheet.crop(228, 131, 28, height);

			player_left[0] = newsheet.crop(132, 163, width, height);
			player_left[1] = newsheet.crop(164, 163, width, height);
			player_left[2] = newsheet.crop(196, 163, width, height);
			player_left[3] = newsheet.crop(228, 163, 28, height);

			player_right[0] = newsheet.crop(132, 195, width, height);
			player_right[1] = newsheet.crop(164, 195, width, height);
			player_right[2] = newsheet.crop(196, 195, width, height);
			player_right[3] = newsheet.crop(228, 195, 28, height);

			player_back[0] = newsheet.crop(132, 227, width, height);
			player_back[1] = newsheet.crop(164, 227, width, height);
			player_back[2] = newsheet.crop(196, 227, width, height);
			player_back[3] = newsheet.crop(228, 227, 28, height);

			// Skely enemy anim
			SkelyEnemy_front[0] = newsheet.crop(132, 131 + 130, width, height);
			SkelyEnemy_front[1] = newsheet.crop(164, 131 + 130, width, height);
			SkelyEnemy_front[2] = newsheet.crop(196, 131 + 130, width, height);
			SkelyEnemy_front[3] = newsheet.crop(228, 131 + 130, 28, height);

			SkelyEnemy_left[0] = newsheet.crop(132, 163 + 130, width, height);
			SkelyEnemy_left[1] = newsheet.crop(164, 163 + 130, width, height);
			SkelyEnemy_left[2] = newsheet.crop(196, 163 + 130, width, height);
			SkelyEnemy_left[3] = newsheet.crop(228, 163 + 130, 28, height);

			SkelyEnemy_right[0] = newsheet.crop(132, 195 + 130, width, height);
			SkelyEnemy_right[1] = newsheet.crop(164, 195 + 130, width, height);
			SkelyEnemy_right[2] = newsheet.crop(196, 195 + 130, width, height);
			SkelyEnemy_right[3] = newsheet.crop(228, 195 + 130, 28, height);

			SkelyEnemy_back[0] = newsheet.crop(132, 227 + 130, width, height);
			SkelyEnemy_back[1] = newsheet.crop(164, 227 + 130, width, height);
			SkelyEnemy_back[2] = newsheet.crop(196, 227 + 130, width, height);
			SkelyEnemy_back[3] = newsheet.crop(228, 227 + 130, 28, height);
			humanoid_front[0] = humanoidSheet.crop(16, 15, 32, 60);
			humanoid_left[0] = humanoidSheet.crop(16, 64, 32, 60);
			humanoid_right[0] = humanoidSheet.crop(16, 128, 32, 60);
			humanoid_back[0] = humanoidSheet.crop(16, 192, 32, 60);

			Pika_front[0] = pikaSheet.crop(58, 11, Pwidth, Pheight);
			Pika_front[1] = pikaSheet.crop(117, 11, Pwidth, Pheight);
			Pika_front[2] = pikaSheet.crop(176, 12, Pwidth, Pheight);
			Pika_front[3] = pikaSheet.crop(236, 12, 33, 37);

			Pika_left[0] = pikaSheet.crop(59, 70, Pwidth, Pheight);
			Pika_left[1] = pikaSheet.crop(119, 72, Pwidth, Pheight);
			Pika_left[2] = pikaSheet.crop(178, 72, Pwidth, Pheight);
			Pika_left[3] = pikaSheet.crop(238, 72, Pwidth, Pheight);

			Pika_right[0] = pikaSheet.crop(57, 130, Pwidth, Pheight);
			Pika_right[1] = pikaSheet.crop(117, 131, Pwidth, Pheight);
			Pika_right[2] = pikaSheet.crop(176, 131, Pwidth, Pheight);
			Pika_right[3] = pikaSheet.crop(236, 131, Pwidth, Pheight);

			Pika_back[0] = pikaSheet.crop(58, 190, Pwidth, Pheight);
			Pika_back[1] = pikaSheet.crop(118, 192, Pwidth, Pheight);
			Pika_back[2] = pikaSheet.crop(177, 192, Pwidth, Pheight);
			Pika_back[3] = pikaSheet.crop(238, 193, Pwidth, Pheight);

			Trainer_front[0] = trainerSheet.crop(7, 6, Twidth, Theight);
			Trainer_front[1] = trainerSheet.crop(70, 6, Twidth, Theight);
			Trainer_front[2] = trainerSheet.crop(133, 6, Twidth, Theight);
			Trainer_front[3] = trainerSheet.crop(198, 6, Twidth, Theight);

			Trainer_left[0] = trainerSheet.crop(7, 71, Twidth, Theight);
			Trainer_left[1] = trainerSheet.crop(70, 71, Twidth, Theight);
			Trainer_left[2] = trainerSheet.crop(133, 71, Twidth, Theight);
			Trainer_left[3] = trainerSheet.crop(198, 71, Twidth, Theight);

			Trainer_right[0] = trainerSheet.crop(7, 136, Twidth, Theight);
			Trainer_right[1] = trainerSheet.crop(70, 136, Twidth, Theight);
			Trainer_right[2] = trainerSheet.crop(133, 136, Twidth, Theight);
			Trainer_right[3] = trainerSheet.crop(198, 136, Twidth, Theight);

			Trainer_back[0] = trainerSheet.crop(7, 196, Twidth, Theight);
			Trainer_back[1] = trainerSheet.crop(70, 196, Twidth, Theight);
			Trainer_back[2] = trainerSheet.crop(133, 196, Twidth, Theight);
			Trainer_back[3] = trainerSheet.crop(198, 196, Twidth, Theight);

			ash_front[0] = ashSheet.crop(15, 146, Awidth, Aheight);
			ash_front[1] = ashSheet.crop(32, 146, Awidth, Aheight);
			ash_front[2] = ashSheet.crop(51, 146, Awidth, Aheight);

			ash_back[0] = ashSheet.crop(122, 146, Awidth, Aheight);
			ash_back[1] = ashSheet.crop(139, 146, Awidth, Aheight);
			ash_back[2] = ashSheet.crop(155, 146, Awidth, Aheight);

			ash_right[0] = ashSheet.crop(173, 146, Awidth, Aheight);
			ash_right[1] = ashSheet.crop(191, 146, Awidth, Aheight);
			ash_right[2] = ashSheet.crop(207, 146, Awidth, Aheight);

			ash_left[0] = ashSheet.crop(69, 146, Awidth, Aheight);
			ash_left[1] = ashSheet.crop(89, 146, Awidth, Aheight);
			ash_left[2] = ashSheet.crop(105, 146, Awidth, Aheight);

			boss_front[0] = bossSheet.crop(250, 17, 41, 43);
			boss_front[1] = bossSheet.crop(291, 19, 41, 43);
			boss_front[2] = bossSheet.crop(332, 17, 41, 43);

			boss_back[0] = bossSheet.crop(253, 63, 39, 54);
			boss_back[1] = bossSheet.crop(292, 62, 40, 55);
			boss_back[2] = bossSheet.crop(333, 62, 40, 55);

			boss_right[0] = bossSheet.crop(534, 305, 57, 49);
			boss_right[1] = bossSheet.crop(594, 306, 57, 49);
			boss_right[2] = bossSheet.crop(660, 318, 57, 49);

			boss_left[0] = bossSheet.crop(226, 116, 57, 51);
			boss_left[1] = bossSheet.crop(285, 116, 57, 49);
			boss_left[2] = bossSheet.crop(342, 116, 57, 49);
			
			
			
			prof_front[0] = profSheet.crop(210, 3, Hwidth, Hheight);
			prof_front[1] = profSheet.crop(226, 3, Hwidth, Hheight);
			prof_front[2] = profSheet.crop(243, 3, Hwidth, Hheight);
			

			prof_back[0] = profSheet.crop(210, 69, Hwidth, Hheight);
			prof_back[1] = profSheet.crop(226, 69 ,Hwidth, Hheight);
			prof_back[2] = profSheet.crop(242, 69, Hwidth, Hheight);
			

			prof_right[0] = profSheet.crop(209, 26, Hwidth, Hheight);
			prof_right[1] = profSheet.crop(224, 25, Hwidth, Hheight);
			prof_right[2] = profSheet.crop(240, 26, Hwidth, Hheight);
			

			prof_left[0] = profSheet.crop(209, 48, Hwidth, Hheight);
			prof_left[1] = profSheet.crop(224, 47, Hwidth, Hheight);
			prof_left[2] = profSheet.crop(240, 47, Hwidth, Hheight);


			bubble[0] = Bubble_sheet.crop(0, 0, 200, 150);
			bubble[1] = Bubble_sheet.crop(200, 0, 200, 150);
			bubble[2] = Bubble_sheet.crop(400, 0, 200, 150);
			bubble[3] = Bubble_sheet.crop(600, 0, 200, 150);

			bubble2[0] = Bubble_sheet2.crop(0, 0, 200, 150);
			bubble2[1] = Bubble_sheet2.crop(200, 0, 200, 150);
			bubble2[2] = Bubble_sheet2.crop(400, 0, 200, 150);
			bubble3[0] = Bubble_sheet3.crop(0, 0, 200, 150);
			bubble3[1] = Bubble_sheet3.crop(200, 0, 200, 150);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static BufferedImage loadImage(String path) {
		try {
			return ImageIO.read(Images.class.getResourceAsStream(path));
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
		return null;
	}

}