package com.mygdx.spacefrogger;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.ScreenUtils;

public class MainMenuScreen implements Screen {
    final AssetManager assetManager = new AssetManager();
    final SpaceFroggerMain game;
    final Texture backgroundImage;
    Rectangle background;

    OrthographicCamera camera;

    public MainMenuScreen(final SpaceFroggerMain game) {
        this.game = game;

        camera = new OrthographicCamera();
        camera.setToOrtho(false, 480, 800);

        assetManager.load(AssetDescriptors.backgroundTexture);
        assetManager.finishLoading();

        backgroundImage = assetManager.get(AssetDescriptors.backgroundTexture);
        background = new Rectangle();
        background.setX(0);
        background.setY(0);
        background.setWidth(480);
        background.setHeight(800);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0, 0.2f, 1);

        camera.update();
        game.batch.setProjectionMatrix(camera.combined);

        game.batch.begin();
        game.batch.draw(backgroundImage, background.x, background.y, background.width, background.height);
        game.font.draw(game.batch, "Take the alien frog", 50, 150);
        game.font.draw(game.batch, "to her capsule!", 50, 100);
        game.batch.end();

        if (Gdx.input.isTouched()) {
            game.setScreen(new MainGame(game));
            dispose();
        }
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