package com.mygdx.spacefrogger;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetManager;
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

    public MainGame(SpaceFroggerMain game){
        this.game = game;
        OrthographicCamera camera = new OrthographicCamera();
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

        for(Capsule c : capsules){
            if (frog.isOverlapping(c)){
                System.out.println("Victoria");
            }
        }


        stage.act(delta);
        stage.draw();
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
    }

    private void loadAssets(){
        assetManager.load(AssetDescriptors.frogTexture);
        assetManager.finishLoading();
    }
}
