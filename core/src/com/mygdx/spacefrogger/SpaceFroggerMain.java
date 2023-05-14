package com.mygdx.spacefrogger;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.utils.ScreenUtils;

import jdk.tools.jmod.Main;

public class SpaceFroggerMain extends Game {
	SpriteBatch batch;
	public BitmapFont font;
	FreeTypeFontGenerator generator;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		generator = new FreeTypeFontGenerator(Gdx.files.internal("Minecraft.ttf"));
		FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
		parameter.size = 28;
		font = generator.generateFont(parameter);
		this.setScreen(new SplashScreen(this));
	}

	@Override
	public void render () {
		super.render();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		font.dispose();
		generator.dispose();
	}
}
