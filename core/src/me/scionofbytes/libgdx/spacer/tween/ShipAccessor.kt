package me.scionofbytes.libgdx.spacer.tween

import aurelienribon.tweenengine.TweenAccessor
import me.scionofbytes.libgdx.spacer.Ship

class ShipAccessor: TweenAccessor<Ship> {

    companion object {
        internal val TWEEN_POSITION = 1
    }

    override fun getValues(target: Ship, tweenType: Int, returnValues: FloatArray): Int {

        when (tweenType) {
            TWEEN_POSITION -> {
                returnValues[0] = target.position.x
                returnValues[1] = target.position.y

                return 2
            }
            else -> {
                assert(false)
                return -1
            }
        }
    }

    override fun setValues(target: Ship, tweenType: Int, newValues: FloatArray) {

        when (tweenType) {
            TWEEN_POSITION -> {
                target.position.x = newValues[0]
                target.position.y = newValues[1]
            }
        }
    }
}