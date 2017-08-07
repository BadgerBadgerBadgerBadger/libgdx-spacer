package me.scionofbytes.libgdx.spacer

import com.badlogic.gdx.ApplicationAdapter
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.math.Vector2

class Main : ApplicationAdapter() {

    lateinit internal var batch: SpriteBatch

    lateinit internal var ship: Ship

    override fun create() {
        batch = SpriteBatch()
        ship = Ship(Vector2(Gdx.graphics.width.toFloat(), Gdx.graphics.height.toFloat()))
    }

    override fun render() {

        clear()

        batch.begin()

        ship.render(batch)

        batch.end()
    }

    fun clear() {
        Gdx.gl.glClearColor(0f, 0f, 0f, 1f)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)
    }

    override fun dispose() {
        batch.dispose()
    }
}
