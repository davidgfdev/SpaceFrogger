package com.mygdx.spacefrogger;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;

public class AssetDescriptors {
    public static final AssetDescriptor<Texture> frogTexture = new AssetDescriptor<Texture>(
            "frog.png", Texture.class);
    public static final AssetDescriptor<Texture> platformTexture = new AssetDescriptor<Texture>(
            "platform.png", Texture.class);
    public static final AssetDescriptor<Texture> capsuleTexture = new AssetDescriptor<Texture>(
            "capsule.png", Texture.class
    );
    public static final AssetDescriptor<Texture> splashTexture = new AssetDescriptor<Texture>(
            "splash.jpg", Texture.class
    );
    public static final AssetDescriptor<Texture> backgroundTexture = new AssetDescriptor<Texture>(
            "background.jpg", Texture.class
    );
    public static final AssetDescriptor<Texture> gameoverTexture = new AssetDescriptor<Texture>(
            "gameover.jpg", Texture.class
    );
    public static final AssetDescriptor<Sound> victorySound = new AssetDescriptor<Sound>(
            "victory.wav", Sound.class
    );
    public static final AssetDescriptor<Sound> failSound = new AssetDescriptor<Sound>(
            "fail.wav", Sound.class
    );
    public static final AssetDescriptor<Sound> jumpSound = new AssetDescriptor<Sound>(
            "jump.wav", Sound.class
    );
}
