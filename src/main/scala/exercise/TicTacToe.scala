package exercise

import scala.collection.mutable
import scala.util.control.Breaks._

class TicTacToe {
	val positions = List(1, 2, 3, 4, 5, 6, 7, 8, 9)
	val strikes = Array(Array(1, 2, 3), Array(4, 5, 6), Array(7, 8, 9),
		Array(1, 4, 7), Array(2, 5, 8), Array(3, 6, 9),
		Array(1, 5, 9), Array(3, 5, 7))

	val map = new mutable.HashMap[Int, String]()

	def markPosition(position: Int, symbol: String): Unit = {
		map += (position -> symbol)
	}

	def printTic(): Unit = {
		printTicTacToeBoard()
		for (c <- strikes.indices) {
			var xCount = 0
			var oCount = 0
			var xTrue = false
			var oTrue = false
			val eachStrike = strikes(c)
			def checkIfXWins(): Unit = {
				xCount += 1
				xTrue = true
				if (xCount == 3 && xTrue) {
					println("X won the match")
					break()
				}
			}
			def checkIfOWins(): Unit = {
				oCount += 1
				oTrue = true
				if (oCount == 3 && oTrue) {
					println("O won the match")
					break()
				}
			}
			for (b <- eachStrike.indices) {
				val strike: Int = eachStrike(b)
				if (map.contains(strike) && "X".equals(map(strike))) {
					checkIfXWins()
				} else if (map.contains(strike) && "O".equals(map(strike))) {
					checkIfOWins()
				}
			}
		}

	}

	def printTicTacToeBoard(): Unit = {
		for (a <- 1 until 10) {
			if (map.contains(a) && "X".equals(map(a))) {
				print("X")
			} else if (map.contains(a) && "O".equals(map(a))) {
				print("O")
			} else {
				print(positions(a - 1))
			}
			print("     ")
			if (a % 3 == 0) {
				println()
				println()
			}
		}
	}
}


