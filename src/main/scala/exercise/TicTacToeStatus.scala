package exercise

class TicTacToeStatus

case class GameWon(winner: BoardValue.Value) extends TicTacToeStatus

case class GameTie() extends TicTacToeStatus

case class InProgress() extends TicTacToeStatus


