package com.mygdx.spacefrogger;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.ScreenUtils;

public class GameOverScreen implements Screen {
    final AssetManager assetManager = new AssetManager();
    final SpaceFroggerMain game;
    Texture backgroundImage;
    Rectangle background;

    OrthographicCamera camera;
    float finalScore;

    public GameOverScreen(final SpaceFroggerMain game, float score) {
        this.game = game;

        camera = new OrthographicCamera();
        camera.setToOrtho(false, 480, 800);

        finalScore = score;
    }

    @Override
    public void show() {
        assetManager.load(AssetDescriptors.gameoverTexture);
        assetManager.finishLoading();

        backgroundImage = assetManager.get(AssetDescriptors.gameoverTexture);

        background = new Rectangle();
        background.setX(0);
        background.setY(0);
        background.setWidth(480);
        background.setHeight(800);
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0, 0.2f, 1);

        camera.update();
        game.batch.setProjectionMatrix(camera.combined);

        game.batch.begin();
        game.batch.draw(backgroundImage, background.x, background.y, background.width, background.height);
        game.font.setColor(Color.WHITE);
        game.font.draw(game.batch, "Punts: " + finalScore,50,200);
        game.batch.end();

        if (Gdx.input.isTouched()) {
            game.setScreen(new SplashScreen(game));
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
        assetManager.dispose();
    }
}