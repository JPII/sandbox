import java.awt.Color;
import net.bervini.rasael.jisoengine.*;
import net.bervini.rasael.jisoengine.env.GameInfo;
import net.bervini.rasael.jisoengine.environment.Tile;
@SuppressWarnings("serial")
public class EngineDemo extends FrameWork {
    
    /** Creates a new instance of BoardExample */
    public EngineDemo(EngineVariables engineVariables) {
        super(engineVariables,11785,null);
        startFPSCalculation(1000);

        java.awt.MenuBar mB = new java.awt.MenuBar();
        
        java.awt.Menu gameMenu = new java.awt.Menu("Game");
        java.awt.Menu helpMenu = new java.awt.Menu("?");
        
        gameMenu.add(new java.awt.MenuItem("Restart"));
        gameMenu.addSeparator();
        gameMenu.add(new java.awt.MenuItem("Quit"));
        
        helpMenu.add(new java.awt.MenuItem("Options"));
        
        mB.add(gameMenu);
        mB.add(helpMenu);

        loadImages();
        createMap();
        
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        startGame();
        
    }
    public static void startGame(){
        engineVariables = new EngineVariables();
        GameInfo.gameTitle = "NavalBattle";
        engineVariables.engineScreenGUIVariables.lookAndFeelClassName = "com.sun.java.swing.plaf.windows.WindowsLookAndFee";//"net.beeger.squareness.SquarenessLookAndFeel";
        engineVariables.engineGridColor = new Color(0,0,0,0);
        engineVariables.engineScreenViewWidth = 800;
        engineVariables.engineScreenViewHeight = 600;
        final BoardExample gameIstance=new BoardExample(engineVariables);
        gameIstance.start();
    }
    public void loadImages() {
    	loadImageToEngine("Data/images/grastile.gif","tileGrass","Tiles:");
        loadImageToEngine("Data/images/title.gif","ENGINE_TITLEBAR","Engine defaults");
        preloadEngineImages(true);
        
    }
    
    public void createMap() {
        for(int y=0;y<getEngineVariables().engineTileMaxY;y++) {
            for(int x=0;x<getEngineVariables().engineTileMaxX;x++) {
                net.bervini.rasael.jisoengine.env.Tile tile = Tile.createTile("tileGrass", 0,0,1);
                getEngineVariables().environmentGameMap[0][y][x] = tile;  
                getEngineVariables().environmentGameMap[1][y][x] = tile;
            }
        }
    }
    
}