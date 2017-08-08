package me.scionofbytes.libgdx.spacer

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.math.Vector2

fun getTouchCoords(): Vector2 {
    return Vector2(Gdx.input.x.toFloat(), Gdx.graphics.height - 1 - Gdx.input.y.toFloat())
}
