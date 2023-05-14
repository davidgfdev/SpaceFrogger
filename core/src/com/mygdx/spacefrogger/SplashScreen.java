package com.mygdx.spacefrogger;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.TimeUtils;

public class SplashScreen implements Screen {
    SpaceFroggerMain game;
    Rectangle splash;
    Texture splashImage;
    SpriteBatch spriteBatch;
    float splashTimeout = 0;

    AssetManager assetManager = new AssetManager();
    final float TIMEOUT = 2000000000;

    OrthographicCamera camera;
    public SplashScreen(SpaceFroggerMain g){
        game = g;

        camera = new OrthographicCamera();
        camera.setToOrtho(false, 480, 800);

        assetManager.load(AssetDescriptors.splashTexture);
        assetManager.finishLoading();

        splashImage = assetManager.get(AssetDescriptors.splashTexture);
        splash = new Rectangle();
        splash.setX(0);
        splash.setY(0);
        splash.setWidth(480);
        splash.setHeight(800);

        splashTimeout = TimeUtils.nanoTime();
    }

    @Override
    public void show() {
        spriteBatch = new SpriteBatch();
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0, 0.2f, 1);

        camera.update();
        game.batch.setProjectionMatrix(camera.combined);

        game.batch.begin();
        game.batch.draw(splashImage, splash.x, splash.y, splash.width, splash.height);
        game.font.draw(game.batch, "David Guerrero Forner", 50, 300);
        game.batch.end();


        if (TimeUtils.nanoTime() - splashTimeout > TIMEOUT) {
            splashTimeout = TimeUtils.nanoTime();
            game.setScreen(new MainMenuScreen(game));
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
