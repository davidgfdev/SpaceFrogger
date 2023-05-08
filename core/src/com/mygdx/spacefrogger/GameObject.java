package com.mygdx.spacefrogger;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public abstract class GameObject {
    private Vector2 pos;
    private Vector2 dim;
    private Rectangle hitbox;
    private Sprite sprite;
    private String tag;

    public GameObject(Vector2 pos, Vector2 dim, Rectangle hitbox, Sprite sprite, String tag) {
        this.pos = pos;
        this.dim = dim;
        this.hitbox = hitbox;
        this.sprite = sprite;
        this.tag = tag;
    }

    public boolean collisionDetected(Rectangle other){
        return getHitbox().overlaps(other);
    }

    public Vector2 getPos() {
        return pos;
    }

    public void setPos(Vector2 pos) {
        this.pos = pos;
    }

    public Vector2 getDim() {
        return dim;
    }

    public void setDim(Vector2 dim) {
        this.dim = dim;
    }

    public Rectangle getHitbox() {
        return hitbox;
    }

    public void setHitbox(Rectangle hitbox) {
        this.hitbox = hitbox;
    }

    public Sprite getSprite() {
        return sprite;
    }

    public void setSprite(Sprite sprite) {
        this.sprite = sprite;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
