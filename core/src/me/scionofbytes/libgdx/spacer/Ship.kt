package me.scionofbytes.libgdx.spacer

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.audio.Sound
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.math.Vector2

class Ship internal constructor(screenDimensions: Vector2) {

    internal val img: Texture = Texture("img/sprite/DragonHead.png")
    internal val shotSound: Sound = Gdx.audio.newSound(Gdx.files.internal("audio/sound/shot.wav"))

    internal val dimensions: Vector2 = Vector2(107f, 160f)
    internal val position: Vector2 = Vector2(
        ((screenDimensions.x / 2) - (dimensions.x / 2)),
        ((screenDimensions.y / 2) - (dimensions.y / 2))
    )

    fun render(batch: SpriteBatch) {
        batch.draw(img, position.x, position.y)
    }
}
