package org.sgine.transition

import org.sgine._

trait Transition {
  def finished: Boolean
  def init(): Unit
  def invoke(): Unit

  def start(context: Renderable) = {
    var first = true
    context.render.until(finished) {
      if (first) {
        init()
        first = false
      }
      invoke()
    }
  }

  def andThen(next: Transition): Sequence = new Sequence(List(this, next))
  def and(other: Transition): Parallel = new Parallel(Set(this, other))
}