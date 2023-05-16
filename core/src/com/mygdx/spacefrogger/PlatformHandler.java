package com.mygdx.spacefrogger;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.utils.TimeUtils;

import java.util.Iterator;

public class PlatformHandler extends Group {
    private Texture texture;
    private final long PLATFORM_TIME_INTERVAL = 100000000 * 1000;
    private float lastPlatformTime;
    private int posY;
    private int direction; //-1 = Izquierda / +1 = Derecha

    public PlatformHandler(AssetManager assetManager, int posY, int direction) {
        texture = assetManager.get(AssetDescriptors.platformTexture);
        lastPlatformTime = TimeUtils.nanoTime();
        this.posY = posY;
        this.direction = direction;
        spawnPlatform();
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        Platform currentPlatform = spawnPlatform();
        if (currentPlatform != null)  removePlatform(currentPlatform);
    }

    private Platform spawnPlatform() {
        Platform platform = null;
        if (TimeUtils.nanoTime() - lastPlatformTime > PLATFORM_TIME_INTERVAL) {
            lastPlatformTime = TimeUtils.nanoTime();
            platform = new Platform(texture, direction == -1 ? 600 : 0, posY);
            platform.addAction(Actions.moveTo(direction == -1 ? -100 : 600, platform.getY(), 6));
            addActor(platform);
        }
        return platform;
    }

    private void removePlatform(Platform platform){
        if ((platform.getX() > 600 && direction > 0)
                || (platform.getX() < 0 && direction < 0)){
            removeActor(platform);
        }
    }

    public boolean frogOnPlatform(Frog frog) {
        boolean result = false;
        Iterator<Actor> it = getChildren().iterator();

        while ( it.hasNext()) {
            Platform platform = (Platform) it.next();
            if (platform.isOverlapping(frog) ) {
                System.out.println("miau");
                frog.setX(platform.getX());
                result = true;
            }
        }
        return result;
    }
}
