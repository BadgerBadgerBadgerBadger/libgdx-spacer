package me.scionofbytes.libgdx.spacer

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.audio.Sound
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.math.Vector2

import aurelienribon.tweenengine.Tween
import aurelienribon.tweenengine.TweenManager
import me.scionofbytes.libgdx.spacer.tween.ShipAccessor

class Ship internal constructor(screenDimensions: Vector2, internal val tweenManager: TweenManager) {

    internal val velocity = 500

    internal var desiredCenterPos = Vector2()

    internal val img: Texture = Texture("img/sprite/DragonHead.png")
    internal val shotSound: Sound = Gdx.audio.newSound(Gdx.files.internal("audio/sound/shot.wav"))

    internal val dimensions: Vector2 = Vector2(107f, 160f)
    internal val position: Vector2 = Vector2(
        ((screenDimensions.x / 2) - (dimensions.x / 2)),
        ((screenDimensions.y / 2) - (dimensions.y / 2))
    )

    init {
        Tween.registerAccessor(Ship::class.java, ShipAccessor())
    }

    fun moveTo(position: Vector2) {

        updateDesiredCenterPos(position.x, position.y)

        Tween.to(this, ShipAccessor.TWEEN_POSITION, getTweenDuration())
            .target(desiredCenterPos.x, desiredCenterPos.y)
            .start(tweenManager)
    }

    fun render(batch: SpriteBatch) {
        batch.draw(img, position.x, position.y)
    }

    fun updateDesiredCenterPos(x: Float, y: Float): Vector2 {
        return desiredCenterPos.set(
            x - (dimensions.x / 2),
            y - (dimensions.y / 2)
        )
    }

    fun getTweenDuration(): Float {
        return desiredCenterPos.dst(position) / velocity
    }
}
