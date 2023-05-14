package com.mygdx.spacefrogger;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.StretchViewport;

public class MainGame extends InputAdapter implements Screen {
    SpaceFroggerMain game;
    Stage stage;
    AssetManager assetManager;
    Frog frog;
    Capsule[] capsules = new Capsule[3];
    PlatformHandler[] platformHandlers = new PlatformHandler[6];
    private int health = 3;
    public int score = 0;

    Texture background;
    Sound victorySound, jumpSound, failSound;


    OrthographicCamera camera;

    public MainGame(SpaceFroggerMain game){
        this.game = game;
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 400, 800);
        stage = new Stage(new StretchViewport(400, 800, camera));
        assetManager = new AssetManager();
    }

    @Override
    public void show() {
        loadAssets();

        frog = new Frog(assetManager.<Texture>get(AssetDescriptors.frogTexture));
        capsules[0] = new Capsule(assetManager.<Texture>get(AssetDescriptors.capsuleTexture));
        capsules[1] = new Capsule(assetManager.<Texture>get(AssetDescriptors.capsuleTexture));
        capsules[2] = new Capsule(assetManager.<Texture>get(AssetDescriptors.capsuleTexture));

        capsules[0].setPosition(30, 700);
        capsules[1].setPosition(175, 700);
        capsules[2].setPosition(320, 700);
        platformHandlers[0] = new PlatformHandler(assetManager, 100, 1);
        platformHandlers[1] = new PlatformHandler(assetManager, 200, -1);
        platformHandlers[2] = new PlatformHandler(assetManager, 300, 1);
        platformHandlers[3] = new PlatformHandler(assetManager, 400, -1);
        platformHandlers[4] = new PlatformHandler(assetManager, 500, 1);
        platformHandlers[5] = new PlatformHandler(assetManager, 600, -1);

        victorySound = assetManager.get(AssetDescriptors.victorySound);
        jumpSound = assetManager.get(AssetDescriptors.jumpSound);
        failSound = assetManager.get(AssetDescriptors.failSound);

        for (PlatformHandler handler : platformHandlers){
            stage.addActor(handler);
        }

        stage.addActor(frog);
        stage.addActor(capsules[0]);
        stage.addActor(capsules[1]);
        stage.addActor(capsules[2]);

        Gdx.input.setInputProcessor(new InputHandler(this));
    }

    @Override
    public void render(float delta) {
        while ( !assetManager.update() ) {
            assetManager.getProgress();
        }

        ScreenUtils.clear(0,0,0.2f,1);

        stage.getBatch().begin();
        stage.getBatch().end();

        background = assetManager.get(AssetDescriptors.backgroundTexture);

        stage.getBatch().begin();
        stage.getBatch().draw(background, 0,0);
        game.font.setColor(Color.WHITE);
        game.font.draw(stage.getBatch(), "Vides restants: " + health,20,50);
        game.font.draw(stage.getBatch(), "Punts: " + score,20,100);

        stage.getBatch().end();

        stage.act(delta);
        stage.draw();
    }

    public void frogJumped(){
        if (!frog.isSafe){
            for(Capsule c : capsules){
                if (frog.isOverlapping(c)){
                    frog.respawnFrog();
                    victorySound.play();
                    return;
                }
            }
        }

        if (!frogPlatforming()){
            if (health <= 0){
                game.setScreen(new GameOverScreen(game, score));
            }else{
                failSound.play();
                frog.respawnFrog();
                health--;
            }
            return;
        }

        if (score != 0 && (score%100) == 0){
            health++;
        }

        jumpSound.play();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        assetManager.dispose();
        jumpSound.dispose();
        victorySound.dispose();
        failSound.dispose();
    }

    private void loadAssets(){
        assetManager.load(AssetDescriptors.frogTexture);
        assetManager.load(AssetDescriptors.capsuleTexture);
        assetManager.load(AssetDescriptors.platformTexture);
        assetManager.load(AssetDescriptors.backgroundTexture);
        assetManager.load(AssetDescriptors.victorySound);
        assetManager.load(AssetDescriptors.jumpSound);
        assetManager.load(AssetDescriptors.failSound);
        assetManager.finishLoading();
    }

    private boolean frogPlatforming(){
        boolean result = false;
        for (PlatformHandler p : platformHandlers){
            if (p.frogOnPlatform(frog)){
                result = true;
            }
        }

        return result;
    }
}
