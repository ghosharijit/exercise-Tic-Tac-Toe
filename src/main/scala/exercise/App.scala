package exercise

import scala.annotation.tailrec

object App {
	def main(args: Array[String]): Unit = {
		val ticTacToe = new TicTacToe()

		printTicTacToeBoard(ticTacToe)

		val turns = BoardValue.values.toList

		@tailrec
		def playRound(roundNumber: Int): Unit = {
			val turn = turns(roundNumber % 2)
			val entry = captureEntry(ticTacToe, turn)

			ticTacToe.markPosition(entry, turn)
			printTicTacToeBoard(ticTacToe)

			ticTacToe.status() match {
				case GameTie() =>
					println("Match drawn")
				case GameWon(winner) =>
					println(s"$winner won the match")
				case InProgress() =>
					playRound(roundNumber + 1)
			}
		}

		playRound(1)
	}

	private def captureEntry(ticTacToe: TicTacToe, symbol: BoardValue.Value): Position.Value = {
		@tailrec
		def capturePosition(): Position.Value = {
			val entry: String = scala.io.StdIn.readLine()
			Position.fromString(entry) match {
				case Left(_) =>
					println("Please re-enter a digit")
					capturePosition()
				case Right(position) =>
					if (ticTacToe.isPositionTaken(position)) {
						println("Please re-enter a digit. This is already present")
						capturePosition()
					} else {
						position
					}
			}
		}

		println(s"This is $symbol's turn. Please enter the position-digit")
		capturePosition()
	}

	private def printTicTacToeBoard(ticTacToe: TicTacToe): Unit = {
		for (a <- Position.values) {
			print(ticTacToe.get(a).getOrElse(a.id + 1))
			print("     ")
			if ((a.id + 1) % 3 == 0) {
				println()
				println()
			}
		}
	}
}
