package SingleCycle
import chiseltest._
import chisel3._
import org.scalatest._

class BranchControltest extends FreeSpec with ChiselScalatestTester {
    "branchcontrol" in{
    test(new BranchControl()) { c =>
        c.io.fnct3.poke("b000".U) 
        c.io.branch.poke(true.B)
        c.io.arg_x.poke(10.U)
        c.io.arg_y.poke(10.U)
        c.clock.step(1)
        c.io.br_taken.expect(true.B) 
        
        
        }
    }   
}