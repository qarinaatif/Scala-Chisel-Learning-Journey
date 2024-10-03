package lab1
import chiseltest._
import chisel3._
import org.scalatest._
class Counter1test extends FreeSpec with ChiselScalatestTester {
 "COUNTER 1" in {
   test(new Counter1(4)) {v =>
     v.clock.step(50)
   }
 }
}
