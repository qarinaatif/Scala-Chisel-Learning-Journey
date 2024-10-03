package lab1
import chiseltest._
import chisel3._
import org.scalatest._

class Counter2Test extends FreeSpec with ChiselScalatestTester {
  "COUNTER2" in {
    test(new Counter2(4.U)) { v =>
      v.clock.step(50)
    }
  }
}
