/*
import chisel3 . _
class EncoderIO extends Bundle {
val in = Input ( UInt (4. W) )
val out = Output ( UInt (2.W ) )
}
class Encoder4to2 extends Module {
val io = IO ( new EncoderIO )
io . out := " b11 " . U  {

switch ( io . in ) {
is  (" b0001 " . U)
 io . out := " bOO".U
} 
is(" b0010 " . U ) {
io . out := " b01 " . U
} 
is (" b0100 " . U ) {
io . out := " b10 " . U
} 
is{
io . out := " b11 " . U
}
}
}

*/