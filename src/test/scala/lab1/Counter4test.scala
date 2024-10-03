package lab1
import chiseltest._
import chisel3._
import org.scalatest._
class Counter4test extends FreeSpec with ChiselScalatestTester {
 "COUNTER4" in {
   test(new Counter4(4)) {v =>
     //v.io.max.poke(10.U)
     v.clock.step(50)
    //  v.io.c.expect(0.S)
   }
 }
}
