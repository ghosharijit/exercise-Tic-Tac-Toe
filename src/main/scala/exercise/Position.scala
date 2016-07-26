package exercise

object Position extends Enumeration {
	val One, Two, Three, Four, Five, Six, Seven, Eight, Nine = Value

	def toInt(position: Value): Int = position.id + 1

	def fromInt(value: Int): Either[String, Value] =
		if (value.toInt < 1) {
			Left("Underflow")
		} else if (value.toInt > maxId) {
			Left("Overflow")
		} else {
			Right(this (value.toInt - 1))
		}

	def fromString(value: String): Either[String, Value] = {
		try {
			fromInt(value.toInt)
		} catch {
			case _: NumberFormatException => Left("Not a number")
		}
	}
}
