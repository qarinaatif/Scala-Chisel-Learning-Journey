package SingleCycle
import chisel3._
import chisel3.util._
import chiseltest._
import org.scalatest._

class Alutest extends FreeSpec with ChiselScalatestTester{
    "ALU TEST" in {
        test(new Alu) { c =>
        c.io.aluctrl.poke ( "b0000".U )
        c.io.op1.poke ( 1.U )
        c.io.op2.poke ( 0.U )
        c.clock.step (1)
        c.io.aluout.expect( 1.U )
        }
    }
}