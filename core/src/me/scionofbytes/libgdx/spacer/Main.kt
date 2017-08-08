package me.scionofbytes.libgdx.spacer

import aurelienribon.tweenengine.TweenManager
import com.badlogic.gdx.ApplicationAdapter
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.math.Vector2

class Main : ApplicationAdapter() {

    lateinit internal var batch: SpriteBatch
    lateinit internal var ship: Ship
    lateinit internal var touchPos: Vector2
    lateinit internal var manager: TweenManager

    override fun create() {

        manager = TweenManager()
        batch = SpriteBatch()
        ship = Ship(Vector2(Gdx.graphics.width.toFloat(), Gdx.graphics.height.toFloat()), manager)
    }

    override fun render() {

        actuallyRender()
        handleInput()
        updateTweens()
    }

    /*
        Since we already have a `render` method, I got creative (haar haar) with this one. The render
        method does more than just rendering, so I'm gonna use this method to only handle display
        level stuff.
     */
    fun actuallyRender() {

        clear()

        batch.begin()

        ship.render(batch)

        batch.end()
    }

    fun clear() {
        Gdx.gl.glClearColor(0f, 0f, 0f, 1f)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)
    }

    fun handleInput() {

        if (Gdx.input.isTouched) {

            touchPos = getTouchCoords()
            ship.moveTo(touchPos)
        }
    }

    fun updateTweens() {
        manager.update(Gdx.graphics.deltaTime)
    }

    override fun dispose() {
        batch.dispose()
    }
}
