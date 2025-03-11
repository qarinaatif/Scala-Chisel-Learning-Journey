package SingleCycle
import chisel3._
import chisel3.util._
import chiseltest._
import org.scalatest._

class Programcountertest extends FreeSpec with ChiselScalatestTester{
    "Programcounter Test" in {
        test(new Programcounter) { c =>
            c.io.in.poke(1.S)
            c.clock.step(1)
            c.io.pc4.expect(1.S)
            c.io.pcout.expect(1.S)
    }}
}