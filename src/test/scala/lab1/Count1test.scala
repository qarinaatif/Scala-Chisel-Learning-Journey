package lab1

import chiseltest._
import chisel3._
import org.scalatest._

class Count1Test extends FreeSpec with ChiselScalatestTester {
  "COUNT1" in {
    test(new Count1(4.U)) { v =>
      v.clock.step(50)
    }
  }
}
