package exercise

import org.scalatest.FunSuite

class Position$Test extends FunSuite {
	test("Given a value input should return the enumeration value") {
		val values = List("1", "2", "3", "4", "5", "6", "7", "8", "9")

		for (value <- values.indices) {
			assert(Position.fromString(values(value)).right.get == Position(value))
		}
	}

	test("Given a value that is too small should return an error") {
		assert(Position.fromString("0").isLeft)
	}

	test("Given a value that is too large should return an error") {
		assert(Position.fromString("10").isLeft)
	}

	test("Given an alphanumeric value should return an error") {
		assert(Position.fromString("abc").isLeft)
	}
}
