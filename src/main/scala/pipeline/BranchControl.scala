package SingleCycle
import chisel3._
import chisel3.util._

class BranchControl extends Module {
    val io = IO(new Bundle{
        val fnct3 = Input ( UInt (3. W ) )
        val branch = Input ( Bool () )
        val arg_x = Input ( UInt (32. W ) )
        val arg_y = Input ( UInt (32. W ) )
        val br_taken = Output ( Bool () )
        })

        io.br_taken :=0.B
        when(io.branch){
            switch ( io.fnct3) {
                is ("b0000".U){
                    io.br_taken := (io.arg_x === io.arg_y)
                } 
                is ("b0001".U){
                    io.br_taken := (io.arg_x =/= io.arg_y)
                } 
                is ("b0010".U){
                    io.br_taken := (io.arg_x < io.arg_y)
                } 
                is ("b0100".U){
                    io.br_taken := (io.arg_x >= io.arg_y)
            } 
        }
    }
}