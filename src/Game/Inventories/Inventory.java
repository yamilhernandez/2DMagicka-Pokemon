package Game.Inventories;

import Game.Items.Item;
import Game.SpellCast.FireBallSpell;
import Resources.Images;
import UI.UIInventory;
import UI.UIManager;
import Main.Handler;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

/**
 * Created by Elemental on 1/3/2017.
 */
public class Inventory {

	private Handler handler;
	private boolean active = false;
	private UIManager uiManager;
	private ArrayList<Item> inventoryItems;

	public Inventory(Handler handler) {

		this.handler = handler;
		inventoryItems = new ArrayList<>();

		uiManager = new UIManager(handler);

		uiManager.addObjects(new UIInventory(0, 0, 329, 265, Images.inventory, () -> {
		}));
	}

	public void tick() {

		for (Item i : inventoryItems) {
			if (i.getCount() == 0) {
				inventoryItems.remove(inventoryItems.indexOf(i));
				return;
			}
		}

		if (handler.getKeyManager().keyJustPressed(KeyEvent.VK_Q)) {
			active = !active;
			handler.getWorld().getEntityManager().getPlayer().getSpellGUI().setActive(false);

		}

		if (!active) {
			return;
		}

		handler.getMouseManager().setUimanager(uiManager);
		uiManager.tick();

	}

	public void render(Graphics g) {

		if (!active) {
			uiManager.isActive(uiManager.getObjects(), false);
			return;
		}

		uiManager.isActive(uiManager.getObjects(), true);
		uiManager.Render(g);
		g.setColor(Color.white);
		renderItems(g);

	}

	// Inventory Methods
	private void renderItems(Graphics g) {

		int xUnit = 0;
		int yUnit = 0;

		for (int i = 0; i < this.inventoryItems.size(); i++) {

			if (xUnit > 250) {
				xUnit = 0;
				yUnit += 60;

			}

			g.drawImage(inventoryItems.get(i).getTexture(), 25 + xUnit, 25 + yUnit, inventoryItems.get(i).getWidth(),
					inventoryItems.get(i).getHeight(), null);
			g.drawString(String.valueOf(inventoryItems.get(i).getCount()), 25 + xUnit, 25 + yUnit);
			xUnit += 60;

		}

		// if (inventoryItems.size() == 1) {
		// g.drawImage(inventoryItems.get(0).getTexture(), 25, 24,
		// inventoryItems.get(0).getWidth(),
		// inventoryItems.get(0).getHeight(), null);
		// g.drawString(String.valueOf(inventoryItems.get(0).getCount()), 25 + 33, 25 +
		// 35);
		// } else if (inventoryItems.size() == 2) {
		// g.drawImage(inventoryItems.get(0).getTexture(), 25, 24,
		// inventoryItems.get(0).getWidth(),
		// inventoryItems.get(0).getHeight(), null);
		// g.drawString(String.valueOf(inventoryItems.get(0).getCount()), 25 + 33, 25 +
		// 35);
		// g.drawImage(inventoryItems.get(1).getTexture(), 86, 24,
		// inventoryItems.get(1).getWidth(),
		// inventoryItems.get(1).getHeight(), null);
		// g.drawString(String.valueOf(inventoryItems.get(1).getCount()), 86 + 33, 24 +
		// 35);
		// } else if (inventoryItems.size() == 3) {
		// g.drawImage(inventoryItems.get(0).getTexture(), 25, 24,
		// inventoryItems.get(0).getWidth(),
		// inventoryItems.get(0).getHeight(), null);
		// g.drawString(String.valueOf(inventoryItems.get(0).getCount()), 25 + 33, 25 +
		// 35);
		// g.drawImage(inventoryItems.get(1).getTexture(), 86, 24,
		// inventoryItems.get(1).getWidth(),
		// inventoryItems.get(1).getHeight(), null);
		// g.drawString(String.valueOf(inventoryItems.get(1).getCount()), 86 + 33, 24 +
		// 35);
		// g.drawImage(inventoryItems.get(2).getTexture(), 147, 24,
		// inventoryItems.get(2).getWidth(),
		// inventoryItems.get(2).getHeight(), null);
		// g.drawString(String.valueOf(inventoryItems.get(2).getCount()), 147 + 33, 24 +
		// 35);
		//
		// } else if (inventoryItems.size() == 4) {
		// g.drawImage(inventoryItems.get(0).getTexture(), 25, 24,
		// inventoryItems.get(0).getWidth(),
		// inventoryItems.get(0).getHeight(), null);
		// g.drawString(String.valueOf(inventoryItems.get(0).getCount()), 25 + 33, 25 +
		// 35);
		// g.drawImage(inventoryItems.get(1).getTexture(), 86, 24,
		// inventoryItems.get(1).getWidth(),
		// inventoryItems.get(1).getHeight(), null);
		// g.drawString(String.valueOf(inventoryItems.get(1).getCount()), 86 + 33, 24 +
		// 35);
		// g.drawImage(inventoryItems.get(2).getTexture(), 147, 24,
		// inventoryItems.get(2).getWidth(),
		// inventoryItems.get(2).getHeight(), null);
		// g.drawString(String.valueOf(inventoryItems.get(2).getCount()), 147 + 33, 24 +
		// 35);
		// g.drawImage(inventoryItems.get(3).getTexture(), 208, 24,
		// inventoryItems.get(2).getWidth(),
		// inventoryItems.get(3).getHeight(), null);
		// g.drawString(String.valueOf(inventoryItems.get(3).getCount()), 208 + 33, 24 +
		// 35);
		// } else if (inventoryItems.size() == 5) {
		// g.drawImage(inventoryItems.get(0).getTexture(), 25, 24,
		// inventoryItems.get(0).getWidth(),
		// inventoryItems.get(0).getHeight(), null);
		// g.drawString(String.valueOf(inventoryItems.get(0).getCount()), 25 + 33, 25 +
		// 35);
		// g.drawImage(inventoryItems.get(1).getTexture(), 86, 24,
		// inventoryItems.get(1).getWidth(),
		// inventoryItems.get(1).getHeight(), null);
		// g.drawString(String.valueOf(inventoryItems.get(1).getCount()), 86 + 33, 24 +
		// 35);
		// g.drawImage(inventoryItems.get(2).getTexture(), 147, 24,
		// inventoryItems.get(2).getWidth(),
		// inventoryItems.get(2).getHeight(), null);
		// g.drawString(String.valueOf(inventoryItems.get(2).getCount()), 147 + 33, 24 +
		// 35);
		// g.drawImage(inventoryItems.get(3).getTexture(), 208, 24,
		// inventoryItems.get(3).getWidth(),
		// inventoryItems.get(3).getHeight(), null);
		// g.drawString(String.valueOf(inventoryItems.get(3).getCount()), 208 + 33, 24 +
		// 35);
		// /////////
		// g.drawImage(inventoryItems.get(4).getTexture(), 269, 24,
		// inventoryItems.get(4).getWidth(),
		// inventoryItems.get(4).getHeight(), null);
		// g.drawString(String.valueOf(inventoryItems.get(4).getCount()), 269 + 33, 24 +
		// 35);
		// }else if (inventoryItems.size() == 6) {
		// g.drawImage(inventoryItems.get(0).getTexture(), 25, 24,
		// inventoryItems.get(0).getWidth(),
		// inventoryItems.get(0).getHeight(), null);
		// g.drawString(String.valueOf(inventoryItems.get(0).getCount()), 25 + 33, 25 +
		// 35);
		// g.drawImage(inventoryItems.get(1).getTexture(), 86, 24,
		// inventoryItems.get(1).getWidth(),
		// inventoryItems.get(1).getHeight(), null);
		// g.drawString(String.valueOf(inventoryItems.get(1).getCount()), 86 + 33, 24 +
		// 35);
		// g.drawImage(inventoryItems.get(2).getTexture(), 147, 24,
		// inventoryItems.get(2).getWidth(),
		// inventoryItems.get(2).getHeight(), null);
		// g.drawString(String.valueOf(inventoryItems.get(2).getCount()), 147 + 33, 24 +
		// 35);
		// g.drawImage(inventoryItems.get(3).getTexture(), 208, 24,
		// inventoryItems.get(3).getWidth(),
		// inventoryItems.get(3).getHeight(), null);
		// g.drawString(String.valueOf(inventoryItems.get(3).getCount()), 208 + 33, 24 +
		// 35);
		// g.drawImage(inventoryItems.get(4).getTexture(), 269, 24,
		// inventoryItems.get(4).getWidth(),
		// inventoryItems.get(4).getHeight(), null);
		// g.drawString(String.valueOf(inventoryItems.get(4).getCount()), 269 + 33, 24 +
		// 35);
		// g.drawImage(inventoryItems.get(5).getTexture(), 20, 78,
		// inventoryItems.get(4).getWidth()+10,
		// inventoryItems.get(5).getHeight()+10, null);
		// g.drawString(String.valueOf(inventoryItems.get(5).getCount()), 25 + 33, 87 +
		// 35);
		//
		// }
		//
		//
		//
		// else if (inventoryItems.size() == 7) {
		// g.drawImage(inventoryItems.get(0).getTexture(), 25, 24,
		// inventoryItems.get(0).getWidth(),
		// inventoryItems.get(0).getHeight(), null);
		// g.drawString(String.valueOf(inventoryItems.get(0).getCount()), 25 + 33, 25 +
		// 35);
		// g.drawImage(inventoryItems.get(1).getTexture(), 86, 24,
		// inventoryItems.get(1).getWidth(),
		// inventoryItems.get(1).getHeight(), null);
		// g.drawString(String.valueOf(inventoryItems.get(1).getCount()), 86 + 33, 24 +
		// 35);
		// g.drawImage(inventoryItems.get(2).getTexture(), 147, 24,
		// inventoryItems.get(2).getWidth(),
		// inventoryItems.get(2).getHeight(), null);
		// g.drawString(String.valueOf(inventoryItems.get(2).getCount()), 147 + 33, 24 +
		// 35);
		// g.drawImage(inventoryItems.get(3).getTexture(), 208, 24,
		// inventoryItems.get(3).getWidth(),
		// inventoryItems.get(3).getHeight(), null);
		// g.drawString(String.valueOf(inventoryItems.get(3).getCount()), 208 + 33, 24 +
		// 35);
		// g.drawImage(inventoryItems.get(4).getTexture(), 269, 24,
		// inventoryItems.get(4).getWidth(),
		// inventoryItems.get(4).getHeight(), null);
		// g.drawString(String.valueOf(inventoryItems.get(4).getCount()), 269 + 33, 24 +
		// 35);
		// g.drawImage(inventoryItems.get(5).getTexture(), 20, 78,
		// inventoryItems.get(4).getWidth()+10,
		// inventoryItems.get(5).getHeight()+10, null);
		// g.drawString(String.valueOf(inventoryItems.get(5).getCount()), 25 + 33, 87 +
		// 35);
		// g.drawImage(inventoryItems.get(6).getTexture(), 82, 78,
		// inventoryItems.get(4).getWidth()+10,
		// inventoryItems.get(6).getHeight()+10, null);
		// g.drawString(String.valueOf(inventoryItems.get(6).getCount()), 86 + 33, 87 +
		// 35);
		//
		// }

	}

	public void addItem(Item item) {
		for (Item i : inventoryItems) {
			if (i.getId() == item.getId()) {
				i.setCount(i.getCount() + 1);
				return;
			}
		}
		if (item.getId() == 2) {
			handler.getWorld().getEntityManager().getPlayer().getSpellGUI().addSpell(new FireBallSpell(handler));
		}
		inventoryItems.add(item);

	}

	public void deleteItem(Item item) {
		for (Item i : inventoryItems) {
			if (i.getId() == item.getId()) {
				i.setCount(i.getCount() - 1);
				return;
			}
		}
	}

	// GET SET
	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}

	public ArrayList<Item> getInventoryItems() {
		return inventoryItems;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
}
