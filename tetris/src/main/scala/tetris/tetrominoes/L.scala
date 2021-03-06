package tetris.tetrominoes

import tetris.tetrominoes.Color.Orange

/**
 * Shapes:
 * x      xx   x
 * o  xox  o xox
 * xx x    x
 */
case class L(x: Int = 0, rotation: Int = 0) extends Tetromino {

  val shape0 = Seq((0, 1), (0, -1), (1, -1))
  val shape1 = Seq((-1, 0), (-1, -1), (1, 0))
  val shape2 = Seq((-1, 1), (0, 1), (0, -1))
  val shape3 = Seq((-1, 0), (1, 1), (1, 0))

  val currentShape = rotation % 4 match {
    case 0 => shape0
    case 1 => shape1
    case 2 => shape2
    case 3 => shape3
  }

  def rotate: L = L(x, (rotation + 1) % 4)

  def allRotations: Seq[L] = (0 until 4).map(new L(x, _))

  def copy(x: Int = 0, rotation: Int = 0): L = new L(x, rotation)

  def color = new Orange

}