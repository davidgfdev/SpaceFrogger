package com.mygdx.spacefrogger;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class Platform extends Image {
    public Platform(Texture texture, int posX, int posY){
        super(texture);
        setPosition(posX, posY);
        setSize(40,40);
    }

    public boolean isOverlapping(Actor other){
        Rectangle otherRectangle = new Rectangle(other.getX(), other.getY(), other.getWidth(), other.getHeight());
        Rectangle myRectangle = new Rectangle(this.getX(), this.getY(), this.getWidth() - 20, this.getHeight() - 20);

        return myRectangle.overlaps(otherRectangle);
    }
}
