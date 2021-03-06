package example

import org.sgine._
import org.sgine.lwjgl.BasicDesktopApp
import org.sgine.widget.Image

object InputExample extends BasicDesktopApp {
  create.on {
    this += new Image("sgine.png") {
      position.center := ui.center
      position.middle := ui.middle

      mouse.tapped.attach { evt =>
        val to = if (color.alpha.get == 1.0) {
          0.5
        } else {
          1.0
        }
        color.alpha transitionTo to in 200.millis start ui
      }
    }
  }
}
