package displays;

import java.util.List;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import rendering.FloatGrid;

//note when creating a world the canvas is, for some reason, 10px smaller for both components so oversize accordingly

public abstract class WorldTemplate{
	protected List<KeyCode> keys;
	protected WorldManager wm;
	protected FloatGrid renderMap;
	protected volatile boolean objsLoaded = false;
	
	public abstract void update(double tickDelta);
	public abstract void draw(int prevFrames, GraphicsContext g);
	public abstract void prepForDelete();
	public abstract void allocateResources();
	
	public void finishedLoadingAssets(){
		objsLoaded = true;
	}
	
	public WorldTemplate(WorldManager wm, FloatGrid renderMap) {
		this.wm = wm;
		this.renderMap = renderMap;
		allocateResources();
	}
}