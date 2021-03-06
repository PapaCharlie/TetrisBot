package tetris.tetrominoes

import tetris.tetrominoes.Color.Magenta

/**
 * Shapes:
 * x       x  o
 * ox xox xo xox
 * o   x   x
 */
case class T(x: Int = 0, rotation: Int = 0) extends Tetromino {

  val shape0 = Seq((-1, 0), (0, 1), (1, 0))
  val shape1 = Seq((-1, 0), (1, 0), (0, -1))
  val shape2 = Seq((-1, 0), (0, 1), (0, -1))
  val shape3 = Seq((0, 1), (1, 0), (0, -1))

  var currentShape = rotation % 4 match {
    case 0 => shape0
    case 1 => shape1
    case 2 => shape2
    case 3 => shape3
  }

  def rotate: T = T(x, (rotation + 1) % 4)

  def allRotations: Seq[T] = (0 until 4).map(new T(x, _))

  def copy(x: Int = 0, rotation: Int = 0): T = new T(x, rotation)

  def color = new Magenta

}