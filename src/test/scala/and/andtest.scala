//code that calls module is called test bench
package and
import chiseltest._
import chisel3._
import org.scalatest._
//freespec is a class
//ChiselScalatestTester is a class
// test bench start
class andtest extends FreeSpec with ChiselScalatestTester {
 "AND GATE" in {
   test(new ands()) {v =>
     //poke means to enter input
     //expect refers to output
     //U REFERS TO SIGNED AND UNSIGNED
     //
     v.io.a.poke(1.U)
     v.io.b.poke(0.U)
    // for big input values we use clock
     v.clock.step(1)
     v.io.c.expect(0.U)
   }
 }
}
