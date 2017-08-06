package me.scionofbytes.libgdx.spacer;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Main extends ApplicationAdapter {

  SpriteBatch batch;
  Texture img;

  int locX;
  int locY;

  @Override
  public void create() {

    batch = new SpriteBatch();
    img = new Texture("Asterix-icon.png");

    locX = 300;
    locY = 400;
  }

  @Override
  public void render() {

    int dirX = Math.random() < 0.5 ? 1 : -1;
    int dirY = Math.random() < 0.5 ? 1 : -1;

    locX += (int)(Math.random() * 2) * dirX;
    locY += (int)(Math.random() * 2) * dirY;

    drawAsterix();
  }

  void drawAsterix() {

    batch.begin();
    batch.draw(img, locX, locY);
    batch.end();
  }

  @Override
  public void dispose() {

    batch.dispose();
    img.dispose();
  }
}
