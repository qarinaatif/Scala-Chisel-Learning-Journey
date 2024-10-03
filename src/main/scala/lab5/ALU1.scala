/*import chisel3 . _
import chisel3 . util . _
import chisel3 . iotesters .{ Driver , PeekPokeTester }

class ALU1 ( width_parameter : Int ) extends Module {
val io = IO ( new IO_Interface ( width_parameter ) )
io . alu_out := 0. U
val index = log2Ceil ( width_parameter )
switch ( io . alu_oper ) { // AND
when ( " b0000 " . U ) {
io . alu_out := io . arg_x & io . arg_y
} // OR
else when ( " b0001 " . U ) {
io . alu_out := io . arg_x | io . arg_y
} // ADD
else when ( " b0010 " . U ) {
io . alu_out := io . arg_x + io . arg_y
} // SUB
else when ( " b0110 " . U ) {
io . alu_out := io . arg_x - io . arg_y
} // XOR
else when ( " b0011 " . U ) {
io . alu_out := io . arg_x ^ io . arg_y
} // SLL
else when ( " b0100 " . U ) {
io . alu_out := io . arg_x << io . arg_y ( index -1 , 0)
} // SRL
else when ( " b0101 " . U ) {
io . alu_out := io . arg_x >> io . arg_y ( index -1 , 0)
} // SRA
else when ( " b0111 " . U ) {
io . alu_out := ( io . arg_x . asSInt >> io . arg_y ( index -1 , 0) ) . asUInt
} // SLT
else when ( " b1000 " . U ) {
io . alu_out := io . arg_x . asSInt < io . arg_y . asSInt
} // SLTU
otherwise ( " b1001 " . U ) {
io . alu_out := io . arg_x < io . arg_y
}
}
}
class IO_Interface ( width : Int ) extends Bundle {
val alu_oper = Input ( UInt ( width . W ) )
val arg_x = Input ( UInt ( width . W ) )
val arg_y = Input ( UInt ( width . W ) )
val alu_out = Output ( UInt ( width . W ) )
}

println (( new chisel3 . stage . ChiselStage ) . emitVerilog ( new ALU (32) ) )
println (( new chisel3 . stage . ChiselStage ) . emitVerilog ( new ALU (64) ) )


*/