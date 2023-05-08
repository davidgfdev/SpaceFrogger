package com.mygdx.spacefrogger;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.StretchViewport;

public class MainGame extends InputAdapter implements Screen {
    SpaceFroggerMain game;
    Stage stage;
    AssetDescriptors assetDescriptors = new AssetDescriptors();
    GameObject frog;

    public MainGame(SpaceFroggerMain game){
        this.game = game;
        OrthographicCamera camera = new OrthographicCamera();
        camera.setToOrtho(false, 400, 800);
        stage = new Stage(new StretchViewport(400, 800, camera));
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
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

    }
}
