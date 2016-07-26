package exercise

import exercise.Position._

class TicTacToe {
	private val board = new Board()

	def markPosition(position: Position.Value, symbol: BoardValue.Value): Unit = board.markPosition(position, symbol)

	def isPositionTaken(position: Position.Value): Boolean = board.isPositionTaken(position)

	def get(position: Position.Value): Option[BoardValue.Value] = board.get(position)

	def status(): TicTacToeStatus = {
		val strikes = Array(
			Array(One, Two, Three), Array(Four, Five, Six), Array(Seven, Eight, Nine),
			Array(One, Four, Seven), Array(Two, Five, Eight), Array(Three, Six, Nine),
			Array(One, Five, Nine), Array(Three, Five, Seven))

		def hasWon(boardValue: BoardValue.Value): Boolean =
			strikes.exists(strike => strike.forall(cell => board.get(cell).contains(boardValue)))

		if (board.isFull) GameTie()
		else if (hasWon(BoardValue.X)) GameWon(BoardValue.X)
		else if (hasWon(BoardValue.O)) GameWon(BoardValue.O)
		else InProgress()
	}
}