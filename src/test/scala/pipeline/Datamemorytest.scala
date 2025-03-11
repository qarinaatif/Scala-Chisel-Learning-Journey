package SingleCycle
import chisel3._
import chisel3.util._
import chiseltest._
import org.scalatest._

class Datamemorytest extends FreeSpec with ChiselScalatestTester{
    "Datamemory Test" in {
        test(new Datamemory) { c =>
            c.io.memwrite.poke(0.B)
            c.io.memread.poke(1.B)
            c.io.memaddress.poke(1.U)
            c.clock.step(1)
            c.io.memout.expect(0.S)

            c.io.memwrite.poke(1.B)
            c.io.memread.poke(0.B)
            c.io.memaddress.poke(1.U)
            c.io.memdata.poke(100101795.S)
            c.clock.step(1)
            c.io.memout.expect(0.S)

            c.io.memwrite.poke(0.B)
            c.io.memread.poke(1.B)
            c.io.memaddress.poke(1.U)
            c.clock.step(1)
            c.io.memout.expect(100101795.S)
    }}
}