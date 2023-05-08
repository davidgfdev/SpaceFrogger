package com.mygdx.spacefrogger;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.graphics.Texture;

public class AssetDescriptors {
    public static final AssetDescriptor<Texture> frogTexture = new AssetDescriptor<Texture>(
            "square.png", Texture.class);
    public static final AssetDescriptor<Texture> platformTexture = new AssetDescriptor<Texture>(
            "square.png", Texture.class);
    public static final AssetDescriptor<Texture> capsuleTexture = new AssetDescriptor<Texture>(
            "square.png", Texture.class
    );
    public static final AssetDescriptor<Texture> meteorTexture = new AssetDescriptor<Texture>(
            "square.png", Texture.class
    );
}
