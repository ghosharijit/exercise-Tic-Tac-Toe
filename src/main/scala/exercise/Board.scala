package exercise

import scala.collection.mutable

class Board {
	private val map = new mutable.HashMap[Position.Value, BoardValue.Value]()

	def isFull: Boolean = map.size == 9

	def get(a: Position.Value): Option[BoardValue.Value] = map.get(a)

	def markPosition(position: Position.Value, symbol: BoardValue.Value): Unit = map += (position -> symbol)

	def isPositionTaken(position: Position.Value): Boolean = map.contains(position)
}
