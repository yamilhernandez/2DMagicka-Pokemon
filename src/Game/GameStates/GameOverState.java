package Game.GameStates;


import Main.Game;
import Resources.Images;
import UI.ClickListlener;
import UI.UIImageButton;
import UI.UIManager;
import Main.Handler;

import java.awt.*;



/**
 * Created by AlexVR on 7/1/2018.
 */
public class GameOverState extends State {

    private UIManager uiManager;

    public GameOverState(Handler handler) {
        super(handler);
        uiManager = new UIManager(handler);
        handler.getMouseManager().setUimanager(uiManager);

       
        
        uiManager.addObjects(new UIImageButton(handler.getWidth()-180, handler.getHeight()-100, 128+50, 64+50, Images.butretry, new ClickListlener() {
            @Override
            public void onClick() {
                handler.getMouseManager().setUimanager(null);
       
                handler.getGame().reStart();
                
                State.setState(handler.getGame().gameState);
            }
        }));

        uiManager.addObjects(new UIImageButton(20, handler.getHeight()-75, 150, 65, Images.butback, new ClickListlener() {
            @Override
            public void onClick() {
            	handler.getMouseManager().setUimanager(null);
            
            	State.setState(handler.getGame().menuState);
            	
            }
        }));
    }

    @Override
    public void tick() {
        handler.getMouseManager().setUimanager(uiManager);
        uiManager.tick();

    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.darkGray);
        g.fillRect(0,0,handler.getWidth(),handler.getHeight());
        g.drawImage(Images.gameOver,0,0,handler.getWidth(),handler.getHeight(),null);
        uiManager.Render(g);
        g.setColor(Color.white);
        

    }


}
