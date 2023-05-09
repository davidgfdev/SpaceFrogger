package com.mygdx.spacefrogger;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class Frog extends Image {
    public Frog(Texture textura){
        super(textura);
        setPosition(170, 0);
        setSize(64,64);
    }

    public boolean isOverlapping(Actor other){
        Rectangle otherRectangle = new Rectangle(other.getX(), other.getY(), other.getWidth(), other.getHeight());
        Rectangle myRectangle = new Rectangle(this.getX(), this.getY(), this.getWidth(), this.getHeight());

        return myRectangle.overlaps(otherRectangle);
    }
}
